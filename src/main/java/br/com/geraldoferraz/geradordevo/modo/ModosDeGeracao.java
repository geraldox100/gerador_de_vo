package br.com.geraldoferraz.geradordevo.modo;

public class ModosDeGeracao {
	
	
	public static ModoDeGeracao java(){
		return new ModoDeGeracaoJava();
	}
	
	public static ModoDeGeracao flex(){
		return new ModoDeGeracaoFlex();
	}

}
