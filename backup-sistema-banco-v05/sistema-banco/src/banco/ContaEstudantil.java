package banco;

import java.util.Scanner;

public class ContaEstudantil extends Conta {
	
	int contador = 0;
	int opcao = 0;
	double limiteEstudantil = 5000;
	
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
			
			this.gravarMovimentacaoDebito(this.getContarMovimentacao(), this.getSaldo(), valor);
			
			this.setContarMovimentacao(this.getContarMovimentacao() + 1);
		}
		// aqui ele tenta debitar mas o valor que tem na conta e no limite estudantil � menor do q a conta q ele qr pagar(debito)
		// VERIFICAR ESSA LOGICA
		else if(valor > saldo && valor > this.getLimiteEstudantil() + saldo) {
			System.out.println("Voc� n�o possui saldo nem limite estudantil suficiente para debitar esse valor.");
		
		}
		// aqui ele ve que a conta � maior que o saldo da conta dele, ent�o ele pergunta se quer utilizar o limite estudantil pra pagar a conta
		else if(valor > this.getSaldo() && valor <= this.getLimiteEstudantil() + saldo) {
				System.out.println("O saldo � menor do que o valor a ser debitado, deseja usar o Limite Estudantil?\n[1]Sim\n[2]Nao");
				
				opcao = leia.nextInt();
				
					if(opcao == 1 && saldo<=0) {// aqui ele paga s� com o valor do limite estudatil, ja que o saldo � 0
						this.setLimiteEstudantil(this.getLimiteEstudantil() - valor);
						
						contador++;
						
						this.gravarMovimentacaoDebito(this.getContarMovimentacao(), this.getSaldo(), valor, this.getLimiteEstudantil());
						
						this.setContarMovimentacao(this.getContarMovimentacao() + 1);
						
					}
					if(opcao == 1 && saldo>0) {// aqui ele checa se tem algo no saldo, e pergunta se qr utilizar o saldo pra completar pra pagar a conta
						System.out.printf("Voc� possui %.2f de saldo, deseja usar esse saldo para completar o d�bito?\n[1]Sim\n[2]N�o",this.saldo);
						
						opcao = leia.nextInt();
							
							if(opcao == 1) {// aqui se voc� aceitar, ele zera o saldo e desconta o resto na conta estudantil
								valor = valor - this.saldo;
								
								this.saldo = this.saldo - this.saldo;
								this.setLimiteEstudantil(this.getLimiteEstudantil() - valor);
								
								contador++;
								
								this.gravarMovimentacaoDebito(this.getContarMovimentacao(), this.getSaldo(), valor, this.getLimiteEstudantil());
								
								this.setContarMovimentacao(this.getContarMovimentacao() + 1);
								
							}
							else {// aqui se voc� recusar a usar o saldo que tem, ele checa se a conta � maior que o limite estudantil e bloqueia o d�bito se for
								
								if(valor > this.limiteEstudantil) {
									System.out.println("Voc� n�o possui limite estudantil o suficiente para completar a transa��o.");
									
								}
								else {//aqui se a conta for menor que o limite estudantil, ele debita do limite sem mexer no saldo
									this.setLimiteEstudantil(this.getLimiteEstudantil() - valor);
									contador++;
									
									this.gravarMovimentacaoDebito(this.getContarMovimentacao(), this.getSaldo(), valor, this.getLimiteEstudantil());
									
									this.setContarMovimentacao(this.getContarMovimentacao() + 1);
									
								}
								
							}
						
					}
					// aqui ele volta se vc dizer que n�o pra pergunta da linha 91, no caso ele bloqueia o d�bito 
					//pq o saldo � menor que a conta e vc nao qr usar o limite estudantil
					if(opcao == 2) {
						
					}
			}
	}
}
