package br.com.geraldoferraz.geradordevo.modo;

import br.com.geraldoferraz.geradordevo.template.Template;
import br.com.geraldoferraz.geradordevo.tipo.Atributo;
import br.com.geraldoferraz.geradordevo.tipo.Metodo;

public interface ModoDeGeracao {
	
	public Class<? extends Atributo> getAtributo();
	public void setAtributo(Class<? extends Atributo> atributo);
	public Class<? extends Metodo> getMetodo();
	public void setMetodo(Class<? extends Metodo> metodo);
	public Template getTemplate();
	public void setTemplate(Template template);
	public ModoDeGeracao definirPacote(String pacote);
	public ModoDeGeracao definirHierarquia(Class<?> clazz);
	public ModoDeGeracao definirHierarquia(String hierarquia);
	public String buscarHierarquia();
	public String buscarPacote();
	
	public String getSuffix();
	public void setSuffix(String suffix);

}
