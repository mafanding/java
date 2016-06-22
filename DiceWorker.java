import javax.swing.*;

public class DiceWorker extends SwingWorker{
    int timeToRoll;

    DiceWorker(int timeToRoll){
        super();
        this.timeToRoll=timeToRoll;
    }

    protected int[] doInBackground(){
        int[] result=new int[16];
        for(int i=0;i<timeToRoll;i++){
            int sum=0;
                    for(int j=0;j<3;j++){
                      sum+=Math.floor(Math.random()*6);
                    }
            result[sum]=result[sum]+1;
        }
        return result;
    }
}