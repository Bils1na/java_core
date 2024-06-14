package org.example.jdk_hw1.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Server extends JFrame {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    JTextArea log;
    JButton start, stop;

    private boolean isServerWorking;
    private String logHistory = "";

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
                if (isServerWorking != true) {
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
                if (isServerWorking == true) {
                    isServerWorking = false;
                    logHistory += "Server stopped.\n";
                }
                log.setText(logHistory);
            }
        });

        setVisible(true);
    }

}
