package br.com.geraldoferraz.geradordevo.tipo.java;

import br.com.geraldoferraz.geradordevo.tipo.Atributo;
import br.com.geraldoferraz.geradordevo.tipo.Classe;
import br.com.geraldoferraz.geradordevo.util.JavaTemplates;

public class ClasseJava extends Classe{
	
	private JavaTemplates templates = new JavaTemplates();

	@Override
	public String getTextoDaClasse() {
		StringBuilder classBuilder = new StringBuilder(templates.getClassTemplate());
		StringBuilder importBuilder = new StringBuilder();
		StringBuilder atributoBuilder = new StringBuilder();
		StringBuilder metodosBuilder = new StringBuilder();
		
		for (Atributo atributo : atributos) {
			importBuilder.append(atributo.getImport());
			
			atributoBuilder.append(atributo.getDeclaracao());
			
			metodosBuilder.append(atributo.getGetter());
			metodosBuilder.append("\n\n");
			metodosBuilder.append(atributo.getSetter());
			metodosBuilder.append("\n\n");
		}
		String importt = importBuilder.toString();
		if(importt.length() > 0 ){
			importt +="\n";
		}
		String atributos = atributoBuilder.toString();
		String metodos = metodosBuilder.toString();
		String clazz = classBuilder.toString();
		String nome = this.nome;
		int ponto = nome.lastIndexOf(".");
		if(ponto > 0){
			nome = nome.substring(ponto+1);
		}
		String retorno = clazz.replace("#import", importt).replace("#nome", nome).replace("#atributos", atributos).replace("#metodos", metodos);
		return retorno;
	}

}
