package kh.web.message;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf8");
			response.setCharacterEncoding("utf8");
			String requestURI = request.getRequestURI();
			String contextPath = request.getContextPath();
			String command = requestURI.substring(contextPath.length());
			boolean isRedirect = true;
			String dst = null;
			
			MessageDAO dao = new MessageDAO();
			if(command.equals("input.do")) {
				isRedirect = false;
				dst="inputMessage.jsp";
			}else if(command.equals("inputProc.do")) {
				String name = request.getParameter("name");
				String message = request.getParameter("message");
				int result = dao.insertData(name, message);
				request.setAttribute("name", name);
				request.setAttribute("message", message);
				request.setAttribute("result", result);
				isRedirect= false;
				dst="inputView.jsp";
			}else if(command.equals("output.do")) {
				List<MessageDTO> result = dao.viewAllData();
				request.setAttribute("result", result);
				isRedirect = false;
				dst = "outputView.jsp";
			}
			
		if(isRedirect) {
			response.sendRedirect(dst);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher(dst);
			rd.forward(request, response);
		}
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
