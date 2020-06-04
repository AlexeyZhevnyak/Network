package Network.Model;

import java.io.Serializable;

public abstract class Weapon<T extends Weapon<T>> implements Serializable, Comparable<Weapon<?>> {
   private String Nation;
        public Weapon(String Nation){
            this.Nation=Nation;
        }

    @Override
    public String toString() {
        return "Weapon{" +
                "Nation='" + Nation + '\'' +
                '}';
    }

    public String getNation() {
        return Nation;
    }

    public void setNation(String nation) {
        Nation = nation;
    }

    public Weapon() {

    }

    @Override
    public int compareTo(Weapon<?> o) {
        return 0;
    }
}
