package chatbot;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Saves all chatbot conversations to a file.
 */
public class ChatHistory {

    private static final String FILE_PATH = "data/chat_history.txt";

    /**
     * Saves one message to the chat history.
     */
    public static void saveMessage(String sender, String message) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_PATH, true))) {

            writer.write(sender + ": " + message);
            writer.newLine();

        } catch (IOException e) {

            System.out.println("Unable to save chat history.");

        }

    }

}