public class Produto {
	private String nome;
	private double valor;
	private int quantidade;

	public Produto(String nome, double valor, int quantidade) {
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public double getValor() {
		return valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
