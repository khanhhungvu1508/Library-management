# Library management
The code to manage the library with library regulations referenced by VNU center library. The library regulations of the VNU are found in the link below:

[VNU library regulations](http://www.vnulib.edu.vn/index.php/muon-tra-tai-lieu-tvtt)

## Function
The library management program undertake the following functions:
1. The management system is only used by the person who managing the library system. In other cases, it is not allowed to access this system
2. The system can be added new book with 2 types of book: Natural science book and social science book. For more convenient tracking, the system has the ability to list all types of books according to the type of book as well as look up a specific book.
3. The system can be made ID library card with ID card is made by randomize universally unique identifier (UUID) code.
4. The system can be updated the parameters of borrowing book. In order not to have a dispute between borrowing times (Some returns for the same books), each of time one member borrowed one book, the system will provide a random 12-digit number to ensure this.
5. The system can be updated the parameters of returning book. Since the quality of the book returned may be not good as the initial so by rule, all of the factor which adversely affects the quality of the book the borrower must be pay fine money.
6. The system is integrated with the payment system, which is the place to pay compensation when borrowers pay in installments to the library system.
7. The system can be list the history borrowing book of all member who has ID library card.

## Usage

The system need to use some supported package/ import to achieve the following purposes:
1. To operate any problem related to I/O:
```java
import java.util.*;
/* Incluing java.util.scanner */
```

[To be continued]

