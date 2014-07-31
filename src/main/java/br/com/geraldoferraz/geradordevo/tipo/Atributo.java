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

	protected String removerPacoteDoNome(String nomeClasse) {
		int ponto = nomeClasse.lastIndexOf(".");
		if (ponto > 0) {
			nomeClasse = nomeClasse.substring(ponto + 1);
		}
		return nomeClasse;
	}

	protected String getNomeCamelCase() {
		
		String primeiraLetra = nome.charAt(0) + "";
		String retorno = primeiraLetra.toUpperCase() + nome.substring(1);
		
		if(nome.startsWith("java.lang")){
			retorno = retorno+"VO";
		}
		return retorno;
	}

	public void setPacote(String pacote) {
		this.pacote = pacote;
	}
	
	public String getPacote() {
		return pacote;
	}

}
