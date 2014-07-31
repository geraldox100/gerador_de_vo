package br.com.geraldoferraz.geradordevo.modo;

import br.com.geraldoferraz.geradordevo.template.FlexTemplates;
import br.com.geraldoferraz.geradordevo.template.Template;
import br.com.geraldoferraz.geradordevo.tipo.Atributo;
import br.com.geraldoferraz.geradordevo.tipo.flex.AtributoFlex;

public class ModoDeGeracaoFlex extends ModoDeGeracaoPadrao{


	@Override
	public Class<? extends Atributo> getAtributo() {
		return AtributoFlex.class;
	}

	@Override
	public Template getTemplate() {
		return new FlexTemplates();
	}


	

}
