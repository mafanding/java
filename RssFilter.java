import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;

import nu.xom.Attribute;
import nu.xom.Builder;
import nu.xom.DocType;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.Serializer;
import nu.xom.Text;

public class RssFilter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length<2) {
			System.out.println("Error");
			System.exit(1);
		}
		String rssFile=args[0];
		String searchTerm=args[1];
		try {
			URL rssURL=new URL("http://feeds.sportsfilter.com/sportsfilter");
			rssURL.openConnection();		
			InputStreamReader in=new InputStreamReader(rssURL.openStream());
			BufferedReader buff=new BufferedReader(in);
		    StringBuilder sb=new StringBuilder();
		    String line;
		    while((line=buff.readLine())!=null){
		    	sb.append(line);
		    }
		    buff.close();
		    FileWriter fw=new FileWriter("feed4.rss");
		    BufferedWriter bw=new BufferedWriter(fw);
		    bw.write(sb.toString());
		    bw.close();
			Builder builder=new Builder();
			Document doc=builder.build(new File("feed4.rss"));
			Element root=doc.getRootElement();
			Attribute version=root.getAttribute("version");
			String versionVal=version.getValue();
			if(versionVal.equals("0.91")&doc.getDocType()==null){
				DocType rssDtd=new DocType("rss"	, "http://my.netscape.com/publish/formats/rss-0.91.dtd");
				doc.insertChild(rssDtd, 0);
			}
			Element channel=root.getFirstChildElement("channel");
			Element title=channel.getFirstChildElement("title");
			Text titleText=(Text)title.getChild(0);
			titleText.setValue(titleText.getValue()+": Search for "+searchTerm+" articles");
			Elements items=channel.getChildElements("item");
			for (int i = 0; i < items.size(); i++) {
				Element item=items.get(i);
				Element itemTitle=item.getFirstChildElement("title");
				if (itemTitle!=null) {
					Text itemTitleText=(Text)itemTitle.getChild(0);
					if(itemTitleText.getValue().indexOf(searchTerm)==-1){
						channel.removeChild(item);
					}
				}
			}
			Serializer out=new Serializer(System.out);
			out.setIndent(2);
			out.write(doc);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
