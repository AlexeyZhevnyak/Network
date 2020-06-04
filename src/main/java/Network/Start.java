package Network;

import Network.Menu.Menu;
import Network.Model.Weapon;
import Network.NeTwork.ClientContainer;
import Network.Utils.Container;

import java.io.IOException;
import java.lang.reflect.GenericSignatureFormatError;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Start {
    List array = new ArrayList();
    GenericColl genericColl = new GenericColl();
    int select=0;
    int i = 0;


    Menu menu = new Menu();

    public Start() throws IOException {
    }


    public  void dialog() throws IOException {
        do {
            menu.printMenu();
            select = new Scanner(System.in).nextInt();
            switch (select) {
                case 1:
                    genericColl.add();
                    break;
                case 2:
                    genericColl.ud();
                    break;
                case 3:
                    genericColl.delete();
                    break;
                case 4:
                    genericColl.printAll();
                    break;
                case 5:
                    genericColl.save();
                    break;
                case 6:
                    genericColl.load();

                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }while (select!=0);

    }








}
