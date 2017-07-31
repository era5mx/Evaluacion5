/*
 * @(#)ErrorController.java   26/07/2017
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

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.logging.Logger;
import mx.rengifo.evaluacion.util.Constante;

/**
 * Servlet implementation class ErrorController
 * @author <a href="david.rengifo.mx">david rengifo</a>
 */
@WebServlet(urlPatterns = { "/error401", "/error403", "/error404", "/error405", "/error500", "/error503" })
public class ErrorController extends HttpServlet {

    /** Constante de Serializacion */
    private static final long serialVersionUID = 1L;
           
    /**
     * Logger
     */
    private static final Logger logger = Logger.getLogger(ErrorController.class.getName());
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ErrorController() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String applicationContextPath = request.getContextPath();
        
        if(request.getRequestURI().equals(applicationContextPath + "/error401")){
            response.sendRedirect(Constante.URL_ERROR);
        } else if (request.getRequestURI().equals(applicationContextPath + "/error403")) {
            response.sendRedirect(Constante.URL_ERROR);
        } else if (request.getRequestURI().equals(applicationContextPath + "/error404")) {
            response.sendRedirect(Constante.URL_ERROR);
        } else if (request.getRequestURI().equals(applicationContextPath + "/error405")) {
            response.sendRedirect(Constante.URL_ERROR);
        } else if (request.getRequestURI().equals(applicationContextPath + "/error500")) {
            response.sendRedirect(Constante.URL_ERROR);
        } else if (request.getRequestURI().equals(applicationContextPath + "/error503")) {
            response.sendRedirect(Constante.URL_ERROR);
        }
    }
}
