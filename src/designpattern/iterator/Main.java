package designpattern.iterator;

/**
 * Created by Xiaolong on 12/24/2016.
 */
public class Main {
    public static void test(){
        BookShelf bookshelf1 = new BookShelf();
        bookshelf1.appendBook(new Book("Book 1"));
        bookshelf1.appendBook(new Book("Book 2"));
        bookshelf1.appendBook(new Book("Book 3"));
        bookshelf1.appendBook(new Book("Book 4"));
        Iterator it = bookshelf1.iterator();
        while (it.hasNext()){
            Book book = (Book)it.next();
            System.out.println(book.getName());
        }
    }
}
