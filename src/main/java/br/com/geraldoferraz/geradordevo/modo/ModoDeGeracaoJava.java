package br.com.geraldoferraz.geradordevo.modo;

import br.com.geraldoferraz.geradordevo.template.Template;
import br.com.geraldoferraz.geradordevo.tipo.Atributo;
import br.com.geraldoferraz.geradordevo.tipo.Metodo;

public class ModoDeGeracaoJava extends ModoDeGeracaoPadrao {

	private Template template;
	private Class<? extends Metodo> metodo;
	private Class<? extends Atributo> atributo;
	private String suffix;

	public ModoDeGeracaoJava() {
	}

	@Override
	public Class<? extends Atributo> getAtributo() {
		return atributo;
	}

	@Override
	public Template getTemplate() {
		return template;
	}

	@Override
	public Class<? extends Metodo> getMetodo() {
		return metodo;
	}

	@Override
	public void setAtributo(Class<? extends Atributo> atributo) {
		this.atributo = atributo;
	}

	@Override
	public void setMetodo(Class<? extends Metodo> metodo) {
		this.metodo = metodo;
	}

	@Override
	public void setTemplate(Template template) {
		this.template = template;
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
