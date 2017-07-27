/*
 * @(#)MainController.java   26/07/2017
 *
 * Copyright (c) 2016 David Rengifo
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 */
package mx.rengifo.evaluacion.controller;

import mx.rengifo.evaluacion.util.Constante;
import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainController
 * @author <a href="david.rengifo.mx">david rengifo</a>
 */
@WebServlet(urlPatterns = { "/inicio", "/login", "/register", "/takeExam", "/takeExam2", "/takeExam3", "/logout" })
public class MainController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * Logger
     */
    private static final Logger logger = Logger.getLogger(MainController.class.getName());

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
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
