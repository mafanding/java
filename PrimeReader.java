import java.io.*;

public class PrimeReader{
    public static void main(String[] args){
        try{
            FileInputStream file=new FileInputStream("400primes.dat");
            BufferedInputStream buff=new BufferedInputStream(file);
            DataInputStream data=new DataInputStream(buff);
            try{
                while(true){
                    int in=data.readInt();
                    System.out.print(in+" ");
                }
            }catch(EOFException ex){
                buff.close();
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}