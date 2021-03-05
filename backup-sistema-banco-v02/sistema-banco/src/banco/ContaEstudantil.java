package banco;

import java.util.Random;
import java.util.Scanner;

public class ContaEstudantil extends Conta {
	
	int contador = 0;
	int opcao = 0;
	double limiteEstudantil = 5000;
	int i = 0;
	
	Scanner leia = new Scanner(System.in);
	
	public ContaEstudantil() {
		
	}
	
	public ContaEstudantil(int numero, String cpf) {
		super(numero, cpf);
		this.setLimiteEstudantil(5000);
	}
	
	public double getLimiteEstudantil() {
		return limiteEstudantil;
	}

	public void setLimiteEstudantil(double limiteEstudantil) {
		this.limiteEstudantil = limiteEstudantil;
	}

	@Override
	public void debito(double valor) {
		if(this.getSaldo() >= valor) {
			this.saldo = this.getSaldo() - valor;
			this.contador++;
			
			System.out.println("Saque realizado com sucesso!!");
			System.out.println("R$ "+ this.getSaldo());
			
			this.gravarMovimentacaoDebito(i, this.getSaldo(), valor);
			
			i++;
		}
		// aqui ele tenta debitar mas o valor que tem na conta e no limite estudantil é menor do q a conta q ele qr pagar(debito)
		// VERIFICAR ESSA LOGICA
		else if(valor > saldo && valor > this.getLimiteEstudantil() + saldo) {
			System.out.println("Você não possui saldo nem limite estudantil suficiente para debitar esse valor.");
		
		}
		// aqui ele ve que a conta é maior que o saldo da conta dele, então ele pergunta se quer utilizar o limite estudantil pra pagar a conta
		else if(valor > this.getSaldo() && valor <= this.getLimiteEstudantil() + saldo) {
				System.out.println("O saldo é menor do que o valor a ser debitado, deseja usar o Limite Estudantil?\n[1]Sim\n[2]Nao");
				
				opcao = leia.nextInt();
				
					if(opcao == 1 && saldo<=0) {// aqui ele paga só com o valor do limite estudatil, ja que o saldo é 0
						this.setLimiteEstudantil(this.getLimiteEstudantil() - valor);
						
						contador++;
						
						this.gravarMovimentacaoDebito(i, this.getSaldo(), valor, this.getLimiteEstudantil());
						
						i++;
						
					}
					if(opcao == 1 && saldo>0) {// aqui ele checa se tem algo no saldo, e pergunta se qr utilizar o saldo pra completar pra pagar a conta
						System.out.printf("Você possui %.2f de saldo, deseja usar esse saldo para completar o débito?\n[1]Sim\n[2]Não",this.saldo);
						
						opcao = leia.nextInt();
							
							if(opcao == 1) {// aqui se você aceitar, ele zera o saldo e desconta o resto na conta estudantil
								valor = valor - this.saldo;
								
								this.saldo = this.saldo - this.saldo;
								this.setLimiteEstudantil(this.getLimiteEstudantil() - valor);
								
								contador++;
								
								this.gravarMovimentacaoDebito(i, this.getSaldo(), valor, this.getLimiteEstudantil());
								
								i++;
								
							}
							else {// aqui se você recusar a usar o saldo que tem, ele checa se a conta é maior que o limite estudantil e bloqueia o débito se for
								
								if(valor > this.limiteEstudantil) {
									System.out.println("Você não possui limite estudantil o suficiente para completar a transação.");
									
								}
								else {//aqui se a conta for menor que o limite estudantil, ele debita do limite sem mexer no saldo
									this.setLimiteEstudantil(this.getLimiteEstudantil() - valor);
									contador++;
									
									this.gravarMovimentacaoDebito(i, this.getSaldo(), valor, this.getLimiteEstudantil());
									
									i++;
									
								}
								
							}
						
					}
					// aqui ele volta se vc dizer que não pra pergunta da linha 91, no caso ele bloqueia o débito 
					//pq o saldo é menor que a conta e vc nao qr usar o limite estudantil
					if(opcao == 2) {
						
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
		System.out.println("Seja Bem-Vindo a sua Conta Estudantil");
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
					System.out.println("Limite de Credito: "+ this.getLimiteEstudantil());
					System.out.println();
				break;
				
				case '3':
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
				
				case '4':
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
