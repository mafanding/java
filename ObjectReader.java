import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectReader {
	public static void main(String[] args){
		try{
		FileInputStream file=new FileInputStream("Message.obj");
		ObjectInputStream obj=new ObjectInputStream(file);
		Message message=(Message)obj.readObject();
		System.out.println("Message: ");
		System.out.println(message.from);
		System.out.println(message.to);
		System.out.println(message.when);
		for(int i=0;i<message.lineCount;i++){
			System.out.println(message.text[i]);
		}
		obj.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
