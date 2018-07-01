package AST.exp.consts;

import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.Type;

public abstract class Constant extends Exp {
    public abstract Object getValue();
}
