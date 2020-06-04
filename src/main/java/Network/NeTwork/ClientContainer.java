package Network.NeTwork;

import Network.Model.Weapon;
import Network.Utils.Container;

import java.io.*;
import java.net.Socket;
import java.util.Collection;
import java.util.Scanner;

public class ClientContainer<T extends Serializable> implements Container<T> {

    Scanner in;
    private final ObjectOutputStream oos;
    private final ObjectInputStream ois;

    public ClientContainer(String host,int port) throws IOException {
        Socket socket = new Socket(host, port);
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());
    }



    @Override
    public String add(T element) {
        Request request = new Request(Type.Add, element);
        try {
            oos.writeObject(request);
            oos.flush();
            Response response = (Response) ois.readObject();
            System.out.println(response.getPayload());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void ud(int i, T element) {

        Request request = new Request(Type.ud,new Comp(i, element));
        try {
            oos.writeObject(request);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void delete(int i) throws IOException {
        Request request = new Request(Type.delete, i);
        oos.writeObject(request);
        oos.flush();

    }

    @Override
    @SuppressWarnings("un")
    public void printAll() {
    Request request = new Request(Type.printAll,null);
        try {
            oos.writeObject(request);
            oos.flush();
            Response response = (Response) ois.readObject();
            System.out.println(response.getPayload());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void save()
    {
        Request request = new Request(Type.save,null);
        try {
            oos.writeObject(request);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void load() {
        Request request = new Request(Type.load,null);
        try {
            oos.writeObject(request);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
