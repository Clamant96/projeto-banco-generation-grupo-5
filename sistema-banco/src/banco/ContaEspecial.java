package banco;

import java.util.Random;
import java.util.Scanner;

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
			
		}else if(debitar <= limite) {
			System.out.printf("Saque de R$ %.2f realizado com sucesso!! \n", debitar);
			
			System.out.println();
			System.out.printf("Saldo atual R$ %.2f \n", this.getSaldo());
			System.out.printf("Saldo limite R$ %.2f", this.getLimite());
			
		}
		
	}
	
	public void menuPerfil() {
		Random aleatorio = new Random();
		Scanner entradaDados = new Scanner(System.in);
		
		int opcao;
		int valor = 0;
		int i = 0;
		
		// MENU | PERFIL DE CONTA
		System.out.println("Ola, seja bem vindo ao BBBank - G5");
		System.out.println("Bom, Bonito e Barato.");
		
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
					System.out.println("Limite de Credito: "+ this.getLimite());
					System.out.println();
				break;
				
				case '2':
					System.out.println("MENU | MEU DADOS");
					System.out.println();
					
					System.out.println("Conta: "+ this.getNumero());
					System.out.println("CPF: "+ this.getCpf());
					System.out.println("Saldo Conta: "+ this.getSaldo());
					System.out.println("Limite de Credito: "+ this.getLimite());
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
					
					this.debito(valor, this.getLimite());
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
			
			i++;
			
			if(i == this.getMovimento().length) {
				opcao = '0';
				
				System.out.println("-----------------------------------------------");
				System.out.println("Voce realizou o maximo de movimentacoes do dia!");
				System.out.println("-----------------------------------------------");
				System.out.println();
				
			}
			
		}while(opcao != '0');
	}
	
}
