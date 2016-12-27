package dp.iterator;


import java.util.ArrayList;

/**
 * Created by Xiaolong on 12/24/2016.
 */
public class Main {
    public static void test() {
        //Use BookshelfIterator
        BookShelf bookshelf = new BookShelf();
        bookshelf.appendBook(new Book("Book 1"));
        bookshelf.appendBook(new Book("Book 2"));
        bookshelf.appendBook(new Book("Book 3"));
        bookshelf.appendBook(new Book("Book 4"));
        Iterator it = bookshelf.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            System.out.println(book.getName());
        }

        //Use ArrayList directly:
        ArrayList<Book> bookarraylist = new ArrayList<>();
        bookarraylist.add(new Book("Book 1"));
        bookarraylist.add(new Book("Book 2"));
        bookarraylist.add(new Book("Book 3"));
        bookarraylist.add(new Book("Book 4"));
        //Use foreach directly:
        for (Book bk : bookarraylist) System.out.println(bk.getName());
        //Get ArrayList's iterator and use hasNext() in loop:
        java.util.Iterator it2 = bookarraylist.iterator();
        while (it2.hasNext()) {
            Book book = (Book) it2.next();
            System.out.println(book.getName());
        }
    }
}
