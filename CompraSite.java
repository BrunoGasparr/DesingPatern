package DesingPatern;

public class CompraSite implements RegraFinanceiro {

    private double ultimoValorProcessado;
    private String enderecoEntrega;
    private final String PLATAFORMA = "Gateway de Pagamento Online";

    @Override
    public void pagar(double valor) {
        this.ultimoValorProcessado = valor;
        System.out.println("[SITE] Validando cartão de crédito...");
        System.out.println("[SITE] Pagamento de R$ " + valor + " aprovado.");
        System.out.println("[SITE] Logística: Preparando envio para: " + this.enderecoEntrega);
    }

    @Override
    public double calcularDesconto(double valorBruto, double percentual) {
        return valorBruto * (percentual / 100);
    }

    @Override
    public double calcularValorTotal(double valorBruto, double desconto, double taxas) {
        // No site, 'taxas' geralmente representa o Frete
        return (valorBruto - desconto) + taxas;
    }

    @Override
    public void exibirResumoFinanceiro() {
        System.out.println("\n--- COMPROVANTE DIGITAL ---");
        System.out.println("Método: " + PLATAFORMA);
        System.out.println("Valor Final: R$ " + ultimoValorProcessado);
        System.out.println("Entrega em: " + (enderecoEntrega != null ? enderecoEntrega : "Retirada na Loja"));
    }

    @Override
    public double calcularLucroLiquido() {
        // O site tem taxas de transação digital (ex: 5%) e impostos (10%)
        return ultimoValorProcessado * 0.85;
    }

    @Override
    public void realizarEstorno(String transacaoId, double valor) {
        System.out.println("[SITE] Estorno de R$ " + valor + " solicitado para o ID: " + transacaoId);
    }

    // Getter e Setter específico do Site
    public void setEnderecoEntrega(String endereco) { this.enderecoEntrega = endereco; }
}
