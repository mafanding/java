import java.util.*;

public class CodeKeeper{
    ArrayList list;
    String[] code={
        "alpha","lambda","gamma","delta","zeta"
    };

    CodeKeeper(String[] userCodes){
        list=new ArrayList();
        for(int i=0;i<code.length;i++){
            addCode(code[i]);
        }
        for(int i=0;i<userCodes.length;i++){
            addCode(userCodes[i]);
        }
        for(Iterator ite=list.iterator();ite.hasNext();){
            String output=(String) ite.next();
            System.out.println(output);
        }
    }

    private void addCode(String code){
        if(!list.contains(code)){
            list.add(code);
        }
    }

    public static void main(String[] args){
        CodeKeeper keeper=new CodeKeeper(args);
    }
}