package oop;

class Keyboard {
    //{keys, color} are instance variables which are stored with object itself
    private int keys;
    private String color;

    //{final} is used for const. In java there is no const
    final String type = "mechanical";

    //constructor
    public Keyboard(){
        keys = 100;
        color = "purple";
    }

    //-> using of getters and setters so that the variables aren't directly accessible outside the class is encapsulation
    //setters
    public void setKey(int keys){
        //{this} refers to the current object that we have created
        //{lhs} refers to instance variable and rhs refers to the local variable
        this.keys = keys;
    }
    public void setColor(String s){
        color = s;
    }
    
    //getters
    public int getKeys() {
        return keys;
    }

    public String getColor() {
        return color;
    }

    public void pressed(){
        System.out.println("key pressed" + " " + keys + " " + color);
    }

    public void hit(){
        System.out.println("hit from keyboard");
    }

    //{method overloading}: compile time polymorphism
    public void hit(String s){
        System.out.println("got hit with " + s);
    }
}

//Inheritance
class AdvanceKeyboard extends Keyboard {
    public void hitNum(int n){
        System.out.println("number pressed: "+ n);
    }

    //{method overriding: runtime polymorphism} it depends on which object you create
    public void hit(){
        System.out.println("hit from keyboard advanced");
    }

    public void show(){
        super.hit();
    }
}

class Main{
    public static void main(String[] args){
        Keyboard obj = new Keyboard();
        // obj.keys = 8;
        // obj.color = "white";
        obj.pressed();

        AdvanceKeyboard kb = new AdvanceKeyboard();
        kb.hitNum(20);
        // kb.keys = 20;
        // kb.color = "black";
        kb.setKey(80);
        kb.setColor("black");
        kb.pressed();

        //polymorphism: here created object created is of adv. so advkeyboard func called
        Keyboard gh = new AdvanceKeyboard();
        gh.hit();
        // gh.show(); //shows error since gh is reference to Keyboard class object and Keyboard class doesn't have show() method
        
        //using super method to access the parent's class method
        AdvanceKeyboard ak = new AdvanceKeyboard();
        ak.show();
    }
}