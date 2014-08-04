package br.com.geraldoferraz.geradordevo.modo;

import br.com.geraldoferraz.geradordevo.template.FlexVOTemplates;
import br.com.geraldoferraz.geradordevo.template.Template;
import br.com.geraldoferraz.geradordevo.tipo.Atributo;
import br.com.geraldoferraz.geradordevo.tipo.Metodo;
import br.com.geraldoferraz.geradordevo.tipo.flex.AtributoFlex;

public class ModoDeGeracaoFlex extends ModoDeGeracaoPadrao{


	private String suffix;

	@Override
	public Class<? extends Atributo> getAtributo() {
		return AtributoFlex.class;
	}

	@Override
	public Template getTemplate() {
		return new FlexVOTemplates();
	}

	@Override
	public Class<? extends Metodo> getMetodo() {
		return null;
	}

	@Override
	public void setAtributo(Class<? extends Atributo> atributo) {
	}

	@Override
	public void setMetodo(Class<? extends Metodo> metodo) {
	}

	@Override
	public void setTemplate(Template template) {
	}

	@Override
	public String getSuffix() {
		return suffix;
	}

	@Override
	public void setSuffix(String suffix) {
		this.suffix = suffix;
		
	}


	

}
