package br.com.geraldoferraz.geradordevo.util;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import br.com.geraldoferraz.geradordevo.template.FlexVOTemplates;

public class FlexVOTemplatesTest {
	
	private FlexVOTemplates templates = new FlexVOTemplates();
	
	private static final String CLASS_TEMPLATE="#package#importpublic class #nomeVO #extends{\n\n#atributos\n#metodos}";
	private static final String GETTER_TEMPLATE = "\tpublic function get #nome#(): #tipo{ \n\t\treturn _#nome#;\n\t}";
	private static final String SETTER_TEMPLATE = "\tpublic function set #nome#(valor: #tipo) : void {\n\t\t_#nome# = valor;\n\t}";
	private static final String DECLARACAO_TEMPLATE = "\tprivate var _#nome# : #tipo;\n";
	private static final String IMPORT_TEMPLATE = "import #tipo;\n";
	
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