package br.com.geraldoferraz.geradordevo.template;

public abstract class EJBTemplate implements Template {


	@Override
	public String getSetterTemplate() {
		return "";
	}

	@Override
	public String getGetterTemplate() {
		return "";
	}

	@Override
	public String getExtensao() {
		return ".java";
	}
	
	@Override
	public String getDeclaracaoTemplate() {
		return "";
	}


}
