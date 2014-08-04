package br.com.geraldoferraz.geradordevo.template;

public class FlexVOTemplates extends VOTemplate{

	private static final String CLASS = "#package#importpublic class #nomeVO #extends{\n\n#atributos\n#metodos}";
	private static final String IMPORT = "import #tipo;\n";
	private static final String DECLARACAO = "\tprivate var _#nome# : #tipo;\n";
	private static final String GETTER = "\tpublic function get #nome#(): #tipo{ \n\t\treturn _#nome#;\n\t}";
	private static final String SETTER = "\tpublic function set #nome#(valor: #tipo) : void {\n\t\t_#nome# = valor;\n\t}";


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
		return ".as";
	}

}
