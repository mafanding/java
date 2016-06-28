
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class FingerServer{
    public FingerServer(){
        try{
            ServerSocketChannel sockChannel=ServerSocketChannel.open();
            sockChannel.configureBlocking(false);
            InetSocketAddress server=new InetSocketAddress("localhost",79);
            ServerSocket socket=sockChannel.socket();
            socket.bind(server);
            Selector selector=Selector.open();
            sockChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true){
                selector.select();
                Set keys=selector.selectedKeys();
                Iterator it=keys.iterator();
                while (it.hasNext()){
                    SelectionKey selKey=(SelectionKey)it.next();
                    it.remove();
                    if(selKey.isAcceptable()){
                        ServerSocketChannel selChannel=(ServerSocketChannel)selKey.channel();
                        ServerSocket selSocket=selChannel.socket();
                        Socket connection=selSocket.accept();
                        handleRequest(connection);
                        connection.close();
                    }
                }
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    private void handleRequest(Socket conn) throws IOException{
        InputStreamReader isr=new InputStreamReader(conn.getInputStream());
        BufferedReader is=new BufferedReader(isr);
        PrintWriter pw=new PrintWriter(new BufferedOutputStream(conn.getOutputStream()),false);
        pw.println("Nio Finger Server");
        pw.flush();
        String outLine=null;
        String inLine=is.readLine();
        if(inLine.length()>0){
            outLine=inLine;
        }
        readPlan(outLine,pw);
        pw.flush();
        pw.close();
        is.close();
    }

    private void readPlan(String outLine,PrintWriter pw){
        try{
            FileReader file=new FileReader(outLine+".plan");
            BufferedReader buff=new BufferedReader(file);
            boolean eof=false;
            while(!eof){
                String line=buff.readLine();
                if(line!=null){
                    pw.print(line);
                }else{
                    eof=true;
                }
            }
            buff.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args){
        new FingerServer();
    }
}