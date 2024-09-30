// Definição do record Endereco, que representa um endereço com seus componentes
public record Endereco(String cep, String logradouro, String complemento, String bairro, String localidade, String uf) {
    
    // Sobrescrita do método toString para fornecer uma representação legível do objeto Endereco
    @Override
    public String toString() {
        // Utiliza String.format para criar uma string formatada com os dados do endereço
        return String.format(
            // String de formato com placeholders para cada campo do endereço
            "Endereço consultado:\nCEP: %s\nLogradouro: %s\nComplemento: %s\nBairro: %s\nLocalidade: %s\nUF: %s",
            
            // Para cada campo, verifica se é nulo e substitui por "Desconhecido(a)" se for o caso
            // CEP
            cep != null ? cep : "Desconhecido(a)", 
            // Logradouro
            logradouro != null ? logradouro : "Desconhecido(a)", 
            // Complemento (verifica também se está vazio)
            complemento != null && !complemento.isEmpty() ? complemento : "Desconhecido(a)", 
            // Bairro
            bairro != null ? bairro : "Desconhecido(a)", 
            // Localidade
            localidade != null ? localidade : "Desconhecido(a)", 
            // UF (Unidade Federativa)
            uf != null ? uf : "Desconhecido(a)"
        );
    }
}