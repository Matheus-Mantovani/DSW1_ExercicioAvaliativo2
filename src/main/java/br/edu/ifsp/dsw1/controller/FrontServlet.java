package br.edu.ifsp.dsw1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.AtualizarPedidoCommand;
import br.edu.ifsp.dsw1.controller.command.AtualizarPedidoFormCommand;
import br.edu.ifsp.dsw1.controller.command.CadastrarUsuarioCommand;
import br.edu.ifsp.dsw1.controller.command.CadastrarUsuarioFormCommand;
import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.controller.command.ErroCommand;
import br.edu.ifsp.dsw1.controller.command.GerenciarPedidosCommand;
import br.edu.ifsp.dsw1.controller.command.IndexCommand;
import br.edu.ifsp.dsw1.controller.command.LoggedCommand;
import br.edu.ifsp.dsw1.controller.command.LoginCommand;
import br.edu.ifsp.dsw1.controller.command.LogoutCommand;
import br.edu.ifsp.dsw1.controller.command.NovoPedidoCommand;
import br.edu.ifsp.dsw1.controller.command.NovoPedidoFormCommand;
import br.edu.ifsp.dsw1.controller.command.RemoverPedidoCommand;

@WebServlet("/front.do")
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

    public FrontServlet() {
        super();
    }

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Command command = null;
    	String action = request.getParameter("action");
    	
    	if("login".equals(action)) {
    		command = new LoginCommand();
    	} else if ("index".equals(action)) {
    		command = new IndexCommand();
    	} else {
    		command = new ErroCommand();
    	}
    	
    	String view = command.execute(request, response);
    	var dispatcher = request.getRequestDispatcher(view);
    	dispatcher.forward(request, response);
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}
