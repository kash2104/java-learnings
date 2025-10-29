package abs;

import javax.sound.sampled.Port;

//interfaces

//abstract class which only contains the abstract methods, we can make them an interface
interface Computer{
    //by default all the methods declared here are public and abstract
    void compiler(); //same as public abstract void compiler()

    //cannot create objects of interfaces as well
}
interface Portable{
    void move();

    //the variables declared in interface are final and static so need to be initialised and are accessed directly by the interface_name
    boolean flag = false;
}

//with interface we can do multiple inheritance which is not possible with classes

class Laptop implements Computer,Portable{
    public void compiler(){
        System.out.println("compiling");
    }

    public void move(){
        System.out.println("laptops are portable");
    }
}

class Desktop implements Computer{
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


class second{
    public static void main(String args[]){
        Laptop lap = new Laptop();
        Computer d = new Desktop();

        Dev dev1 = new Dev();
        dev1.code(lap);

        System.out.println(Portable.flag);
    }
}