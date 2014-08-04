package br.com.geraldoferraz.geradordevo.tipo.java;

import static br.com.geraldoferraz.geradordevo.util.Util.*;
import java.lang.reflect.Method;

import javax.persistence.Entity;

import br.com.geraldoferraz.geradordevo.template.JavaEJBTemplates;
import br.com.geraldoferraz.geradordevo.tipo.Metodo;
import br.com.geraldoferraz.geradordevo.util.Util;

public class MetodoJava extends Metodo{
	
	private JavaEJBTemplates templates = new JavaEJBTemplates();
	
	@Override
	public String getImport() {
		String retorno = "";
		for (Class<?> parametro : this.parametros) {
			if(deveColocarImportNoJava(parametro.getName())){
				retorno += templates.getImportTemplate().replace("#tipo", parametro.getName()+colocarSeForVO(parametro.getName()));
			}
		}
		if(deveColocarImportNoJava(this.retorno.getName())){
			retorno += templates.getImportTemplate().replace("#tipo", this.retorno.getName()+colocarSeForVO(this.retorno.getName()));
		}
		return retorno;
	}
	
	public String getTexto(){
		return substituir(templates.getMetodoTemplate());
	}
	
	private String substituir(String template) {
		return template.replace("#retorno", getTipo()).replace("#nomeMetodo", getNome()).replace("#parametro", getTextoParametros());
	}


	private String getTextoParametros() {
		String retorno = "";
		for (Class<?> parametro : this.parametros) {
			retorno += getNomeDoParametro(parametro)+", ";
		}
		retorno = retorno.substring(0,retorno.lastIndexOf(", "));
		return retorno;
	}
	private String getNomeDoParametro(Class<?> parametro) {
		
		String nomeClasse = Util.removerPacoteDoNome(parametro.getName());
		if(parametro.isAnnotationPresent(Entity.class)){
			nomeClasse +="VO";
		}
		String nomeVariavel = Util.getNomeVariavel(nomeClasse);
		return nomeClasse+" "+nomeVariavel;
	}

	private String getTipo() {
		String tipo = Util.removerPacoteDoNome(retorno.getName());
		if(retorno.isAnnotationPresent(Entity.class)){
			tipo +="VO";
		}
		return tipo;
	}
	
	public static void main(String[] args) {
		Method[] declaredMethods = MetodoJava.class.getDeclaredMethods();
		for (Method method : declaredMethods) {
			System.out.println(method.getName());
		}
	}
	

}
