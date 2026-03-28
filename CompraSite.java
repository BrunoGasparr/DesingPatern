package DesingPatern;

public class CompraSite implements RegraFinanceiro {
    String enderecoEntrega;

    @Override
    public void pagar(double valor) {
        if (enderecoEntrega != null){
            System.out.println("[SITE] Validando cartão de crédito...");
            System.out.println("[SITE] Pagamento de R$ " + calcularValorTotal(valor) + " aprovado.");
            System.out.println("[SITE] Logística: Preparando envio para: " + this.enderecoEntrega);
        }
    }

    @Override
    public String getEnderecoEntrega(){
        return enderecoEntrega;
    }

    @Override
    public double calcularDesconto(double valorBruto) {
        //Desconto na loja virtual é 0
        return valorBruto*1;
    }

    @Override
    public double calcularValorTotal(double valorBruto) {
        // Descontos vezes a taxa
        return calcularDesconto(valorBruto)*1.06;
    }

    @Override
    public void exibirResumoFinanceiro(double valor) {
        if (enderecoEntrega != null){
            System.out.println("\n--- COMPROVANTE DIGITAL ---");
            System.out.println("Valor Final: R$ " + calcularValorTotal(valor));
            System.out.println("Entrega em: " + enderecoEntrega);
            System.out.println("Lucro Total: "+calcularLucroLiquido(valor));
        } else System.out.println("Você deve decidir o endereço de entrega antes.");
    }

    @Override
    public double calcularLucroLiquido(double ultimoValorProcessado) {
        // O site tem taxas de transação digital (ex: 5%) e impostos (10%)
        return ultimoValorProcessado * 0.85;
    }

    @Override
    public void realizarEstorno() {
        System.out.println("[SITE] Gerando vale-troca para transação...");
    }

    // Getter e Setter específico do Site
    @Override
    public void setEnderecoEntrega(String endereco){
        this.enderecoEntrega = endereco;
    }
}
