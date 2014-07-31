package br.com.geraldoferraz.geradordevo.template;

public class JavaTemplates implements Template{

	private static final String CLASS = "#package#importpublic class #nome #extends{\n\n\tprivate static final long serialVersionUID = 1L;\n\n#atributos\n#metodos}";
	private static final String IMPORT = "import #tipo#;\n";
	private static final String DECLARACAO = "\tprivate #tipo# #nome#;\n";
	private static final String GETTER = "\tpublic #tipo# get#NomeCamelCase#(){\n\t\treturn this.#nome#;\n\t}";
	private static final String SETTER = "\tpublic void set#NomeCamelCase#(#tipo# #nome#){\n\t\tthis.#nome# = #nome#;\n\t}";


	@Override
	public String getClassTemplate() {
		return CLASS;
	}

	@Override
	public String getSetterTemplate() {
		return SETTER;
	}

	@Override
	public String getGetterTemplate() {
		return GETTER;
	}
	
	@Override
	public String getDeclaracaoTemplate(){
		return DECLARACAO;
	}

	@Override
	public String getImportTemplate() {
		return IMPORT;
	}

	@Override
	public String getExtensao() {
		return ".java";
	}

}
