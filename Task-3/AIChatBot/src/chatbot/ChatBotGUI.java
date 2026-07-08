package chatbot;

import javax.swing.*;
import java.awt.*;

/**
 * Main window of the CodeAlpha AI ChatBot.
 */
public class ChatBotGUI extends JFrame {

    /**
     * Constructor
     */
    public ChatBotGUI() {

        initializeWindow();

        setVisible(true);
    }

    /**
     * Configures the application window.
     */
    private void initializeWindow() {

        setTitle("CodeAlpha AI ChatBot");

        setSize(700, 600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);

        getContentPane().setBackground(Color.WHITE);
    }
}