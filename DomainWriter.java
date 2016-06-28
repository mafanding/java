import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import nu.xom.Builder;
import nu.xom.Comment;
import nu.xom.Document;
import nu.xom.ParsingException;
import nu.xom.Serializer;

public class DomainWriter {
	public static void main(String[] args)  throws IOException{
		try {
			Builder builder=new Builder();
			Document doc=builder.build(new File("feed2.rss"));
			Comment timestamp=new Comment("File created "+new Date());
			doc.insertChild(timestamp, 0);
			FileOutputStream fos=new FileOutputStream("feed3.rss");
			Serializer out=new Serializer(fos, "UTF-8");
			out.setIndent(2);
			out.write(doc);
		} catch (ParsingException pe) {
			// TODO: handle exception
			System.out.println(pe.getMessage());
		}
	}
}
