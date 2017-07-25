package mx.rengifo.evaluacion.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * 
 * @author david
 */
public class CreateDOM {

    public static Document getDOM(String test) throws SAXException, ParserConfigurationException, IOException, URISyntaxException {
        Document dom = null;
        File quizFile = new File(Constante.PATH_EVALUATIONS + "\\" + test + Constante.SUFFIX + ".xml");
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
