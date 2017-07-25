package mx.rengifo.evaluacion.controller;

import mx.rengifo.evaluacion.util.Constante;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/inicio", "/login", "/register", "/takeExam", "/takeExam2", "/takeExam3", "/logout" })
public class MainController extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String applicationContextPath = request.getContextPath();
                if(request.getSession().getAttribute("background")==null) {
                    request.getSession().setAttribute("background", Constante.BACKGROUND);
                }                

		if (request.getRequestURI().equals(applicationContextPath + "/")) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/WEB-INF/jsps/home.jsp");
			dispatcher.forward(request, response);
		} else if(request.getRequestURI().equals(
				applicationContextPath + "/inicio")){
                    response.sendRedirect(Constante.URL);
                }else if (request.getRequestURI().equals(
				applicationContextPath + "/login")) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/WEB-INF/jsps/login.jsp");
			dispatcher.forward(request, response);
		} else if (request.getRequestURI().equals(
				applicationContextPath + "/register")) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/WEB-INF/jsps/register.jsp");
			dispatcher.forward(request, response);
		} else if (request.getRequestURI().equals(
				applicationContextPath + "/takeExam")) {
			request.getSession().setAttribute("currentExam", null);

			String exam = request.getParameter("test");
			request.getSession().setAttribute("exam", exam);
                        
			//System.out.println(request.getSession().getAttribute("user"));
			if (request.getSession().getAttribute("user") == null) {
				request.getRequestDispatcher("/login").forward(request,
						response);
			} else {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/WEB-INF/jsps/quizDetails.jsp");
				dispatcher.forward(request, response);
			}
                } else if(request.getRequestURI().equals(applicationContextPath + "/takeExam2")){
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsps/exam2.jsp");
                    dispatcher.forward(request, response);
                } else if(request.getRequestURI().equals(applicationContextPath + "/takeExam3")){
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsps/exam3.jsp");
                    dispatcher.forward(request, response);
		} else if (request.getRequestURI().equals(
				applicationContextPath + "/logout")) {
			request.getSession().invalidate();
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/WEB-INF/jsps/login.jsp");
			dispatcher.forward(request, response);
		}

	}

}
