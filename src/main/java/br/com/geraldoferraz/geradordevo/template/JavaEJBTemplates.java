package br.com.geraldoferraz.geradordevo.template;

public class JavaEJBTemplates extends EJBTemplate{
	
	private static final String CLASS = "#package#importpublic interface #nome #extends{#metodos}";
	private static final String IMPORT = "import #tipo;\n";
	private static final String METODO = "\tpublic #retorno #nomeMetodo(#parametro);";


	@Override
	public String getClassTemplate() {
		return CLASS;
	}

	@Override
	public String getImportTemplate() {
		return IMPORT;
	}
	@Override	
	public String getMetodoTemplate() {
		return METODO;
	}

}
