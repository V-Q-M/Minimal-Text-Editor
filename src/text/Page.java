package text;

public class Page {

    private final int ROW_SIZE = 30;
    private char[] firstRow;
    private int totalAmountRows = 10;
    private int totalAmountChars = 1;

    private int xIndex = 0;
    private int yIndex = 0;

    public Page(){
       addRow();
    }

    public int getXIndex(){
       return this.xIndex;
    }
    public void setXIndex(int xIndex){
        if (xIndex >= 0 && xIndex < totalAmountChars && xIndex < ROW_SIZE){
            this.xIndex = xIndex;
        }
    }

    public int getYIndex(){
        return this.yIndex;
    }

    public void setYIndex(int yIndex){
        if (yIndex > 0 && yIndex <= totalAmountRows)
        this.yIndex = yIndex;
    }

    public void addRow(){
       firstRow = new char[ROW_SIZE];
    }
    public char[] getCurrentRow(){
        return firstRow;
    }

    public void insertChar(char input){
        totalAmountChars++;
        getCurrentRow()[getXIndex()] = input;
    }

    public void removeChar(){
        totalAmountChars--;
        getCurrentRow()[getXIndex()] = 0;
    }

}
