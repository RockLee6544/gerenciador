package br.com.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListaEmpresas
 */
@WebServlet(urlPatterns= {"/listaEmpresas", "/empresas"}, loadOnStartup=1)
public class ListaEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	public ListaEmpresasServlet() {
		// TODO Auto-generated constructor stub
		System.out.println("Não sou tão preguiçoso");
	}
    /**

	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getLista();
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listaEmpresas.jsp");
		
		request.setAttribute("empresas", lista);
		dispatcher.forward(request, response);
		
	}
	

	

}
