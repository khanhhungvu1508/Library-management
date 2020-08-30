# Library management
The code to manage the library with some library regulations referenced by **VNU center library law**. The library regulations of the VNU are found in the link below:

[VNU library regulations](http://www.vnulib.edu.vn/index.php/muon-tra-tai-lieu-tvtt)

## Function
The library management program undertake the following functions:
1. The management system is only used by the person who managing the library system. In other cases, it is not allowed to access this system
2. The system can be added new book with 2 types of book: **Natural science book and social science book**. For more convenient tracking, the system has the ability to list all types of books according to the type of book as well as look up a specific book.
3. The system can be made ID library card with ID card is made by randomize **universally unique identifier (UUID) code**.
4. The system can be updated the parameters of borrowing book. In order not to have a dispute between borrowing times (Some returns for the same books), each of time one member borrowed one book, the system will provide a **random 12-digit number** to ensure this.
5. The system can be updated the parameters of returning book. Since the quality of the book returned may be not good as the initial so by rule, all of the factor which adversely affects the quality of the book the borrower must be pay fine money.
6. The system is integrated with the payment system, which is the place to pay compensation when borrowers pay in installments to the library system.
7. The system can be list the history borrowing book of all member who has ID library card.

## Usage package/ import

The system need to use some supported package/ import to achieve the following purposes:
1. **Operate any problem related to I/O**:

This is indicated by collect data related to library **(Input ISBN, price of book or answer some questions, ...)** we need add the following import to support:

```java
import java.util.*;
/* Including java.util.scanner */
```

2. **Operate the process date-related data**:

This is indicated by the **law of fines money since return book late** that are retrived by **VNU center library law**:

> If you returned book later than day you began borrow book one week (i.e 7 days), the borrower must pay fine money by the formula: 
>
> &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; <img src="https://latex.codecogs.com/gif.latex?S(d_1,d_2,x)&space;=&space;P(x)&space;&plus;&space;5000&space;\times&space;\left(D(d_1,&space;d_2)&space;-&space;7&space;\right)"> 
>
Which the function and description each of function in above formula is shown below:


| Function | Description |
| --- | ----------- |
| <img src="https://latex.codecogs.com/gif.latex?S(d_1,&space;d_2,&space;x)"> | Fined money since the borrower <img src="https://latex.codecogs.com/gif.latex?x"> returned book over-time |
| <img src="https://latex.codecogs.com/gif.latex?P(x)"> | Price of the book which person <img src="https://latex.codecogs.com/gif.latex?x"> borrow |
| <img src="https://latex.codecogs.com/gif.latex?D(d_1,&space;d_2)"> | Number of days between two days d<sub>1</sub> and d<sub>2</sub> |

In order to find number of days between two days **d<sub>1</sub> and d<sub>2</sub>**, we need add the following import to support the implementation of computing:

```java
import java.text.SimpleDateFormat;
import java.util.*;
/* Including java.util.Math */
```

3. **Operate checking the input validation**

This is indicated by **checking some ISBN code, personal identification number (ID number), phone, email of the person who register library card**. In order to do it, we need add the following import to support input validation function:

```java
import java.util.regex.*;
/**
 * Including java.util.regex.Matcher
 * Including java.util.regex.Pattern
 */
```

4. **Generates random codes for increased security**

This is indicated by **making random UUID code or making random 12-digit number**. To achieve that purpose, we need add the following import to make the random string:

```java
import java.util.*;
/**
 * Including java.util.UUID.randomUUID()
 * Including java.util.Random.nextInt
 */
```

## Several function used for checking valid input

### 1. Checking validity of ISBN code

In this app, we used the **ISBN-13 code** to check the valid string by user input. Retrieved from [O'Reilly Regular Expressions Cookbook, 2nd edition](https://www.oreilly.com/library/view/regular-expressions-cookbook/9781449327453/ch04s13.html), if omitting the fake / real ISBN code is checked by the [check digit algorithm](https://en.wikipedia.org/wiki/International_Standard_Book_Number), one ISBN-13 digit called **valid code** if the regular expression of code is represented by:

```bash
^(?:ISBN(?:-13)?:?●)?(?=[0-9]{13}$|(?=(?:[0-9]+[-●]){4})[-●0-9]{17}$)97[89][-●]?[0-9]{1,5}[-●]?[0-9]+[-●]?[0-9]+[-●]?[0-9]$
```

**In Java**, above is represented by the equivalent structure and the result of the condition shown in the files above:

```java
if (!(Pattern.matches("^(?:ISBN(?:-13)?:?\\ )?(?=[0-9]{13}$|(?=(?:[0-9]+[-\\ ]){4})[-\\ 0-9]{17}$)97[89][-\\ ]?[0-9]{1,5}[-\\ ]?[0-9]+[-\\ ]?[0-9]+[-\\ ]?[0-9]$", super.getISBN())))
{
    System.out.println("ISBN is not valid! Please check ISBN code again!");
    return false;
}
```

### 2. Checking validity of name person

Retrieved from [Name validation](https://www.regextester.com/93648), one name called **valid name** if the regular expression of name is represented by:

```bash
^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$
```

**In Java**, above is represented by the equivalent structure and the result of the condition shown in the files above:

```java
if (!(Pattern.matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$", name)))
{
    System.out.println("Your name contains the invalid letter. Please check your name again!");
    return false;
}
```

### 3. Checking validity of ID

Retrieved from [Regex to match a custom ID format](https://stackoverflow.com/questions/46077747/regex-to-match-a-custom-id-format/46077883), if no alphabet is allowed, one ID called **valid ID** if the regular expression of ID is represented by:

```bash
^[0-9]\S+?[0-9]{8,20}$
```

**In Java**, above is represented by the equivalent structure and the result of the condition shown in the files above:

```java
if (!(Pattern.matches("^[0-9]\\S+?[0-9]{8,20}$", id)))
{
    System.out.println("Your ID is invalid. Please check your ID again!");
    return false;
}
```

### 4. Checking validity of phone number

According to the convention of the app, one phone number called **valid phone number** if there are **from 8 to 20 1-digit numbers (from 0 to 9)** or the regular expression of phone number is represented by:
```bash
^[0-9]{8,20}$
```

**In Java**, above is represented by the equivalent structure and the result of the condition shown in the files above:

```java
if (!(Pattern.matches("^[0-9]{8,20}$", phone)))
{
    System.out.println("Your phone is invalid. Please check your phone again!");
    return false;
}
```

### 5. Checking validity of email
Retrieved from [Validate email](https://viblo.asia/p/tim-hieu-ve-regular-expression-yMnKMARmK7P), one email called **valid ID** if the regular expression of email is represented by:

```bash
^[a-z][a-z0-9_\.]{5,32}@[a-z0-9]{2,}(\.[a-z0-9]{2,4}){1,2}$
```

**In Java**, above is represented by the equivalent structure and the result of the condition shown in the files above:

```java
if (!(Pattern.matches("^[a-z][a-z0-9_.]{5,32}@[a-z0-9]{2,}(.[a-z0-9]{2,4}){1,2}$", email)))
{
    System.out.println("Your email is not valid. Please check your email again!");
    return false;
}
```

### 6. Checking validity position of book

According to the convention of the app, one position of book called **valid phone number** if it has a form **A?-?** for natural science book and has a form **B?-?** for social science book with **?** is one number, for example **1, 2, 3, ...** or the regular expression of position is represented by:
```bash
^A[0-9]+-[0-9]+$ # For natural science book
^B[0-9]+-[0-9]+$ # For social science book
```

**In Java**, above is represented by the equivalent structure and the result of the condition shown in the files above:

```java
/* For natural science book */
if (!Pattern.matches("^A[0-9]+-[0-9]+$", position))
{
    System.out.println("The position isn't correct syntax! Please check it again");
    return false;
}
/* For social science book */
if (!Pattern.matches("^B[0-9]+-[0-9]+$", position))
{
    System.out.println("The position isn't correct syntax! Please check it again");
    return false;
}
```

### 7. Checking validity of gender

According to the convention of the app, input for gender (sex) called **valid** if it input only **F** (Female) or **M** (Male) or the regular expression of position is represented by:
```bash
^[FM]$
```

**In Java**, above is represented by the equivalent structure and the result of the condition shown in the files above:

```java
if (!(Pattern.matches("^[FM]$", sex)))
{
    System.out.println("Your sex only F or M and don't take the unnecessary letter. Please check your sex again!");
    return false;
}
```

### 8. Checking validity of day borrow/ return

According to the convention of the app, input for day borrow/ return called **valid** if it input in form **dd/mm/yyyy** and retrieved from [The regular expression for Date format dd/mm/yyyy](https://stackoverflow.com/questions/8283405/what-is-the-regular-expression-for-date-format-dd-mm-yyyy/49609587), the regular expression of position is represented by:
```bash
^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$
```

**In Java**, above is represented by the equivalent structure and the result of the condition shown in the files above:

```java
if (!(Pattern.matches("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$", dayReturn)))
{
    System.out.println ("The format of day returned is not correct! Please read carefully instruction and do it again!");
    return false;
}
```
## Several random functions are used to increase security

### 1. Randomize UUID code

**Defination**: Please visit [Universally unique identifier](https://en.wikipedia.org/wiki/Universally_unique_identifier)

**In Java**, to generate a UUID randomly we can use a function:

```java
/* To generate the idCard is a random UUID code */
idCard = UUID.randomUUID().toString();
```

### 2. Randomize 12-digit number

**In Java**, to generate a 12-digit random number we could write the following:

```java
/* To generate the billCode is a 12-digit random number */
Random random = new Random();
billCode = random.ints(leftLimit, rightLimit + 1).filter(i -> (i >= 48 && i <= 57)).limit(targetStringLength).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
```
