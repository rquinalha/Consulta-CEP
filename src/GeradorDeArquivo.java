// Importações necessárias para manipulação de arquivos e tratamento de exceções
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// Classe responsável por gerar e salvar arquivos com os resultados das buscas de CEP
public class GeradorDeArquivo {
    // Constante que define o diretório onde os arquivos de resultado serão salvos
    private static final String DIRETORIO_RESULTADOS = "resultados_busca";

    // Método estático para salvar o resultado da busca de CEP em um arquivo
    public static void salvarResultadoBusca(String resultado, String cep) {
        // Cria um objeto File representando o diretório de resultados
        File diretorio = new File(DIRETORIO_RESULTADOS);
        // Verifica se o diretório não existe e, se não existir, cria-o
        if (!diretorio.exists()) {
            diretorio.mkdirs();
        }

        // Gera o nome do arquivo baseado no CEP fornecido
        String nomeArquivo = String.format("%s/Resultado_CEP_%s.txt", DIRETORIO_RESULTADOS, cep);

        // Tenta escrever o resultado no arquivo
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            // Escreve o conteúdo do resultado no arquivo
            writer.write(resultado);
            // Imprime uma mensagem de sucesso no console
            System.out.println("Resultado da busca salvo com sucesso em '" + nomeArquivo + "'");
        } catch (IOException e) {
            // Em caso de erro na escrita do arquivo, imprime uma mensagem de erro
            System.out.println("Ocorreu um erro ao salvar o arquivo: " + e.getMessage());
        }
    }
}
