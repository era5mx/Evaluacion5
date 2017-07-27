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

import mx.rengifo.evaluacion.util.Message;
import mx.rengifo.evaluacion.util.Constante;
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
        try {
            Properties properties=new Properties();
            FileInputStream in = new FileInputStream(Constante.PATH_PROPERTIES+"dbConnection.properties");
            properties.load(in);
            System.out.println("Se cargó el archivo de properties");
            in.close();

            Class.forName(properties.getProperty("jdbc.driver"));
            String dbURL = "jdbc:mysql://".concat(properties.getProperty("jdbc.server"))
                    .concat(StringUtils.isNotBlank(properties.getProperty("jdbc.port"))?":".concat(properties.getProperty("jdbc.port")):"")
                    .concat("/").concat(properties.getProperty("jdbc.schema"))
                    .concat("?useUnicode=").concat(properties.getProperty("jdbc.useUnicode"))
                    .concat("&useJDBCCompliantTimezoneShift=").concat(properties.getProperty("jdbc.useJDBCCompliantTimezoneShift"))
                    .concat("&useLegacyDatetimeCode=").concat(properties.getProperty("jdbc.useLegacyDatetimeCode"))
                    .concat("&serverTimezone=").concat(properties.getProperty("jdbc.serverTimezone"));
            System.out.println("Se preparó la URL: [" + dbURL + "]");
            con = DriverManager.getConnection(dbURL, properties.getProperty("jdbc.username"), properties.getProperty("jdbc.password"));
        } catch (ClassNotFoundException ex) {
            System.out.println(Message.ERROR_DRIVER);
            if(Constante.DEBUG_ENABLED) {logger.log(Level.SEVERE, Message.ERROR_DRIVER, ex);}
            System.exit(1);
        } catch (SQLException sqe) {
            System.out.println(Message.ERROR_MESSAGE_OPEN_CONNECTION);
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
