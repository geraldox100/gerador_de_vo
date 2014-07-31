package br.com.geraldoferraz.geradordevo.util;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import br.com.geraldoferraz.geradordevo.template.JavaTemplates;

public class JavaTemplatesTest {
	
	private JavaTemplates templates = new JavaTemplates();
	
	private static final String CLASS_TEMPLATE="#package#importpublic class #nome #extends{\n\n\tprivate static final long serialVersionUID = 1L;#atributos\n#metodos}";
	private static final String GETTER_TEMPLATE = "\tpublic #tipo# get#NomeCamelCase#(){\n\t\treturn this.#nome#;\n\t}";
	private static final String SETTER_TEMPLATE = "\tpublic void set#NomeCamelCase#(#tipo# #nome#){\n\t\tthis.#nome# = #nome#;\n\t}";
	private static final String DECLARACAO_TEMPLATE = "\tprivate #tipo# #nome#;\n";
	private static final String IMPORT_TEMPLATE = "import #tipo#;\n";
	
	@Test
	public void quandoPedirTemplateDeClasse(){
		String classTemplate = templates.getClassTemplate();
		assertThat(classTemplate, equalTo(CLASS_TEMPLATE));
	}
	
	@Test
	public void quandoPedirTemplateDeGetter(){
		String getterTemplate = templates.getGetterTemplate();
		assertThat(getterTemplate, equalTo(GETTER_TEMPLATE));
	}
	
	@Test
	public void quandoPedirTemplateDeSetter(){
		String setterTemplate = templates.getSetterTemplate();
		assertThat(setterTemplate, equalTo(SETTER_TEMPLATE));
	}
	
	@Test
	public void quandoPedirTemplateDeDeclaracao(){
		String declaracaoTemplate = templates.getDeclaracaoTemplate();
		assertThat(declaracaoTemplate, equalTo(DECLARACAO_TEMPLATE));
	}

	@Test
	public void quandoPedirTemplateDeImport(){
		String importTemplate = templates.getImportTemplate();
		assertThat(importTemplate, equalTo(IMPORT_TEMPLATE));
	}
	
}