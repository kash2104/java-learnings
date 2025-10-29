package exception_handling;


public class first {
    
    public static void main(String args[]){

        int i = 4;
        int j = 0;
        int result = 0;
        
        //we can make different catch blocks for different types of exception
        try {
            result = i/j;

            if(result == 0){
                //can throw our own exception as well
                throw new Exception();
            }
        } catch (Exception e) {
            //here the e is an object
            System.out.println("something went wrong");
        }
        finally{

            //executed if no exception or exception
            System.out.println("finally");
        }

        //without the try-catch block the program will exit and not print the below 2 lines.
        //with try-catch, program won't stop and will print 0,bye
        System.out.println(result);
        System.out.println("bye");


        //2 types of exception: checked and unchecked
        //unchecked: the compiler doesn't care what we have written like i/j;
        //checked: the compiler forces you to put a piece of code in try-catch block


        /*
         * a(){
         *  b();
         * }
         * b(){
         *  c();
         * }
         * c(){
         *  has some exception: 1. try-catch 2. throws exception
         *  if throws, then it is responsiblity of b to handle it either via try-catch or throws it to a()
         * }
         */
    }
}
