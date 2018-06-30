package AST.statement.loop;

        import AST.block.Block;
        import jdk.internal.org.objectweb.asm.ClassVisitor;
        import jdk.internal.org.objectweb.asm.MethodVisitor;


public class ForEach extends Loop{
    String id1,id2;
    public ForEach(Block block, String id1, String id2){
        super(block);
        this.id1=id1;
        this.id2=id2;
    }
    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {

    }
}
