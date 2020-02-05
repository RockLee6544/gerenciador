package br.com.gerenciador.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;
import br.com.gerenciador.servlet.Action;

public class ListaEmpresa implements Action{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getLista();
		request.setAttribute("empresas", lista);
		
		return "foward:listaEmpresas.jsp";
	}

}
