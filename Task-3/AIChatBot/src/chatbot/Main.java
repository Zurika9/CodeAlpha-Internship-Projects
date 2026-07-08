package chatbot;

import javax.swing.SwingUtilities;

/**
 * Entry point of the AI ChatBot application.
 */
public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(ChatBotGUI::new);

    }
}