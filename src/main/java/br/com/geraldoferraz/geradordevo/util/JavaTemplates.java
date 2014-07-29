package br.com.geraldoferraz.geradordevo.util;

public class JavaTemplates {

	private static final String CLASS = "#importpublic class #nome {\n\n#atributos\n#metodos}";
	private static final String IMPORT = "import #tipo#;\n";
	private static final String DECLARACAO = "\tprivate #tipo# #nome#;\n";
	private static final String GETTER = "\tpublic #tipo# get#NomeCamelCase#(){\n\t\treturn this.#nome#;\n\t}";
	private static final String SETTER = "\tpublic void set#NomeCamelCase#(#tipo# #nome#){\n\t\tthis.#nome# = #nome#;\n\t}";


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
