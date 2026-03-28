package DesingPatern;

import java.util.ArrayList;
import java.util.List;

public class Compra {

    private List<String> carrinho = new ArrayList<>();
    private double valorAcumuladoBruto = 0;
    private String estrategia;
    private RegraFinanceiro formaPagamento; // Padrão Strategy: Composição da interface

    public Compra(String estrategia) {
        if (estrategia.equals("Loja")){
            this.estrategia = estrategia;
            formaPagamento = new CompraLoja();
        } else if (estrategia.equals("Site")){
            this.estrategia = estrategia;
            formaPagamento = new CompraSite();
        } else System.out.println("Estratégia não aceita.");
    }

    public void adicionarProduto(String nome, double preco) {
        carrinho.add(nome);
        valorAcumuladoBruto += preco;
        System.out.println("Item adicionado: " + nome);
    }

    public void finalizarCompra() {

        double total = formaPagamento.calcularValorTotal(valorAcumuladoBruto);

        System.out.println("\n--- Checkout "+estrategia+"  ---");
        System.out.println("Itens: " + carrinho);

        // Delegando a execução para a estratégia escolhida
        formaPagamento.pagar(total);

        formaPagamento.exibirResumoFinanceiro(total);

        if (formaPagamento.getEnderecoEntrega() != null){
            carrinho.clear();
            valorAcumuladoBruto = 0;
        }
    }

    public RegraFinanceiro getFormaPagamento() {
        return formaPagamento;
    }
}
