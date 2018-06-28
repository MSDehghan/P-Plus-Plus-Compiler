package AST.statement.loop;

import AST.block.Block;
import AST.statement.Statement;

/**
 * Created by pooria on 6/28/2018.
 */
public abstract class Loop extends Statement{
    Block block;
    Loop(Block block){
        this.block = block;
    }

}
