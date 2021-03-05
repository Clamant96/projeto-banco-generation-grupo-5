package banco;

import java.util.Random;

public abstract class Conta {
	private int numero;
	private String cpf;
	//depois alterar para private
	protected double saldo;
	private boolean ativa;
	private int contarMovimentacao = 0;
	
	private String[] movimento = new String[10];
	
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
	public void setMovimento(String movimento[]) {
		this.movimento = movimento;
	}
	
	public String[] getMovimento() {
		return this.movimento;
	}
	
	public void setContarMovimentacao(int contarMovimentacao) {
		this.contarMovimentacao = contarMovimentacao;
	}
	
	public int getContarMovimentacao() {
		return this.contarMovimentacao;
	}
	
	/* ================================== */
	/* PERFIL | CREDITA UM VALOS NA CONTA */
	/* ================================== */
	
	public void credito(double creditar) {
		if(creditar > 0) {
			this.saldo = this.getSaldo() + creditar;
			System.out.printf("O valor R$ %.2f foi inserido com sucesso em sua conta!\n", creditar);
			System.out.println();
			
		}else if(creditar == 0) {
			System.out.printf("O valor R$ %.2f depositado deve ser maior que R$ 0,00 \n", creditar);
			System.out.println("Transacao bloqueada");
			
		}else if(creditar < 0) {
			System.out.printf("O valor R$ %.2f depositado deve positivo \n", creditar);
			System.out.println("Transacao bloqueada");
			
		}
	}
	
	/* ================================= */
	/* PERFIL | DEBITA UM VALOS NA CONTA */
	/* ================================= */
	
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
	
	/* ================================= */
	/* PERFIL | DEBITA UM VALOS NA CONTA */
	/* ================================= */
	
	public void debito(double debitar, double limite) {
		System.out.printf("Saldo atual R$ %.2f \n", this.getSaldo());
		System.out.println();
		
		if(debitar <= this.getSaldo() && debitar <= limite) {
			this.saldo = this.getSaldo() - debitar;
			
		}else if(debitar > limite){
			System.out.println("O valor desejado ultrapassa seu limite de credito mensal.");
			
		}else {
			this.saldo = this.getSaldo() - debitar;

		}
		
	}
	
	public void ajusteSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	/* ========================= */
	/* PERFIL | NUMERO ALEATORIO */
	/* ========================= */
	
	public void gerarNumero() {
		this.setNumero(aleatorio.nextInt((999999 - 111111) + 1) + 111111);
	}
	
	/* ====================================== */
	/* PERFIL | ARMAZENA TRANSACOES - CREDITO */
	/* ====================================== */
	
	public void gravarMovimentacaoCredito(int i, double saldo, double credito) {
		this.movimento[i] = "(+)Credito R$ "+ Double.toString(credito) +" Saldo R$ "+ Double.toString(Math.round(saldo));
	}
	
	public void gravarMovimentacaoCredito(int i, double saldo, double credito, double limite) {
		this.movimento[i] = "(+)Credito R$ "+ Double.toString(credito) +" Saldo R$ "+ Double.toString(Math.round(saldo)) +" Limite R$ "+ Double.toString(Math.round(limite));
	}
	
	public void gravarMovimentacaoCredito(int i, double saldo) {
		this.movimento[i] = "(+)Credito R$ "+ Double.toString(Math.round(saldo) * 0.05) +" Reajuste Saldo R$ "+ Double.toString(Math.round(saldo));
	}
	
	/* ===================================== */
	/* PERFIL | ARMAZENA TRANSACOES - DEBITO */
	/* ===================================== */
	
	public void gravarMovimentacaoDebito(int i, double saldo, double debito) {
		this.movimento[i] = "(-)Debito R$ "+ Double.toString(debito) +" Saldo R$ "+ Double.toString(Math.round(saldo));
	}
	
	public void gravarMovimentacaoDebito(int i, double saldo, double debito, double limite) {
		this.movimento[i] = "(-)Debito R$ "+ Double.toString(debito) +" Saldo R$ "+ Double.toString(Math.round(saldo)) +" Limite R$ "+ Double.toString(Math.round(limite));
	}
	
	/* =========================== */
	/* PERFIL | IMPRIME TRANSACOES */
	/* =========================== */
	
	public void listarMovimentacoesConta() {
		System.out.println();
		System.out.println("Movimentacao Mensal");
		
		for(int j = 0; j < this.getMovimento().length; j++) {
			if(this.getMovimento()[j] != null) {
				System.out.print("Movimentacao "+ (j + 1) +": "+ this.getMovimento()[j]);
				System.out.println();
			}
			
		}
		System.out.println();
	}
}
