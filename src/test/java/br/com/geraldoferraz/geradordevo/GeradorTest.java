package br.com.geraldoferraz.geradordevo;


import static br.com.geraldoferraz.geradordevo.modo.ModosDeGeracao.ejb;
import static br.com.geraldoferraz.geradordevo.modo.ModosDeGeracao.vo;

import java.util.Map;
import java.util.Set;

import org.junit.Before;

import br.com.geraldoferraz.geradordevo.ejbs.Hierarquia;
import br.com.geraldoferraz.geradordevo.modo.ModoDeGeracao;

public class GeradorTest {

	private Gerador gerador;

	private String basePackage = "br.com.geraldoferraz.geradordevo.entidades";

	@Before
	public void beforeGerador() {
		gerador = new Gerador();
		gerador.buscarClassesEm(basePackage);
	}

	public static void main(String[] strings) {

		Gerador gerador = new Gerador();
		gerador.buscarClassesEm("br.com.geraldoferraz.geradordevo.ejbs");

		ModoDeGeracao[] ejb = ejb();
		for (ModoDeGeracao modo : ejb) {
			modo.definirHierarquia(Hierarquia.class);
			modo.definirPacote("br.com.geraldoferraz.geradorvo.gerados.ejb.java");
		}

		Map<String, String> javas = gerador.gerar(ejb);
		imprimir(javas);

//		String caminhoJava = "D:\\geraldo\\repositorio\\git\\gerador_de_vo\\src\\test\\java\\br\\com\\geraldoferraz\\geradordevo\\gerados\\vo\\java\\";
//		Gravador gravador = new Gravador();

//		gravador.setCaminhoParaSalvar(caminhoJava).salvar(javas);
//		 for (String clazz : javas) {
//			 gravador.salvar(clazz);
//		 }
		System.out.println("fim");
	}

	private static void imprimir(Map<String, String> javas) {
		Set<String> keys = javas.keySet();
		for (String key : keys) {
			System.out.println(javas.get(key));
		}
		
	}

}
