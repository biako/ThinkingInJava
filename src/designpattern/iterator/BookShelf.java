package designpattern.iterator;

import java.util.ArrayList;

/**
 * Created by Xiaolong on 12/24/2016.
 */
public class BookShelf implements Aggregate {
    private ArrayList<Book> booklist;

    public BookShelf() {
        booklist = new ArrayList<>();
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }

    public Book getBook(int index) {
        return booklist.get(index);
    }

    public void appendBook(Book book) {
        this.booklist.add(book);
    }

    public int getLength() {
        return booklist.size();
    }


}
