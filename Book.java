import java.util.*;
import java.util.regex.*;

public class Book
{
    private String isbn; // International standard book number 
    private String title;
    private String subject;
    private String publisher;
    private String language;
    private int numberofPages;
    private int dayofPublish;
    private int monthofPublish;
    private int yearofPublish;
    private int priceofBook;
    private int numberofBook;
    Scanner book = new Scanner(System.in);
    
    public Book()
    {
        super();
        this.isbn = "???";
        this.title = "???";
        this.subject = "???";
        this.publisher = "???";
        this.language = "???";
        this.numberofPages = -1;
        this.dayofPublish = -1;
        this.monthofPublish = -1;
        this.yearofPublish = -1;
        this.priceofBook = -1;
        this.numberofBook = -1;
    }
    
    public Book(String isbn, String title, String subject, String publisher, String language, int numberofPages, int dayofPublish, int monthofPublish,
                int yearofPublish, int priceofBook)
    {
        super();
        this.isbn = isbn;
        this.title = title;
        this.subject = subject;
        this.publisher = publisher;
        this.language = language;
        this.numberofPages = numberofPages;
        this.dayofPublish = dayofPublish;
        this.monthofPublish = monthofPublish;
        this.yearofPublish = yearofPublish;
        this.priceofBook = priceofBook;
        this.numberofBook = numberofBook;
    }
    
    public String   getISBN()                               {return isbn;}
    public String   getTitle()                              {return title;}
    public String   getSubject()                            {return subject;}
    public String   getPublisher()                          {return publisher;}
    public String   getLanguage()                           {return language;}
    public int      getNumberofPages()                      {return numberofPages;}
    public int      getDayofPublish()                       {return dayofPublish;}
    public int      getMonthofPublish()                     {return monthofPublish;}
    public int      getYearofPublish()                      {return yearofPublish;}
    public int      getPriceofBook()                        {return priceofBook;}
    public int      getNumberofBook()                       {return numberofBook;}
    public void     setISBN (String isbn)                   {this.isbn = isbn;}
    public void     setTitle (String title)                 {this.title = title;}
    public void     setSubject (String subject)             {this.subject = subject;}
    public void     setPublisher (String publisher)         {this.publisher = publisher;}
    public void     setLanguage (String language)           {this.language = language;}
    public void     setNumberofPages (int numberofPages)    {this.numberofPages = numberofPages;}
    public void     setDayofPublish (int dayofPublish)      {this.dayofPublish = dayofPublish;}
    public void     setMonthofPublish (int monthofPublish)  {this.monthofPublish = monthofPublish;}
    public void     setYearofPublish (int yearofPublish)    {this.yearofPublish = yearofPublish;}
    public void     setPriceofBook (int priceofBook)        {this.priceofBook = priceofBook;}
    public void     setNumberofBook (int numberofBook)      {this.numberofBook = numberofBook;}
    
    public void AddInformation()
    {
        System.out.print("Title of book: ");                                                    title = book.nextLine();
        System.out.print("Subject: ");                                                          subject = book.nextLine();
        System.out.print("Publisher: ");                                                        publisher = book.nextLine();
        System.out.print("Language: ");                                                         language = book.nextLine();
        System.out.print("Number of pages: ");                                                  numberofPages = book.nextInt();
        book.nextLine();
        System.out.print("ISBN: ");                                                             isbn = book.nextLine();
        System.out.print("Day of publish: ");                                                   dayofPublish = book.nextInt();
        System.out.print("Month of publish: ");                                                 monthofPublish = book.nextInt();
        System.out.print("Year of publish: ");                                                  yearofPublish = book.nextInt();
        System.out.print("Current price of book: ");                                            priceofBook = book.nextInt();
        System.out.print("Current number of books have: ");                                     numberofBook = book.nextInt();
    }
    
    public void PrintInformation()
    {
        System.out.println("Title of book: " + title);
        System.out.println("Subject: " + subject);
        System.out.println("Publisher: " + publisher);         
        System.out.println("Language: " + language);          
        System.out.println("Number of pages: " + numberofPages);  
        System.out.println("ISBN: " + isbn);             
        System.out.println("Date of publish: " + dayofPublish + "/" + monthofPublish + "/" + yearofPublish);
        System.out.println("Current price of book: " + priceofBook);  
        System.out.println("Current number of book: " + numberofBook);
    }
}