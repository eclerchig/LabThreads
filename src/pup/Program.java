package pup;

import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Generator generator = new Generator(buffer);
        Thread thread = new Thread(generator);
        Converter converter = new Converter(buffer);
        Thread thread2 = new Thread(converter);
        //thread2.setDaemon(true);
        thread.start();
        thread2.start();
    }
}
