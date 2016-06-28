
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import nu.xom.Attribute;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Text;

public class RssStarter{
    public static void main(String[] args){
        Element rss=new Element("rss");
        Attribute version=new Attribute("version","2.0");
        rss.addAttribute(version);
        Element channel=new Element("channel");
        rss.appendChild(channel);
        Element title=new Element("title");
        Text titleText=new Text("Workbench");
        title.appendChild(titleText);
        channel.appendChild(title);
        Element link=new Element("link");
        Text linkText=new Text("http://www.baidu.com");
        link.appendChild(linkText);
        channel.appendChild(link);
        Document doc=new Document(rss);
        try{
            FileWriter fw=new FileWriter("feed.rss");
            BufferedWriter buff=new BufferedWriter(fw);
            buff.write(doc.toXML());
            buff.close();
        }catch(IOException ie){
            System.out.println(ie.getMessage());
        }
        System.out.println(doc.toXML());
    }
}