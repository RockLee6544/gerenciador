package br.com.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private static List<Empresa> listaEmpresa = new ArrayList<>();
	private static Integer sequence = 0;
	
	static {
			 Empresa empresa = new Empresa();
			 empresa.setNome("Alura");
			 empresa.setId(Banco.sequence++);
			 Empresa caelum = new Empresa();
			 caelum.setNome("Caelum");
			 caelum.setId(Banco.sequence++);
			 
			 listaEmpresa.add(empresa);
			 listaEmpresa.add(caelum);
	}
	
	public void addEmpresa(Empresa empresa) {
		empresa.setId(Banco.sequence++);
		Banco.listaEmpresa.add(empresa);
		System.out.println(empresa.getNome());
	}

	
	public List<Empresa> getLista(){
		return Banco.listaEmpresa;
	}
}
