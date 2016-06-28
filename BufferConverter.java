import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class BufferConverter {
	public static void main(String[] args) {
		try {
			String data="firend.dat";
			FileInputStream inData=new FileInputStream(data);
			FileChannel channel=inData.getChannel();
			long inSize=channel.size();
			ByteBuffer source=ByteBuffer.allocate((int)inSize);
			channel.read(source,0);
			source.position(0);
			System.out.println("Original byte data: ");
			for(int i=0;source.remaining()>0;i++){
				System.out.print(source.get()+" ");
			}
			source.position(0);
			Charset ascii=Charset.forName("US-ASCII");
			CharsetDecoder toAscii=ascii.newDecoder();
			CharBuffer destination=toAscii.decode(source);
			destination.position(0);
			System.out.println("\nNew data: ");
			for(int i=0;destination.remaining()>0;i++){
				System.out.print(destination.get()+" ");
			}
			System.out.println();
		} catch (FileNotFoundException fe) {
			// TODO: handle exception
			System.out.println(fe.getMessage());
		}catch(IOException ie){
			System.out.println(ie.getMessage());
		}
	}
}
