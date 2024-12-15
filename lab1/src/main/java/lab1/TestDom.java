package lab1;
import java.io.*;

import javax.sql.rowset.spi.XmlWriter;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
public class TestDom {
	
	public static void main(String[] args) throws Exception {
		
		Document  doc = DocumentFactory.getInstance().createDocument();
		Element root = doc.addElement("root");
		root.addAttribute("myAttribute","myValue");
		Element elem = root.addElement("myelem");
		elem.addText("Hello world");
		
		
		FileOutputStream fos = new FileOutputStream("simple.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		
		XMLWriter writer = new XMLWriter(fos, format);
		
		writer.write(doc);
		writer.flush();
		writer.close();
		fos.close();
		
	}

}
