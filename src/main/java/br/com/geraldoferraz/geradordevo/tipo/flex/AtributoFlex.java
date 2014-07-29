package br.com.geraldoferraz.geradordevo.tipo.flex;

import br.com.geraldoferraz.geradordevo.tipo.Atributo;
import br.com.geraldoferraz.geradordevo.util.FlexTemplates;

public class AtributoFlex extends Atributo{
	
	private FlexTemplates template = new FlexTemplates();

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
		String retorno = template.getImportTemplate().replace("#tipo#", resolverPrimitivo(getTipo()));
		if(getTipo().startsWith("java.lang") || 
				getTipo().startsWith("java.util.Date") || 
				getTipo().startsWith("java.util.Calendar") || 
				getTipo().startsWith("br.com.sicoob.tipos.DateTime")){
			retorno = "";
		}
		
		return retorno;
	}
	
	private String substituirVariaveis(String texto) {
		return texto.replace("#tipo#", getTipoResolvido()).replace("#nome#", getNome());
	}

	private String getTipoResolvido() {
		String tipo = resolverPrimitivo(getTipo());
		return removerPacoteDoNome(tipo);
	}

	private String resolverPrimitivo(String tipo) {
		if(tipo.startsWith("java.lang.")){
			if(tipo.endsWith("Integer") || tipo.endsWith("int")){
				tipo = "Number";
			}
		}else if(tipo.startsWith("java.util.List")){
			tipo = "mx.collections.ListCollectionView";
		}else if(tipo.equals("java.util.Date") || tipo.equals("java.util.Calendar") || tipo.equals("br.com.sicoob.tipos.DateTime")){
			tipo = "Date";
		}else{
			tipo = tipo+"VO";
		}
		return tipo;
	}

}
