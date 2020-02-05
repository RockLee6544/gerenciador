package br.com.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/* é um significa herança Servlet, qual protocolo
esse servlet vai atender o HTTP.

agora queremos adicionar um método que servi ou atende
uma requisição HTTP já que queremos um método que servi , vamos
criar o método service
Assim como tem Override que anotação para o compilador
existem anotações para máquina virtual
*/
//Oi
@WebServlet(urlPatterns = "/oi")
public class OiMundo extends HttpServlet {
	

	/*Na verdade o que temos que fazer é sobreescrever um método
	da classe mãe,esse método recebe dois parametros pq dissemos que ele trabalha
	com requisição e resposta, podemos sempre jogar menos exceções 
	O HTTP sempre trabalha através da requisição e da reposta , no mundo
	java essa requisição e reposta é representada por um objeto.
	Queremos dar um apelido /oi para nosso servlet e uma reposta.
	*/
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		/* No mundo HTTP existem duas maneiras de devolver uma reposta 
		 * a primeira é na forma de fluxo binário (grafico, pdf, imagem) e a segunda 
		 * é o conteudo HTML.
		 */
		//No caso do fluxo binario usamos resp.getOutputStream();
		//Mas queremos devolver um HTML (texto)
		//Através do response definimos se vai ser binario ou dados textuais(caracteres)
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<html>");
		printWriter.println("<body>");
		printWriter.println("Oi mundo escrevemos o primeiro Servlet");
		printWriter.println("</body");
		printWriter.println("<html>");
		
		/*Esse writer escreve no fluxo de resposta para o navegador, o tomcat percebe a mundaça 
		e faz um reload , mas nem sempre funciona , então clicamos no restart*/

	}
	


}
