import java.util.Scanner;

public class InteracaoUsuario {
// Método estático para executar a consulta de CEP
    public static void executarConsulta() {
        ConsultaCep consultaCep = new ConsultaCep();
        try (Scanner scanner = new Scanner(System.in)) {
            Endereco endereco = null;
            while (endereco == null) {
                // Solicita ao usuário que digite o CEP ou "Sair" para encerrar
                System.out.print("Digite o CEP (apenas números) ou 'Sair' para encerrar: ");
                String cep = scanner.nextLine();
                
                // Verifica se o usuário deseja sair
                if (cep.equalsIgnoreCase("sair")) {
                    System.out.println("Aplicação encerrada.");
                    scanner.close(); // Encerra o scanner
                    return; // Encerra a aplicação
                }
                
                // Verifica se o CEP contém apenas números
                if (!cep.matches("\\d+")) {
                    System.out.println("Somente números são aceitos. Tente novamente.");
                    continue; // Volta ao início do loop para solicitar o CEP novamente
                }
                // Busca o endereço correspondente ao CEP
                endereco = consultaCep.buscaEndereco(cep);
            }   // Solicita ao usuário que digite o complemento
            System.out.print("Digite o complemento: ");
            String complemento = scanner.nextLine();
            // Cria um novo objeto Endereco com o complemento
            Endereco enderecoComComplemento = new Endereco(endereco.cep(), endereco.logradouro(), complemento, endereco.bairro(), endereco.localidade(), endereco.uf());
            // Exibe o endereço completo
            System.out.println(enderecoComComplemento);
            // Encerra o scanner
        }
    }
}