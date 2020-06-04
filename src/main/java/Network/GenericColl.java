package Network;

import Network.Menu.MenuItem1;
import Network.Model.Rifle;
import Network.Model.SteelArm;
import Network.Model.Weapon;
import Network.NeTwork.ClientContainer;
import Network.Utils.Container;


import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericColl<T> {
    List array = new ArrayList();
    Container<Weapon<?>> arr = new ClientContainer<Weapon<?>>("localhost",8080);
private Container<T> container;
    String pr = "";
    MenuItem1 menuItem1 = new MenuItem1();
    Rifle rifle =new Rifle();
    SteelArm steelArm =new SteelArm();
    int select;
    int count = 0;

    public GenericColl() throws IOException {
    }

    public void add(){
        int select1 = menuItem1.print();
        if (select1 == 1) {
            arr.add(rifle.createRifle());

        }
        if (select1==2){
            arr.add(steelArm.createSteelArm());
        }
    }
    public void ud(){
        select = menuItem1.printChoose();
        int select1 = menuItem1.print();
        if (select1 == 1) {
            arr.ud(select,rifle.createRifle());
        }
        if (select1==2){
            arr.ud(select,steelArm.createSteelArm());
        }

    }
    public void delete() throws IOException {
        arr.delete(menuItem1.printChoose());
        System.out.println("Successful");
    }

    public void printAll(){
        arr.printAll();
    }
    public void save(){
        arr.save();
    }
    public  void load() {
        arr.load();

    }






}
