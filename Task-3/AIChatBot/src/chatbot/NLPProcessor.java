package chatbot;

/**
 * ==========================================================
 * NLPProcessor.java
 *
 * Handles preprocessing of user input.
 * This is a simple NLP implementation that normalizes text
 * before it is searched in the FAQ database.
 * ==========================================================
 */
public class NLPProcessor {

    /**
     * Cleans and normalizes user input.
     *
     * @param input Raw user input
     * @return Processed text
     */
    public static String preprocess(String input) {

        if (input == null) {
            return "";
        }

        return input
                .toLowerCase()
                .replaceAll("[^a-z0-9 ]", "")
                .replaceAll("\\s+", " ")
                .trim();
    }
}