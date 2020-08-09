package scopes;

public class Driver {
    static int myInt=5;
    public static void main(String[] args) {
        Human h1 =new Human();//instance of human
        h1.setName("Bill");
        System.out.println(h1);

        Human h2 = new Human("Matt", 34,555555);
        System.out.println(h2);

        Human h3= new Human("Sean", 20, 300);
        h3.setHomePlanet("Mars");
        System.out.println(h3);
        System.out.println(h1);
        System.out.println(h2);

        myMethod(myInt+6);
        showBlockScope();
    }
     public static void myMethod(int i){
         System.out.println(myInt);
        System.out.println(i);
    }
    public static void showBlockScope(){
        int j=0;//method scope
        for(int i=0; i<10;i++){//i is block scope
            i=i+j;
            j++;
            System.out.println(i);
        }
        //j=j+i; i no longer exists
        System.out.println("Outside for loop: " +j);
    }
}
