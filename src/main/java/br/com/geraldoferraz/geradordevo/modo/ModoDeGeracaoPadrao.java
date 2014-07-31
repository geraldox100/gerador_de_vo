package br.com.geraldoferraz.geradordevo.modo;

public abstract class ModoDeGeracaoPadrao implements ModoDeGeracao{
	
	
	private Class<?> clazz;
	private String pacote;
	private String hierarquia;

	@Override
	public ModoDeGeracao definirHierarquia(Class<?> clazz) {
		this.clazz = clazz;
		return this;
	}
	
	@Override
	public String buscarHierarquia() {
		String retorno = "";
		if(clazz != null){
			retorno = clazz.getName();
		}
		if(hierarquia != null && !hierarquia.equals("")){
			retorno = hierarquia;
		}
		return retorno;
	}
	
	@Override
	public ModoDeGeracao definirPacote(String pacote) {
		this.pacote = pacote;
		return this;
	}
	
	@Override
	public String buscarPacote() {
		return pacote;
	}
	@Override
	public ModoDeGeracao definirHierarquia(String hierarquia) {
		this.hierarquia = hierarquia;
		return this;
	}
	

}
