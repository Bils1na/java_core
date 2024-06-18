package org.example.jdk_hw1.server;

import javax.swing.*;

import org.example.jdk_hw1.client.ClientUI;

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
    private ArrayList<ClientUI> onlineUsers;


    public String getLogHistory() {
        return readLog();
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

    public boolean connectUser(ClientUI clientUI) {
        if (isServerWorking) {
            if (!onlineUsers.contains(clientUI)) {
                onlineUsers.add(clientUI);
                return true;
            } else {
                return false;    
            }
        } else {
            return false;
        }
    }

    public void disconnectUser(ClientUI clientUI) {
        if (clientUI != null && onlineUsers.contains(clientUI)) {
            onlineUsers.remove(clientUI);
            clientUI.disconnectFromServer();
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
        for (ClientUI clientUI : onlineUsers) {
            clientUI.answer(text);
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
        try (FileReader reader = new FileReader(LOG_PATH)) {
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
        log.append(text + "\n");
    }


}

    
    