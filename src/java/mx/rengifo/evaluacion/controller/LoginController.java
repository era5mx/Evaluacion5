/*
 * @(#)LoginController.java   26/07/2017
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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.rengifo.evaluacion.util.DatabaseConnectionFactory;
import mx.rengifo.evaluacion.util.Message;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/**
 * Servlet implementation class LoginController
 * @author <a href="david.rengifo.mx">david rengifo</a>
 */
@WebServlet("/checkLogin")
public class LoginController extends HttpServlet {

    /** Constante de Serializacion */
    private static final long serialVersionUID = 1L;
           
    /**
     * Logger
     */
    private static final Logger logger = Logger.getLogger(LoginController.class.getName());
    
    /**
     * Query para realizar el login
     */
    private static final String SELECT_EXAM_FROM_USERS = "Select exam from users where username=? and password=? and calificacion IS NULL";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }

    /**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(Constante.DEBUG_ENABLED) {logger.log(Level.INFO, "username = [{0}]", username);}
        if(Constante.DEBUG_ENABLED) {logger.log(Level.INFO, "password = [{0}]", password);}

        Connection con = DatabaseConnectionFactory.createConnection();
        ResultSet set = null;
        PreparedStatement ps = null;
        String exam ="";
        
        if(null!=con){
            try {
                ps = con.prepareStatement(SELECT_EXAM_FROM_USERS);
                ps.setString(1, username);
                ps.setString(2, password);
                ps.executeQuery();
                set = ps.getResultSet();

                while (set.next()) {
                    exam = set.getString(1);
                }

                if (StringUtils.isNotBlank(exam)) {
                    if(Constante.DEBUG_ENABLED) {logger.log(Level.INFO, "Acceso exitoso");}
                    request.getSession().setAttribute("user", username);
                    request.getSession().setAttribute("exam", exam);
                    request.getRequestDispatcher("/WEB-INF/jsps/home.jsp").forward(request, response);
                } else {
                    String s = "<br><br>Usuario y/o Contrase&ntilde;a invalido(s). <br>Si ya realiz&oacute; el examen su usuario estar&aacute; bloqueado.";
                    this.accesoInvalido(request,response,s);
                }

            } catch (SQLException sqe) {
                    if(Constante.DEBUG_ENABLED) {logger.log(Level.SEVERE, Message.ERROR_MESSAGE_SELECT, sqe);}
            } finally {
                try {
                    if (set != null && !set.isClosed()) { set.close(); }
                    if (ps != null && !ps.isClosed()) { ps.close(); }
                    if(!con.isClosed()) { con.close(); }
                } catch (SQLException se) {
                    if(Constante.DEBUG_ENABLED) {logger.log(Level.SEVERE, Message.ERROR_MESSAGE_CLOSE_CONNECTION, se);}
                }
            }
        }
        else {
           String s = Message.ERROR_MESSAGE_OPEN_CONNECTION;
           this.accesoInvalido(request,response,s); 
        }
    }
    
    /**
     * Maneja el acceso invalido
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    private void accesoInvalido(HttpServletRequest request, HttpServletResponse response, String errorMessage) throws ServletException, IOException{
        if(Constante.DEBUG_ENABLED) {logger.log(Level.INFO, "Acceso invalido");}
        request.setAttribute("errorMessage", errorMessage);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsps/login.jsp");
        rd.forward(request, response);
    }
}
