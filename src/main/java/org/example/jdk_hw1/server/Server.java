package org.example.jdk_hw1.server;

import javax.swing.*;

import org.example.jdk_hw1.client.Client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Server extends JFrame {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    JTextArea log;
    JButton start, stop;

    private boolean isServerWorking;

    private ArrayList<Client> onlineUsers = new ArrayList();
    private String logHistory = "";


    public JTextArea getLog() {
        return log;
    }

    public String getLogHistory() {
        return logHistory;
    }

    public void setLogHistory(String logHistory) {
        this.logHistory = logHistory;
    }

    public Server() {
        isServerWorking = false;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);

        setTitle("Server chat");
        setResizable(false);
        start = new JButton("Start");
        stop = new JButton("Stop");
        log = new JTextArea();
        log.setEditable(false);
        JPanel btnPanel = new JPanel(new GridLayout(1, 2));
        btnPanel.add(start);
        btnPanel.add(stop);
        add(log, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServerWorking) {
                    isServerWorking = true;
                    logHistory += "Server started.\n";
                } else {
                    logHistory += "Server is already started.\n";
                }
                log.setText(logHistory);
            }
        });
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking) {
                    isServerWorking = false;
                    logHistory += "Server stopped.\n";
                }
                log.setText(logHistory);
            }
        });

        setVisible(true);
    }

    public boolean isServerWorking() {
        return isServerWorking;
    }

    public boolean connectUser(Client client) {
        if (!onlineUsers.contains(client)) {
            onlineUsers.add(client);
            return true;
        } else {
            return false;    
        }
    }

    public void disconnectUser(Client client) {
        if (onlineUsers.contains(client)) {
            onlineUsers.remove(client);
        }
    }
}
