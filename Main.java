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

        System.out.println("\n\n");

        Compra loja_fisica = new Compra("Loja");
        loja_fisica.adicionarProduto("Teclado", 160);
        loja_fisica.adicionarProduto("Monitor", 100);
        loja_fisica.finalizarCompra();

        System.out.println("\n\n");

        Compra site = new Compra("Site");
        site.adicionarProduto("Teclado", 160);
        site.adicionarProduto("Monitor", 100);
        site.finalizarCompra();
        site.getFormaPagamento().setEnderecoEntrega("Rua Marcelo 100");
        site.finalizarCompra();
    }
}
