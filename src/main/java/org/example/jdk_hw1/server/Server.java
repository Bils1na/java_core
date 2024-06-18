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
    private static final String LOG_PATH = "src/main/java/org/example/jdk_hw1/server/log.txt";

    JTextArea log;
    JButton start, stop;

    private boolean isServerWorking;
    private ArrayList<Client> onlineUsers;
    private String logHistory = "";


    public String getLogHistory() {
        return logHistory;
    }

    public void setLogHistory(String logHistory) {
        this.logHistory = logHistory;
    }

    public Server() {
        isServerWorking = false;
        onlineUsers = new ArrayList<>();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Server chat");
        setResizable(false);

        createPanel();
        
        setVisible(true);
    }

    private void createPanel() {
        add(createLog(), BorderLayout.CENTER);
        add(createFoooterPanel(), BorderLayout.SOUTH);
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
                
            }
        });
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        return btnPanel;
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
