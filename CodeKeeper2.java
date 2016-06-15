import java.util.*;

public class CodeKeeper2{
    ArrayList<String> list;
    String[] codes={
        "alpha","lambda","gamma","delta","zeta"
    };

    CodeKeeper2(String[] userCodes){
        list=new ArrayList<String>();
        for(int i=0;i<codes.length;i++){
            addCode(codes[i]);
        }
        for(int i=0;i<userCodes.length;i++){
            addCode(userCodes[i]);
        }
        for(String code:list){
            System.out.println(code);
        }
    }

    private void addCode(String code){
        if(!list.contains(code)){
            list.add(code);
        }
    }

    public static void main(String[] args){
        new CodeKeeper2(args);
    }
}