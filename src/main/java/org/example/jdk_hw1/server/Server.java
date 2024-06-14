package org.example.jdk_hw1.server;

import javax.swing.*;
import java.awt.*;

public class Server extends JFrame {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    JTextArea log;
    JButton start, stop;

    public Server() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);

        setTitle("Server chat");
        setResizable(false);
        start = new JButton("Start");
        stop = new JButton("Stop");
        log = new JTextArea();
        log.setEditable(false);
        log.setFocusable(false);
        JPanel btnPanel = new JPanel(new GridLayout(1, 2));
        btnPanel.add(start);
        btnPanel.add(stop);
        add(log, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

}
