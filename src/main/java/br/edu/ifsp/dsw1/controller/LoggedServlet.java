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

@WebServlet("/logged.do")
public class LoggedServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
    

    public LoggedServlet() {
        super();
    }

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Command command = null;
    	String action = request.getParameter("action");
    	
    	if ("index".equals(action)) {
    		command = new IndexCommand();
    	} else if("logged".equals(action)) {
    		command = new LoggedCommand();
    	} else if("cadastrarUsuario".equals(action)) {
    		command = new CadastrarUsuarioCommand();
    	} else if("novoPedido".equals(action)) {
    		command = new NovoPedidoCommand();
    	} else if("atualizarPedido".equals(action)) {
    		command = new AtualizarPedidoCommand();
    	} else if("gerenciarPedidos".equals(action)) {
    		command = new GerenciarPedidosCommand();
    	} else if("removerPedido".equals(action)) {
    		command = new RemoverPedidoCommand();
    	} else if("logout".equals(action)) {
    		command = new LogoutCommand();
    	} else if("cadastrarUsuarioForm".equals(action)) {
    		command = new CadastrarUsuarioFormCommand();
    	} else if("novoPedidoForm".equals(action)) {
    		command = new NovoPedidoFormCommand();
    	} else if("atualizarPedidoForm".equals(action)) {
    		command = new AtualizarPedidoFormCommand();
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
