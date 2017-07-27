/*
 * @(#)Message.java   26/07/2017
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
 * Message
 * @author <a href="david.rengifo.mx">david rengifo</a>
 */
public class Message {
    
    /**
     * Mensaje para imprimir seleccionaste
     */
    public static final String PRINT_SELECTED = "Seleccionaste ";
    
    /**
     * Mensaje para imprimir has hecho clic en el boton
     */
    public static final String CLICK_BUTTON = "Has hecho clic en el botón ";

    /**
     * Mensaje de Error al realizar la lectuar del archivo xml
     */
    public static final String ERROR_MESSAGE_IO = "Error : Mientras se realizaba la lectura del archivo";

    /**
     * Mensaje de Error al no poder cargar el driver de MySql
     */
    public static final String ERROR_DRIVER = "Error: No se pudo cargar la clase del driver para MySQL! ";

    /**
     * Mensaje de Error al fallar la creacion de la conexion a la base de datos
     */
    public static final String ERROR_MESSAGE_OPEN_CONNECTION = "Error: Mientras se creaba la conexion a la base de datos. ";

    /**
     * Mensaje de Error al fallar una consulta realizada a la base de datos
     */
    public static final String ERROR_MESSAGE_SELECT = "Error : Mientras se consultaba la base de datos. ";

    /**
     * Mensaje de Error al fallar un insert en la base de datos
     */
    public static final String ERROR_MESSAGE_INSERT = "Error : Mientras se insertaba el registro en la base de datos. ";

    /**
     * Mensaje de Error al fallar un insert en la base de datos
     */
    public static final String ERROR_MESSAGE_INSERT_RESULTS = "Error : No se pudieron persistir los resultados del examen ";

    /**
     * Mensaje de Error para indicar que no se pudieron persistir los resultados
     */
    public static final String ERROR_PERSIST_RESULT = "No se pudieron persistir los resultados del examen para ";
            
    /**
     * Mensaje de Error al fallar la actualizacion de la base de datos
     */
    public static final String ERROR_MESSAGE_UPDATE = "Error : Mientras se actualizaba el registro en la base de datos. ";

    /**
     * Mensaje de Error al fallar el cierre de la conexion a la base de datos
     */
    public static final String ERROR_MESSAGE_CLOSE_CONNECTION = "Error : Mientras se cerraba la conexion a la base de datos. ";

    /**
     * Mensaje de Error por no encontrar el archivo xml del examen
     */
    public static final String ERROR_EXAM_NOT_FOUND = "Error : No se ha encontrado el archivo de este examen. ";

}
