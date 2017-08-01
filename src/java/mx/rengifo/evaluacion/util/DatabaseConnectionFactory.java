/*
 * @(#)DatabaseConnectionFactory.java   26/07/2017
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
package mx.rengifo.evaluacion.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/**
 * Encapsula la logica para manejar la conexion con la base de datos
 * @author <a href="david.rengifo.mx">david rengifo</a>
 */
public class DatabaseConnectionFactory {

    /**
     * Logger
     */
    private static final Logger logger = Logger.getLogger(DatabaseConnectionFactory.class.getName());

    /**
     * Crea la conexion a la base de datos
     * @return
     */
    public static Connection createConnection() {

        Connection con = null;
        Properties properties=new Properties();
        if(Constante.DEBUG_ENABLED) {logger.log(Level.INFO, "Se cargar\u00e1 el archivo de properties desde: [{0}dbConnection.properties]", Constante.PATH_PROPERTIES);}
        try {
            //Se prueba que carge el arhivo de properties
            try (FileInputStream in = new FileInputStream(Constante.PATH_PROPERTIES+"dbConnection.properties")) {
                properties.load(in);
                if(Constante.DEBUG_ENABLED) {logger.log(Level.INFO, "Se carg\u00f3 el archivo de properties");}
            }

            Class.forName(properties.getProperty("jdbc.driver"));
            String dbURL = "jdbc:mysql://".concat(properties.getProperty("jdbc.server").trim())
                    .concat(StringUtils.isNotBlank(properties.getProperty("jdbc.port").trim())?":".concat(properties.getProperty("jdbc.port")):"")
                    .concat("/").concat(properties.getProperty("jdbc.schema").trim())
                    .concat("?useUnicode=").concat(properties.getProperty("jdbc.useUnicode").trim())
                    .concat("&useJDBCCompliantTimezoneShift=").concat(properties.getProperty("jdbc.useJDBCCompliantTimezoneShift").trim())
                    .concat("&useLegacyDatetimeCode=").concat(properties.getProperty("jdbc.useLegacyDatetimeCode").trim())
                    .concat("&serverTimezone=").concat(properties.getProperty("jdbc.serverTimezone").trim());
            if(Constante.DEBUG_ENABLED) {logger.log(Level.INFO, "Se prepar\u00f3 la URL: [{0}]", dbURL);}
            con = DriverManager.getConnection(dbURL, properties.getProperty("jdbc.username"), properties.getProperty("jdbc.password").trim());
        } catch (ClassNotFoundException ex) {
            if(Constante.DEBUG_ENABLED) {logger.log(Level.SEVERE, Message.ERROR_DRIVER, ex);}
            System.exit(1);
        } catch (SQLException sqe) {
            if(Constante.DEBUG_ENABLED) {logger.log(Level.SEVERE, Message.ERROR_MESSAGE_OPEN_CONNECTION, sqe);}
        } catch (IOException ex) {
            if(Constante.DEBUG_ENABLED) {logger.log(Level.SEVERE, Message.ERROR_MESSAGE_IO, ex);}
        }
        return con;
    }
    
    /**
     * Cierra la conexion con la base de datos
     * @param set
     * @param ps
     * @param con
     */
    public static void closeConnection(ResultSet set, PreparedStatement ps, Connection con) {
        try {
            if (null != set && !set.isClosed()) {set.close();}
            if (null != ps && !ps.isClosed()) {ps.close();} 
            if (null != con && !con.isClosed()) {con.close();}
        } catch (SQLException se) {
            System.out.println(Message.ERROR_MESSAGE_CLOSE_CONNECTION);
            if(Constante.DEBUG_ENABLED) {logger.log(Level.SEVERE, Message.ERROR_MESSAGE_CLOSE_CONNECTION, se);}
        }
    }

}
