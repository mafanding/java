
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.ParsingException;
import nu.xom.Text;


public class DomainEditor{
    public static void main(String[] args) throws IOException{
        try{
            Builder build=new Builder();
            File fileXML=new File("feed.rss");
            Document doc=build.build(fileXML);
            Element root=doc.getRootElement();
            Element channel=root.getFirstChildElement("channel");
            Elements children=channel.getChildElements();
            for(int i=0;i<children.size();i++){
                Element link=children.get(i);
                Text linkText=(Text)link.getChild(0);
                if(linkText.getValue().equals("http://www.baidu.com")){
                    link.removeChild(0);
                    link.appendChild("www.google.com");
                }
            }
            Element item=new Element("item");
            Element itemTitle=new Element("title");
            itemTitle.appendChild("hahahahah");
            item.appendChild(itemTitle);
            channel.appendChild(item);
            try{
                FileWriter fw=new FileWriter("feed2.rss");
                BufferedWriter buff=new BufferedWriter(fw);
                buff.write(doc.toXML());
                buff.close();
            }catch(IOException ie){
                System.out.println(ie.getMessage());
            }
            System.out.println(doc.toXML());
        }catch(ParsingException pe){
            System.out.println(pe.getMessage());
        }
    }
}