/*
 * @(#)CreateDOM.java   26/07/2017
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * Create DOM
 * @author <a href="david.rengifo.mx">david rengifo</a>
 */
public class CreateDOM {
    
    /**
     * Logger
     */
    private static final Logger logger = Logger.getLogger(CreateDOM.class.getName());

    /**
     *
     * @param test
     * @return
     * @throws SAXException
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws URISyntaxException
     */
    public static Document getDOM(String test) throws SAXException, ParserConfigurationException, IOException, URISyntaxException {
        Document dom = null;
        File quizFile = new File(Constante.PATH_EVALUATIONS + test + Constante.SUFFIX + ".xml");
        System.out.println("Quiz File Absolute Path " + quizFile.getAbsolutePath());

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        
        
        
        try {
            dom = db.parse(quizFile);
            if(dom!=null && dom.getDocumentElement()!=null) { 
                dom.getDocumentElement().normalize(); 
            }
        } catch (FileNotFoundException fileNotFound) {
            System.out.println(Message.ERROR_EXAM_NOT_FOUND + fileNotFound);
        }
        
        return dom;
    }

}
