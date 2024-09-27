public record Endereco(String cep, String logradouro, String complemento, String bairro, String localidade, String uf) {
    
    // O método toString foi sobrescrito para fornecer uma representação legível do objeto Endereco.
    @Override
    public String toString() {
        return String.format("Endereço consultado:\nCEP: %s\nLogradouro: %s\nComplemento: %s\nBairro: %s\nLocalidade: %s\nUF: %s", 
                             cep != null ? cep : "Desconhecido(a)", logradouro != null ? logradouro : "Desconhecido(a)", 
                             complemento != null ? complemento : "Desconhecido(a)", bairro != null ? bairro : "Desconhecido(a)", 
                             localidade != null ? localidade : "Desconhecido(a)", uf != null ? uf : "Desconhecido(a)");
    }
}