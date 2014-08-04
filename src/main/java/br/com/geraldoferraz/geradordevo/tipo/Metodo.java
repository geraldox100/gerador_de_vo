package br.com.geraldoferraz.geradordevo.tipo;

public abstract class Metodo {
	
	protected String nome;
	protected Class<?> retorno;
	protected Class<?>[] parametros;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Class<?>[] getParametros() {
		return parametros;
	}
	public void setParametros(Class<?>[] parametros) {
		this.parametros = parametros;
	}
	public Class<?> getRetorno() {
		return retorno;
	}
	public void setRetorno(Class<?> retorno) {
		this.retorno = retorno;
	}
	
	public abstract String getTexto();
	public abstract String getImport();
	
	
	
	
	

}
