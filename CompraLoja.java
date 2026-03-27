package DesingPatern;

import java.util.ArrayList;
import java.util.List;

public class CompraLoja implements RegraFinanceiro {

    private List<String> produtos = new ArrayList<>();
    private double valorAcumuladoBruto = 0;
    private RegraFinanceiro formaPagamento; // Padrão Strategy: Composição da interface

    public void adicionarProduto(String nome, double preco) {
        produtos.add(nome);
        valorAcumuladoBruto += preco;
        System.out.println("[LOJA] Item adicionado: " + nome);
    }

    public void setFormaPagamento(RegraFinanceiro formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public void finalizarCompra() {
        if (formaPagamento == null) {
            System.out.println("Erro: Selecione uma forma de pagamento!");
            return;
        }

        double desconto = calcularDesconto(valorAcumuladoBruto, 5); // 5% fixo na loja
        double total = calcularValorTotal(valorAcumuladoBruto, desconto, 2.0); // Taxa de serviço/embalagem

        System.out.println("\n--- Checkout Loja Física ---");
        System.out.println("Itens: " + produtos);

        // Delegando a execução para a estratégia escolhida
        formaPagamento.pagar(total);

        exibirResumoFinanceiro();
    }

    @Override
    public void pagar(double valor) {
        System.out.println("[LOJA] Recebendo R$ " + valor + " em espécie/maquininha no balcão.");
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
        System.out.println("Resumo Loja: Venda concluída. Lucro: R$ " + calcularLucroLiquido());
    }

    @Override
    public double calcularLucroLiquido() {
        // Loja física tem custos operacionais maiores (ex: sobra 70% do bruto)
        return valorAcumuladoBruto * 0.70;
    }

    @Override
    public void realizarEstorno(String transacaoId, double valor) {
        System.out.println("[LOJA] Gerando vale-troca para transação: " + transacaoId);
    }
}
