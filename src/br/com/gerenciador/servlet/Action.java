package br.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException;

}
