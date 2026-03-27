package DesingPatern;

public class Main {
    public static void main(String[] args) {

        //Setando a variável estoque como a instância do singleton Estoque
        Estoque estoque = Estoque.getInstancia();

        //Adicionando 3 produtos à lista do estoque, com o último dando erro
        estoque.adicionarProduto("Mouse", 120, 10);
        estoque.adicionarProduto("Teclado", 160, 15);
        estoque.adicionarProduto("Monitor", 100, 5);
        estoque.adicionarProduto("Memória RAM", -200, -10);

        //Testa a função retirarProduto, primeiramente dando erro e depois funcionando
        estoque.retirarProduto(4);
        estoque.retirarProduto(0);

        //Testa a função editrQuantidade, primeiramente funcionando e depois dando erro
        estoque.editarQuantidade(1, 10);
        estoque.editarQuantidade(1, -1);

        //Testa a função buscarPorNomeDeProduto, primeiramente funcionando e depois dando erro
        estoque.buscarPorNomeDeProduto("Teclado");
        estoque.buscarPorNomeDeProduto("Memória RAM");

        //Testa a função TotalEstoque, retornando o valor total no estoque
        estoque.TotalEstoque();

        //Teste a função verificarDisponibilidade, primeiramente retornando true e depois false
        estoque.verificarDisponibilidade(0, 5);
        estoque.verificarDisponibilidade(1, 15);


        // 1. Padrão Strategy: Criamos diferentes estratégias de processamento financeiro
        RegraFinanceiro processadorWeb = new CompraSite();
        ((CompraSite) processadorWeb).setEnderecoEntrega("Rua das Flores, 123");

        // 2. O Contexto: A Loja Física
        CompraLoja carrinhoLoja = new CompraLoja();
        carrinhoLoja.adicionarProduto("Notebook Pro", 4500.00);
        carrinhoLoja.adicionarProduto("Mouse Sem Fio", 150.00);

        System.out.println(" CENÁRIO 1: COMPRA NA LOJA ");
        // Injetando a estratégia de pagamento local
        carrinhoLoja.setFormaPagamento(carrinhoLoja);
        carrinhoLoja.finalizarCompra();

        System.out.println("\n CENÁRIO 2: COMPRA NA LOJA MAS PAGANDO VIA SITE (TOTEM) ");
        // Reutilizando a estratégia do Site dentro da Loja (Polimorfismo puro)
        carrinhoLoja.setFormaPagamento(processadorWeb);
        carrinhoLoja.finalizarCompra();

        System.out.println("\n CENÁRIO 3: ESTORNO USANDO INTERFACE ");
        executarProcedimentoPadrao(processadorWeb, "TX-999", 100.0);
    }

    // Método utilitário que não sabe qual classe está recebendo, apenas que segue a Regra
    public static void executarProcedimentoPadrao(RegraFinanceiro regra, String id, double valor) {
        regra.realizarEstorno(id, valor);
    }

}
