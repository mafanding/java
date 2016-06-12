import java.util.StringTokenizer;

public class Practice3{
    public static void main(String[] args){
        String datetime="05/22/2015";
        StringTokenizer d=new StringTokenizer(datetime,"/");
        System.out.println(d.nextToken());
        System.out.println(d.nextToken());
        System.out.println(d.nextToken());

        SwimPool sp=new SwimPool();
        sp.depth=3;
        sp.height=2;
        sp.weight=500;
        sp.getAttributes();
    }
}