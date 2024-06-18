package org.example.jdk_sem2.src.common;

import org.example.jdk_sem2.src.common.MainCanvas;

import java.awt.*;

public interface CanvasRepaintListener {
    void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime);
}
