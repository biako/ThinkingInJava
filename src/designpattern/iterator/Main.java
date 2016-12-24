package designpattern.iterator;


import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Xiaolong on 12/24/2016.
 */
public class Main {
    public static void test(){
        BookShelf bookshelf = new BookShelf();
        bookshelf.appendBook(new Book("Book 1"));
        bookshelf.appendBook(new Book("Book 2"));
        bookshelf.appendBook(new Book("Book 3"));
        bookshelf.appendBook(new Book("Book 4"));
        Iterator it = bookshelf.iterator();
        while (it.hasNext()){
            Book book = (Book)it.next();
            System.out.println(book.getName());
        }

        ArrayList<Book> bookarraylist = new ArrayList<>();
        bookarraylist.add(new Book("Book 1"));
        bookarraylist.add(new Book("Book 2"));
        bookarraylist.add(new Book("Book 3"));
        bookarraylist.add(new Book("Book 4"));
        for (Book bk : bookarraylist) System.out.println(bk.getName());
        java.util.Iterator it2 = bookarraylist.iterator();
        while (it2.hasNext()) {
            Book book = (Book)it2.next();
            System.out.println(book.getName());
        }


    }
}
