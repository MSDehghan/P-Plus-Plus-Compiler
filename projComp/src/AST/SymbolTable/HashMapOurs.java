package AST.SymbolTable;

import java.util.HashMap;


public class HashMapOurs <K,V> extends  HashMap <K,V> {
    private int index = 0;
    private String labelStart ;
    private String labelLast;

    public String getLabelLast() {
        return labelLast;
    }

    public void setLabelLast(String labelLast) {
        this.labelLast = labelLast;
    }

    public String getLabelStart() {
        return labelStart;
    }

    public void setLabelStart(String labelStart) {
        this.labelStart = labelStart;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public int getAndAddIndex(){
        return index++;
    }
    public void addIndex(int add){
        index += add;
    }
}
