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
        book1.setA(1); 
        book1.setAuthor("Tan Ah Teck");
        book1.setC(1); 
        book1.setCatagory("Programming");
        book1.setYear(2009);
        book1.setEdition((byte) 7);
        book1.setPrice(19.99);
        bookList.add(book1);

        BookStore book2 = new BookStore();
        book2.setIsbn("0123456002");
        book2.setTitle("More Java For Dummies");
        book2.setA(1);
        book2.setAuthor("Tan Ah Teck");
        book2.setC(1);
        book2.setCatagory("Programming");
        book2.setYear(2008);
        book2.setPrice(45.99);
        bookList.add(book2);

        BookStore book3 = new BookStore();
        book3.setIsbn("0123456003");
        book3.setTitle("The Complere Guide to Fishing");
        book3.setA(3); 
        book3.setAuthor("Bill Jones");
        book3.setAuthor("Jame Cook");
        book3.setAuthor("Mary Tring");
        book3.setC(2);
        book3.setCatagory("Fishing");
        book3.setCatagory("Leisure");
        book3.setLanguage("French");
        book3.setYear(2008);
        book3.setEdition((byte) 1);
        book3.setPrice(39.99);
        bookList.add(book3);

        
        Document doc = DocumentFactory.getInstance().createDocument();
        Element root = doc.addElement("bookstore"); // Root element

        
        for (BookStore b : bookList) {
            Element book = root.addElement("book");
            book.addAttribute("isbn", b.getIsbn()); // Add attribute

            Element elem1 = book.addElement("title");
            elem1.addText(b.getTitle());

           
            String[] authors = b.getAuthor();
            if (authors != null && authors.length > 0) {
//                Element authorsElem = book.addElement("authors");
                for (String author : authors) {
                    if (author != null) {
                        Element authorElem = book.addElement("author");
                        authorElem.addText(author);
                    }
                }
            }

            
            String[] categories = b.getCatagory();
            if (categories != null && categories.length > 0) {
//                Element categoriesElem = book.addElement("categories");
                for (String category : categories) {
                    if (category != null) {
                        Element categoryElem = book.addElement("category");
                        categoryElem.addText(category);
                    }
                }
            }
            if(b.getLanguage()!=null) {
            Element elem8 = book.addElement("language");
            elem8.addText(b.getLanguage());
            }
            Element elem4 = book.addElement("year");
            elem4.addText(String.valueOf(b.getYear()));

            if (b.getEdition() != null) {
                Element elem5 = book.addElement("edition");
                elem5.addText(String.valueOf(b.getEdition()));
            }

            Element elem6 = book.addElement("price");
            elem6.addText(String.valueOf(b.getPrice()));
        }

        
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
