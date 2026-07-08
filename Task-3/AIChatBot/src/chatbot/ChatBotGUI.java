package chatbot;

import javax.swing.*;
import java.awt.*;

/**
 * ==========================================================
 * CodeAlpha Internship - Task 3
 * Artificial Intelligence ChatBot

 * ChatBotGUI.java

 * This class represents the graphical user interface (GUI)
 * of the AI ChatBot application.

 * Responsibilities:
 * - Create the main application window
 * - Display the conversation area
 * - Display the user input field
 * - Display the Send button
 * ==========================================================
 */
public class ChatBotGUI extends JFrame {

    // ======================================================
    // GUI COMPONENTS
    // ======================================================

    // Displays the application title
    private JLabel titleLabel;

    // Displays the entire conversation
    private JTextArea chatArea;

    // Makes the chat area scrollable
    private JScrollPane scrollPane;

    // User types messages here
    private JTextField inputField;

    // Button used to send messages
    private JButton sendButton;

    // Panel containing the input field and Send button
    private JPanel bottomPanel;

    /**
     * Constructor
     */
    public ChatBotGUI() {

        initializeWindow();

        initializeComponents();

        displayWelcomeMessage();

        setVisible(true);
    }

    /**
     * Configures the main application window.
     */
    private void initializeWindow() {

        setTitle("CodeAlpha AI ChatBot");

        setSize(700, 600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);

        setLayout(new BorderLayout());

        getContentPane().setBackground(Color.WHITE);
    }

    /**
     * Creates and places all GUI components.
     */
    private void initializeComponents() {

        //--------------------------------------------------
        // Title
        //--------------------------------------------------

        titleLabel = new JLabel(
                "🤖 CodeAlpha AI ChatBot",
                SwingConstants.CENTER
        );

        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        add(titleLabel, BorderLayout.NORTH);

        //--------------------------------------------------
        // Chat Area
        //--------------------------------------------------

        chatArea = new JTextArea();

        chatArea.setEditable(false);

        chatArea.setFont(new Font("Arial", Font.PLAIN, 16));

        chatArea.setLineWrap(true);

        chatArea.setWrapStyleWord(true);

        scrollPane = new JScrollPane(chatArea);

        add(scrollPane, BorderLayout.CENTER);

        //--------------------------------------------------
        // Bottom Panel
        //--------------------------------------------------

        bottomPanel = new JPanel(new BorderLayout(10, 0));

        inputField = new JTextField();

        sendButton = new JButton("Send");

        bottomPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        bottomPanel.add(inputField, BorderLayout.CENTER);

        bottomPanel.add(sendButton, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * Displays the welcome message when the application starts.
     */
    private void displayWelcomeMessage() {

        chatArea.append("Bot: Welcome to CodeAlpha AI ChatBot!\n");

        chatArea.append("Bot: How can I help you today?\n\n");
    }

}