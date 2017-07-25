/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.rengifo.evaluacion.util;

/**
 *
 * @author david
 */
public class Constante {

    /**
     * Habilita (true) / Deshabilita (false) el log de las excepciones manejadas
     */
    public static final boolean DEBUG_ENABLED = false;
    
    /**
     * Ruta donde vive el archivo properties con los datos para la conexion a la base de datos
     */
    public static final String PATH_PROPERTIES = "C:\\Users\\david\\Documents\\NetBeansProjects\\OnlineQuizz\\web\\WEB-INF\\";

    /**
     * Ruta donde se colocan los archivos xml de las evaluaciones
     */
    public static final String PATH_EVALUATIONS = "C:\\era5\\evaluaciones";

    /**
     * Sufijo utilizado en el nombrado de las evaluaciones
     * Los archivos xml de las evaluciones deben nombrarse con este sufijo
     */
    public static final String SUFFIX = "-evaluacion";

    /**
     * URL de inmujeres
     */
    public static final String URL = "http://www.gob.mx/inmujeres/";

    /**
     * Background (white | gray)
     */
    public static final String BACKGROUND = "white";
    
    /**
     * Titulo general del sitio
     */
    public static final String TITLE_GRAL = "Evaluaci&oacute;n en l&iacute;nea ";

}
