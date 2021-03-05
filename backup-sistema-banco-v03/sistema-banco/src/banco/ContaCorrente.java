package banco;

import java.util.Random;
import java.util.Scanner;

public class ContaCorrente extends Conta{
	int contadorTalao;
	/*int i = 0;*/
	
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

	/*public void menuPerfil() {
		Random aleatorio = new Random();
		Scanner entradaDados = new Scanner(System.in);
		
		int opcao;
		int valor = 0;
		
		// MENU | PERFIL DE CONTA
		System.out.println("Ola, seja bem vindo ao BBBank - G5");
		System.out.println("Bom, Bonito e Barato");
		
		System.out.println();
		System.out.println("Seja Bem-Vindo a sua Conta Corrente");
		System.out.println("Numero Conta: "+ this.getNumero());
		
		do {
			System.out.println("1 | VERIFICAR SALDO");
			System.out.println("2 | VERIFICAR DADOS CADASTRAIS");
			System.out.println("3 | SOLICITAR TALAO");
			System.out.println("4 | CREDITAR");
			System.out.println("5 | DEBITAR");
			System.out.println("0 | LOGOUT");
			
			System.out.print("==> "); 
			opcao = entradaDados.next().charAt(0);
			entradaDados.nextLine();
			
			//System.out.println("O valor da posicao e: "+ (i + 1));
			
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
					System.out.print("Taloes Solicitados: "+ this.getContadorTalao());
					System.out.println();
				break;
				
				case '3':
					System.out.println("MENU | MEUS TALOES");
					System.out.println();
	                
	                do {
	                	System.out.print("Deseja solicitar um cheque? S/N ");
	                    opcao = entradaDados.next().toUpperCase().charAt(0);
	                    
	                    System.out.println();
	                    //System.out.println("Valor de opcao: "+ opcao);
	                    
	                    if(opcao != 'S' && opcao != 'N'){ 
	                    	System.out.println("Opcao invalida!");
	                    	
	                	}else if(opcao == 'S') {
	                    	this.pedeTalao();
	                    	System.out.println("Talao solicitado!");
	                    
	                    }else if(opcao == 'N') {
	                    	System.out.println("Se mudar de ideia, entre em contato!");
	                    	
	                    }
	                	
	                } while(opcao != 'S' && opcao != 'N');
	                
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
					
					i++;
					
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
		
		do{
        	System.out.println("Você atingiu o limite de transações mensais. Deseja solicitar um cheque? S/N");
            opcao = entradaDados.next().toUpperCase().charAt(0);
            
            if(opcao == 'S' && this.getContadorTalao() < 3) {
                this.pedeTalao();
                System.out.println("Taloes pedidos ate o momento: "+ this.getContadorTalao());
                    
            } else {
                System.out.println("Saldo Atual: " + this.getSaldo());
                opcao = 'N';
            }
    		
    	} while(opcao != 'N');
		
		System.out.println("Movimentacao Mensal");
		for(int j = 0; j < this.getMovimento().length; j++) {
			System.out.print("Movimentacao "+ (j + 1) +": "+ this.getMovimento()[j]);
			System.out.println();
		}
		
		this.listarMovimentacoesConta();
	
	}*/
}
