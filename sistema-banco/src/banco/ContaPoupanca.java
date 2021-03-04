package banco;

public class ContaPoupanca extends Conta {
	private int aniversarioPoupanca;
	
	public ContaPoupanca() {
	}
	
	public ContaPoupanca(int aniversarioPoupanca) {
		this.aniversarioPoupanca = aniversarioPoupanca;
	}
	
	public void setAniversarioPoupanca(int aniversarioPoupanca) {
		this.aniversarioPoupanca = aniversarioPoupanca;
	}
	
	public int getAniversarioPoupanca() {
		return this.aniversarioPoupanca;
	}
	
	public double correcao(int reajuste) {
		// duvida em relacao a como sera calculado o valor do aniversario
		
		if(reajuste == this.getAniversarioPoupanca()) {
			double juros = 0.05;
			//this.saldo = (this.getSaldo() * juros) + this.getSaldo();
			
			System.out.println("Aniversario da conta, foi realizado um reajuste de 0,05% de juros");
			System.out.printf("Saldo atual R$ %f \n", this.getSaldo());
			
			System.out.println();
			
		}else {
			System.out.println("Nao ha reajuste ate o momento!");
		}
		
		return this.getSaldo();
	}
}
