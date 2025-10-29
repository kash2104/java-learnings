package basics;

import java.util.List;

class Demo{
    public static void main(String[] args){
        System.out.println("hello from java");

        //loops
        int i = 0; //this is local variable and they are stored with the methods(oop)
        while(i < 5){
            System.out.println(i);
            i++;
        }
        System.out.println();
        i = 0;
        do{
            System.out.println(i);
            i++;
        }while(i < 5);
        System.out.println();

        for(int j=  0; j < 5; j++){
            System.out.println(j);
        }
        System.out.println();

        int nums[] = {1,2,3};
        for(int k : nums){
            System.out.println(k);
        }
        System.out.println();
        List<Integer>arr = List.of(1,2,3,4,5);
        arr.forEach(ch -> System.out.println(ch));

        //to perform some filter and sorting operations, it can't be performed using .forEach loop
        arr.stream().filter(num -> num %2==0).forEach(x -> System.out.println(x));

    }
}