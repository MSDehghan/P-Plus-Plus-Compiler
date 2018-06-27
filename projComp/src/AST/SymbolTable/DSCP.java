package AST.SymbolTable;

import jdk.internal.org.objectweb.asm.Type;

import java.util.ArrayList;

/**
 * Created by pooria on 6/27/2018.
 */

abstract class DSCP {
    Type type=null;
    String name=null;
    DSCP(String name, Class<?> clazz){
        this.type = Type.getType(clazz);
        this.name = name;
    }
    DSCP(String name, String typeS){
        this.type = Type.getType(typeS);
        this.name = name;
    }
}

abstract class DSCP_STATIC extends DSCP{
    DSCP_STATIC(String name, Class<?> clazz){
        super(name,clazz);
    }
    DSCP_STATIC(String name, String typeS){
        super(name, typeS);
    }
}

abstract class DSCP_DYNAMIC extends DSCP{
    int index=-1;
    DSCP_DYNAMIC(String name, Class<?> clazz,int index){
        super(name,clazz);
        this.index = index;
    }
    DSCP_DYNAMIC(String name, String typeS, int index){
        super(name, typeS);
        this.index = index;
    }
}

class DSCP_VAR_DYNAMIC extends DSCP_DYNAMIC{
    DSCP_VAR_DYNAMIC(String name, Class<?> clazz,int index){
        super(name,clazz,index);
    }
    DSCP_VAR_DYNAMIC(String name, String typeS, int index){
        super(name, typeS,index);
    }
}



class DSCP_VAR_STATIC extends DSCP_STATIC{
    DSCP_VAR_STATIC(String name, Class<?> clazz){
        super(name,clazz);
    }
    DSCP_VAR_STATIC(String name, String typeS){
        super(name, typeS);
    }
}



class DSCP_ARR_DYNAMIC extends DSCP_DYNAMIC{
    int up;
    ArrayList <Integer> dims = new ArrayList<Integer>();
    DSCP_ARR_DYNAMIC(String name, Class<?> clazz, int up,int index, int ... dims){
        super(name,clazz,index);

        for(int i : dims){
            this.dims.add(i);
        }
        this.up = up;
    }
    DSCP_ARR_DYNAMIC(String name, String typeS, int index, int up,int ... dims){
        super(name, typeS,index);

        for(int i : dims){
            this.dims.add(i);
        }
        this.up = up;
    }
}

class DSCP_ARR_STATIC extends DSCP_STATIC{
    ArrayList <Integer> dims = new ArrayList<Integer>();
    int up;
    DSCP_ARR_STATIC(String name, Class<?> clazz, int index, int up,int ... dims){
        super(name,clazz);

        for(int i : dims){
            this.dims.add(i);
        }
        this.up = up;
    }
    DSCP_ARR_STATIC(String name, String typeS, int index, int up,int ... dims){
        super(name, typeS);

        for(int i : dims){
            this.dims.add(i);
        }
        this.up = up;
    }
}


class DSCP_RECORD_DYNAMIC extends DSCP_DYNAMIC{

    ArrayList <String> listNames = new ArrayList<String>();
    DSCP_RECORD_DYNAMIC(String name, Class<?> clazz,int index, String ... names){
        super(name,clazz,index);
        for(String a : names){
            listNames.add(a);
        }
    }
    DSCP_RECORD_DYNAMIC(String name, String typeS, int index, String ... names){
        super(name, typeS,index);
        this.index = index;
        for(String a : names){
            listNames.add(a);
        }

    }

}

class DSCP_RECORD_STATIC extends DSCP_STATIC{



    ArrayList <String> listNames = new ArrayList<String>();
    DSCP_RECORD_STATIC(String name, Class<?> clazz, String ... names){
        super(name,clazz);
        for(String a : names){
            listNames.add(a);
        }
    }
    DSCP_RECORD_STATIC(String name, String typeS, String ... names){
        super(name, typeS);
        for(String a : names){
            listNames.add(a);
        }
    }
}




