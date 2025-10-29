package abs;

//abstract classes

//here computer class is just a concept so we can make it an abstract class
abstract class Computer{
    //here we have made the method declared.
    //class containing abstract method should be an abstract class
    public abstract void compiler();

    //abstract class can also have normal methods as well i.e. it is ok if there are no abstract methods
    public void show(){}

    //can't make object of abstract class
}

//the abstract methods should be implemented in the child classes. no compulsion for normal methods
class Laptop extends Computer{
    public void compiler(){
        System.out.println("compiling");
    }
}

class Desktop extends Computer{
    public void compiler(){
        System.out.println("compiling from desktop");
    }
}

class Dev{
    public void code(Computer lap){
        System.out.println("coding...");
        lap.compiler();
    }
}

class first {

    public static void main(String args[]){
        Laptop lap = new Laptop();
        Computer d = new Desktop();

        Dev dev1 = new Dev();
        dev1.code(lap);
    }
    
}
