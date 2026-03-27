package DesingPatern;

public interface RegraFinanceiro {

    // Aplica um desconto ao valor bruto
    double calcularDesconto(double valorBruto, double percentual);

    // Calcula o valor total final (Bruto - Descontos + Taxas)
    double calcularValorTotal(double valorBruto, double desconto, double taxas);

    // Mostra o resumo das operações financeiras realizadas
    void exibirResumoFinanceiro();

    // Retorna o lucro líquido (Bruto - Desconto - Taxas - Impostos)
    double calcularLucroLiquido();

    // Realiza o estorno de um valor específico 
    void realizarEstorno(String transacaoId, double valor);

}
