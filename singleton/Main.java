

class Singleton{
  private static Singleton instance = null;
  private Singleton(){
    System.out.println("constructor called!! Object created");
  }
  public static Singleton getInstance(){
    if(instance == null){
      instance = new Singleton();
    }
    return instance;
  }
}


public class Main{
  public static void main(String[] args){
    Singleton s1 = Singleton.getInstance();
    Singleton s2 = Singleton.getInstance();

    System.out.println(s1 == s2);

  }
}
