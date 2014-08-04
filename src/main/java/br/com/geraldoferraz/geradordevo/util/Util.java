package br.com.geraldoferraz.geradordevo.util;


public class Util {
	
	
	
	public static String removerPacoteDoNome(String nomeClasse) {
		int ponto = nomeClasse.lastIndexOf(".");
		if (ponto > 0) {
			nomeClasse = nomeClasse.substring(ponto + 1);
		}
		return nomeClasse;
	}

	public static String getNomeDeClasseComVO(String nome) {
		
		String primeiraLetra = nome.charAt(0) + "";
		String retorno = primeiraLetra.toUpperCase() + nome.substring(1);
		
		if(nome.startsWith("java.lang")){
			retorno = retorno+"VO";
		}
		return retorno;
	}
	
	public static String getNomeVariavel(String nomeClasse) {
		String primeiraLetra = nomeClasse.charAt(0) + "";
		String retorno = primeiraLetra.toLowerCase() + nomeClasse.substring(1);
		return retorno;
	}
	
	public static boolean forPrimitivo(String tipo) {
		return tipo.equals("boolean") || tipo.equals("byte") || tipo.equals("char") || tipo.equals("short") || tipo.equals("int") || tipo.equals("long") || tipo.equals("float")
				|| tipo.equals("double");
	}

	public static boolean forJavaLang(String tipo) {
		return tipo.startsWith("java.lang.");
	}

	public static boolean forJavaMath(String tipo) {
		return tipo.startsWith("java.math.");
	}

	public static boolean forData(String tipo) {
		return tipo.equals("java.util.Calendar") || tipo.equals("java.util.Date") || tipo.equals("java.sql.Date") || tipo.endsWith("DateTime")
				|| tipo.endsWith("DateTimeDB");
	}
	
	public static boolean deveColocarVONoNome(String tipo) {
		if (!(forData(tipo) || forJavaLang(tipo) || forPrimitivo(tipo) || forJavaMath(tipo))) {
			return true;
		}
		return false;
	}
	
	public static String colocarSeForVO(String tipo) {
		String vo = "";
		if (deveColocarVONoNome(tipo)) {
			vo = "VO";
		}
		return vo;
	}
	
	
	public static String getTipoFlex(String tipo) {
		if(forWrapperNumerico(tipo) || forPrimitivoNumerico(tipo)){
			tipo = "Number";
		}else if(forCharOuCharacter(tipo)){
			tipo = "String";
		}else if(forBoolean(tipo)){
			tipo = "Boolean";
		}else if(tipo.startsWith("java.util.List")){
			tipo = "mx.collections.ListCollectionView";
		}else if(forData(tipo)){
			tipo = "Date";
		}else if(!tipo.startsWith("java.lang.String")){
			tipo = tipo+"VO";
		}
		return tipo;
	}

	
	
	public static boolean forBoolean(String tipo) {
		return tipo.equals("boolean") || tipo.equals("java.lang.Boolean");
	}

	public static boolean forCharOuCharacter(String tipo) {
		return tipo.equals("char") || tipo.equals("java.lang.Character");
	}

	public static boolean forPrimitivoNumerico(String tipo) {
		return tipo.equals("byte") || tipo.equals("short") || tipo.equals("int") || tipo.equals("long") || tipo.equals("float")
				|| tipo.equals("double");
	}
	
	public static boolean forWrapperNumerico(String tipo) {
		return tipo.equals("java.lang.Byte") || tipo.equals("java.lang.Short") || tipo.equals("java.lang.Integer") || tipo.equals("java.lang.Long") || tipo.equals("java.lang.Float")
				|| tipo.equals("java.lang.Double");
	}
	
	public static boolean deveColocarImportNoFlex(String tipo){
		return !(tipo.startsWith("java.lang") ||  forData(tipo) || 
				forBoolean(tipo) || forCharOuCharacter(tipo) || forPrimitivoNumerico(tipo) || forWrapperNumerico(tipo));
	}

	public static boolean deveColocarImportNoJava(String tipo) {
		return !forJavaLang(tipo) && !forPrimitivo(tipo) && !forVoid(tipo);
	}

	private static boolean forVoid(String tipo) {
		return tipo.equals( "void");
	}
}
