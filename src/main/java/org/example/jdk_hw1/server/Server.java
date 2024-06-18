package org.example.jdk_hw1.server;

import javax.swing.*;

import org.example.jdk_hw1.client.Client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
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

        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
                if (isServerWorking) {
                    appendLog("Сервер уже запущен.\n");
                } else {
                    isServerWorking = true;
                    appendLog("Сервер запущен.\n");
                }
            }
        });
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServerWorking) {
                    appendLog("Сервер отключен.\n");
                } else {
                    isServerWorking = false;
                    while (!onlineUsers.isEmpty()) {
                        disconnectUser(onlineUsers.get(onlineUsers.size()-1));
                    }
                    appendLog("Сервер отлючен.\n");
                }
            }
        });

        return btnPanel;
    }

    public boolean isServerWorking() {
        return isServerWorking;
    }

    public boolean connectUser(Client client) {
        if (isServerWorking) {
            if (!onlineUsers.contains(client)) {
                onlineUsers.add(client);
                return true;
            } else {
                return false;    
            }
        } else {
            return false;
        }
    }

    public void disconnectUser(Client client) {
        if (client != null && onlineUsers.contains(client)) {
            onlineUsers.remove(client);
            client.disconnectFromServer();
        }
    }

    public void message(String text) {
        if (!isServerWorking) {
            return;
        }
        
         appendLog(text);
         answerAll(text);
         saveInLog(text);
    }

    private void answerAll(String text) {
        for (Client client: onlineUsers) {
            client.answer(text);
        }
    }

    private void saveInLog(String text) {
        try (FileWriter writer = new FileWriter(LOG_PATH, true)) {
            writer.write(text);
            writer.write("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      
    private String readLog() {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader =  new FileReader(LOG_PATH)) {
            int c;
            while ((c = reader.read()) != -1) {
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void appendLog(String text) { 
        log.append(text);
    }


}

    
    