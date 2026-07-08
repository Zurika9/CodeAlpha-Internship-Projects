package chatbot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ==========================================================
 * FAQDatabase
 *
 * Loads chatbot questions and answers from faq.txt
 * ==========================================================
 */
public class FAQDatabase {

    private final Map<String, String> faqMap;

    public FAQDatabase() {

        faqMap = new HashMap<>();

        loadFAQs();

    }

    /**
     * Reads all FAQs from the text file.
     */
    private void loadFAQs() {

        try (BufferedReader reader =
                     new BufferedReader(new FileReader("data/faq.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.contains("=")) {

                    String[] parts = line.split("=", 2);

                    faqMap.put(
                            parts[0].trim().toLowerCase(),
                            parts[1].trim()
                    );

                }
            }

        } catch (IOException e) {

            System.out.println("Unable to load FAQ database.");

        }

    }

    /**
     * Returns the answer for a question.
     */
    public String getAnswer(String question) {

        return faqMap.get(question.toLowerCase());

    }

    /**
     * Checks whether the question exists.
     */
    public boolean containsQuestion(String question) {

        return faqMap.containsKey(question.toLowerCase());

    }

}