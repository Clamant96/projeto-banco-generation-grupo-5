package banco;

import java.util.Random;
import java.util.Scanner;

public class Banco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random aleatorio = new Random();
		Scanner entradaDados = new Scanner(System.in);
		
		//ContaEspecial ce = new ContaEspecial();
		
		/*ce.debito(50, ce.getLimite());
		ce.setNumero(123456);
		ce.credito(10);
		ce.debito(50, ce.getLimite());
		ce.credito(5);*/

		int opcao;
		int valor = 0;
		
		String cpf;
		int numero;
		int aniversarioPoupanca;
		
		do {
			System.out.println("Ola, seja bem vindo ao Connect Banck.");
			System.out.println("Encurtando distancias entre seus objetivos.");
			System.out.println("O que voce gostaria de fazer hoje?");
			
			System.out.println();
			
			System.out.println("1 | CONTA POUPANCA");
			System.out.println("2 | CONTA CORRENTE");
			System.out.println("3 | CONTA ESPECIAL");
			System.out.println("4 | CONTA EMPRESA");
			System.out.println("5 | CONTA ESTUDANTIL");
			System.out.println("0 | SAIR");
			
			System.out.print("==> "); 
			opcao = entradaDados.next().charAt(0);
			entradaDados.nextLine();
			
			switch(opcao) {
				case '1':
					System.out.println("PERFIL | CONTA POUPANCA");
					System.out.println();
					
					System.out.println("Cadastro: ");
					System.out.print("CPF: ");
					cpf = entradaDados.nextLine();
					
					numero = aleatorio.nextInt((999999 - 111111) + 1) + 111111;
					aniversarioPoupanca = 30;
					
					ContaPoupanca cp = new ContaPoupanca(numero, cpf, aniversarioPoupanca);
					
					cp.menuPerfil();
				break;
				
				case '2':
					System.out.println("PERFIL | CONTA CORRENTE");
					System.out.println();
					
					System.out.println("Cadastro: ");
					System.out.print("CPF: ");
					cpf = entradaDados.nextLine();
					
					numero = aleatorio.nextInt((999999 - 111111) + 1) + 111111;
					aniversarioPoupanca = 30;
					
					ContaCorrente cc = new ContaCorrente(numero, cpf);
					
					cc.menuPerfil();
				break;
				
				case '3':
					System.out.println("PERFIL | CONTA ESPECIAL");
					System.out.println();
					
					System.out.println("Cadastro: ");
					System.out.print("CPF: ");
					cpf = entradaDados.nextLine();
					
					numero = aleatorio.nextInt((999999 - 111111) + 1) + 111111;
					
					ContaEspecial ce = new ContaEspecial(numero, cpf);
					
					ce.menuPerfil();
					
					/*System.out.println("Cadastro: ");
					System.out.print("CPF: ");
					ce.setCpf(entradaDados.nextLine());
					
					ce.gerarNumero();
					System.out.println("Numero Conta: "+ ce.getNumero());
					System.out.println();
					
					// MENU | PERFIL DE CONTA
					System.out.println("Ola, seja bem vindo ao Connect Banck.");
					System.out.println("Encurtando distancias entre seus objetivos.");
					
					System.out.println();
					System.out.println("Seja Bem-Vindo a sua Conta Especial");
					System.out.println("Numero Conta: "+ ce.getNumero());
					
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
								
								System.out.println("Saldo Conta: "+ ce.getSaldo());
								System.out.println("Limite de Credito: "+ ce.getLimite());
								System.out.println();
							break;
							
							case '2':
								System.out.println("MENU | MEU DADOS");
								System.out.println();
								
								System.out.println("Conta: "+ ce.getNumero());
								System.out.println("CPF: "+ ce.getCpf());
								System.out.println("Saldo Conta: "+ ce.getSaldo());
								System.out.println("Limite de Credito: "+ ce.getLimite());
								System.out.println();
							break;
							
							case '3':
								System.out.println("MENU | CREDITAR");
								System.out.println();
								
								System.out.println("Quanto voce deseja depositar? ");
								System.out.print("R$ ");
								valor = entradaDados.nextInt();
								
								ce.credito(valor);
								System.out.println();
							break;
							
							case '4':
								System.out.println("MENU | DEBITAR");
								System.out.println();
								
								System.out.println("Quanto voce deseja sacar? ");
								System.out.print("R$ ");
								valor = entradaDados.nextInt();
								
								ce.debito(valor, ce.getLimite());
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
						
					}while(opcao != '0');*/
					
				break;
					
				case '4':
					System.out.println("PERFIL | CONTA EMPRESA");
					System.out.println();
				break;
					
				case '5':
					System.out.println("PERFIL | CONTA ESTUDANTIL");
					System.out.println();
					
					System.out.println("Cadastro: ");
					System.out.print("CPF: ");
					cpf = entradaDados.nextLine();
					
					numero = aleatorio.nextInt((999999 - 111111) + 1) + 111111;
					
					ContaEstudantil ca = new ContaEstudantil(numero, cpf);
					
					ca.menuPerfil();
				break;
					
				case '0':
					System.out.println("Sair!");
				break;
					
				default:
					System.out.println("Opcao invalida, tente novamente!");
				break;
					
			}
			
		}while(opcao != '0');
	}

}
