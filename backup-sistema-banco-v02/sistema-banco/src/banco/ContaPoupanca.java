package banco;

import java.util.Random;
import java.util.Scanner;

public class ContaPoupanca extends Conta {
	private int aniversarioPoupanca;
	int i = 0;
	
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
		
		this.gravarMovimentacaoCredito(i, this.getSaldo(), valor);
		
		i++;
		
	}
	
	public void debito(double valor) {
		if(this.getSaldo() >= valor) {
			this.saldo = this.getSaldo() - valor;
			
			System.out.println("Valor debitado com sucesso!");
			System.out.println("Saldo Atual R$ "+ this.getSaldo());
			
			this.gravarMovimentacaoDebito(i, this.getSaldo(), valor);
			
			i++;
				
		}else {
			System.out.printf("O valor R$ %.2f e maior do que voce tem em conta!", valor);
		}
			
	}
	
	public void menuPerfil() {
		Random aleatorio = new Random();
		Scanner entradaDados = new Scanner(System.in);
		
		int opcao;
		int valor = 0;
		/*int i = 0;*/
		
		// MENU | PERFIL DE CONTA
		System.out.println("Ola, seja bem vindo ao BBBank");
		System.out.println("Bom, Bonito e Barato.");
		
		System.out.println();
		System.out.println("Seja Bem-Vindo a sua Conta Poupança");
		System.out.println("Numero Conta: "+ this.getNumero());
		
		do {
			System.out.println("1 | VERIFICAR SALDO");
			System.out.println("2 | VERIFICAR DADOS CADASTRAIS");
			System.out.println("3 | VERIFICAR ANIVERSARIO");
			System.out.println("4 | CREDITAR");
			System.out.println("5 | DEBITAR");
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
					System.out.println("Aniversario da conta dia "+ this.getAniversarioPoupanca());
					//System.out.println("Limite de Credito: "+ this.getLimite());
					System.out.println();
				break;
				
				case '3':
					System.out.println("MENU | ANIVERSARIO CONTA");
					System.out.println();
					
					System.out.print("Por favor, informe o dia de hoje: ");
					valor = entradaDados.nextInt();
					
					this.correcaoAniversario(valor);
					System.out.println();
				break;
				
				case '4':
					System.out.println("MENU | CREDITAR");
					System.out.println();
					
					System.out.println("Quanto voce deseja depositar? ");
					System.out.print("R$ ");
					valor = entradaDados.nextInt();
					
					this.credito(valor);
					
					//this.gravarMovimentacaoConta(i, this.getSaldo());
					
					/*this.gravarMovimentacaoCredito(i, this.getSaldo(), valor);
					
					i++;*/
					
					System.out.println();
				break;
				
				case '5':
					System.out.println("MENU | DEBITAR");
					System.out.println();
					
					System.out.println("Quanto voce deseja sacar? ");
					System.out.print("R$ ");
					valor = entradaDados.nextInt();
					
					this.debito(valor);
					
					//this.gravarMovimentacaoConta(i, this.getSaldo());
					
					/*this.gravarMovimentacaoDebito(i, this.getSaldo(), valor);
					
					i++;*/
					
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
			
			//i++;
			
			if(i == this.getMovimento().length) {
				opcao = '0';
				
				System.out.println("-----------------------------------------------");
				System.out.println("Voce realizou o maximo de movimentacoes do dia!");
				System.out.println("-----------------------------------------------");
				System.out.println();
				
			}
			
		}while(opcao != '0');
		
		/*System.out.println("Movimentacao Mensal");
		for(int j = 0; j < this.getMovimento().length; j++) {
			System.out.print("Movimentacao "+ (j + 1) +": "+ this.getMovimento()[j]);
			System.out.println();
		}*/
		
		this.listarMovimentacoesConta();
	
	}
}
