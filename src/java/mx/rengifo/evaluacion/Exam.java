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
import org.apache.commons.lang3.StringUtils;

/**
 * Examen
 * @author david
 */
public class Exam {
    
    public static final String INSERT_INTO_QUIZRESULTADOS = "INSERT INTO `quiz`.`resultados` (`username`,`pregunta`,`resultado`) VALUES (?,?,?)";

    Document dom;
    public int currentQuestion = 0;

    public Map<Integer, Integer> selections = new LinkedHashMap<Integer, Integer>();
    public ArrayList<QuizQuestion> questionList = new ArrayList<QuizQuestion>(10);

    public Exam(String test) throws SAXException, ParserConfigurationException, IOException, URISyntaxException {
        dom = CreateDOM.getDOM(test);
    }

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

    public ArrayList<QuizQuestion> getQuestionList() {
        return this.questionList;
    }

    public int getCurrentQuestion() {
        return currentQuestion;
    }

    public Map<Integer, Integer> getSelections() {
        return this.selections;
    }

    public int calculateResult(Exam exam, String username) {
        int totalCorrect = 0;
        Map<Integer, Integer> userSelectionsMap = exam.selections;

        //Se valida y se persisten los resultados
        if (null != userSelectionsMap && StringUtils.isNotBlank(username)) {
            persisteSelections(userSelectionsMap, username);
        } else {
            System.out.println("No se pudieron persistir los resultados del examen para [" + username + "]");
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
                sqe.printStackTrace();
                System.out.println("Error : While Inserting record in database");
            } finally {
                try {
                    con.close();
                } catch (SQLException se) {
                    System.out.println("Error : While Closing Connection");
                }
            }
        }

    }
    
}
