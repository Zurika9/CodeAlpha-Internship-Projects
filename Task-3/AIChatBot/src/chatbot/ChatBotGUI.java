package chatbot;

import javax.swing.*;
import java.awt.*;

/**
 * ==========================================================
 * CodeAlpha Internship - Task 3
 * Artificial Intelligence ChatBot
 *
 * ChatBotGUI.java
 *
 * This class represents the graphical user interface (GUI)
 * of the AI ChatBot application.
 *
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

    // Displays the conversation
    private JTextArea chatArea;

    // Makes the chat area scrollable
    private JScrollPane scrollPane;

    // User types messages here
    private JTextField inputField;

    // Button to send messages
    private JButton sendButton;

    // Bottom panel containing input field and button
    private JPanel bottomPanel;

    private ChatBotEngine chatBotEngine;

    /**
     * Constructor
     */
    public ChatBotGUI() {

        chatBotEngine = new ChatBotEngine();

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

        // ==========================
        // Header
        // ==========================

        titleLabel = new JLabel(
                "🤖 CodeAlpha AI ChatBot",
                SwingConstants.CENTER
        );

        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        add(titleLabel, BorderLayout.NORTH);

        // ==========================
        // Chat Area
        // ==========================

        chatArea = new JTextArea();

        chatArea.setEditable(false);

        chatArea.setFont(new Font("Arial", Font.PLAIN, 16));

        chatArea.setLineWrap(true);

        chatArea.setWrapStyleWord(true);

        scrollPane = new JScrollPane(chatArea);

        add(scrollPane, BorderLayout.CENTER);

        // ==========================
        // Bottom Panel
        // ==========================

        bottomPanel = new JPanel(new BorderLayout(10, 0));

        bottomPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        inputField = new JTextField();

        sendButton = new JButton("Send");

        bottomPanel.add(inputField, BorderLayout.CENTER);

        bottomPanel.add(sendButton, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);

        // Event Listeners
        sendButton.addActionListener(e -> sendMessage());

        inputField.addActionListener(e -> sendMessage());
    }

    /**
     * Displays the welcome message when the application starts.
     */
    private void displayWelcomeMessage() {

        chatArea.append("Bot: Welcome to CodeAlpha AI ChatBot!\n");
        chatArea.append("Bot: How can I help you today?\n\n");
    }

    /**
     * Sends the user's message to the chat area.
     */
    private void sendMessage() {

        String message = inputField.getText().trim();

        if (message.isEmpty()) {
            return;
        }

        chatArea.append("You: " + message + "\n");

        String response = chatBotEngine.getResponse(message);

        if (response.equals("__UNKNOWN__")) {

            chatArea.append("Bot: I don't know the answer yet.\n");

            String answer = JOptionPane.showInputDialog(
                    this,
                    "Please teach me the correct answer:"
            );

            if (answer != null && !answer.trim().isEmpty()) {

                chatBotEngine.learn(message, answer);

                chatArea.append("Bot: Thank you! I've learned something new.\n\n");

            } else {

                chatArea.append("Bot: No problem. Maybe next time.\n\n");

            }

        } else {

            chatArea.append("Bot: " + response + "\n\n");

        }

        inputField.setText("");

        chatArea.setCaretPosition(chatArea.getDocument().getLength());

    }
}