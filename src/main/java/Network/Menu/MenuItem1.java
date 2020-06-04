package Network.Menu;

import java.util.Scanner;

public class MenuItem1 {
    public int print(){
        System.out.println("input (1) to choose Rifle");
        System.out.println("input (2) to choose Steel");
        Scanner sc1 = new Scanner(System.in);
        return  sc1.nextInt();
    }
    public int printChoose(){
        System.out.println("Choose element");
        return  new Scanner(System.in).nextInt();
    }

}
