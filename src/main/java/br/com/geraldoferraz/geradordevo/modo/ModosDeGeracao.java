package br.com.geraldoferraz.geradordevo.modo;

import br.com.geraldoferraz.geradordevo.template.JavaEJBTemplates;
import br.com.geraldoferraz.geradordevo.template.JavaVOTemplates;
import br.com.geraldoferraz.geradordevo.tipo.java.AtributoJava;
import br.com.geraldoferraz.geradordevo.tipo.java.EmptyMetodoJava;
import br.com.geraldoferraz.geradordevo.tipo.java.MetodoJava;

public class ModosDeGeracao {

	public static ModoDeGeracao vo() {
		ModoDeGeracaoJava modoDeGeracaoJava = new ModoDeGeracaoJava();
		modoDeGeracaoJava.setTemplate(new JavaVOTemplates());
		modoDeGeracaoJava.setMetodo(EmptyMetodoJava.class);
		modoDeGeracaoJava.setAtributo(AtributoJava.class);
		modoDeGeracaoJava.setSuffix("VO");
		return modoDeGeracaoJava;
	}

	public static ModoDeGeracao[] ejb() {
		return new ModoDeGeracao[]{remote(),local()};
	}

	public static ModoDeGeracao remote() {
		ModoDeGeracaoJava modoDeGeracaoJava = new ModoDeGeracaoJava();
		modoDeGeracaoJava.setTemplate(new JavaEJBTemplates());
		modoDeGeracaoJava.setMetodo(MetodoJava.class);
		modoDeGeracaoJava.setAtributo(EmptyAtributoJava.class);
		modoDeGeracaoJava.setSuffix("Remote");
		return modoDeGeracaoJava;
	}

	public static ModoDeGeracao local() {
		ModoDeGeracaoJava modoDeGeracaoJava = new ModoDeGeracaoJava();
		modoDeGeracaoJava.setTemplate(new JavaEJBTemplates());
		modoDeGeracaoJava.setMetodo(EmptyMetodoJava.class);
		modoDeGeracaoJava.setAtributo(EmptyAtributoJava.class);
		modoDeGeracaoJava.setSuffix("Local");
		return modoDeGeracaoJava;
	}

	public static ModoDeGeracao flex() {
		return new ModoDeGeracaoFlex();
	}

}
