package chatbot;

/**
 * ==========================================================
 * ChatBotEngine
 *
 * This class processes user messages and retrieves
 * responses from the FAQ database.
 * ==========================================================
 */
public class ChatBotEngine {

    // Reference to the FAQ database
    private FAQDatabase faqDatabase;

    /**
     * Constructor
     */
    public ChatBotEngine() {

        faqDatabase = new FAQDatabase();

    }

    /**
     * Generates a chatbot response.
     *
     * @param userMessage User's input
     * @return Bot response
     */
    public String getResponse(String userMessage) {

        // Convert input to lowercase and remove extra spaces
        userMessage = NLPProcessor.preprocess(userMessage);

        // Check if the question exists
        if (faqDatabase.containsQuestion(userMessage)) {

            return faqDatabase.getAnswer(userMessage);

        }

        // Default response
        return "Sorry, I don't understand that yet.";

    }

}