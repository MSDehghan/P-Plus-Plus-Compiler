package AST.SymbolTable;

import java.util.HashMap;


public class HashMapOurs <K,V> extends  HashMap <K,V> {
    private int index = 0;

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
