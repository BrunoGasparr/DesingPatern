package DesingPatern;

public class CompraSite implements RegraFinanceiro {

    // guarda o último valor processado
    private double ultimoValorProcessado;

    // estratégia de pagamento
    private Pagamento formaPagamento;

    // endereço da entrega (necessário na compra online)
    private String enderecoEntrega;

    // define forma de pagamento
    public void setFormaPagamento(Pagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    // define endereço
    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    @Override
    public void pagar(double valor) {

        // valida pagamento
        if (formaPagamento == null) {
            System.out.println("[SITE] Forma de pagamento não definida");
            return;
        }

        // valida endereço (exigido no site)
        if (enderecoEntrega == null || enderecoEntrega.isEmpty()) {
            System.out.println("[SITE] Endereço não informado");
            return;
        }

        this.ultimoValorProcessado = valor;

        System.out.println("[SITE] Processando pagamento online...");

        // chama estratégia (Pix, Cartão, etc)
        formaPagamento.pagar(valor);
    }

    @Override
    public double calcularDesconto(double valorBruto, double percentual) {
        return valorBruto * (percentual / 100);
    }

    @Override
    public double calcularValorTotal(double valorBruto, double desconto, double taxas) {
        return (valorBruto - desconto) + taxas;
    }

    @Override
    public void exibirResumoFinanceiro() {
        System.out.println("--- Relatório Web ---");
        System.out.println("Endereço: " + enderecoEntrega);
        System.out.println("Último valor: R$ " + ultimoValorProcessado);
        System.out.println("Status: Finalizada");
    }

    @Override
    public double calcularLucroLiquido() {
        double taxaGateway = ultimoValorProcessado * 0.05;
        double impostos = ultimoValorProcessado * 0.10;
        return ultimoValorProcessado - taxaGateway - impostos;
    }

    @Override
    public void realizarEstorno(String transacaoId, double valor) {
        System.out.println("[SITE] Estorno da transação: " + transacaoId);
        System.out.println("[SITE] Valor: R$ " + valor);
    }
}
