package chatbot;

import javax.swing.*;
import java.awt.*;

/**
 * Main window of the CodeAlpha AI ChatBot.
 */
public class ChatBotGUI extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;
    private JScrollPane scrollPane;
    private JPanel bottomPanel;
    private JLabel titleLabel;
    /**
     * Constructor
     */
    public ChatBotGUI() {

        initializeWindow();

        initializeComponents();

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
    private void initializeComponents() {

        // Header
        titleLabel = new JLabel("🤖 CodeAlpha AI ChatBot", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        add(titleLabel, BorderLayout.NORTH);

        // Chat Area
        chatArea = new JTextArea();

        chatArea.setEditable(false);

        chatArea.setFont(new Font("Arial", Font.PLAIN, 16));

        chatArea.setLineWrap(true);

        chatArea.setWrapStyleWord(true);

        scrollPane = new JScrollPane(chatArea);

        add(scrollPane, BorderLayout.CENTER);

        // Bottom Panel
        bottomPanel = new JPanel(new BorderLayout());

        inputField = new JTextField();

        sendButton = new JButton("Send");

        bottomPanel.add(inputField, BorderLayout.CENTER);

        bottomPanel.add(sendButton, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);

        chatArea.append("Bot: Welcome! I am your AI ChatBot.\n\n");

    }
}