package org.example.jdk_sem2.src.draw_pic;

import org.example.jdk_sem2.src.draw_pic.view.MainWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }
}