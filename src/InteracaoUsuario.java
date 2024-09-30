// Importação da classe Scanner para leitura de entrada do usuário
import java.util.Scanner;

// Classe responsável pela interação com o usuário
public class InteracaoUsuario {
    // Criação de um objeto Scanner para leitura de entrada do usuário
    private static Scanner scanner = new Scanner(System.in);

    // Método principal que executa a consulta de CEP
    public static void executarConsulta() {
        // Variável de controle para continuar ou encerrar o loop de busca
        boolean continuarBusca = true;

        // Loop principal para realizar múltiplas buscas
        while (continuarBusca) {
            String cep;
            // Loop para garantir que o CEP digitado tenha no máximo 8 dígitos
            do {
                System.out.print("Digite o CEP para busca (8 dígitos e somente números): ");
                cep = scanner.nextLine().trim();
                if (cep.length() > 8) {
                    System.out.println("Favor digitar somente 8 dígitos para o CEP.");
                }
            } while (cep.length() > 8);

            // Realiza a busca do CEP e armazena o resultado
            String resultado = realizarBusca(cep);
            if (resultado.equals("CEP desconhecido")) {
                System.out.println(resultado);
            } else {
                // Exibe o resultado da busca
                System.out.println(resultado);
                // Pergunta se o usuário deseja salvar o resultado
                System.out.print("Deseja salvar este resultado? (S/N): ");
                String salvar = scanner.nextLine().trim();
                if (salvar.equalsIgnoreCase("S")) {
                    // Salva o resultado em um arquivo
                    GeradorDeArquivo.salvarResultadoBusca(resultado, cep);
                }
            }

            // Pergunta se o usuário deseja fazer uma nova busca
            System.out.print("Deseja fazer uma nova busca? (S/N): ");
            String novaBusca = scanner.nextLine().trim();
            continuarBusca = novaBusca.equalsIgnoreCase("S");
        }

        // Mensagem de encerramento do programa
        System.out.println("Programa encerrado. Obrigado por usar!");
        // Fecha o scanner para liberar recursos
        scanner.close();
    }

    // Método privado para realizar a busca do CEP
    private static String realizarBusca(String cep) {
        // Cria uma instância de ConsultaCep
        ConsultaCep consultaCep = new ConsultaCep();
        // Realiza a busca do endereço pelo CEP
        Endereco endereco = consultaCep.buscaEndereco(cep);
        
        // Verifica se o endereço foi encontrado e se é válido
        if (endereco != null && !endereco.toString().contains("Desconhecido(a)")) {
            return endereco.toString();
        } else {
            return "CEP desconhecido";
        }
    }
}