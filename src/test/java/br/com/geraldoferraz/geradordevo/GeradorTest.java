package br.com.geraldoferraz.geradordevo;

import static br.com.geraldoferraz.geradordevo.modo.ModosDeGeracao.flex;
import static br.com.geraldoferraz.geradordevo.modo.ModosDeGeracao.java;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import br.com.geraldoferraz.geradordevo.entidades.HierarquiaVO;
import br.com.geraldoferraz.geradordevo.modo.ModoDeGeracao;


public class GeradorTest {
	
	private Gerador gerador;
	
	private String basePackage = "br.com.geraldoferraz.geradordevo.entidades";
	
	
	@Before
	public void beforeGerador(){
		gerador = new Gerador();
		gerador.buscarEntidadesEm(basePackage);
	}
	
//	@Test
//	public void quandoGerarJava(){
//		List<String> classes = gerador.gerar(java());
//		assertThat(classes.size(), equalTo(3));
//	}
//	
//	@Test
//	public void quandoGerarFlex(){
//		List<String> classes = gerador.gerar(flex());
//		assertThat(classes.size(), equalTo(3));
//	}
//	
//	@Test
//	public void quandoGerarJavaFlex(){
//		List<String> classes = gerador.gerar(java(),flex());
//		assertThat(classes.size(), equalTo(6));
//	}
	
	public static void main(String[] args) {
		
		Gerador gerador = new Gerador();
		gerador.buscarEntidadesEm("br.com.geraldoferraz.geradordevo.entidades");
		
		ModoDeGeracao java = java().definirHierarquia(HierarquiaVO.class).definirPacote("br.com.geraldoferraz.geradordevo.gerados.vo.java");
		ModoDeGeracao flex = flex().definirHierarquia("br.com.geraldoferraz.geradordevo.entidades").definirPacote("br.com.geraldoferraz.geradordevo.gerados.vo.flex");
		
		Map<String,String> javas = gerador.gerar(java);
		Map<String,String> flexes = gerador.gerar(flex);
		
		String caminhoJava = "D:\\geraldo\\repositorio\\git\\gerador_de_vo\\src\\test\\java\\br\\com\\geraldoferraz\\geradordevo\\gerados\\vo\\java\\";
//		String caminhoJava = "D:\\geraldo\\tmp\\";
		String caminhoFlex = "D:\\geraldo\\repositorio\\git\\gerador_de_vo\\src\\test\\java\\br\\com\\geraldoferraz\\geradordevo\\gerados\\vo\\flex\\";
		Gravador gravador = new Gravador();
		
		gravador.setCaminhoParaSalvar(caminhoJava).salvar(javas);
//		gravador.setCaminhoParaSalvar(caminhoFlex).salvar(flexes);
		
//		for (String clazz : javas) {
//			gravador.salvar(clazz);
//		}
		System.out.println("fim");
	}
	
	

}
