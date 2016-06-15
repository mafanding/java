import java.util.*;

public class FruitList{
    private ArrayList<HashMap> fruitList=new ArrayList<HashMap>();

    public void addFruit(String inName,int inNumber,float inPrice){
        HashMap<String,String> tmp=new HashMap<String,String>();
        tmp.put("name", inName);
        tmp.put("number", Integer.toString(inNumber));
        tmp.put("price", Float.toString(inPrice));
        fruitList.add(tmp);
    }

    public void showFruitList(){
        for(HashMap list:fruitList){
            System.out.println("Name: "+list.get("name"));
            System.out.println("Number: "+list.get("number"));
            System.out.println("Price: "+list.get("price")+"\n");
        }
    }

    public static void main(String[] args){
        FruitList fruit=new FruitList();
        fruit.addFruit("apple", 5, 3.00F);
        fruit.addFruit("pear", 2, 5.00F);
        fruit.addFruit("orige", 1, 1.50F);
        fruit.showFruitList();
    }
}