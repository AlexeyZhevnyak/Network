package Network;

import Network.Menu.Menu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new Menu().printMenu();
        new Start().dialog();
    }
}
