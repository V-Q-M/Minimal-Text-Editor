package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import enums.Mode;

public class InputHandler implements KeyListener {
    EditorPanel editorPanel;
    private Mode mode = Mode.NORMAL;

    private final int ESCAPE_KEY = 27;
    private final int ENTER_KEY = 10;


    public InputHandler(EditorPanel editorPanel){
        this.editorPanel = editorPanel;
    }

    public void analyzeInput(char input){
        switch(mode){
            case Mode.NORMAL    -> processNormalInput(input);
            case Mode.INSERT    -> processInsertInput(input);
            case Mode.COMMAND   -> processCommandInput(input);
            case Mode.SELECTION -> processSelectionInput(input);
            case Mode.REPLACE   -> processReplaceInput(input);
        }
        editorPanel.repaint();
    }

    private void processNormalInput(char input){
        int currentX = editorPanel.firstPage.getXIndex();
        switch (input) {
            case 'j' -> editorPanel.firstPage.setYIndex(1);    // move down
            case 'k' -> editorPanel.firstPage.setYIndex(-1);   // move up
            case 'h' -> editorPanel.firstPage.setXIndex(currentX - 1);
            case 'l' -> editorPanel.firstPage.setXIndex(currentX + 1);

            case 'i' -> mode = Mode.INSERT;
            case ':' -> mode = Mode.COMMAND;
            case 'v' -> mode = Mode.SELECTION;
            case 'r' -> mode = Mode.REPLACE;
            case 'd' -> System.out.println("DELETE ROW");
            case 'c' -> {
                System.out.println("DELETE ROW");
                mode = Mode.INSERT;
            }
            case 'x' -> {
                editorPanel.firstPage.removeChar();
                editorPanel.firstPage.setXIndex(editorPanel.getX() - 1);
            }
            case 'p' -> System.out.println("PASTE");
        }
    }
    private final char BACKSPACE_KEY = 8;

    private void processInsertInput(char input){
        switch (input){
            case ESCAPE_KEY -> {
                mode = Mode.NORMAL;
                return;
            }
            case BACKSPACE_KEY -> {
                editorPanel.firstPage.setXIndex(editorPanel.firstPage.getXIndex() - 1);
                editorPanel.firstPage.removeChar();
                return;
            }

        }
        editorPanel.firstPage.insertChar(input);
        editorPanel.firstPage.setXIndex(editorPanel.firstPage.getXIndex() + 1);
    }

    private void processReplaceInput(char input){
        switch (input){
            case ESCAPE_KEY -> {
                mode = Mode.NORMAL;
                return;
            }
        }
        editorPanel.firstPage.insertChar(input);
        mode = Mode.NORMAL;
    }

    private void processCommandInput(char input){
        switch (input){
            case ESCAPE_KEY -> mode = Mode.NORMAL;
            case 'q' -> System.out.println("EXIT");
            case 'w' -> System.out.println("WRITE");
        }
    }

    private void processSelectionInput(char input){
        switch (input){
            case ESCAPE_KEY -> mode = Mode.NORMAL;
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {
        analyzeInput(e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
