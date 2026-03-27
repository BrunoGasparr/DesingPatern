package DesingPatern;

public interface RegraFinanceiro {

    double calcularDesconto(double valorBruto, double percentual);

    double calcularValorTotal(double valorBruto, double desconto, double taxas);

    void exibirResumoFinanceiro();

    double calcularLucroLiquido();

    void realizarEstorno(String transacaoId, double valor);

    void pagar(double valor);
}
