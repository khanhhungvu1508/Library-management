import java.util.*;
import java.text.SimpleDateFormat;
public class Main
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner (System.in);
		Scanner content = new Scanner (System.in);
		int numsofBookhave = 0;
		int numsofScienceBook = 0;
		int numsofSocialBook = 0;
		int numsofCard = 0;
		int[] timesofborrow = new int[10000];
		ScienceBook[] listofScienceBooks = new ScienceBook[10000];
		SocialBook[] listofSocialBooks = new SocialBook[10000];
		LibraryCard[] listofCard = new LibraryCard[10000];
		ExchangedBook[][] listofBookExchanged = new ExchangedBook[10000][10000];
		for (int i = 0; i < 10000; i++)
		    timesofborrow[i] = 0;
		while (true)
		{
		    System.out.println("Please login manager account to continue: ");
		    System.out.print("Login: ");
		    String loginManagement = content.nextLine();
		    System.out.print("Password: ");
		    String passwordManagement = content.nextLine();
		    if (!(loginManagement.equals("cenlib@abc.edu.vn") == true && passwordManagement.equals("managelib1907@!2020") == true))
		        throw new ArithmeticException("Only management of library can be access to the management system of library");
		    System.out.print("Choose mode to continue (1 to add new book in your library, 2 to see all natural science books, 3 to see all social " 
		                    + "science books, 4 for searching book, 5 to register the account, 6 to borrow book, 7 to return book, 8 to pay the "
		                    + "doubt money, 9 to list of members' book borrowing history): ");
		    int mode = scanner.nextInt();
		    if (mode == 1)
		    {
		        String position = (numsofBookhave % 10 == 0)? "st": (numsofBookhave % 10 == 1)? "nd": (numsofBookhave % 10 == 2)? "rd": "th";
		        System.out.println("Please input above information to add " + (numsofBookhave + 1) + position + " book in library: ");
		        System.out.print("Choose type of book to add (1 for natural science books, 2 for social science book): ");
		        int modeType = scanner.nextInt();
		        if (modeType == 1)
		        {
    		        listofScienceBooks[numsofScienceBook] = new ScienceBook();
    		        listofScienceBooks[numsofScienceBook].AddInformation();
    		        boolean addSucessfully = false;
    		        while (!addSucessfully)
    		        {
    		            while (!(listofScienceBooks[numsofScienceBook].checkInformation()))
    		            {
    		                listofScienceBooks[numsofScienceBook] = new ScienceBook();
    		                listofScienceBooks[numsofScienceBook].AddInformation();
    		            }
    		            addSucessfully = true;
    		            for (int i = 0; i < numsofScienceBook; i++)
    		            {
    		                if (listofScienceBooks[i].getISBN().equals(listofScienceBooks[numsofScienceBook].getISBN()))
    		                {
    		                    System.out.println("This book is same as this book you have added before!. Please check it again!");
    		                    addSucessfully = false;
    		                    break;
    		                }
    		                if (listofScienceBooks[i].getPosition().equals(listofScienceBooks[numsofScienceBook].getPosition()))
    		                {
    		                    System.out.println("This possition has other books booked!. Please check it again!");
    		                    addSucessfully = false;
    		                    break;
    		                }
    		            }
    		            if (addSucessfully == false)
    		            {
    		                listofScienceBooks[numsofScienceBook] = new ScienceBook();
    		                listofScienceBooks[numsofScienceBook].AddInformation();
    		            }
    		        }
    		        listofScienceBooks[numsofScienceBook].PrintInformation();
    		        numsofScienceBook++;
		        }
		        if (modeType == 2)
		        {
    		        listofSocialBooks[numsofSocialBook] = new SocialBook();
    		        listofSocialBooks[numsofSocialBook].AddInformation();
    		        boolean addSucessfully = false;
    		        while (!addSucessfully)
    		        {
    		            while (!(listofSocialBooks[numsofSocialBook].checkInformation()))
    		            {
    		                listofSocialBooks[numsofSocialBook] = new SocialBook();
    		                listofSocialBooks[numsofSocialBook].AddInformation();
    		            }
    		            addSucessfully = true;
    		            for (int i = 0; i < numsofSocialBook; i++)
    		            {
    		                if (listofSocialBooks[i].getISBN().equals(listofSocialBooks[numsofSocialBook].getISBN()))
    		                {
    		                    System.out.println("This book is same as this book you have added before!. Please check it again!");
    		                    addSucessfully = false;
    		                    break;
    		                }
    		                if (listofSocialBooks[i].getPosition().equals(listofSocialBooks[numsofSocialBook].getPosition()))
    		                {
    		                    System.out.println("This possition has other books booked!. Please check it again!");
    		                    addSucessfully = false;
    		                    break;
    		                }
    		            }
    		            if (addSucessfully == false)
    		            {
    		                listofSocialBooks[numsofSocialBook] = new SocialBook();
    		                listofSocialBooks[numsofSocialBook].AddInformation();
    		            }
    		        }
    		        listofSocialBooks[numsofSocialBook].PrintInformation();
    		        numsofSocialBook++;
		        }
		        numsofBookhave++;
		    }
		    if (mode == 2)
		    {
		        System.out.println("The below are all of the natural science book: ");
		        for (int i = 0; i < numsofScienceBook; i++)
		        {
		            String position = (i % 10 == 0)? "st": (i % 10 == 1)? "nd": (i % 10 == 2)? "rd": "th";
		            System.out.println("The information of " + (i + 1) + position + " natural science book in library: ");
		            listofScienceBooks[i].SeeInformation();
		            System.out.println("-------------------------------------------------------------------");
		        }
		        System.out.println("Total have: " + numsofScienceBook + " natural science books");
		        System.out.println("-------------------------------------------------------------------");
		    }
		    if (mode == 3)
		    {
		        System.out.println("The below are all of the social science book: ");
		        for (int i = 0; i < numsofSocialBook; i++)
		        {
		            String position = (i % 10 == 0)? "st": (i % 10 == 1)? "nd": (i % 10 == 2)? "rd": "th";
		            System.out.println("The information of " + (i + 1) + position + " social science book in library: ");
		            listofSocialBooks[i].SeeInformation();
		            System.out.println("-------------------------------------------------------------------");
		        }
		        System.out.println("Total have: " + numsofSocialBook + " social science books");
		        System.out.println("-------------------------------------------------------------------");
		    }
		    if (mode == 4)
		    {
		        SearchBook searchbook = new SearchBook();
		        searchbook.AddInformation();
		        int find = -1;
		        for (int i = 0; i < numsofScienceBook; i++)
		        {
		            if (searchbook.getISBNcheck() == true)
		            {
		                if (searchbook.getISBN().equals(listofScienceBooks[i].getISBN()) == false)              {find = -1;}
		                else    find = i;
		            }
		            if (searchbook.getTitlecheck() == true)
		            {
		                if (searchbook.getTitle().equals(listofScienceBooks[i].getTitle()) == false)            {find = -1;}
		                else    find = i;
		            }
		            if (searchbook.getSubjectcheck() == true)
		            {
		                if (searchbook.getSubject().equals(listofScienceBooks[i].getSubject()) == false)        {find = -1;}
		                else    find = i;
		            }
		            if (searchbook.getPublishercheck() == true)
		            {
		                if (searchbook.getPublisher().equals(listofScienceBooks[i].getPublisher()) == false)    {find = -1;}
		                else    find = i;
		            } 
		            if (searchbook.getLanguagecheck() == true)
		            {
		                if (searchbook.getLanguage().equals(listofScienceBooks[i].getLanguage()) == false)      {find = -1;}
		                else    find = i;
		            }
		            if (searchbook.getPricecheck() == true)
		            {
		                if (searchbook.getPriceofBook() != listofScienceBooks[i].getPriceofBook())              {find = -1;}
		                else    find = i;
		            }
		            if (find != -1)
		                break;
		        }
		        if (find != -1)
		        {
		            System.out.println("The book you find in natural science book. Here is the information of the book: ");
		            listofScienceBooks[find].SeeInformation();
		        }
		        if (find == -1)
		        {
		            for (int i = 0; i < numsofSocialBook; i++)
    		        {
    		            if (searchbook.getISBNcheck() == true)
    		            {
    		                if (searchbook.getISBN().equals(listofSocialBooks[i].getISBN()) == false)              {find = -1;}
    		                else    find = i;
    		            }
    		            if (searchbook.getTitlecheck() == true)
    		            {
    		                if (searchbook.getTitle().equals(listofSocialBooks[i].getTitle()) == false)            {find = -1;}
    		                else    find = i;
    		            }
    		            if (searchbook.getSubjectcheck() == true)
    		            {
    		                if (searchbook.getSubject().equals(listofSocialBooks[i].getSubject()) == false)        {find = -1;}
    		                else    find = i;
    		            }
    		            if (searchbook.getPublishercheck() == true)
    		            {
    		                if (searchbook.getPublisher().equals(listofSocialBooks[i].getPublisher()) == false)    {find = -1;}
    		                else    find = i;
    		            } 
    		            if (searchbook.getLanguagecheck() == true)
    		            {
    		                if (searchbook.getLanguage().equals(listofSocialBooks[i].getLanguage()) == false)      {find = -1;}
    		                else    find = i;
    		            }
    		            if (searchbook.getPricecheck() == true)
    		            {
    		                if (searchbook.getPriceofBook() != listofSocialBooks[i].getPriceofBook())              {find = -1;}
    		                else    find = i;
    		            }
    		            if (find != -1)
    		                break;
    		        }
    		        if (find != -1)
    		        {
    		            System.out.println("The book you find in social science book. Here is the information of the book: ");
    		            listofSocialBooks[find].SeeInformation();
    		        }
    		        else
    		            System.out.println("No book was found!");
		        }
		    }
		    if (mode == 5)
		    {
		        String position = (numsofCard % 10 == 0)? "st": (numsofCard % 10 == 1)? "nd": (numsofCard % 10 == 2)? "rd": "th";
		        System.out.println("Please input above information to add " + (numsofCard + 1) + position + " library card: ");
		        listofCard[numsofCard] = new LibraryCard();
		        listofCard[numsofCard].giveInformation();
		        boolean registerSucessfully = false;
		        while (!registerSucessfully)
		        {
		            while (!listofCard[numsofCard].checkInformation())
		            {
		                listofCard[numsofCard] = new LibraryCard();
		                listofCard[numsofCard].giveInformation();
		            }
		            registerSucessfully = true;
		            for (int i = 0; i < numsofCard; i++)
		            {
		                if (listofCard[numsofCard].getID().equals(listofCard[i].getID()) == true)
		                {
		                    System.out.println("The ID has been existed! Please check your ID again!");
		                    registerSucessfully = false;
		                    break;
		                }
		            }
		            if (registerSucessfully == false)
    		        {
    		            listofCard[numsofCard] = new LibraryCard();
		                listofCard[numsofCard].giveInformation();
    		        }
		        }
		        listofCard[numsofCard].PrintInformation();
		        numsofCard++;
		    }
		    if (mode == 6)
		    {
		        System.out.print("Please input your ID library card to continue: ");
		        String idchecking = content.nextLine();
		        int positionofID = -1;
		        boolean IDsuccesfully = false;
		        while (!IDsuccesfully)
		        {
    		        for (int i = 0; i < numsofCard; i++)
    		        {
    		            if (listofCard[i].getIDCard().equals(idchecking) == true)
    		            {
    		                System.out.println("Access successfully!");
    		                positionofID = i;
    		                IDsuccesfully = true;
    		                break;
    		            }
    		        }
    		        if (IDsuccesfully == false)
    		        {
    		            System.out.println("Your ID library card is not existed! Please check your ID library card again!");
    		            System.out.print("Please input your ID library card to continue: ");
		                idchecking = content.nextLine();
    		        }
		        }
                listofBookExchanged[positionofID][timesofborrow[positionofID]] = new ExchangedBook();
                listofBookExchanged[positionofID][timesofborrow[positionofID]].addInformationBorrow();
                boolean borrowSucessfully = false;
                while (!borrowSucessfully)
                {
                    while (!listofBookExchanged[positionofID][timesofborrow[positionofID]].checkInformationBorrow())
                    {
                        listofBookExchanged[positionofID][timesofborrow[positionofID]] = new ExchangedBook();
                        listofBookExchanged[positionofID][timesofborrow[positionofID]].addInformationBorrow();
                    }
                    for (int i = 0; i < numsofScienceBook; i++)
                    {
                        if (listofScienceBooks[i].getISBN().equals(listofBookExchanged[positionofID][timesofborrow[positionofID]].getISBNCheck()) == true)
                        {
                            borrowSucessfully = true;
                            System.out.println("Congratulation on you! You have finished borrow this book. Here are all information about book: ");
                            listofScienceBooks[i].SeeInformation();
                            listofBookExchanged[positionofID][timesofborrow[positionofID]].PrintBillCode();
                            break;
                        }
                    }
                    if (borrowSucessfully == false)
                    {
                        for (int i = 0; i < numsofSocialBook; i++)
                        {
                            if (listofSocialBooks[i].getISBN().equals(listofBookExchanged[positionofID][timesofborrow[positionofID]].getISBNCheck()) == true)
                            {
                                borrowSucessfully = true;
                                System.out.println("Congratulation on you! You have finished borrow this book. Here are all information about book: ");
                                listofSocialBooks[i].SeeInformation();
                                listofBookExchanged[positionofID][timesofborrow[positionofID]].PrintBillCode();
                                break;
                            }
                        }
                    }
                    if (borrowSucessfully == false)
                    {
                        System.out.println("Your ISBN of book is not existed! Please check again!");
                        listofBookExchanged[positionofID][timesofborrow[positionofID]] = new ExchangedBook();
                        listofBookExchanged[positionofID][timesofborrow[positionofID]].addInformationBorrow();
                    }
                }
                timesofborrow[positionofID]++;
		    }
		    if (mode == 7)
		    {
		        System.out.print("Please input your ID library card to continue: ");
		        String idchecking = content.nextLine();
		        int positionofID = -1;
		        boolean IDsuccesfully = false;
		        while (!IDsuccesfully)
		        {
    		        for (int i = 0; i < numsofCard; i++)
    		        {
    		            if (listofCard[i].getIDCard().equals(idchecking) == true)
    		            {
    		                System.out.println("Access successfully!");
    		                positionofID = i;
    		                IDsuccesfully = true;
    		                break;
    		            }
    		        }
    		        if (IDsuccesfully == false)
    		        {
    		            System.out.println("Your ID library card is not existed! Please check your ID library card again!");
    		            System.out.print("Please input your ID library card to continue: ");
		                idchecking = content.nextLine();
    		        }
		        }
                System.out.print("Please input your bill code to continue: ");
                String billCodeChecking = content.nextLine();
                int positionofBillcode = -1;
                boolean billSuccessfully = false;
                while (!billSuccessfully)
                {
                    for (int i = 0; i < timesofborrow[positionofID]; i++)
                    {
                        if (listofBookExchanged[positionofID][i].getBillCode().equals(billCodeChecking) == true
                        && listofBookExchanged[positionofID][i].getDayReturn().equals("???") == true)
                        {
                            System.out.println("The bill has been existed!");
                            positionofBillcode = i;
                            billSuccessfully = true;
                            break;
                        }
                    }
                    if (billSuccessfully == false)
                    {
                        System.out.println("Your bill returned is not existed! Please check your bill code again!");
                        System.out.print("Please input your bill code to continue: ");
                        billCodeChecking = content.nextLine();
                    }
                }
                System.out.println("Day begin borrow is: " + listofBookExchanged[positionofID][positionofBillcode].getDayBorrow());
                listofBookExchanged[positionofID][positionofBillcode].addInformationReturn();
                while (!(listofBookExchanged[positionofID][positionofBillcode].checkInformationReturn()))
                    listofBookExchanged[positionofID][positionofBillcode].addInformationReturn();    
                long payFine = 0;
                long daysBetween = -1;
                // Checking for over-time returned
                try {
                    SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String dateBeforeString = listofBookExchanged[positionofID][positionofBillcode].getDayBorrow();
                    String dateAfterString = listofBookExchanged[positionofID][positionofBillcode].getDayReturn();
                    Date dateBefore = myFormat.parse(dateBeforeString);
                    Date dateAfter = myFormat.parse(dateAfterString);
                    long difference = dateAfter.getTime() - dateBefore.getTime();
                    daysBetween = (difference / (1000 * 60 * 60 * 24));
                } catch (Exception e) {
	                e.printStackTrace();
                }
                if (daysBetween > 7)
                {
                    System.out.println("Oh no! You returned book over-time. You must have pay fine since breaching return books on time");
                    boolean findBook = false;
                    for (int i = 0; i < numsofScienceBook; i++)
                    {
                        if (listofScienceBooks[i].getISBN().equals(listofBookExchanged[positionofID][positionofBillcode].getISBNCheck()) == true)
                        {
                            findBook = true;
                            long addFine = listofScienceBooks[i].getPriceofBook() + 5000 * (daysBetween - 7);
                            System.out.println("Since the price of book is " + listofScienceBooks[i].getPriceofBook() + " so you must pay "
                                             + addFine + " by law of the library");
                            payFine += addFine;
                            break;
                        }
                    }
                    if (findBook == false)
                    {
                        for (int i = 0; i < numsofSocialBook; i++)
                        {
                            if (listofSocialBooks[i].getISBN().equals(listofBookExchanged[positionofID][positionofBillcode].getISBNCheck()) == true)
                            {
                                findBook = true;
                                long addFine = listofSocialBooks[i].getPriceofBook() + 5000 * (daysBetween - 7);
                                System.out.println("Since the price of book is " + listofSocialBooks[i].getPriceofBook() + " so you must pay "
                                                   + addFine + "by law of the library");
                                payFine += addFine;
                                break;
                            }
                        }
                    }
                }
                // Checking for borrower tear, wet or peel off document labels or note cards book
                System.out.print("During the time of borrowing, did the borrower tear, wet or peel off document labels or note cards on book? ");
                boolean NoPrettyBook = scanner.nextBoolean();
                if (NoPrettyBook == true)
                {
                    for (int i = 0; i < numsofScienceBook; i++)
                    {
                        if (listofScienceBooks[i].getISBN().equals(listofBookExchanged[positionofID][positionofBillcode].getISBNCheck()) == true)
                        {
                            NoPrettyBook = false;
                            long addFine = 80000;
                            System.out.println("You must pay " + addFine + " by law of the library");
                            payFine += addFine;
                            break;
                        }
                    }
                    if (NoPrettyBook == true)
                    {
                        for (int i = 0; i < numsofSocialBook; i++)
                        {
                            if (listofSocialBooks[i].getISBN().equals(listofBookExchanged[positionofID][positionofBillcode].getISBNCheck()) == true)
                            {
                                NoPrettyBook = false;
                                long addFine = 80000;
                                System.out.println("You must pay " + addFine + "by law of the library");
                                payFine += addFine;
                                break;
                            }
                        }
                    }
                }
                // Checking for lost book/ make the book can't use again
                System.out.print("During the time of borrowing, did the borrower lost book/ make the book can't use again? ");
                boolean LostBook = scanner.nextBoolean();
                if (LostBook == true)
                {
                    for (int i = 0; i < numsofScienceBook; i++)
                    {
                        if (listofScienceBooks[i].getISBN().equals(listofBookExchanged[positionofID][positionofBillcode].getISBNCheck()) == true)
                        {
                            LostBook = false;
                            long addFine = listofScienceBooks[i].getPriceofBook() * 10 + 50000;
                            System.out.println("Since the price of book is " + listofScienceBooks[i].getPriceofBook() + " so you must pay "
                                               + addFine + " by law of the library");
                            payFine += addFine;
                            break;
                        }
                    }
                    if (LostBook == true)
                    {
                        for (int i = 0; i < numsofSocialBook; i++)
                        {
                            if (listofSocialBooks[i].getISBN().equals(listofBookExchanged[positionofID][positionofBillcode].getISBNCheck()) == true)
                            {
                                NoPrettyBook = false;
                                long addFine = listofSocialBooks[i].getPriceofBook() * 10 + 50000;
                                System.out.println("Since the price of book is " + listofSocialBooks[i].getPriceofBook() + " so you must pay "
                                             + addFine + "by law of the library");
                                payFine += addFine;
                                break;
                            }
                        }
                    }
                }
                // Checking for borrower make dirty/ write or draw on book 
                System.out.print("During the time of borrowing, did the borrower make dirty/ write or draw on book? ");
                boolean DirtyBook = scanner.nextBoolean();
                if (DirtyBook == true)
                {
                    for (int i = 0; i < numsofScienceBook; i++)
                    {
                        if (listofScienceBooks[i].getISBN().equals(listofBookExchanged[positionofID][positionofBillcode].getISBNCheck()) == true)
                        {
                            DirtyBook = false;
                            long addFine = listofScienceBooks[i].getNumberofPages() * 3000;
                            System.out.println("Since the number of pages of book is " + listofScienceBooks[i].getNumberofPages() 
                                               + " so you must pay " + addFine + " by law of the library");
                            payFine += addFine;
                            break;
                        }
                    }
                    if (DirtyBook == true)
                    {
                        for (int i = 0; i < numsofSocialBook; i++)
                        {
                            if (listofSocialBooks[i].getISBN().equals(listofBookExchanged[positionofID][positionofBillcode].getISBNCheck()) == true)
                            {
                                NoPrettyBook = false;
                                long addFine = listofSocialBooks[i].getNumberofPages() * 3000;
                                System.out.println("Since the number of pages of book is " + listofSocialBooks[i].getPriceofBook() 
                                                   + " so you must pay " + addFine + "by law of the library");
                                payFine += addFine;
                                break;
                            }
                        }
                    }
                }
                // Checking for borrower peel book covers 
                System.out.print("During the time of borrowing, did the borrower peel book covers? ");
                boolean PeelBook = scanner.nextBoolean();
                if (PeelBook == true)
                {
                    for (int i = 0; i < numsofScienceBook; i++)
                    {
                        if (listofScienceBooks[i].getISBN().equals(listofBookExchanged[positionofID][positionofBillcode].getISBNCheck()) == true)
                        {
                            PeelBook = false;
                            long addFine = 15000;
                            System.out.println("You must pay " + addFine + " by law of the library");
                            payFine += addFine;
                            break;
                        }
                    }
                    if (PeelBook == true)
                    {
                        for (int i = 0; i < numsofSocialBook; i++)
                        {
                            if (listofSocialBooks[i].getISBN().equals(listofBookExchanged[positionofID][positionofBillcode].getISBNCheck()) == true)
                            {
                                DirtyBook = false;
                                long addFine = 15000;
                                System.out.println("You must pay " + addFine + "by law of the library");
                                payFine += addFine;
                                break;
                            }
                        }
                    }
                }
                // Checking for borrower lost some book pages 
                System.out.print("During the time of borrowing, did the borrower lost some book pages? ");
                boolean LostPage = scanner.nextBoolean();
                if (LostPage == true)
                {
                    for (int i = 0; i < numsofScienceBook; i++)
                    {
                        if (listofScienceBooks[i].getISBN().equals(listofBookExchanged[positionofID][positionofBillcode].getISBNCheck()) == true)
                        {
                            LostPage = false;
                            long addFine = listofScienceBooks[i].getNumberofPages() * 10000;
                            System.out.println("Since the number of pages of book is " + listofScienceBooks[i].getPriceofBook() 
                                               + " so you must pay " + addFine + " by law of the library");
                            payFine += addFine;
                            break;
                        }
                    }
                    if (LostPage == true)
                    {
                        for (int i = 0; i < numsofSocialBook; i++)
                        {
                            if (listofSocialBooks[i].getISBN().equals(listofBookExchanged[positionofID][positionofBillcode].getISBNCheck()) == true)
                            {
                                LostPage = false;
                                long addFine = listofSocialBooks[i].getNumberofPages() * 10000;
                                System.out.println("Since the number of pages of book is " + listofSocialBooks[i].getPriceofBook() 
                                                   + " so you must pay " + addFine + "by law of the library");
                                payFine += addFine;
                                break;
                            }
                        }
                    }
                }
                System.out.println("***********************************************************************************************************");
                System.out.println("The total fine charge for careless bookkeeping is: " + payFine);
                listofCard[positionofID].setFineAmount(listofCard[positionofID].getFineAmount() + payFine);
                if (payFine > 0)
                    System.out.println("I have you better compliance with library laws");
                System.out.println("***********************************************************************************************************");
		    }
		    if (mode == 8)
		    {
		        System.out.print("Please input your ID library card to continue: ");
		        String idchecking = content.nextLine();
		        int positionofID = -1;
		        boolean IDsuccesfully = false;
		        while (!IDsuccesfully)
		        {
    		        for (int i = 0; i < numsofCard; i++)
    		        {
    		            if (listofCard[i].getIDCard().equals(idchecking) == true)
    		            {
    		                System.out.println("Access successfully!");
    		                positionofID = i;
    		                IDsuccesfully = true;
    		                break;
    		            }
    		        }
    		        if (IDsuccesfully == false)
    		        {
    		            System.out.println("Your ID library card is not existed! Please check your ID library card again!");
    		            System.out.print("Please input your ID library card to continue: ");
		                idchecking = content.nextLine();
    		        }
		        }
		        System.out.println("The amount of money you doubted is: " + listofCard[positionofID].getFineAmount());
		        System.out.print("Please input the money you want to pay: ");
		        long payMoney = scanner.nextLong();
		        if (payMoney >= listofCard[positionofID].getFineAmount())
		        {
		            System.out.println("Congratulation on you! You have finished pay all of the money the borrower doubted");
		            System.out.println("Please the manager pay borrower the amount of money is: " 
		                                + (payMoney - listofCard[positionofID].getFineAmount()));
		            listofCard[positionofID].setFineAmount(0);
		        }
		        else
		        {
		            System.out.println("Congratulation on you! You have finished pay all some money the borrower doubted");
		            System.out.println("The doubt money the borrower remain is: " 
		                                + (listofCard[positionofID].getFineAmount() - payMoney));
		            listofCard[positionofID].setFineAmount(listofCard[positionofID].getFineAmount() - payMoney);
		        }
		    }
		    if (mode == 9)
		    {
		        for (int i = 0; i < numsofCard; i++)
		        {
		            for (int j = 0; j < timesofborrow[i]; j++)
		            {
		                System.out.println("------------------------------------------------------------------------------------");
		                listofBookExchanged[i][j].ShowInformation();
		                System.out.println("------------------------------------------------------------------------------------");
		            }
		        }
		    }
		    if (mode <= 0 || mode >= 10)
		    {
		        System.out.println("The number only from 0 to 9! Please check again!");
		    }
		}
	}
}
