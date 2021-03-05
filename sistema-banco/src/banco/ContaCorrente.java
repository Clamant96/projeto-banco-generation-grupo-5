package banco;

public class ContaCorrente extends Conta{
	int contadorTalao;
	
	public ContaCorrente() {	
		this.setContadorTalao(0);
	}
	
	public ContaCorrente(int numero, String cpf) {	
		super(numero, cpf);
		this.setContadorTalao(0);
	}
	
	public ContaCorrente(int contadorTalao) {
		this.setContadorTalao(0);
	}
	
	public void setContadorTalao(int contadorTalao) {
		this.contadorTalao = contadorTalao;
	}
	
	public int getContadorTalao() {
		return this.contadorTalao;
	}
	
	public void pedeTalao() {
        if (this.getContadorTalao() < 3) {
            this.setContadorTalao(this.getContadorTalao() + 1);

            System.out.println("Talão de cheque solicitado");

        } else { 
            System.out.println("Você atingiu o limite mensal.");
            
        }
    }
	
	
	@Override
	public void debito(double debitar) {
		if(debitar <= this.getSaldo()) {
			this.saldo = this.getSaldo() - debitar;
			System.out.printf("Saque de R$ %.2f realizado com sucesso!! \n", debitar);
			
			System.out.println();
			System.out.printf("Saldo atual R$ %.2f \n", this.getSaldo());
			System.out.println();
			
			this.gravarMovimentacaoDebito(this.getContarMovimentacao(), this.getSaldo(), debitar);
			
			//i++;
			this.setContarMovimentacao(this.getContarMovimentacao() + 1);
			
		}else {
			System.out.printf("O valor R$ %f que voce deseja sacar e invalido\n", debitar);
			System.out.println();
		}
	}
}
