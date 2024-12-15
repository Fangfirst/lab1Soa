package lab1_1;

import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import model.BookStoree;
public class create1XMLbook {
	public static void main(String[] args) throws Exception {
        BookStoree b = new BookStoree();
        b.setIsbn("0123456001");
        b.setTitle("Java For Dummies");
        b.setAuthor("Tan Ah Teck");
        b.setCatagory("Programming");
        b.setYear(2009);
        b.setEdition((byte) 7);
        b.setPrice(19.99);

        // Create the document and root element
        Document doc = DocumentFactory.getInstance().createDocument();
        Element root = doc.addElement("bookstore"); // Root element

        // Add a book element as a child of root
        Element book = root.addElement("book");
        book.addAttribute("isbn", b.getIsbn()); // Add attribute

        Element elem1 = book.addElement("title");
        elem1.addText(b.getTitle());
        Element elem2 = book.addElement("author");
        elem2.addText(b.getAuthor());
        Element elem3 = book.addElement("category");
        elem3.addText(b.getCatagory());
        Element elem4 = book.addElement("year");
        elem4.addText(String.valueOf(b.getYear()));
        Element elem5 = book.addElement("edition");
        elem5.addText(String.valueOf(b.getEdition()));
        Element elem6 = book.addElement("price");
        elem6.addText(String.valueOf(b.getPrice()));

        // Write the document to an XML file
        FileOutputStream fos = new FileOutputStream("book.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(fos, format);

        writer.write(doc);
        writer.flush();
        writer.close();
        fos.close();

        System.out.println("XML file created successfully!");
    }
}
