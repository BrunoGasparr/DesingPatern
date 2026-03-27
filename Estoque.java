package DesingPatern;

import java.util.ArrayList;
import java.util.List;

public class Estoque implements RegrasEstoque{
    private List<Produto> produtos;
    static Estoque instancia = new Estoque();

    //Constructor private para garantir que só seja usado uma vez
    private Estoque() {
        this.produtos = new ArrayList<>();
    }

    //Metodo que usa o constructor uma vez e depois retorna a instancia que foi criada
    public static Estoque getInstancia(){
        return instancia;
    }

    @Override
    public void adicionarProduto(String nome, double valor, int quantidade) {
        if (valor<0 || quantidade<0){
            System.out.println("O valor e a quantidade não podem ser negativos.");
            return;
        }
        System.out.println("Produto "+nome+" adicionado!");
        produtos.add(new Produto(nome, valor, quantidade));
    }

    @Override
    public void retirarProduto(int id) {
        if (this.produtos.size() > id && id>=0){
            System.out.println("Produto "+produtos.get(id).getNome()+" retirado!");
            produtos.remove(id);
            return;
        }
        System.out.println("Id não corrensponde a um produto!");
    }

    @Override
    public void editarQuantidade(int id, int quantidade){
        if (quantidade<0) {
            System.out.println("Quantidade não pode ser negativa.");
        } else if (this.produtos.size() > id && id>=0){
            System.out.println("Quantidade em estoque do produto "+produtos.get(id).getNome()+" alterada para "+quantidade+"!");
            produtos.get(id).setQuantidade(quantidade);
            return;
        }
        System.out.println("Id não corrensponde a um produto!");
    }

    @Override
    public void buscarPorNomeDeProduto(String produto) {
        for (int id=0; id<this.produtos.size(); id++){
            if (this.produtos.get(id).getNome().equals(produto)){
                System.out.println("O produto procurado está na posição "+(id+1)+" com id "+id+"!");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    @Override
    public double TotalEstoque() {
        double total = 0;
        for (Produto produto : produtos){
            total += produto.getValor() * produto.getQuantidade();
        }
        System.out.println("O valor total em estoque é de "+total+" reais!");
        return total;
    }

    @Override
    public boolean verificarDisponibilidade(int id, int quantidade) {
        if (this.produtos.size() > id) {
            Produto produto = this.produtos.get(id);
            if (produto.getQuantidade() >= quantidade) {
                System.out.println("Produto " + produtos.get(id).getNome() + " tem a quantidade indicada!");
                return true;
            } else {
                System.out.println("Produto " + produtos.get(id).getNome() + " não tem a quantidade indicada!");
                return false;
            }
        }
        System.out.println("Id não corrensponde a um produto!");
        return false;
    }
}
