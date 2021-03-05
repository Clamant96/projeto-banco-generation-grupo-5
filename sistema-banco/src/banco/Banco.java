package banco;

/*import java.util.ArrayList;
import java.util.List;*/

import java.util.Random;
import java.util.Scanner;

public class Banco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random aleatorio = new Random();
		Scanner entradaDados = new Scanner(System.in);
		
		//List<Conta> conta = new ArrayList<>();

		int opcao;
		int valor = 0;
		char opcaoPerfil;
		
		String cpf;
		int numero;
		int aniversarioPoupanca;
		double emprestimo;
		
		do {
			System.out.println("Ola, seja bem vindo ao Connect Bank.");
			System.out.println("Bom, Bonito e Barato");
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
					/* ======================= */
					/* PERFIL | CONTA POUPANCA */
					/* ======================= */
					
					System.out.println("PERFIL | CONTA POUPANCA");
					System.out.println();
					
					System.out.println("Cadastro: ");
					System.out.print("CPF: ");
					cpf = entradaDados.nextLine();
					
					numero = aleatorio.nextInt((999999 - 111111) + 1) + 111111;
					aniversarioPoupanca = 30;
					
					/* =================================== */
					/* INSTANCIA A CLASSE - CONTA POUPANCA */
					/* =================================== */
					
					ContaPoupanca cp = new ContaPoupanca(numero, cpf, aniversarioPoupanca);
					//conta.add(new ContaPoupanca(numero, cpf, aniversarioPoupanca));
					
					opcaoPerfil = '0';
					valor = 0;
					cp.setContarMovimentacao(0);
					
					/* ====================== */
					/* MENU | PERFIL DE CONTA */
					/* ====================== */
					
					System.out.println("Ola, seja bem vindo ao BBBank");
					System.out.println("Bom, Bonito e Barato.");
					
					System.out.println();
					System.out.println("Seja Bem-Vindo a sua Conta Poupança");
					System.out.println("Numero Conta: "+ cp.getNumero());
					
					do {
						System.out.println("1 | VERIFICAR SALDO");
						System.out.println("2 | VERIFICAR DADOS CADASTRAIS");
						System.out.println("3 | VERIFICAR ANIVERSARIO");
						System.out.println("4 | CREDITAR");
						System.out.println("5 | DEBITAR");
						System.out.println("0 | LOGOUT");
						
						System.out.print("==> "); 
						opcaoPerfil = entradaDados.next().charAt(0);
						entradaDados.nextLine();
						
						switch(opcaoPerfil) {
							case '1':
								System.out.println("MENU | VERIFICAR SALDO");
								System.out.println();
								
								System.out.println("Saldo Conta: "+ cp.getSaldo());
								System.out.println();
							break;
							
							case '2':
								System.out.println("MENU | MEU DADOS");
								System.out.println();
								
								System.out.println("Conta: "+ cp.getNumero());
								System.out.println("CPF: "+ cp.getCpf());
								System.out.println("Saldo Conta: "+ cp.getSaldo());
								System.out.println("Aniversario da conta dia "+ cp.getAniversarioPoupanca());
								System.out.println();
							break;
							
							case '3':
								System.out.println("MENU | ANIVERSARIO CONTA");
								System.out.println();
								
								System.out.print("Por favor, informe o dia de hoje: ");
								valor = entradaDados.nextInt();
								
								cp.correcaoAniversario(valor);
								System.out.println();
							break;
							
							case '4':
								System.out.println("MENU | CREDITAR");
								System.out.println();
								
								System.out.println("Quanto voce deseja depositar? ");
								System.out.print("R$ ");
								valor = entradaDados.nextInt();
								
								/* ========================= */
								/* CREDITA UM VALOR NA CONTA */
								/* ========================= */
								
								cp.credito(valor);
								
								System.out.println();
							break;
							
							case '5':
								System.out.println("MENU | DEBITAR");
								System.out.println();
								
								System.out.println("Quanto voce deseja sacar? ");
								System.out.print("R$ ");
								valor = entradaDados.nextInt();
								
								/* ======================== */
								/* DEBITA UM VALOR NA CONTA */
								/* ======================== */
								
								cp.debito(valor);
								
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
						
						if(cp.getContarMovimentacao() == cp.getMovimento().length) {
							opcaoPerfil = '0';
							
							System.out.println("-----------------------------------------------");
							System.out.println("Voce realizou o maximo de movimentacoes do dia!");
							System.out.println("-----------------------------------------------");
							System.out.println();
							
						}
						
					}while(opcaoPerfil != '0');
					
					cp.listarMovimentacoesConta();
					
				break;
				
				case '2':
					/* ======================= */
					/* PERFIL | CONTA CORRENTE */
					/* ======================= */
					
					System.out.println("PERFIL | CONTA CORRENTE");
					System.out.println();
					
					System.out.println("Cadastro: ");
					System.out.print("CPF: ");
					cpf = entradaDados.nextLine();
					
					numero = aleatorio.nextInt((999999 - 111111) + 1) + 111111;
					
					/* =================================== */
					/* INSTANCIA A CLASSE - CONTA CORRENTE */
					/* =================================== */
					
					ContaCorrente cc = new ContaCorrente(numero, cpf);
					
					opcaoPerfil = '0';
					valor = 0;
					cc.setContarMovimentacao(0);
					
					/* ====================== */
					/* MENU | PERFIL DE CONTA */
					/* ====================== */
					
					System.out.println("Ola, seja bem vindo ao BBBank - G5");
					System.out.println("Bom, Bonito e Barato");
					
					System.out.println();
					System.out.println("Seja Bem-Vindo a sua Conta Corrente");
					System.out.println("Numero Conta: "+ cc.getNumero());
					
					do {
						System.out.println("1 | VERIFICAR SALDO");
						System.out.println("2 | VERIFICAR DADOS CADASTRAIS");
						System.out.println("3 | SOLICITAR TALAO");
						System.out.println("4 | CREDITAR");
						System.out.println("5 | DEBITAR");
						System.out.println("0 | LOGOUT");
						
						System.out.print("==> "); 
						opcaoPerfil = entradaDados.next().charAt(0);
						entradaDados.nextLine();
						
						switch(opcaoPerfil) {
							case '1':
								System.out.println("MENU | VERIFICAR SALDO");
								System.out.println();
								
								System.out.println("Saldo Conta: "+ cc.getSaldo());
								System.out.println();
							break;
							
							case '2':
								System.out.println("MENU | MEU DADOS");
								System.out.println();
								
								System.out.println("Conta: "+ cc.getNumero());
								System.out.println("CPF: "+ cc.getCpf());
								System.out.println("Saldo Conta: "+ cc.getSaldo());
								System.out.print("Taloes Solicitados: "+ cc.getContadorTalao());
								System.out.println();
							break;
							
							case '3':
								System.out.println("MENU | MEUS TALOES");
								System.out.println();
				                
				                do {
				                	System.out.print("Deseja solicitar um cheque? S/N ");
				                	opcaoPerfil = entradaDados.next().toUpperCase().charAt(0);
				                    
				                    System.out.println();
				                    
				                    if(opcaoPerfil != 'S' || opcao != 'N'){ 
				                    	System.out.println("Opcao invalida!");
				                    	
				                	}else if(opcaoPerfil == 'S') {
				                		cc.pedeTalao();
				                    	/*System.out.println("Talao solicitado!");*/
				                    
				                    }else if(opcaoPerfil == 'N') {
				                    	System.out.println("Se mudar de ideia, entre em contato!");
				                    	
				                    }
				                	
				                } while(opcaoPerfil != 'S' && opcao != 'N');
				                
				                System.out.println();
							break;
							
							case '4':
								System.out.println("MENU | CREDITAR");
								System.out.println();
								
								System.out.println("Quanto voce deseja depositar? ");
								System.out.print("R$ ");
								valor = entradaDados.nextInt();
								
								/* ========================= */
								/* CREDITA UM VALOR NA CONTA */
								/* ========================= */
								
								cc.credito(valor);
								
								cc.gravarMovimentacaoCredito(cc.getContarMovimentacao(), cc.getSaldo(), valor);
								
								cc.setContarMovimentacao(cc.getContarMovimentacao() + 1);
								
								System.out.println();
							break;
							
							case '5':
								System.out.println("MENU | DEBITAR");
								System.out.println();
								
								System.out.println("Quanto voce deseja sacar? ");
								System.out.print("R$ ");
								valor = entradaDados.nextInt();
								
								/* ======================== */
								/* DEBITA UM VALOR NA CONTA */
								/* ======================== */
								
								cc.debito(valor);
								
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
						
						if(cc.getContarMovimentacao() == cc.getMovimento().length) {
							opcaoPerfil = '0';
							
							System.out.println("-----------------------------------------------");
							System.out.println("Voce realizou o maximo de movimentacoes do dia!");
							System.out.println("-----------------------------------------------");
							System.out.println();
							
						}
						
					}while(opcaoPerfil != '0');
					
					do{
						/*AJUSTAR*/
						if(cc.getContarMovimentacao() < 10) {
							opcaoPerfil = 'N';
				            
						}else {
							
							System.out.println("Você atingiu o limite de transações mensais. Deseja solicitar um cheque? S/N");
				        	opcaoPerfil = entradaDados.next().toUpperCase().charAt(0);
				            
				            if(opcaoPerfil == 'S' && cc.getContadorTalao() < 3) {
				                cc.pedeTalao();
				                System.out.println("Taloes pedidos ate o momento: "+ cc.getContadorTalao());
				                    
				            } else {
				                System.out.println("Saldo Atual: " + cc.getSaldo());
				                opcaoPerfil = 'N';
				            }
						}
			    		
			    	} while(opcaoPerfil != 'N');
					
					cc.listarMovimentacoesConta();
					
				break;
				
				case '3':
					/* ======================= */
					/* PERFIL | CONTA ESPECIAL */
					/* ======================= */
					
					System.out.println("PERFIL | CONTA ESPECIAL");
					System.out.println();
					
					System.out.println("Cadastro: ");
					System.out.print("CPF: ");
					cpf = entradaDados.nextLine();
					
					numero = aleatorio.nextInt((999999 - 111111) + 1) + 111111;
					
					/* =================================== */
					/* INSTANCIA A CLASSE - CONTA ESPECIAL */
					/* =================================== */
					
					ContaEspecial ce = new ContaEspecial(numero, cpf);
					
					opcaoPerfil = '0';
					valor = 0;
					ce.setContarMovimentacao(0);
					
					/* ====================== */
					/* MENU | PERFIL DE CONTA */
					/* ====================== */
					
					System.out.println("Ola, seja bem vindo ao BBBank - G5");
					System.out.println("Bom, Bonito e Barato.");
					
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
						opcaoPerfil = entradaDados.next().charAt(0);
						entradaDados.nextLine();
						
						switch(opcaoPerfil) {
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
								
								/* ========================= */
								/* CREDITA UM VALOR NA CONTA */
								/* ========================= */
								
								ce.credito(valor);
								
								ce.gravarMovimentacaoCredito(ce.getContarMovimentacao(), ce.getSaldo(), valor);
								
								ce.setContarMovimentacao(ce.getContarMovimentacao() + 1);
								
								System.out.println();
							break;
							
							case '4':
								System.out.println("MENU | DEBITAR");
								System.out.println();
								
								System.out.println("Quanto voce deseja sacar? ");
								System.out.print("R$ ");
								valor = entradaDados.nextInt();
								
								/* ======================== */
								/* DEBITA UM VALOR NA CONTA */
								/* ======================== */
								
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
						
						if(ce.getContarMovimentacao() == ce.getMovimento().length) {
							opcaoPerfil = '0';
							
							System.out.println("-----------------------------------------------");
							System.out.println("Voce realizou o maximo de movimentacoes do dia!");
							System.out.println("-----------------------------------------------");
							System.out.println();
							
						}
						
					}while(opcaoPerfil != '0');
					
					ce.listarMovimentacoesConta();
					
				break;
					
				case '4':
					/* ======================= */
					/* PERFIL | CONTA EMPRESA  */
					/* ======================= */
					
					System.out.println("PERFIL | CONTA EMPRESA");
					System.out.println();
					
					System.out.println("Cadastro: ");
					System.out.print("CPF: ");
					cpf = entradaDados.nextLine();
					
					numero = aleatorio.nextInt((999999 - 111111) + 1) + 111111;
					emprestimo = 10000;
					
					/* ================================== */
					/* INSTANCIA A CLASSE - CONTA EMPRESA */
					/* ================================== */
					
					ContaEmpresa co = new ContaEmpresa(numero, cpf, emprestimo);
					
					opcaoPerfil = '0';
					valor = 0;
					co.setContarMovimentacao(0);
					
					/* ====================== */
					/* MENU | PERFIL DE CONTA */
					/* ====================== */
					
					System.out.println("Ola, seja bem vindo ao BBBank - G5");
					System.out.println("Bom, Bonito e Barato.");
					
					System.out.println();
					System.out.println("Seja Bem-Vindo a sua Conta Empresa");
					System.out.println("Numero Conta: "+ co.getNumero());
					
					do {
						System.out.println("1 | VERIFICAR SALDO");
						System.out.println("2 | VERIFICAR DADOS CADASTRAIS");
						System.out.println("3 | SOLICITAR EMPRESTIMO");
						System.out.println("4 | CREDITAR");
						System.out.println("5 | DEBITAR");
						System.out.println("0 | LOGOUT");
						
						System.out.print("==> "); 
						opcaoPerfil = entradaDados.next().charAt(0);
						entradaDados.nextLine();
						
						switch(opcaoPerfil) {
							case '1':
								System.out.println("MENU | VERIFICAR SALDO");
								System.out.println();
								
								System.out.println("Saldo Conta: "+ co.getSaldo());
								System.out.println();
							break;
							
							case '2':
								System.out.println("MENU | MEU DADOS");
								System.out.println();
								
								System.out.println("Conta: "+ co.getNumero());
								System.out.println("CPF: "+ co.getCpf());
								System.out.println("Saldo Conta: "+ co.getSaldo());
								System.out.println("Emprestimo: "+ co.getEmprestimo());
								System.out.println();
							break;
							
							case '3':
								System.out.println("MENU | MEU EMPRESTIMO");
								System.out.println();
								
								co.mostrarsaldo();
								co.pegaremprestimo();
								
								System.out.println();
							break;
							
							case '4':
								System.out.println("MENU | CREDITAR");
								System.out.println();
								
								System.out.println("Quanto voce deseja depositar? ");
								System.out.print("R$ ");
								valor = entradaDados.nextInt();
								
								/* ========================= */
								/* CREDITA UM VALOR NA CONTA */
								/* ========================= */
								
								co.credito(valor);
								
								co.gravarMovimentacaoCredito(co.getContarMovimentacao(), co.getSaldo(), valor);
								
								co.setContarMovimentacao(co.getContarMovimentacao() + 1);
								
								System.out.println();
							break;
							
							case '5':
								System.out.println("MENU | DEBITAR");
								System.out.println();
								
								System.out.println("Quanto voce deseja sacar? ");
								System.out.print("R$ ");
								valor = entradaDados.nextInt();
								
								/* ======================== */
								/* DEBITA UM VALOR NA CONTA */
								/* ======================== */
								
								co.debito(valor);
								
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
						
						if(co.getContarMovimentacao() == co.getMovimento().length) {
							opcaoPerfil = '0';
							
							System.out.println("-----------------------------------------------");
							System.out.println("Voce realizou o maximo de movimentacoes do dia!");
							System.out.println("-----------------------------------------------");
							System.out.println();
							
						}
						
					}while(opcaoPerfil != '0');
					
					co.listarMovimentacoesConta();
					
				break;
					
				case '5':
					/* ========================= */
					/* PERFIL | CONTA ESTUDANTIL */
					/* ========================= */
					
					System.out.println("PERFIL | CONTA ESTUDANTIL");
					System.out.println();
					
					System.out.println("Cadastro: ");
					System.out.print("CPF: ");
					cpf = entradaDados.nextLine();
					
					numero = aleatorio.nextInt((999999 - 111111) + 1) + 111111;
					
					/* ===================================== */
					/* INSTANCIA A CLASSE - CONTA ESTUDANTIL */
					/* ===================================== */
					
					ContaEstudantil ca = new ContaEstudantil(numero, cpf);
					
					opcaoPerfil = '0';
					valor = 0;
					ca.setContarMovimentacao(0);
					
					/* ====================== */
					/* MENU | PERFIL DE CONTA */
					/* ====================== */
					
					System.out.println("Ola, seja bem vindo ao BBBank - G5");
					System.out.println("Bom, Bonito e Barato.");
					
					System.out.println();
					System.out.println("Seja Bem-Vindo a sua Conta Estudantil");
					System.out.println("Numero Conta: "+ ca.getNumero());
					
					do {
						System.out.println("1 | VERIFICAR SALDO");
						System.out.println("2 | VERIFICAR DADOS CADASTRAIS");
						System.out.println("3 | CREDITAR");
						System.out.println("4 | DEBITAR");
						System.out.println("0 | LOGOUT");
						
						System.out.print("==> "); 
						opcaoPerfil = entradaDados.next().charAt(0);
						entradaDados.nextLine();
						
						switch(opcaoPerfil) {
							case '1':
								System.out.println("MENU | VERIFICAR SALDO");
								System.out.println();
								
								System.out.println("Saldo Conta: "+ ca.getSaldo());
								System.out.println();
							break;
							
							case '2':
								System.out.println("MENU | MEU DADOS");
								System.out.println();
								
								System.out.println("Conta: "+ ca.getNumero());
								System.out.println("CPF: "+ ca.getCpf());
								System.out.println("Saldo Conta: "+ ca.getSaldo());
								System.out.println("Limite de Credito: "+ ca.getLimiteEstudantil());
								System.out.println();
							break;
							
							case '3':
								System.out.println("MENU | CREDITAR");
								System.out.println();
								
								System.out.println("Quanto voce deseja depositar? ");
								System.out.print("R$ ");
								valor = entradaDados.nextInt();
								
								/* ========================= */
								/* CREDITA UM VALOR NA CONTA */
								/* ========================= */
								
								ca.credito(valor);
								
								ca.gravarMovimentacaoCredito(ca.getContarMovimentacao(), ca.getSaldo(), valor);
								
								ca.setContarMovimentacao(ca.getContarMovimentacao() + 1);
								
								System.out.println();
							break;
							
							case '4':
								System.out.println("MENU | DEBITAR");
								System.out.println();
								
								System.out.println("Quanto voce deseja sacar? ");
								System.out.print("R$ ");
								valor = entradaDados.nextInt();
								
								/* ======================== */
								/* DEBITA UM VALOR NA CONTA */
								/* ======================== */
								
								ca.debito(valor);
								
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
						
						if(ca.getContarMovimentacao() == ca.getMovimento().length) {
							opcaoPerfil = '0';
							
							System.out.println("-----------------------------------------------");
							System.out.println("Voce realizou o maximo de movimentacoes do dia!");
							System.out.println("-----------------------------------------------");
							System.out.println();
							
						}
						
					}while(opcaoPerfil != '0');
					
					ca.listarMovimentacoesConta();
					
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
