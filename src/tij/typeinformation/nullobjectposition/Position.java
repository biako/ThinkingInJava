package tij.typeinformation.nullobjectposition;

/**
 * Created by Xiaolong on 12/27/2016.
 */
class Position {
    private String title;
    private Person person;

    // If no person is set, make it null.
    public Position(String jobTitle, Person employee) {
        title = jobTitle;
        person = employee;
        if (person == null)
            person = Person.NULL;
    }

    // If no person is set, make it null.
    public Position(String jobTitle) {
        title = jobTitle;
        person = Person.NULL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        title = newTitle;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person newPerson) {
        person = newPerson;
        if (person == null)
            person = Person.NULL;
    }

    public String toString() {
        return "Position: " + title + "; " + person;
    }
}
