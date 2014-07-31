package br.com.geraldoferraz.geradordevo.modo;

import br.com.geraldoferraz.geradordevo.template.JavaTemplates;
import br.com.geraldoferraz.geradordevo.template.Template;
import br.com.geraldoferraz.geradordevo.tipo.Atributo;
import br.com.geraldoferraz.geradordevo.tipo.java.AtributoJava;

public class ModoDeGeracaoJava extends ModoDeGeracaoPadrao {


	@Override
	public Class<? extends Atributo> getAtributo() {
		return AtributoJava.class;
	}

	@Override
	public Template getTemplate() {
		return new JavaTemplates();
	}

}
