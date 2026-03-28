package DesingPatern;

public interface RegraFinanceiro {

    double calcularDesconto(double valorBruto);

    double calcularValorTotal(double valorBruto);

    void exibirResumoFinanceiro(double valor);

    double calcularLucroLiquido(double valor);

    void realizarEstorno();

    void pagar(double valor);

    String getEnderecoEntrega();

    void setEnderecoEntrega(String endereco);
}
