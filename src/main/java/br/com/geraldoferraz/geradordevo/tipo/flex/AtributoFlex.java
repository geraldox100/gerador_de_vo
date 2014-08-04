package br.com.geraldoferraz.geradordevo.tipo.flex;

import static br.com.geraldoferraz.geradordevo.util.Util.*;
import br.com.geraldoferraz.geradordevo.template.FlexVOTemplates;
import br.com.geraldoferraz.geradordevo.tipo.Atributo;
import br.com.geraldoferraz.geradordevo.util.Util;

public class AtributoFlex extends Atributo{
	
	private FlexVOTemplates template = new FlexVOTemplates();

	@Override
	public String getGetter() {
		return substituirVariaveis(template.getGetterTemplate());
	}

	@Override
	public String getSetter() {
		return substituirVariaveis(template.getSetterTemplate());
	}

	@Override
	public String getDeclaracao() {
		return substituirVariaveis(template.getDeclaracaoTemplate());
	}

	@Override
	public String getImport() {
		String retorno = template.getImportTemplate().replace("#tipo", getTipoFlex(getTipo()));
		if(!deveColocarImportNoFlex(getTipo())){
			retorno = "";
		}
		
		return retorno;
	}
	
	private String substituirVariaveis(String texto) {
		return texto.replace("#tipo", getTipoResolvido()).replace("#nome#", getNome());
	}

	private String getTipoResolvido() {
		String tipo = getTipoFlex(getTipo());
		return Util.removerPacoteDoNome(tipo);
	}
	
	
	

}
