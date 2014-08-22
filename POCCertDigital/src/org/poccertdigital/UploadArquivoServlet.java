package org.poccertdigital;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadArquivo
 */
@WebServlet("/UploadArquivo")
public class UploadArquivoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UploadArquivoServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if(isMultipart){
			
			ServletContext servletContext = this.getServletConfig().getServletContext();
			File arquivo = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
			 
			System.out.println(arquivo.getName());
		}
		else
		{
			System.out.println("não é um arquivo");
		}
	}

}
