package br.com.geraldoferraz.geradordevo.tipo.flex;

import br.com.geraldoferraz.geradordevo.template.FlexTemplates;
import br.com.geraldoferraz.geradordevo.tipo.Atributo;

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
				forData() || forBoolean() || forCharOuCharacter() || forPrimitivoNumerico() || forWrapperNumerico()){
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
		if(forWrapperNumerico() || forPrimitivoNumerico()){
			tipo = "Number";
		}else if(forCharOuCharacter()){
			tipo = "String";
		}else if(forBoolean()){
			tipo = "Boolean";
		}else if(tipo.startsWith("java.util.List")){
			tipo = "mx.collections.ListCollectionView";
		}else if(forData()){
			tipo = "Date";
		}else if(!tipo.startsWith("java.lang.String")){
			tipo = tipo+"VO";
		}
		return tipo;
	}

	private boolean forData() {
		return tipo.equals("java.util.Date") || tipo.equals("java.util.Calendar") || tipo.equals("br.com.sicoob.tipos.DateTime") || tipo.equals("br.com.bancoob.persistencia.types.DateTimeDB");
	}
	
	private boolean forBoolean() {
		return tipo.equals("boolean") || tipo.equals("java.lang.Boolean");
	}

	private boolean forCharOuCharacter() {
		return tipo.equals("char") || tipo.equals("java.lang.Character");
	}

	private boolean forPrimitivoNumerico() {
		return tipo.equals("byte") || tipo.equals("short") || tipo.equals("int") || tipo.equals("long") || tipo.equals("float")
				|| tipo.equals("double");
	}
	
	private boolean forWrapperNumerico() {
		return tipo.equals("java.lang.Byte") || tipo.equals("java.lang.Short") || tipo.equals("java.lang.Integer") || tipo.equals("java.lang.Long") || tipo.equals("java.lang.Float")
				|| tipo.equals("java.lang.Double");
	}
	

}
