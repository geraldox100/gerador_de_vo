package br.com.geraldoferraz.geradordevo.modo;

import br.com.geraldoferraz.geradordevo.template.Template;
import br.com.geraldoferraz.geradordevo.tipo.Atributo;

public interface ModoDeGeracao {
	
	public Class<? extends Atributo> getAtributo();
	public ModoDeGeracao definirHierarquia(Class<?> clazz);
	public ModoDeGeracao definirHierarquia(String hierarquia);
	public String buscarHierarquia();
	public ModoDeGeracao definirPacote(String pacote);
	public String buscarPacote();
	public Template getTemplate();

}
