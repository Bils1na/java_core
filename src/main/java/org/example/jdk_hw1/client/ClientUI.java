package org.example.jdk_hw1.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class ClientUI extends JFrame implements View {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    JTextField ip, port, username, message;
    JPasswordField password;
    JButton btnLogin, btnSend;
    JTextArea chat;
    JPanel loginPanel;

    private Controller controller;


    public ClientUI() {
        setting();
        createPanel();

        setVisible(true);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    private void setting() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Client chat");
        setResizable(false);
    }

    @Override
    public void showMessage(String text) {
        chat.append(text + "\n");
    }

    @Override
    public void disconnectedFromServer() {
        hideHeaderPanel(true);
    }

    public void disconnectFromServer() {
        controller.disconnectFromServer();
    }

    public void hideHeaderPanel(boolean visible) {
        loginPanel.setVisible(false);
    }

    private void createPanel() {
        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createLog(), BorderLayout.CENTER);
        add(createFooterPanel(), BorderLayout.SOUTH);
    }

    public void connectedToServer() {
        if (controller.connectToServer(username.getText())) {
            loginPanel.setVisible(false);
        }
    }

    public void message() {
        controller.message(message.getText());
        message.setText("");
    }

    private Component createFooterPanel() {
        JPanel messagePanel = new JPanel(new GridLayout(1, 2));
        message = new JTextField();
        btnSend = new JButton("send");
        messagePanel.add(message);
        messagePanel.add(btnSend);

        message.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n') {
                    message();
                }
            }
        });


        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message();
            }
        });

        return messagePanel;
    }

    private Component createLog() {
        chat = new JTextArea();
        chat.setEditable(false);

        return chat;
    }

    private Component createHeaderPanel() {
        JPanel loginInputPanel = new JPanel(new GridLayout(2, 3));
        loginPanel = new JPanel(new GridLayout(1, 2));
        ip = new JTextField("127.0.0.1");
        port = new JTextField("8150");
        username = new JTextField();
        password = new JPasswordField("123456");
        btnLogin = new JButton("login");

        loginInputPanel.add(ip);
        loginInputPanel.add(port);
        loginInputPanel.add(username);
        loginInputPanel.add(password);
        loginPanel.add(loginInputPanel);
        loginPanel.add(btnLogin);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectedToServer();
            }
        });

        return loginPanel;
    }

    @Override
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING){
            this.disconnectedFromServer();
        }
    }

}
