package br.com.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlteraEmpresa
 */
@WebServlet("/AlteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Date data = null;
		
		try {
			String dataAbertura = request.getParameter("dataAbertura");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			data = dateFormat.parse(dataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		String nomeEmpresa = request.getParameter("nome");
		String id = request.getParameter("id");
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(data);
		empresa.setId(Integer.valueOf(id));
		
		Banco banco = new Banco();
		banco.alterarEmpresa(empresa);
		
		response.sendRedirect("listaEmpresas");
	}

}
