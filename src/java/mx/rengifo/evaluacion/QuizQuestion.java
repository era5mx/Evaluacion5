/*
 * @(#)QuizQuestion.java   26/07/2017
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

/**
 * QuizQuestion
 * @author <a href="david.rengifo.mx">david rengifo</a>
 */
public class QuizQuestion {
	
	int questionNumber;
	String question;
	String questionOptions[];
	int correctOptionIndex;
	
    /**
     *
     * @return
     */
    public String getQuestion()
	{ 
		return question;
	}
	
    /**
     *
     * @return
     */
    public int getQuestionNumber()
	{
		return questionNumber;
	}
	
    /**
     *
     * @param i
     */
    public void setQuestionNumber(int i)
	{
		questionNumber=i;
	}
	
    /**
     *
     * @return
     */
    public int getCorrectOptionIndex()
	{
		return correctOptionIndex;
	}
	
    /**
     *
     * @return
     */
    public String[] getQuestionOptions()
	{
		return questionOptions;
	}
	
    /**
     *
     * @param s
     */
    public void setQuestion(String s)
	{
		question=s;
	}

    /**
     *
     * @param i
     */
    public void setCorrectOptionIndex(int i)
	{
		correctOptionIndex=i;
	}

    /**
     *
     * @param s
     */
    public void setQuestionOptions(String[]s)
	{
		questionOptions=s;
	}

}
