package lab1_1;

import java.io.FileOutputStream;
import java.util.ArrayList;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import model.BookStore;

public class createXmlBooks {
    public static void main(String[] args) throws Exception {
        // Create a list of books
        ArrayList<BookStore> bookList = new ArrayList<>();

        // Add books to the list
        BookStore book1 = new BookStore();
        book1.setIsbn("0123456001");
        book1.setTitle("Java For Dummies");
        book1.setAuthor("Tan Ah Teck");
        book1.setCatagory("Programming");
        book1.setYear(2009);
        book1.setEdition((byte) 7);
        book1.setPrice(19.99);
        bookList.add(book1);

        BookStore book2 = new BookStore();
        book2.setIsbn("0123456002");
        book2.setTitle("Effective Java");
        book2.setAuthor("Joshua Bloch");
        book2.setCatagory("Programming");
        book2.setYear(2018);
        book2.setEdition((byte) 3);
        book2.setPrice(45.99);
        bookList.add(book2);

        BookStore book3 = new BookStore();
        book3.setIsbn("0123456003");
        book3.setTitle("Clean Code");
        book3.setAuthor("Robert C. Martin");
        book3.setCatagory("Programming");
        book3.setYear(2008);
        book3.setEdition((byte) 1);
        book3.setPrice(39.99);
        bookList.add(book3);

        // Create the document and root element
        Document doc = DocumentFactory.getInstance().createDocument();
        Element root = doc.addElement("bookstore"); // Root element

        // Add books to the XML
        for (BookStore b : bookList) {
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
        }

        // Write the document to an XML file
        FileOutputStream fos = new FileOutputStream("bookstore.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(fos, format);

        writer.write(doc);
        writer.flush();
        writer.close();
        fos.close();

        System.out.println("XML file created successfully with multiple books!");
    }
}
