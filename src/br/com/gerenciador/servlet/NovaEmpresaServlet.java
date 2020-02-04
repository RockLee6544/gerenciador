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
		
		//chamar o jsp que possui todo o código de visualização
		// vamos despachar a requisição para jsp
		/*RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
		request.setAttribute("empresa", empresa);
		rd.forward(request, response);*/
		
		//chamar o jsp que possui todo o código de visualização
		// vamos despachar a requisição para servlet
		/*RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
		request.setAttribute("empresa", empresa);
		rd.forward(request, response);*/
		
		/*Vimos que usar o mesmo post para chamar um outro servlet pode dar problema,
		pois os post pode ser reenviado quantas vezes o usuário quiser, por isso
		iremos refazer o redirecionamento pelo lado do client,
		
		Nosso problema aconteceu pq recebemos uma requisição do tipo post do navegador
		pelo servlet e depois repassamos essa mesma requisição ou a uma pagina ou a um servlet
		e com isso podemos reenviar a requisição post quantas vezes quisermos.
		
		Nós queremos pegar a requisição do tipo post e devolver uma reposta 
		para navegador dizendo para ele fazer redirecionamento, um redirecionamento
		client side.
		No dispatcher a requisição pode ser passada para frente , já no redirect 
		é sempre uma nova requisição.
		
		 
		 A requisição só vive durante uma request.
		 Para resolver nosso problema vamos precisar de algo que sobrevive 
		 entre requisições , o escopo request não é suficiete
		*/
		
		response.sendRedirect("listaEmpresas");
		
	}

}
