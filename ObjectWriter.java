import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class ObjectWriter {
	public static void main(String[] args){
		Message mess=new Message();
		String autho="Jonson ma ,China";
		String recipient="John Black,Finish";
		String[] letter={"Nice to meet you","I am Johnson ma"};
		Date date=new Date();
		mess.writeMessage(autho, recipient, date, letter);
		try{
			FileOutputStream file=new FileOutputStream("Message.obj");
			ObjectOutputStream obj=new ObjectOutputStream(file);
			obj.writeObject(mess);
			obj.close();
			System.out.println("Write OK");
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
}

class Message implements Serializable{
	int lineCount;
	String from,to;
	Date when;
	String[] text;
	
	void writeMessage(String inFrom,String inTo,Date inWhen,String[] inText){
		text=new String[inText.length];
		for(int i=0;i<inText.length;i++){
			text[i]=inText[i];
		}
		lineCount=inText.length;
		to=inTo;
		from=inFrom;
		when=inWhen;
	}
}
