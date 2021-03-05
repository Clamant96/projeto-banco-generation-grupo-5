package banco;

import java.util.Random;
import java.util.Scanner;

public abstract class Conta {
	private int numero;
	private String cpf;
	//depois alterar para private
	protected double saldo;
	private boolean ativa;
	
	private double[] movimento = new double[2];
	
	Random aleatorio = new Random();
	
	public Conta() {
	}
	
	public Conta(int numero) {
		this.numero = numero;
	}
	
	public Conta(int numero, String cpf) {
		this.numero = numero;
		this.cpf = cpf;
	}
	
	public Conta(int numero, double saldo, String cpf, boolean ativa) {
		this.numero = numero;
		this.cpf = cpf;
		this.ativa = ativa;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}
	
	public boolean getAtiva() {
		return this.ativa;
	}
	
	// Movimentos conta
	public void setMovimento(double movimento[]) {
		this.movimento = movimento;
	}
	
	public double[] getMovimento() {
		return this.movimento;
	}
	
	public void credito(double creditar) {
		if(creditar > 0) {
			this.saldo = this.getSaldo() + creditar;
			System.out.printf("O valor R$ %.2f foi inserido com sucesso em sua conta!\n", creditar);
			//System.out.printf("Saldo atual R$ %.2f\n", this.getSaldo());
			System.out.println();
			
		}else if(creditar == 0) {
			System.out.printf("O valor R$ %.2f depositado deve ser maior que R$ 0,00 \n", creditar);
			System.out.println("Transacao bloqueada");
			
		}else if(creditar < 0) {
			System.out.printf("O valor R$ %.2f depositado deve positivo \n", creditar);
			System.out.println("Transacao bloqueada");
			
		}
	}
	
	public void debito(double debitar) {
		if(debitar <= this.getSaldo()) {
			this.saldo = this.getSaldo() - debitar;
			System.out.printf("Saque de R$ %.2f realizado com sucesso!! \n", debitar);
			
			System.out.println();
			System.out.printf("Saldo atual R$ %.2f \n", this.getSaldo());
			System.out.println();
			
		}else {
			System.out.printf("O valor R$ %f que voce deseja sacar e invalido\n", debitar);
			System.out.println();
		}
	}
	
	public void debito(double debitar, double limite) {
		System.out.printf("Saldo atual R$ %.2f \n", this.getSaldo());
		System.out.println();
		
		if(debitar <= this.getSaldo() && debitar <= limite) {
			this.saldo = this.getSaldo() - debitar;
			/*System.out.printf("Saque de R$ %.2f realizado com sucesso!! \n", debitar);
			
			System.out.println();
			System.out.printf("Saldo atual R$ %.2f \n", this.getSaldo());
			System.out.println();*/
			
		}else if(debitar > limite){
			System.out.println("O valor desejado ultrapassa seu limite de credito mensal.");
			
		}else {
			this.saldo = this.getSaldo() - debitar;
			//contaEspecial.setLimite(limite - this.getSaldo());
			
			//this.saldo = 0;
			
			/*System.out.println("Voce esta utilizando seu limite de credito!");
			System.out.printf("Saque de R$ %.2f realizado com sucesso!! \n", debitar);
			
			System.out.println();
			System.out.printf("Saldo atual R$ %.2f \n", this.getSaldo());
			//System.out.printf("Saldo limite R$ %.2f", contaEspecial.getLimite());
			System.out.println();*/
		}
		
	}
	
	public void ajusteSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void gerarNumero() {
		this.setNumero(aleatorio.nextInt((999999 - 111111) + 1) + 111111);
	}
	
	public void menuPerfil() {
		Random aleatorio = new Random();
		Scanner entradaDados = new Scanner(System.in);
		
		int opcao;
		int valor = 0;
		
		// MENU | PERFIL DE CONTA
		System.out.println("Ola, seja bem vindo ao BBBank");
		System.out.println("Bom, Bonito e Barato");
		
		System.out.println();
		System.out.println("Seja Bem-Vindo a sua Conta Especial");
		System.out.println("Numero Conta: "+ this.getNumero());
		
		do {
			System.out.println("1 | VERIFICAR SALDO");
			System.out.println("2 | VERIFICAR DADOS CADASTRAIS");
			System.out.println("3 | CREDITAR");
			System.out.println("4 | DEBITAR");
			System.out.println("0 | LOGOUT");
			
			System.out.print("==> "); 
			opcao = entradaDados.next().charAt(0);
			entradaDados.nextLine();
			
			switch(opcao) {
				case '1':
					System.out.println("MENU | VERIFICAR SALDO");
					System.out.println();
					
					System.out.println("Saldo Conta: "+ this.getSaldo());
					//System.out.println("Limite de Credito: "+ this.getLimite());
					System.out.println();
				break;
				
				case '2':
					System.out.println("MENU | MEU DADOS");
					System.out.println();
					
					System.out.println("Conta: "+ this.getNumero());
					System.out.println("CPF: "+ this.getCpf());
					System.out.println("Saldo Conta: "+ this.getSaldo());
					//System.out.println("Limite de Credito: "+ this.getLimite());
					System.out.println();
				break;
				
				case '3':
					System.out.println("MENU | CREDITAR");
					System.out.println();
					
					System.out.println("Quanto voce deseja depositar? ");
					System.out.print("R$ ");
					valor = entradaDados.nextInt();
					
					this.credito(valor);
					System.out.println();
				break;
				
				case '4':
					System.out.println("MENU | DEBITAR");
					System.out.println();
					
					System.out.println("Quanto voce deseja sacar? ");
					System.out.print("R$ ");
					valor = entradaDados.nextInt();
					
					//this.debito(valor, this.getLimite());
					System.out.println();
				break;
				
				case '0':
					System.out.println("LOGOUT");
					System.out.println();
				break;
				
				default:
					System.out.println("Opcao invalida, tente novamente!");
					System.out.println();
				break;
			}
			
		}while(opcao != '0');
	
	}
}
