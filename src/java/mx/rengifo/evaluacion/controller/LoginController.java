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
 */
@WebServlet("/checkLogin")
public class LoginController extends HttpServlet {

    /**
     * Constante de serializaacion
     */
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
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username = [" + username + "]");
        System.out.println("password = [" + password + "]");
        Connection con = DatabaseConnectionFactory.createConnection();
        ResultSet set = null;
        //int i = 0;
        String exam ="";

        PreparedStatement ps = null;
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
                System.out.println("acceso exitoso");
                request.getSession().setAttribute("user", username);
                request.getSession().setAttribute("exam", exam);
                request.getRequestDispatcher("/WEB-INF/jsps/home.jsp").forward(request, response);
            } else {
                System.out.println("acceso invalido");
                request.setAttribute("errorMessage", "<br/>Usuario y/o Contraseña invalido(s). <br/>Si ya realizó el examen su usuario estará bloqueado.");
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsps/login.jsp");
                rd.forward(request, response);
            }

        } catch (SQLException sqe) {
                System.out.println(Message.ERROR_MESSAGE_SELECT);
                if(Constante.DEBUG_ENABLED) {logger.log(Level.SEVERE, Message.ERROR_MESSAGE_SELECT, sqe);}
        } finally {
            try {
                if (set != null && !set.isClosed()) {
                    set.close();
                }
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
                con.close();
            } catch (SQLException se) {
                System.out.println("Error : Mientras se cerraba la conexion");
            }
        }
    }
}
