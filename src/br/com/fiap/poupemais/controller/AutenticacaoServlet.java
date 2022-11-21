package br.com.fiap.poupemais.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import br.com.fiap.poupemais.bean.Usuario;
import br.com.fiap.poupemais.dao.impl.OracleUsuarioDAO;

/**
 * Servlet implementation class autenticacaoServlet
 */

@WebServlet("/login")
public class AutenticacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutenticacaoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = request.getParameter("email");
        String senha = request.getParameter("senha");
       
        Usuario usuario = new Usuario();
        usuario.setSenha(senha);
        usuario.setDsEmail(login);
        
        OracleUsuarioDAO confirmarusuario = new OracleUsuarioDAO();
        
        
        boolean verificacao = confirmarusuario.validarUsuario(usuario);
        
        
       
        
        if (verificacao) {
        	response.sendRedirect("lista-despesa.jsp");
        }else {
        	response.sendRedirect("failure.jsp");
        }
		
	}

}
