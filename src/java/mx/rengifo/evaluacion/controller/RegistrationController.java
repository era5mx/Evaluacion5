/*
 * @(#)RegistrationController.java   26/07/2017
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

import mx.rengifo.evaluacion.util.DatabaseConnectionFactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.rengifo.evaluacion.util.Constante;
import mx.rengifo.evaluacion.util.Message;
import org.apache.commons.lang3.StringUtils;

/**
 * Servlet implementation class RegistrationController
 * @author <a href="david.rengifo.mx">david rengifo</a>
 */
@WebServlet("/checkRegister")
public class RegistrationController extends HttpServlet {

    /** Constante de Serializacion */
    private static final long serialVersionUID = 1L;
    
    /**
     * Query para el alta de usuarios
     */
    private static final String INSERT_INTO_USERS = "INSERT INTO users (`username`,`email`,`password`,`exam`,`calificacion`) values (?,?,?,?,?)";
    
    /**
     * Logger
     */
    private static final Logger logger = Logger.getLogger(RegistrationController.class.getName());

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String exam = request.getParameter("exam");

        boolean valido = validateParameters(username, email, password, exam);

        if (valido) {
            Connection con = DatabaseConnectionFactory.createConnection();
            PreparedStatement ps = null;
            
            if(null!=con){
                try {
                    con.setAutoCommit(false);
                    ps = con.prepareStatement(INSERT_INTO_USERS);
                    ps.setString(1, username);
                    ps.setString(2, email);
                    ps.setString(3, password);
                    ps.setString(4, exam);
                    ps.setString(5, null);
                    ps.executeUpdate();
                    con.commit();

                } catch (SQLException sqe) {
                    if(Constante.DEBUG_ENABLED) {logger.log(Level.SEVERE, Message.ERROR_MESSAGE_INSERT, sqe);}
                } finally {
                    try {
                        con.close();
                    } catch (SQLException se) {
                        if(Constante.DEBUG_ENABLED) {logger.log(Level.SEVERE, Message.ERROR_MESSAGE_CLOSE_CONNECTION, se);}
                    }
                }
                request.setAttribute("newUser", username);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsps/regSuccess.jsp");
                dispatcher.forward(request, response);
            }
            else{
                String s = Message.ERROR_MESSAGE_OPEN_CONNECTION;
                this.accesoInvalido(request, response, email);
            }

        } else {
            String s = "<br><br>Todos los campos son obligatorios.<br>Debe utilizar un correo valido y seleccionar un rol.";
            this.accesoInvalido(request, response, email);
        }

    }

    /**
     * Valida los parametros para el registro
     * @param username
     * @param email
     * @param password
     * @param exam
     * @return 
     */
    private boolean validateParameters(String username, String email, String password, String exam) {
        boolean valido = false;
        if (StringUtils.isNotBlank(username) 
                && StringUtils.isNotBlank(email) 
                && StringUtils.isNotBlank(password) 
                && StringUtils.contains(email, "@") && StringUtils.contains(email, ".") 
                && StringUtils.isNotBlank(exam)) {
            valido = true;
        }
        return valido;
    }
    
    /**
     * Maneja el acceso invalido
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    private void accesoInvalido(HttpServletRequest request, HttpServletResponse response, String errorMessage) throws ServletException, IOException{
        if(Constante.DEBUG_ENABLED) {logger.log(Level.SEVERE, "Error de Conexion o Parametros invalido");}
        request.setAttribute("errorMessage", errorMessage);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsps/login.jsp");
        rd.forward(request, response);
    }

}
