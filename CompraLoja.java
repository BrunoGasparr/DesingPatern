package DesingPatern;

import java.util.ArrayList;
import java.util.List;

public class CompraLoja implements RegraFinanceiro {

    private List<String> produtos = new ArrayList<>();
    private double valorTotalBruto;
    private RegraFinanceiro formaPagamento;

    // Métodos específicos da Loja
    public void adicionarProduto(String produto, double preco) {
        produtos.add(produto);
        valorTotalBruto += preco;
    }

    public void setFormaPagamento(RegraFinanceiro formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public void finalizarCompra() {
        if (formaPagamento == null) {
            System.out.println("Forma de pagamento não definida!");
            return;
        }

        // Usando as regras financeiras implementadas na própria classe
        double desconto = calcularDesconto(valorTotalBruto, 10); // Ex: 10% de desconto padrão
        double valorComTaxas = calcularValorTotal(valorTotalBruto, desconto, 5.0); // Ex: Taxa fixa de 5.0

        System.out.println("--- Processando Pagamento ---");
        System.out.println("Produtos: " + produtos);

        // A forma de pagamento externa executa o ato de pagar
        formaPagamento.pagar(valorComTaxas);

        exibirResumoFinanceiro();
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
        System.out.println("Resumo: Venda de " + produtos.size() + " itens finalizada com sucesso.");
        System.out.println("Lucro Estimado: R$ " + calcularLucroLiquido());
    }

    @Override
    public double calcularLucroLiquido() {
        // Exemplo: Lucro é 30% do valor bruto após impostos fictícios
        double impostos = valorTotalBruto * 0.15;
        return (valorTotalBruto - impostos) * 0.30;
    }

    @Override
    public void realizarEstorno(String transacaoId, double valor) {
        System.out.println("Estorno da transação " + transacaoId + " no valor de R$ " + valor + " realizado.");
    }

    @Override
    public void pagar(double valor) {
        // Este método na classe CompraLoja representa um pagamento "Direto no Caixa"
        System.out.println("Pagamento de R$ " + valor + " processado fisicamente no balcão.");
    }
}
