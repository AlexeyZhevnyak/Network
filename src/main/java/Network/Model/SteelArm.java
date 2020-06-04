package Network.Model;



import java.util.Objects;
import java.util.Scanner;

public class SteelArm extends Weapon<SteelArm> {
   private Boolean pocket;
   private int dlina;

    public Boolean getPocket() {
        return pocket;
    }

    public void setPocket(Boolean pocket) {
        this.pocket = pocket;
    }

    public int getDlina() {
        return dlina;
    }

    public void setDlina(int dlina) {
        this.dlina = dlina;
    }

    public SteelArm(int dlina, boolean pocket, String Nation){
        this.setNation(Nation);
        this.dlina=dlina;
        this.pocket=pocket;
    }

    public SteelArm() {

    }


    @Override
    public String toString() {
        return
                "S"+"\n"+pocket +"\n"+
                dlina +"\n"+
                 getNation()+"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SteelArm steelArm = (SteelArm) o;
        return dlina == steelArm.dlina &&
                Objects.equals(pocket, steelArm.pocket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pocket, dlina);
    }

    public SteelArm createSteelArm(){
        System.out.println("Choose lenght");
        Scanner sc2 = new Scanner(System.in);
        int p1 = sc2.nextInt();
        System.out.println("Choose pocket or false");
        Scanner sc3 = new Scanner(System.in);
        boolean p2 = sc3.nextBoolean();
        System.out.println("Choose Nation");
        Scanner sc4 = new Scanner(System.in);
        String p3 = sc4.nextLine();
        return new SteelArm(p1,p2,p3);

    }
    public  void updSteelArm(int a){
        System.out.println("Choose lenght");
        Scanner sc2 = new Scanner(System.in);
        int p1 = sc2.nextInt();
        System.out.println("Choose pocket or false");
        Scanner sc3 = new Scanner(System.in);
        boolean p2 = sc3.nextBoolean();
        System.out.println("Choose Nation");
        Scanner sc4 = new Scanner(System.in);
        String p3 = sc4.nextLine();
        SteelArm s1 = new SteelArm(p1,p2,p3);

    }
}
