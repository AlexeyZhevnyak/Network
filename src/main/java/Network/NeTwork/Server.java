package Network.NeTwork;

import Network.Model.Rifle;
import Network.Model.SteelArm;
import Network.Model.Weapon;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static ExecutorService executorService;
    private static CopyOnWriteArrayList<Weapon<?>> list = new CopyOnWriteArrayList<>();


    public static void main(String[] args) throws IOException {

        executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("server started");
        while (true){
            Socket socket = serverSocket.accept();
            System.out.println("new connection opened");
            process(socket);
        }

    }
    private static void process(Socket socket){
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    ObjectInputStream ois  = new ObjectInputStream(socket.getInputStream());
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

                    System.out.println("ready to communicate");
                    while (true){
                        communicate(ois,oos);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
    private static void communicate(ObjectInputStream ois,ObjectOutputStream oos) throws Exception{
        Request request = (Request) ois.readObject();
        String pr;
        System.out.println(request);

        switch (request.getType()) {
            case Add:{
                Weapon<?> element = (Weapon<?>) request.getPayload();
                list.add(element);
                Response response = new Response("it's ok");
                oos.writeObject(response);
                oos.flush();
                break;
            }
            case printAll:{
                Response response = new Response(new ArrayList<>(list));
                oos.writeObject(response);
                oos.flush();
                break;
            }
            case delete:{
                int a = (int) request.getPayload();
                list.remove(a);
                break;
            }
            case ud:{
                Comp comp = (Comp) request.getPayload();
                list.set(comp.i, (Weapon<?>) comp.element);
                oos.flush();
                break;
            }
            case save:{
                    try(FileOutputStream o1 = new FileOutputStream("C:\\Users\\Alex\\IdeaProjects\\Network\\src\\main\\java\\Network\\input.txt"))
                    {
                        for (int i = 0; i <list.size() ; i++) {
                            byte[] buffer = list.get(i).toString().getBytes();
                            o1.write(buffer,0,buffer.length);
                        }
                        o1.write("endF".getBytes(),0,4);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                break;
                }

            case load:{
                File file = new File("C:\\Users\\Alex\\IdeaProjects\\Network\\src\\main\\java\\Network\\input.txt");
                FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader);
                do {
                    pr = reader.readLine();
                    if (pr.equals("R")){
                        Rifle r1 = new Rifle();
                        r1.setColor(reader.readLine());
                        r1.setsNumber(Integer.parseInt(reader.readLine()));
                        r1.setNation(reader.readLine());
                        list.add(r1);
                    }else if (pr.equals("S")){
                        SteelArm s1 = new SteelArm();
                        s1.setPocket(Boolean.parseBoolean(reader.readLine()));
                        s1.setDlina(Integer.parseInt(reader.readLine()));
                        s1.setNation(reader.readLine());
                        list.add(s1);
                    }
                }while (!pr.equals("endF"));
                break;
            }
        }

    }
}
