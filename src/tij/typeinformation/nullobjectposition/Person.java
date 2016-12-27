package tij.typeinformation.nullobjectposition;

/**
 * Created by Xiaolong on 12/27/2016.
 */


class Person {
    // Set all the fields as final.
    public final String first;
    public final String last;
    public final String address;


    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }

    public String toString() {
        return "Person: " + first + " " + last + " " + address;
    }


    // Use a Null interface. Set the default constructor to initialize all fields with "none."
    public static class NullPerson
            extends Person implements Null {
        private NullPerson() {
            super("None", "None", "None");
        }

        public String toString() {
            return "NullPerson";
        }
    }

    //Set it as a public static final.
    public static final Person NULL = new NullPerson();
}

