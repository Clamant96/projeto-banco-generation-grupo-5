package banco;

public class ContaPoupanca extends Conta {
	private int aniversarioPoupanca;
	
	public ContaPoupanca() {
	}
	
	public ContaPoupanca(int numero, String cpf, int aniversarioPoupanca) {
		super(numero, cpf);
		this.aniversarioPoupanca = aniversarioPoupanca;
	}
	
	public void setAniversarioPoupanca(int aniversarioPoupanca) {
		this.aniversarioPoupanca = aniversarioPoupanca;
	}
	
	public int getAniversarioPoupanca() {
		return this.aniversarioPoupanca;
	}
	
	public double correcao(int reajuste) {
		
		if(reajuste == this.getAniversarioPoupanca()) {
			double juros = 0.05;
			
			System.out.println("Aniversario da conta, foi realizado um reajuste de 0,05% de juros");
			System.out.printf("Saldo atual R$ %f \n", this.getSaldo());
			
			System.out.println();
			
		}else {
			System.out.println("Nao ha reajuste ate o momento!");
		}
		
		return this.getSaldo();
	}
	
	public void correcaoAniversario(int aniversarioPoupanca) {
		if(aniversarioPoupanca == this.getAniversarioPoupanca()) {
			System.out.println("Parabéns, feliz aniversário! Sua conta acaba de completar mais um mês em nosso banco. Haverá uma correção no seu saldo de 0,05%.");
			this.saldo = (this.getSaldo() * 0.05) + this.getSaldo();
			
			System.out.println("Saldo atual R$ " + this.getSaldo());
			
		}else {
			System.out.println("Seu saldo atual é R$" + this.getSaldo());
			System.out.println("Siga para o próximo passo. Tenha um ótimo dia.");
		}	
		
	}
	
	public void credito(double valor) {
		this.saldo = this.getSaldo() + valor;
		
		System.out.println("Valor depositado com sucesso!");
		System.out.println("Saldo Atual: "+ this.getSaldo());
		
		this.gravarMovimentacaoCredito(this.getContarMovimentacao(), this.getSaldo(), valor);
		
		this.setContarMovimentacao(this.getContarMovimentacao() + 1);
		
	}
	
	public void debito(double valor) {
		if(this.getSaldo() >= valor) {
			this.saldo = this.getSaldo() - valor;
			
			System.out.println("Valor debitado com sucesso!");
			System.out.println("Saldo Atual R$ "+ this.getSaldo());
			
			this.gravarMovimentacaoDebito(this.getContarMovimentacao(), this.getSaldo(), valor);
			
			this.setContarMovimentacao(this.getContarMovimentacao() + 1);
				
		}else {
			System.out.printf("O valor R$ %.2f e maior do que voce tem em conta!", valor);
		}
			
	}
}
