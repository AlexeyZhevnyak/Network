package Network.NeTwork;


import java.io.Serializable;

public class Comp implements Serializable{
    int i;
    Serializable element;
    public Comp(){

    }

    public  Comp(int i, Serializable element) {
        this.i = i;
        this.element = element;
    }
}
