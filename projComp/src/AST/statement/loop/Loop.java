package AST.statement.loop;

import AST.block.Block;
import AST.statement.Statement;


public abstract class Loop extends Statement{
    Block block;
    Loop(Block block){
        this.block = block;
    }

}
