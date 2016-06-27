import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WebReader extends JFrame {
	JTextArea box=new JTextArea("Getting data...");
	
	WebReader(){
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,300);
		JScrollPane pane=new JScrollPane(box);
		add(pane);
		setVisible(true);
	}
	
	void getData(String url) throws MalformedURLException{
		setTitle(url);
		URL page=new URL("http",url,80,"/");
		StringBuilder text=new StringBuilder();
		try{
			HttpURLConnection conn=(HttpURLConnection)page.openConnection();
			conn.connect();
			InputStreamReader in=new InputStreamReader((InputStream)conn.getContent());
			BufferedReader buff=new BufferedReader(in);
			box.setText("Getting data...");
			String line;
			do{
				line=buff.readLine();
				text.append(line);
				text.append('\n');
				}while(line!=null);
			box.setText(text.toString());
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args){
		if(args.length<1){
			System.out.println("WEB URL");
			System.exit(1);
		}
		try{
			WebReader web=new WebReader();
			web.getData(args[0]);
		}catch(MalformedURLException e){
			System.out.println(e.getMessage());
		}
	}
}
