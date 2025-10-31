package passbyvalueandreference;


class Person{
    String name;

    Person(String name){
        this.name = name;
    }

    void update(Person p){
        p.name = "hi";
    }

    void reassign(Person p){
        p = new Person("hello");
    }
}

class Main{
    static void value(int n){
        System.out.println("inside the first function: "+n);
        n += 1;
        System.out.println("value updated in the function "+n);
    }

    public static void main(String args[]){

        //here the n is same before and after. just the local n inside the value() is updated
        int n = 1;
        System.out.println("before: "+n);
        value(n);
        System.out.println("after: "+n);

        //The parameter p in update() is a local copy of the reference that was passed from the main function.
        // This local copy points to the same original Person object, so when we modify the object’s fields (like name), the change is reflected outside the method.
        // However, if we reassign p to a new object inside the method, the original reference in main remains unchanged.ame
        Person p = new Person("welcome");
        System.out.println(p.name);
        p.update(p);
        System.out.println(p.name);
        p.reassign(p);
        System.out.println(p.name);
    }
}
