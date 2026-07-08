package chatbot;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ==========================================================
 * DynamicLearner.java
 *
 * Saves newly learned questions and answers
 * into the FAQ knowledge base.
 * ==========================================================
 */
public class DynamicLearner {

    /**
     * Saves a new question and answer to faq.txt.
     *
     * @param question User's question
     * @param answer Correct answer
     */
    public void learn(String question, String answer) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("data/faq.txt", true))) {

            writer.newLine();

            writer.write(question.toLowerCase() + "=" + answer);

        } catch (IOException e) {

            System.out.println("Unable to save new knowledge.");

        }

    }

}