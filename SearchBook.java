import java.util.*;
import java.util.regex.*;

public class SearchBook extends Book
{
    private boolean isbncheck;
    private boolean titlecheck;
    private boolean subjectcheck;
    private boolean publishercheck;
    private boolean languagecheck;
    private boolean pricecheck;
    
    Scanner searchbook = new Scanner (System.in);
    
    public SearchBook()                         
    {
        super();
        this.isbncheck = isbncheck;
        this.titlecheck = titlecheck;
        this.subjectcheck = subjectcheck;
        this.publishercheck = publishercheck;
        this.languagecheck = languagecheck;
        this.pricecheck = pricecheck;
    }
    public boolean  getISBNcheck()                              {return isbncheck;}
    public boolean  getTitlecheck()                             {return titlecheck;}
    public boolean  getSubjectcheck()                           {return subjectcheck;}
    public boolean  getPublishercheck()                         {return publishercheck;}
    public boolean  getLanguagecheck()                          {return languagecheck;}
    public boolean  getPricecheck()                             {return pricecheck;}
    public void     setISBNcheck (boolean isbncheck)            {this.isbncheck = isbncheck;}
    public void     setTitlecheck (boolean titlecheck)          {this.titlecheck = titlecheck;}
    public void     setSubjectcheck (boolean subjectcheck)      {this.subjectcheck = subjectcheck;}
    public void     setPublishercheck (boolean publishercheck)  {this.publishercheck = publishercheck;}
    public void     setLanguagecheck (boolean languagecheck)    {this.languagecheck = languagecheck;}
    public void     setPricecheck (boolean pricecheck)          {this.pricecheck = pricecheck;}
    
    @Override
    public void AddInformation()
    {
        System.out.println("Here are all of information needed to search. Input true if you want to search by this information, if not input false");
        
        System.out.print("Do you want to find by ISBN? ");
        isbncheck = searchbook.nextBoolean();
        searchbook.nextLine();
        if (isbncheck == true)
        {
            System.out.print("Please input the ISBN of the book you find: ");
            String addISBN = searchbook.nextLine();
            super.setISBN(addISBN); 
        }
        
        System.out.print("Do you want to find by title of the book? ");
        titlecheck = searchbook.nextBoolean();
        searchbook.nextLine();
        if (titlecheck == true)
        {
            System.out.print("Please input the title of the book you find: ");
            String addTitle = searchbook.nextLine();
            super.setTitle(addTitle);
        }
        
        System.out.print("Do you want to find by subject of the book? ");
        subjectcheck = searchbook.nextBoolean();
        searchbook.nextLine();
        if (subjectcheck == true)
        {
            System.out.print("Please input the subject of the book you find: ");
            String addSubject = searchbook.nextLine();
            super.setSubject(addSubject);
        }
        
        System.out.print("Do you want to find by publisher of the book? ");
        publishercheck = searchbook.nextBoolean();
        searchbook.nextLine();
        if (publishercheck == true)
        {
            System.out.print("Please input the publisher of the book you find: ");
            String addPublisher = searchbook.nextLine();
            super.setPublisher(addPublisher); 
        }
        
        System.out.print("Do you want to find by language of the book? ");
        languagecheck = searchbook.nextBoolean();
        searchbook.nextLine();
        if (languagecheck == true)
        {
            System.out.print("Please input the language of the book you find: ");
            String addLanguage = searchbook.nextLine();
            super.setLanguage(addLanguage);
        }
        
        System.out.print("Do you want to find by price of the book? ");
        pricecheck = searchbook.nextBoolean();
        searchbook.nextLine();
        if (pricecheck == true)
        {
            System.out.print("Please input the price of the book you find: ");
            int addPrice = searchbook.nextInt();
            super.setPriceofBook(addPrice);
        }
    }
    
}