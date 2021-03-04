package banco;

public class ContaCorrente extends Conta{
	int contadorTalao;
	
	public ContaCorrente() {	
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
	
	public void pediTalao() {
		if(this.getContadorTalao() <= 3) {
			this.setContadorTalao(this.getContadorTalao() + 1);
			
			System.out.println("Requisicao de talao aceita!");
			
		}else {
			System.out.println("Desculpe, voce ja realizou todas as requisicoes de taloes de cheque do mes.");
		}
		
	}
}
