public class Person {
    String FirstName;
    String LastName;

    public Person(String fn, String ln){
        this.FirstName = fn;
        this.LastName = ln;
    }

    public String getFirstName(){
        return FirstName;
    }

    public String getLastName(){
        return LastName;
    }

    public String toString(){
        return FirstName + "_" + LastName;
    }

}
