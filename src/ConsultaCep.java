// Importações necessárias para realizar a consulta de CEP
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

// Classe responsável por realizar a consulta de CEP
public class ConsultaCep {

    // Método que recebe um CEP e retorna um objeto Endereco com as informações correspondentes
    public Endereco buscaEndereco(String cep) {
        try {
            // Monta a URL da API ViaCEP, concatenando o CEP fornecido
            String url = "https://viacep.com.br/ws/" + cep + "/json/";

            // Cria um cliente HTTP para realizar a requisição
            HttpClient client = HttpClient.newHttpClient();
            
            // Cria uma requisição HTTP GET para a URL montada
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            // Envia a requisição e aguarda a resposta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verifica se a resposta foi bem-sucedida (código 200)
            if (response.statusCode() == 200) {
                // Obtém o corpo da resposta (JSON)
                String json = response.body();
                
                // Cria um objeto Gson para converter o JSON em objeto Java
                Gson gson = new Gson();
                
                // Converte o JSON em um objeto Endereco e o retorna
                return gson.fromJson(json, Endereco.class);
            } else {
                // Se a resposta não for bem-sucedida, retorna null
                return null;
            }
        } catch (IOException | InterruptedException e) {
            // Em caso de erro na requisição, imprime a mensagem de erro e retorna null
            System.err.println("Erro ao consultar o CEP: " + e.getMessage());
            return null;
        }
    }
}