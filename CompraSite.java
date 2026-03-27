package DesingPatern;

public class CompraSite implements RegraFinanceiro {

    // guarda o último valor que foi processado (usado pra relatório e lucro)
    private double ultimoValorProcessado;

    // estratégia de pagamento (permite trocar Pix, Cartão, etc sem mudar o código aqui)
    private Pagamento formaPagamento;

    // define qual será a forma de pagamento usada
    public void setFormaPagamento(Pagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    @Override
    public void pagar(double valor) {

        // verifica se alguma forma de pagamento foi definida
        if (formaPagamento == null) {
            System.out.println("[SITE] Forma de pagamento não definida");
            return;
        }

        // salva o valor da última transação
        this.ultimoValorProcessado = valor;

        // simula conexão com sistema de pagamento online
        System.out.println("[SITE] Processando pagamento online...");

        // chama a estratégia escolhida (Pix, Cartão, etc)
        formaPagamento.pagar(valor);
    }

    @Override
    public double calcularDesconto(double valorBruto, double percentual) {
        // calcula desconto com base em porcentagem (ex: cupom)
        return valorBruto * (percentual / 100);
    }

    @Override
    public double calcularValorTotal(double valorBruto, double desconto, double taxas) {
        // cálculo final: valor - desconto + taxas (frete, taxas de serviço, etc)
        return (valorBruto - desconto) + taxas;
    }

    @Override
    public void exibirResumoFinanceiro() {
        // exibe um resumo simples da última compra feita
        System.out.println("--- Relatório Web ---");
        System.out.println("Último valor: R$ " + ultimoValorProcessado);
        System.out.println("Status: Finalizada");
    }

    @Override
    public double calcularLucroLiquido() {
        // simula custos do sistema (gateway + impostos)
        double taxaGateway = ultimoValorProcessado * 0.05;
        double impostos = ultimoValorProcessado * 0.10;

        // lucro = valor - custos
        return ultimoValorProcessado - taxaGateway - impostos;
    }

    @Override
    public void realizarEstorno(String transacaoId, double valor) {
        // simula um estorno de pagamento
        System.out.println("[SITE] Estorno da transação: " + transacaoId);
        System.out.println("[SITE] Valor: R$ " + valor);
    }
}
