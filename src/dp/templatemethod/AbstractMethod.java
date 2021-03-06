package dp.templatemethod;

/**
 * Created by Xiaolong on 12/25/2016.
 *
 * Detail method implementation realized by subclasses.
 */
public abstract class AbstractMethod {
    public abstract void open ();
    public abstract void print ();
    public abstract void close ();
    public void display(){
        open ();
        for (int i=0; i<5; i++) print();
        close();
    }

}
