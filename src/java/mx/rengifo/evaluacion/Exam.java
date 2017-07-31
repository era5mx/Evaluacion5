/*
 * @(#)Exam.java   26/07/2017
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
package mx.rengifo.evaluacion;

import mx.rengifo.evaluacion.util.DatabaseConnectionFactory;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import mx.rengifo.evaluacion.util.CreateDOM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.rengifo.evaluacion.util.Constante;
import mx.rengifo.evaluacion.util.Message;
import org.apache.commons.lang3.StringUtils;

/**
 * Examen
 * @author <a href="david.rengifo.mx">david rengifo</a>
 */
public class Exam {
    
    /**
     * Query para persistir los resultados
     */
    public static final String INSERT_INTO_QUIZRESULTADOS = "INSERT INTO `quiz`.`resultados` (`username`,`pregunta`,`resultado`) VALUES (?,?,?)";
    
    /**
     * Query para persistir la calificacion de la primera seccion
     */
    public static final String UPDATE_EXAM_CALIFICACION = "UPDATE `quiz`.`users` SET exam=?, calificacion=? WHERE username = ?";

    /**
     * Logger
     */
    private static final Logger logger = Logger.getLogger(Exam.class.getName());
    
    Document dom;
    public int currentQuestion = 0;

    public Map<Integer, Integer> selections = new LinkedHashMap<Integer, Integer>();
    public ArrayList<QuizQuestion> questionList = new ArrayList<QuizQuestion>(10);

    /**
     *
     * @param test
     * @throws SAXException
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws URISyntaxException
     */
    public Exam(String test) throws SAXException, ParserConfigurationException, IOException, URISyntaxException {
        dom = CreateDOM.getDOM(test);
    }

    /**
     *
     * @param i
     */
    public void setQuestion(int i) {
        int number = i;
        String options[] = new String[4];
        String question = null;
        int correct = 0;
        System.out.println("Dom " + dom);
        NodeList qList = dom.getElementsByTagName("question");
        NodeList childList = qList.item(i).getChildNodes();

        int counter = 0;

        for (int j = 0; j < childList.getLength(); j++) {
            Node childNode = childList.item(j);
            if ("answer".equals(childNode.getNodeName())) {
                options[counter] = childList.item(j).getTextContent();
                counter++;
            } else if ("quizquestion".equals(childNode.getNodeName())) {
                question = childList.item(j).getTextContent();
            } else if ("correct".equals(childNode.getNodeName())) {
                correct = Integer.parseInt(childList.item(j).getTextContent());
            }

        }
        System.out.println("Retrieving Question Number " + number);
        System.out.println("Question is : " + question);
        for (String a : options) {
            System.out.println(a);
        }
        System.out.println("Correct answer index : " + correct);

        QuizQuestion q = new QuizQuestion();
        q.setQuestionNumber(number);
        q.setQuestion(question);
        q.setCorrectOptionIndex(correct);
        q.setQuestionOptions(options);
        questionList.add(number, q);

    }

    /**
     *
     * @return
     */
    public ArrayList<QuizQuestion> getQuestionList() {
        return this.questionList;
    }

    /**
     *
     * @return
     */
    public int getCurrentQuestion() {
        return currentQuestion;
    }

    /**
     *
     * @return
     */
    public Map<Integer, Integer> getSelections() {
        return this.selections;
    }

    /**
     * Calcula el resultado
     * @param exam
     * @param username
     * @return
     */
    public int calculateResult(Exam exam, String username) {
        int totalCorrect = 0;
        Map<Integer, Integer> userSelectionsMap = exam.selections;

        //Se valida y se persisten los resultados
        if (null != userSelectionsMap && StringUtils.isNotBlank(username)) {
            this.persisteSelections(userSelectionsMap, username);
        } else {
            System.out.println(Message.ERROR_MESSAGE_INSERT_RESULTS + " para [" + username + "]");
            if(Constante.DEBUG_ENABLED) {logger.log(Level.SEVERE, Message.ERROR_MESSAGE_INSERT_RESULTS, userSelectionsMap);}
        }

        List<Integer> userSelectionsList = new ArrayList<Integer>(10);
        for (Map.Entry<Integer, Integer> entry : userSelectionsMap.entrySet()) {
            userSelectionsList.add(entry.getValue());
        }
        List<QuizQuestion> questionList = exam.questionList;
        List<Integer> correctAnswersList = new ArrayList<Integer>(10);
        for (QuizQuestion question : questionList) {
            correctAnswersList.add(question.getCorrectOptionIndex());
        }

        for (int i = 0; i < selections.size(); i++) {
            System.out.println(userSelectionsList.get(i) + " --- " + correctAnswersList.get(i));
            if ((userSelectionsList.get(i) - 1) == correctAnswersList.get(i)) {
                totalCorrect++;
            }
        }

        System.out.println("You Got " + totalCorrect + " Correct");
        return totalCorrect;
    }

    /**
     * Persiste la seleccion de resultados
     * @param userSelectionsMap
     * @param username 
     */
    private void persisteSelections(Map<Integer, Integer> userSelectionsMap, String username) {
        for (Map.Entry<Integer, Integer> entry : userSelectionsMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            Connection con = DatabaseConnectionFactory.createConnection();
            PreparedStatement ps = null;
            try {
                con.setAutoCommit(false);

                ps = con.prepareStatement(INSERT_INTO_QUIZRESULTADOS);
                ps.setString(1, username);
                ps.setInt(2, key);
                ps.setString(3, value.toString());
                ps.executeUpdate();
                con.commit();

            } catch (SQLException sqe) {
                System.out.println(Message.ERROR_MESSAGE_INSERT);
                if(Constante.DEBUG_ENABLED) {logger.log(Level.SEVERE, Message.ERROR_MESSAGE_INSERT, sqe);}
            } finally {
                try {
                    con.close();
                } catch (SQLException se) {
                    System.out.println(Message.ERROR_MESSAGE_CLOSE_CONNECTION);
                    if(Constante.DEBUG_ENABLED) {logger.log(Level.SEVERE, Message.ERROR_MESSAGE_CLOSE_CONNECTION, se);}
                }
            }
        }

    }
    
}
