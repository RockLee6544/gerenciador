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


	public Empresa buscaEmpresaPeloId(Integer id) {
		for (Empresa empresa : listaEmpresa) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		
		return null;
	}


	public void alterarEmpresa(Empresa empresaEditada) {
		for (Empresa empresa : listaEmpresa) {
			if(empresa.getId() == empresaEditada.getId()) {
			  empresa.setNome(empresaEditada.getNome());
			  empresa.setDataAbertura(empresaEditada.getDataAbertura());
			}
		}
	}
}
