package designpattern.iterator;

/**
 * Created by Xiaolong on 12/24/2016.
 */
public class BookShelfIterator implements Iterator {
    private BookShelf bookShelf;
    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return (index<bookShelf.getLength());
    }

    @Override
    public Object next() {
        Book book = bookShelf.getBook(index);
        index++;
        return book;
    }
}
