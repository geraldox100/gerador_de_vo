package br.com.geraldoferraz.geradordevo.util;

public class FlexTemplates {

	private static final String CLASS = "#importpublic class #nome {\n\n#atributos\n#metodos}";
	private static final String IMPORT = "import #tipo#;\n";
	private static final String DECLARACAO = "\tprivate var _#nome# : #tipo#;\n";
	private static final String GETTER = "\tpublic function get #nome#(): #tipo#{ \n\t\treturn _#nome#;\n\t}";
	private static final String SETTER = "\tpublic function set #nome#(valor: #tipo#) : void {\n\t\t_#nome# = valor;\n\t}";


	public String getClassTemplate() {
		return CLASS;
	}

	public String getSetterTemplate() {
		return SETTER;
	}

	public String getGetterTemplate() {
		return GETTER;
	}
	
	public String getDeclaracaoTemplate(){
		return DECLARACAO;
	}

	public String getImportTemplate() {
		return IMPORT;
	}

}
