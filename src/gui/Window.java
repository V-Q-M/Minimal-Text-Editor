package gui;

import javax.swing.*;

public class Window {
    private int width = 1600;
    private int height = 900;

    public Window(){
        this.width = 1600;
        this.height = 900;
        openWindow();
    }

    private void openWindow(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new EditorPanel());
        frame.pack();
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
