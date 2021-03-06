package banco;

public class ContaEspecial extends Conta{
	private double limite;

	public ContaEspecial() {
		this.setLimite(1000);
	}

	public ContaEspecial(double limite) {
		this.setLimite(1000);
	}
	
	public ContaEspecial(int numero, String cpf) {
		super(numero, cpf);
		this.setLimite(1000);
	}
	
	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	public double getLimite() {
		return this.limite;
	}
	
	@Override
	public void credito(double creditar) {
		super.credito(creditar);
	}

	@Override
	public void debito(double debitar, double limite) {
		super.debito(debitar, limite);
		
		if(this.getSaldo() < 0 && debitar <= limite) {
			this.setLimite(this.getSaldo() + this.getLimite());
			
			System.out.println("Voce esta utilizando seu limite de credito!");
			System.out.printf("Saque de R$ %.2f realizado com sucesso!! \n", debitar);
			
			System.out.println();
			
			this.ajusteSaldo(0);
			
			System.out.printf("Saldo atual R$ %.2f \n", this.getSaldo());
			System.out.printf("Saldo limite R$ %.2f", this.getLimite());
			System.out.println();
			
			this.gravarMovimentacaoDebito(this.getContarMovimentacao(), this.getSaldo(), debitar, this.getLimite());
			
			this.setContarMovimentacao(this.getContarMovimentacao() + 1);
			
		}else if(debitar <= limite) {
			System.out.printf("Saque de R$ %.2f realizado com sucesso!! \n", debitar);
			
			System.out.println();
			System.out.printf("Saldo atual R$ %.2f \n", this.getSaldo());
			System.out.printf("Saldo limite R$ %.2f", this.getLimite());
			
			this.gravarMovimentacaoDebito(this.getContarMovimentacao(), this.getSaldo(), debitar);
			
			this.setContarMovimentacao(this.getContarMovimentacao() + 1);
			
		}
		
	}
}
