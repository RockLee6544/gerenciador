package br.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		
		StringBuilder classAcao = new StringBuilder("br.com.gerenciador.action.");
		String nomeClasse = request.getParameter("acao");
		String  destino = null;
		
		try {
			Class<Action> tipoAcao = (Class<Action>) Class.forName(classAcao.append(nomeClasse).toString());
			Action action = tipoAcao.newInstance();
			destino = action.executa(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		} 
		
		String[] arrayAcao = destino.split(":");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		if(arrayAcao[0].equals("forward")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/"+arrayAcao[1]);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(arrayAcao[1]);
		}
	
	}


}
