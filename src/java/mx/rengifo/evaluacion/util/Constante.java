/*
 * @(#)Constante.java   26/07/2017
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

/**
 * Constantes
 * @author <a href="david.rengifo.mx">david rengifo</a>
 */
public class Constante {

    /**
     * Habilita (true) / Deshabilita (false) el log de las excepciones manejadas
     */
    public static final boolean DEBUG_ENABLED = false;
    
    /**
     * Ruta donde vive el archivo properties con los datos para la conexion a la base de datos
     */
    public static final String PATH_PROPERTIES = "C:\\Users\\david\\Documents\\NetBeansProjects\\Evaluacion5\\web\\WEB-INF\\";

    /**
     * Ruta donde se colocan los archivos xml de las evaluaciones
     */
    public static final String PATH_EVALUATIONS = "C:\\era5\\evaluaciones\\";

    /**
     * Sufijo utilizado en el nombrado de las evaluaciones
     * Los archivos xml de las evaluciones deben nombrarse con este sufijo
     */
    public static final String SUFFIX = "-evaluacion";

    /**
     * URL de inicio
     */
    public static final String URL = "http://www.era5.mx/";
    
    /**
     * URL de error
     */
    public static final String URL_ERROR = "https://sphera5.github.io/Evaluacion5/";

    /**
     * Background (white | gray)
     */
    public static final String BACKGROUND = "white";
    
    /**
     * Titulo general del sitio
     */
    public static final String TITLE_GRAL = "Evaluaci&oacute;n en l&iacute;nea ";
    
    /**
     * Formato de fecha
     */
    public static final String FORMAT_DATE = "yyyy/MM/dd HH:mm:ss a";

}
