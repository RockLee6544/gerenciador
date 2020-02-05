package br.com.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/* � um significa heran�a Servlet, qual protocolo
esse servlet vai atender o HTTP.

agora queremos adicionar um m�todo que servi ou atende
uma requisi��o HTTP j� que queremos um m�todo que servi , vamos
criar o m�todo service
Assim como tem Override que anota��o para o compilador
existem anota��es para m�quina virtual
*/
//Oi
@WebServlet(urlPatterns = "/oi")
public class OiMundo extends HttpServlet {
	

	/*Na verdade o que temos que fazer � sobreescrever um m�todo
	da classe m�e,esse m�todo recebe dois parametros pq dissemos que ele trabalha
	com requisi��o e resposta, podemos sempre jogar menos exce��es 
	O HTTP sempre trabalha atrav�s da requisi��o e da reposta , no mundo
	java essa requisi��o e reposta � representada por um objeto.
	Queremos dar um apelido /oi para nosso servlet e uma reposta.
	*/
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		/* No mundo HTTP existem duas maneiras de devolver uma reposta 
		 * a primeira � na forma de fluxo bin�rio (grafico, pdf, imagem) e a segunda 
		 * � o conteudo HTML.
		 */
		//No caso do fluxo binario usamos resp.getOutputStream();
		//Mas queremos devolver um HTML (texto)
		//Atrav�s do response definimos se vai ser binario ou dados textuais(caracteres)
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<html>");
		printWriter.println("<body>");
		printWriter.println("Oi mundo escrevemos o primeiro Servlet");
		printWriter.println("</body");
		printWriter.println("<html>");
		
		/*Esse writer escreve no fluxo de resposta para o navegador, o tomcat percebe a munda�a 
		e faz um reload , mas nem sempre funciona , ent�o clicamos no restart*/

	}
	


}
