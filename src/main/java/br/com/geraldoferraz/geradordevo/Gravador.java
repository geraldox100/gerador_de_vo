package br.com.geraldoferraz.geradordevo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

public class Gravador {
	
	private String caminho;

	public Gravador setCaminhoParaSalvar(String caminho) {
		this.caminho = caminho;
		return this;
	}
	
	public void salvar(String name, String clazz) {
		try {
			File file = new File(caminho+"\\"+name);
			PrintWriter pw = new PrintWriter(new FileOutputStream(file));
			pw.print(clazz);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void salvar(Map<String,String> classes) {
		
		Set<String> keySet = classes.keySet();
		for (String className : keySet) {
			String classText = classes.get(className);
			salvar(className,classText);
		}
	}

}
