package br.com.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private static List<Empresa> listaEmpresa = new ArrayList<>();
	
	
	static {
			 Empresa empresa = new Empresa();
			 empresa.setNome("Alura");
			 Empresa caelum = new Empresa();
			 caelum.setNome("Caelum");
			 
			 listaEmpresa.add(empresa);
			 listaEmpresa.add(caelum);
	}
	
	public void addEmpresa(Empresa empresa) {
		Banco.listaEmpresa.add(empresa);
		System.out.println(empresa.getNome());
	}

	
	public List<Empresa> getLista(){
		return Banco.listaEmpresa;
	}
}
