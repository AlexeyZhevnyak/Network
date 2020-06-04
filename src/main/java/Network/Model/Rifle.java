package Network.Model;



import java.util.Objects;
import java.util.Scanner;

public class Rifle extends Weapon<Rifle> {
    private String color;
    private int sNumber;
    public Rifle(int sNumber, String color, String Nation){
        this.setNation(Nation);
        this.sNumber = sNumber;
        this.color = color;
    }

    public Rifle() {
    }



    @Override
    public String toString () {
        return "R"+"\n"+ color + "\n" +
                sNumber + "\n"+
                 getNation()+"\n";
    }

    public String getColor () {
        return color;
    }

    public void setColor (String color){
        this.color = color;
    }

    public int getsNumber () {
        return sNumber;
    }

    public void setsNumber ( int sNumber){
        this.sNumber = sNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rifle rifle = (Rifle) o;
        return sNumber == rifle.sNumber &&
                Objects.equals(color, rifle.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, sNumber);
    }

    public Rifle createRifle() {
        System.out.println("Choose number");
        Scanner sc2 = new Scanner(System.in);
        int p1 = sc2.nextInt();
        System.out.println("Choose color");
        Scanner sc3 = new Scanner(System.in);
        String p2 = sc3.nextLine();
        System.out.println("Choose Nation");
        Scanner sc4 = new Scanner(System.in);
        String p3 = sc4.nextLine();
        return new Rifle(p1, p2, p3);
    }
    public Rifle updRifle(int a){
        System.out.println("Choose number");
        Scanner sc2 = new Scanner(System.in);
        int p1 = sc2.nextInt();
        System.out.println("Choose color");
        Scanner sc3 = new Scanner(System.in);
        String p2 = sc3.nextLine();
        System.out.println("Choose Nation");
        Scanner sc4 = new Scanner(System.in);
        String p3 = sc4.nextLine();
        return new Rifle(p1, p2, p3);

    }

}