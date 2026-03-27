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
        produtos.add(new Produto(nome, valor, quantidade));
    }

    @Override
    public void retirarProduto(int id) {
        if (this.produtos.size() > id){
            produtos.remove(id);
        }
    }

    @Override
    public void editarQuantidade(int id, int quantidade){
        if (this.produtos.size() > id){
            produtos.get(id).setQuantidade(quantidade);
        }
    }

    @Override
    public void buscarPorNomeDeProduto(String produto) {
        for (int id=0; id<this.produtos.size(); id++){
            if (this.produtos.get(id).getNome().equals(produto)){
                System.out.println("O produto procurado está na posição "+(id+1)+" com id "+id);
            }
        }
    }

    @Override
    public double TotalEstoque() {
        double total = 0;
        for (Produto produto : produtos){
            total += produto.getValor() * produto.getQuantidade();
        }
        return total;
    }

    @Override
    public boolean verificarDisponibilidade(int id, int quantidade) {
        if (this.produtos.size() > id){
            Produto produto = this.produtos.get(id);
            return produto.getQuantidade() >= quantidade;
        }
        return false;
    }
}
