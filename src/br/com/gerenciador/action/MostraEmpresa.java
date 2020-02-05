package br.com.gerenciador.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;
import br.com.gerenciador.servlet.Action;

public class MostraEmpresa implements Action {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPeloId(id);
		response.getWriter().append("Server at:").append(request.getContextPath());
		
		request.setAttribute("empresa", empresa);
		return "forward:formAlteraEmpresa.jsp";
		
	}

}
