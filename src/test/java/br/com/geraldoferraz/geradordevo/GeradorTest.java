package br.com.geraldoferraz.geradordevo;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import static br.com.geraldoferraz.geradordevo.modo.ModosDeGeracao.java;
import static br.com.geraldoferraz.geradordevo.modo.ModosDeGeracao.flex;

import org.junit.Before;
import org.junit.Test;

public class GeradorTest {
	
	private Gerador gerador;
	
	
	@Before
	public void beforeGerador(){
		gerador = new Gerador();
		gerador.buscarEntidadesEm("br.com.geraldoferraz.geradordevo.entidades");
	}
	
	@Test
	public void quandoGerarJava(){
		List<String> classes = gerador.gerar(java());
		assertThat(classes.size(), equalTo(3));
	}
	
	@Test
	public void quandoGerarFlex(){
		List<String> classes = gerador.gerar(flex());
		assertThat(classes.size(), equalTo(3));
	}
	
	@Test
	public void quandoGerarJavaFlex(){
		List<String> classes = gerador.gerar(java(),flex());
		assertThat(classes.size(), equalTo(6));
	}
	
	public static void main(String[] args) {
		Gerador gerador = new Gerador();
		gerador.buscarEntidadesEm("br.com.geraldoferraz.geradordevo.entidades");
		List<String> classes = gerador.gerar(java());
		for (String clazz : classes) {
			System.out.println(clazz);
		}
	}
	
	
	
	

}
