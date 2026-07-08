package chatbot;

/**
 * ==========================================================
 * ChatBotEngine.java
 *
 * This class contains the chatbot's response logic.
 * Currently it uses simple rule-based responses.
 * Later we will integrate NLP and FAQ matching.
 * ==========================================================
 */
public class ChatBotEngine {

    /**
     * Generates a response based on the user's message.
     *
     * @param userMessage Message entered by the user
     * @return Bot's response
     */
    public String getResponse(String userMessage) {

        userMessage = userMessage.toLowerCase().trim();

        if (userMessage.equals("hello") || userMessage.equals("hi")) {
            return "Hello! Nice to meet you.";
        }

        if (userMessage.contains("how are you")) {
            return "I'm doing great! Thanks for asking.";
        }

        if (userMessage.contains("your name")) {
            return "I am CodeAlpha AI ChatBot.";
        }

        if (userMessage.contains("java")) {
            return "Java is a powerful object-oriented programming language.";
        }

        if (userMessage.contains("ai")) {
            return "Artificial Intelligence enables machines to simulate human intelligence.";
        }

        if (userMessage.contains("bye")) {
            return "Goodbye! Have a wonderful day!";
        }

        return "Sorry, I don't understand that yet.";
    }

}