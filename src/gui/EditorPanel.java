package gui;

import text.Page;

import javax.swing.*;
import java.awt.*;

public class EditorPanel extends JPanel {
    Page firstPage;
    InputHandler inputHandler = new InputHandler(this);
    public EditorPanel(){
        this.setFocusable(true);
        this.setRequestFocusEnabled(true);
        this.setBackground(Color.BLACK);
        this.addKeyListener(inputHandler);

        firstPage = new Page();
        firstPage.setXIndex(firstPage.getXIndex() + 1);
        firstPage.insertChar('H');
        firstPage.setXIndex(firstPage.getXIndex() + 1);
        firstPage.setXIndex(1);
        firstPage.insertChar('e');
        firstPage.setXIndex(firstPage.getXIndex() + 1);
        firstPage.setXIndex(2);
        firstPage.insertChar('l');
        firstPage.setXIndex(firstPage.getXIndex() + 1);
        firstPage.setXIndex(3);
        firstPage.insertChar('l');
        firstPage.setXIndex(firstPage.getXIndex() + 1);
        firstPage.setXIndex(4);
        firstPage.insertChar('o');
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Monospaced", Font.PLAIN, 28));
        drawText(g2d);

    }

    private void drawText(Graphics2D g2d){
        char[] currentRow = firstPage.getCurrentRow();
        for (int i = 0; i < currentRow.length; i++){
            if (i == firstPage.getXIndex()){
                g2d.setColor(Color.BLUE);
                g2d.fillRect(18 + 18 * i, 77, 20, 28);
                g2d.setColor(Color.WHITE);
            }
            g2d.drawString(String.valueOf(currentRow[i]), 20 + 18 * i, 100);
        }
        repaint();
    }

}
