/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.rengifo.evaluacion.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author david
 */
public class DatabaseConnectionFactoryTest {
    
    public DatabaseConnectionFactoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createConnection method, of class DatabaseConnectionFactory.
     */
    @Test
    public void testCreateConnection() {
        System.out.println("createConnection");
        Connection con = DatabaseConnectionFactory.createConnection();
        assertNotNull(con);
        try {
            assertFalse(con.isClosed());
            DatabaseConnectionFactory.closeConnection(null, null, con);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectionFactoryTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Test of closeConnection method, of class DatabaseConnectionFactory.
     */
    @Test
    public void testCloseConnection() {
        System.out.println("closeConnection");
        ResultSet set = null;
        PreparedStatement ps = null;
        Connection con = null;
        DatabaseConnectionFactory.closeConnection(set, ps, con);
        
        try {
            if(set!=null){
                assertTrue(set.isClosed());
                set=null;
            }
            if(ps!=null){
                assertTrue(ps.isClosed());
                set=null;
            }
            if(con!=null){
                assertTrue(con.isClosed());
                set=null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectionFactoryTest.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        assertNull("", set);
        assertNull("", ps);
        assertNull("", con);
    }
    
}
