package org.example.jdk_hw1.server;

import javax.swing.*;

import org.example.jdk_hw1.client.ClientUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Server extends JFrame implements ServerView {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    JTextArea log;
    JButton start, stop;

    ServerController controller;


    public Server() {
        setting();
        createPanel();
        
        setVisible(true);
    }

    public void setController(ServerController controller) {
        this.controller = controller;
    }

    private void setting() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Server chat");
        setResizable(false);
    }

    private void createPanel() {
        add(createLog(), BorderLayout.CENTER);
        add(createFooterPanel(), BorderLayout.SOUTH);
    }

    private Component createLog() {
        log = new JTextArea();
        log.setEditable(false);
        return log;
    }

    private Component createFooterPanel() {
        start = new JButton("Start");
        stop = new JButton("Stop");
    
        JPanel btnPanel = new JPanel(new GridLayout(1, 2));
        btnPanel.add(start);
        btnPanel.add(stop);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startServer();
            }
        });
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopServer();
            }
        });

        return btnPanel;
    }

    public void message(String text) {
        controller.message(text);
    }

    public void showMessage(String text) {
        log.append(text + "\n");
    }

    @Override
    public void startServer() {
        controller.startServer();
    }

    @Override
    public void stopServer() {

    }
}

    
    