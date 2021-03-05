package banco;

import java.util.Random;
import java.util.Scanner;

public class ContaEmpresa extends Conta {
	private double emprestimo = 10000;
	private double valorEmprestimo=0;
	private int op;
	private char opcao;
	int i = 0;
	
	Scanner ler = new Scanner(System.in); 
	
	public ContaEmpresa(int numero, String cpf, double emprestimo/*, double valorEmprestimo*/) {
		super(numero, cpf);
		this.emprestimo = emprestimo;
		//this.valorEmprestimo = valorEmprestimo;
	}
	
	public ContaEmpresa() {
		
	}
	

	public double getEmprestimo() {
		return emprestimo;
	}


	public void setEmprestimo(double emprestimo) {
		this.emprestimo = emprestimo;
	}


	public double getValorEmprestimo() {
		return valorEmprestimo;
	}


	public void setValorEmprestimo(double valorEmprestimo) {
		this.valorEmprestimo = valorEmprestimo;
	}


	public int getOp() {
		return op;
	}


	public void setOp(int op) {
		this.op = op;
	}


	public void mostrarsaldo() {
		System.out.println("Saldo atual R$ "+this.getSaldo());
	}
	
	
	@Override
	public void credito(double valor) {
		this.saldo = this.saldo+valor;
		
		System.out.println("---------------------------------");
		System.out.println("\nDeposito realizado com sucesso.");
		System.out.printf("\nSaldo atual R$ %.2f ",this.getSaldo());
		System.out.println();
		System.out.println("---------------------------------");

		
	}	
	
	@Override
	public void debito(double valor) {
		if (this.saldo >= valor) {
			
			this.saldo = this.saldo - valor;
			
			System.out.println("---------------------------------");
			System.out.println("\nSaque realizado com sucesso.");
			System.out.printf("\nSaldo atual R$ %.2f ", this.getSaldo());
			System.out.println("\n---------------------------------");
			
			this.gravarMovimentacaoDebito(i, this.getSaldo(), valor);
			
			i++;
			
		}
		
		else if (this.saldo <= valor ) {
			
			this.pegaremprestimo();
		}
		
		else {
			System.out.println("\nTransação Negada");
		}
	}

	public void pegaremprestimo() {
		if (this.saldo >= 0 ) {
			
			System.out.printf("\nVocê tem R$ %.2f dísponivel para emprestimo.",emprestimo);
			
				System.out.println("\nDeseja pegar valor de emprestimo Sim [S] ou Não [N]:  ");
				
				opcao = ler.next().toUpperCase().charAt(0);
				
				if (opcao =='S'){
						
					
						if (this.getEmprestimo() <=0 ) {
							System.out.println("TRANSAÇÃO NEGADA.");
						}
						
						System.out.print("\nDigite o valor que deseja de emprestimo: ");
						valorEmprestimo = ler.nextDouble();
					
						
			        	this.setEmprestimo(this.getEmprestimo()-valorEmprestimo);
			        	
			        	this.saldo = this.saldo+valorEmprestimo;
			        	
						System.out.println("\nEmprestimo realizado com sucesso.");
			        	System.out.printf("\nSaldo atual : R$ %.2f ", this.getSaldo());
			        	//Aparece esse saldo ?System.out.printf("\nEmprestimo saldo: R$ %.2f ",emprestimo);
			        	System.out.println();
			        	
			        	this.gravarMovimentacaoDebito(i, this.getSaldo(), this.getValorEmprestimo(), this.getEmprestimo());
						
						i++;
			 
			        }
			       
			        else if (opcao =='N') {

			        	System.out.println("Obrigado por utilizar nossos serviços!");
			        }					
		}		

	}
	
	@Override
	public void menuPerfil() {
		Random aleatorio = new Random();
		Scanner entradaDados = new Scanner(System.in);
		
		int opcao;
		int valor = 0;
		/*int i = 0;*/
		
		// MENU | PERFIL DE CONTA
		System.out.println("Ola, seja bem vindo ao BBBank - G5");
		System.out.println("Bom, Bonito e Barato.");
		
		System.out.println();
		System.out.println("Seja Bem-Vindo a sua Conta Empresa");
		System.out.println("Numero Conta: "+ this.getNumero());
		
		do {
			System.out.println("1 | VERIFICAR SALDO");
			System.out.println("2 | VERIFICAR DADOS CADASTRAIS");
			System.out.println("3 | SOLICITAR EMPRESTIMO");
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
					System.out.println("Emprestimo: "+ this.getEmprestimo());
					System.out.println();
				break;
				
				case '3':
					System.out.println("MENU | MEU EMPRESTIMO");
					System.out.println();
					
					this.mostrarsaldo();
		        	this.pegaremprestimo();
					
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
					
					this.gravarMovimentacaoCredito(i, this.getSaldo(), valor);
					
					i++;
					
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
