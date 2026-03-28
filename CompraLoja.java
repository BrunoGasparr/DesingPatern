package DesingPatern;

public class CompraLoja implements RegraFinanceiro{
    String enderecoEntrega = "Retirar na loja";

    @Override
    public void pagar(double valor) {
        System.out.println("[LOJA] Recebendo R$ " + valor + " em espécie/maquininha no balcão.");
    }

    @Override
    public double calcularDesconto(double valorBruto) {
        return valorBruto * 0.97;
    }

    @Override
    public double calcularValorTotal(double valorBruto) {
        return calcularDesconto(valorBruto)*1;
    }

    @Override
    public void exibirResumoFinanceiro(double valor) {
        System.out.println("Resumo Loja: Venda concluída. Lucro: R$ " + calcularLucroLiquido(valor)+"\nEntrega: "+enderecoEntrega);
    }

    @Override
    public double calcularLucroLiquido(double valorAcumuladoBruto) {
        // Loja física tem custos operacionais maiores (ex: sobra 70% do bruto)
        return valorAcumuladoBruto * 0.70;
    }

    @Override
    public void realizarEstorno() {
        System.out.println("[LOJA] Gerando vale-troca para transação...");
    }

    @Override
    public String getEnderecoEntrega(){
        return enderecoEntrega;
    }

    @Override
    public void setEnderecoEntrega(String endereco){}
}
