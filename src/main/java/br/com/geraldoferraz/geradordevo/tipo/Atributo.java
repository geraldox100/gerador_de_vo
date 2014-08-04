package br.com.geraldoferraz.geradordevo.tipo;

public abstract class Atributo {

	protected String nome;
	protected String tipo;
	private String pacote;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public abstract String getGetter();

	public abstract String getSetter();

	public abstract String getDeclaracao();

	public abstract String getImport();
	
	

	public void setPacote(String pacote) {
		this.pacote = pacote;
	}
	
	public String getPacote() {
		return pacote;
	}

}
