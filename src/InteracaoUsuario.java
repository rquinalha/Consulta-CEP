import java.util.Scanner;

public class InteracaoUsuario {
// Método estático para executar a consulta de CEP
    public static void executarConsulta() {
        ConsultaCep consultaCep = new ConsultaCep();
        try (Scanner scanner = new Scanner(System.in)) {
            boolean continuarConsulta = true;
            while (continuarConsulta) {
                Endereco endereco = null;
                while (endereco == null) {
                    // Solicita ao usuário que digite o CEP ou "Sair" para encerrar
                    System.out.print("Digite o CEP (apenas números) ou 'Sair' para encerrar: ");
                    String cep = scanner.nextLine();
                    
                    // Verifica se o usuário deseja sair
                    if (cep.equalsIgnoreCase("sair")) {
                        System.out.println("Aplicação encerrada.");
                        return; // Encerra a aplicação
                    }
                    
                    // Verifica se o CEP contém apenas números
                    if (!cep.matches("\\d+")) {
                        System.out.println("Somente números são aceitos. Tente novamente.");
                        continue; // Volta ao início do loop para solicitar o CEP novamente
                    }
                    // Busca o endereço correspondente ao CEP
                    endereco = consultaCep.buscaEndereco(cep);
                }
                // Exibe o endereço completo
                System.out.println(endereco);
                
                // Pergunta ao usuário se deseja fazer uma nova busca
                String resposta;
                do {
                    System.out.print("Deseja fazer uma nova busca? (S/N): ");
                    resposta = scanner.nextLine().toLowerCase();
                    if (!resposta.equals("s") && !resposta.equals("n")) {
                        System.out.println("Por favor, digite apenas 'S' para sim ou 'N' para não.");
                    }
                } while (!resposta.equals("s") && !resposta.equals("n"));
                
                continuarConsulta = resposta.equals("s");
            }
            System.out.println("Aplicação encerrada.");
        }
    }
}