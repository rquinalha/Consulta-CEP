// Importações necessárias
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class ConsultaCep {

    // Método para buscar o endereço a partir do CEP
    public Endereco buscaEndereco(String cep) {
        try {
            // Monta a URL da API com o CEP fornecido
            String url = "https://viacep.com.br/ws/" + cep + "/json/";

            // Cria um cliente HTTP
            HttpClient client = HttpClient.newHttpClient();
            // Cria a requisição HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            // Envia a requisição e obtém a resposta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verifica se a resposta foi bem-sucedida
            if (response.statusCode() == 200) {
                String json = response.body();
                Gson gson = new Gson();
                // Converte o JSON em um objeto Endereco
                return gson.fromJson(json, Endereco.class);
            } else {
                // Exibe mensagem de erro caso a consulta falhe
                System.out.println("Consulta inválida. Tente novamente.");
                return null;
            }
        } catch (IOException | InterruptedException e) {
            // Exibe a pilha de erros em caso de exceção
            System.err.println("Erro: " + e.getMessage());
            return null;
        }

    }
}