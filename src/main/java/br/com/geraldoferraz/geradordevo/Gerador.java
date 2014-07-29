package br.com.geraldoferraz.geradordevo;

import static br.com.geraldoferraz.scanner.searches.filters.arguments.SearchArguments.annotedOnClassWith;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;

import br.com.geraldoferraz.geradordevo.modo.ModoDeGeracao;
import br.com.geraldoferraz.scanner.Scanner;

public class Gerador {

	private Scanner scanner = new Scanner();
	private String pacoteDasEntidades;

	public Gerador() {
		scanner.allClasses(annotedOnClassWith(Entity.class));
	}

	public void buscarEntidadesEm(String pacoteDasEntidades) {
		this.pacoteDasEntidades = pacoteDasEntidades;
	}

	public List<String> gerar(ModoDeGeracao... modos) {

		List<String> retorno = new ArrayList<String>();
		Set<Class<?>> classes = scanner.exactlyIn(pacoteDasEntidades);

		for (ModoDeGeracao modo : modos) {
			for (Class<?> clazz : classes) {
				retorno.add(modo.executar(clazz));
			}
		}

		return retorno;
	}

	

}
