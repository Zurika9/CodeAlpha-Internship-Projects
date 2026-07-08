package chatbot;

/**
 * ==========================================================
 * ChatBotEngine
 *
 * Handles chatbot responses and learning.
 * ==========================================================
 */
public class ChatBotEngine {

    private FAQDatabase faqDatabase;
    private DynamicLearner learner;

    public ChatBotEngine() {

        faqDatabase = new FAQDatabase();
        learner = new DynamicLearner();

    }

    /**
     * Returns the chatbot's response.
     */
    public String getResponse(String userMessage) {

        userMessage = NLPProcessor.preprocess(userMessage);

        if (faqDatabase.containsQuestion(userMessage)) {

            return faqDatabase.getAnswer(userMessage);

        }

        return "__UNKNOWN__";

    }

    /**
     * Teaches the chatbot a new question and answer.
     */
    public void learn(String question, String answer) {

        learner.learn(question, answer);

        faqDatabase = new FAQDatabase();

    }

}