package br.com.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
       

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		
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
		
		
		Banco banco = new Banco();
		banco.addEmpresa(empresa);
		
		//chamar o jsp que possui todo o c�digo de visualiza��o
		// vamos despachar a requisi��o para jsp
		/*RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
		request.setAttribute("empresa", empresa);
		rd.forward(request, response);*/
		
		//chamar o jsp que possui todo o c�digo de visualiza��o
		// vamos despachar a requisi��o para servlet
		/*RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
		request.setAttribute("empresa", empresa);
		rd.forward(request, response);*/
		
		/*Vimos que usar o mesmo post para chamar um outro servlet pode dar problema,
		pois os post pode ser reenviado quantas vezes o usu�rio quiser, por isso
		iremos refazer o redirecionamento pelo lado do client,
		
		Nosso problema aconteceu pq recebemos uma requisi��o do tipo post do navegador
		pelo servlet e depois repassamos essa mesma requisi��o ou a uma pagina ou a um servlet
		e com isso podemos reenviar a requisi��o post quantas vezes quisermos.
		
		N�s queremos pegar a requisi��o do tipo post e devolver uma reposta 
		para navegador dizendo para ele fazer redirecionamento, um redirecionamento
		client side.
		No dispatcher a requisi��o pode ser passada para frente , j� no redirect 
		� sempre uma nova requisi��o.
		
		 
		 A requisi��o s� vive durante uma request.
		 Para resolver nosso problema vamos precisar de algo que sobrevive 
		 entre requisi��es , o escopo request n�o � suficiete
		*/
		
		response.sendRedirect("listaEmpresas");
		
	}

}
