package br.com.geraldoferraz.geradordevo.tipo.java;

import br.com.geraldoferraz.geradordevo.tipo.Atributo;
import br.com.geraldoferraz.geradordevo.util.JavaTemplates;

public class AtributoJava extends Atributo{
	
	private JavaTemplates templates = new JavaTemplates();

	@Override
	public String getGetter() {
		return substituirVariaveis(templates.getGetterTemplate());
	}

	@Override
	public String getSetter() {
		return substituirVariaveis(templates.getSetterTemplate());
	}

	@Override
	public String getDeclaracao() {
		return substituirVariaveis(templates.getDeclaracaoTemplate());
	}
	
	private String substituirVariaveis(String texto) {
		return texto.replace("#tipo#", getTipoResolvido()).replace("#NomeCamelCase#", getNomeCamelCase()).replace("#nome#", nome);
	}

	private String getTipoResolvido() {
		String vo = resolverSeTemQueColocarVO();
		String tipo = this.tipo.replace("java.lang.", "");
		int ponto = tipo.lastIndexOf(".");
		int menor = tipo.lastIndexOf("<");
		int maior = tipo.lastIndexOf(">");
		if(menor > 0){
			ponto = tipo.substring(0, menor).lastIndexOf(".");
			String tipo2 = tipo.substring(menor+1,maior);
			int pontoTipo2 = tipo2.lastIndexOf(".");
			if(pontoTipo2 > 0)
				tipo2 = tipo2.substring(pontoTipo2+1);
			tipo = tipo.substring(ponto+1,menor);
			tipo = tipo+"<"+tipo2+vo+">";
			ponto = -1;
		}
		if(ponto > 0){
			tipo = tipo.substring(ponto+1)+vo;
		}
		return tipo;
	}

	private String resolverSeTemQueColocarVO() {
		String vo = "";
		if(!(this.tipo.equals("java.util.Calendar") || this.tipo.equals("java.util.Date"))){
			vo = "VO";
		}
		return vo;
	}
	
	@Override
	public String getImport() {
		String vo = resolverSeTemQueColocarVO();
		String retorno = "";
		if(tipo.contains("<") && tipo.contains(">")){
			int menor = tipo.indexOf("<");
			int maior = tipo.indexOf(">");
			
			String retorno1 = tipo.substring(0,menor);
			String retorno2 = tipo.substring(menor+1,maior);
			
			retorno = templates.getImportTemplate().replace("#tipo#", retorno1);
			retorno += templates.getImportTemplate().replace("#tipo#", retorno2+vo);
			
			return retorno;
			
		}
		if(!tipo.startsWith("java.lang.")){
			retorno = templates.getImportTemplate().replace("#tipo#", tipo+vo); 
		}
		return retorno;
	}

}
