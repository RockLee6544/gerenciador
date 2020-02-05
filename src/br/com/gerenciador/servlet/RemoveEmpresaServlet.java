package br.com.gerenciador.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;

/**
 * Servlet implementation class RemoveEmpresaServlet
 */
@WebServlet("/removeEmpresa")
public class RemoveEmpresaServlet extends HttpServlet {
       

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer id = Integer.valueOf(request.getParameter("id"));
		Banco banco = new Banco();
		List<Empresa> lista = banco.getLista();
		
		Iterator<Empresa> it = lista.iterator();
		
		while(it.hasNext()) {
			Empresa empresa = it.next();
			if(empresa.getId() == id) {
				it.remove();
			}
			
		}
		
		/*for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getId() == id) {
				lista.remove(i);
				break;
			}
		}*/
		
		response.sendRedirect("listaEmpresas");
		
	}

}
