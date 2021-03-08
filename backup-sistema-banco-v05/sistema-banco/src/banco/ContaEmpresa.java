package banco;

import java.util.Scanner;

public class ContaEmpresa extends Conta {
	private double emprestimo = 10000;
	private double valorEmprestimo=0;
	private int op;
	private char opcao;
	//int i = 0;
	
	Scanner ler = new Scanner(System.in); 
	
	public ContaEmpresa(int numero, String cpf, double emprestimo/*, double valorEmprestimo*/) {
		super(numero, cpf);
		this.emprestimo = emprestimo;
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
	public void credito(double creditar) {
		super.credito(creditar);	
	}	
	
	@Override
	public void debito(double valor) {
		if (this.getSaldo() >= valor) {
			
			this.saldo = this.getSaldo() - valor;
			
			System.out.println("\nSaque realizado com sucesso.");
			System.out.printf("\nSaldo atual R$ %.2f ", this.getSaldo());
			
			this.gravarMovimentacaoDebito(this.getContarMovimentacao(), this.getSaldo(), valor);
			
			this.setContarMovimentacao(this.getContarMovimentacao() + 1);
			
		}
		
		else if (this.getSaldo() <= valor) {
			System.out.print("Saldo Insuficiente");
			this.pegaremprestimo();
		}

	}

	public void pegaremprestimo() {
		if (this.getSaldo() >= 0 ) {
			
			System.out.printf("\nVocê tem R$ %.2f dísponivel para emprestimo.",emprestimo);
			
				System.out.print("\nDeseja pegar valor de emprestimo Sim [S] ou Não [N]:  ");
				opcao = ler.next().toUpperCase().charAt(0);
				
				
				if (opcao =='S'){
						
					System.out.print("Digite o valor que deseja de emprestimo: ");
					valorEmprestimo = ler.nextDouble();
					
					if (this.getEmprestimo() <=0 || this.getValorEmprestimo() > emprestimo) {
						System.out.println("TRANSAÇÃO NEGADA.");
						System.out.printf("Seu limite de emprestimo é de %.2f\n",emprestimo);
					}	
					
					else {
					this.setEmprestimo(this.getEmprestimo()-valorEmprestimo);
		        	
		        	this.saldo = this.getSaldo()+valorEmprestimo;
		        	
		        	System.out.println();
					System.out.println("Emprestimo realizado com sucesso.");
		        	System.out.printf("Saldo atual : R$ %.2f ", this.getSaldo());
		        	//Aparece esse saldo ?System.out.printf("\nEmprestimo saldo: R$ %.2f ",emprestimo);
		        	System.out.println();
					}
		
		        	this.gravarMovimentacaoCredito(this.getContarMovimentacao(), this.getSaldo(), this.getValorEmprestimo(), this.getEmprestimo());
					
					this.setContarMovimentacao(this.getContarMovimentacao() + 1);
		        }
								       
			        else if (opcao =='N') {
			        	System.out.println("Obrigado por utilizar nossos serviços!");
			        }					
		}		
	}
}
