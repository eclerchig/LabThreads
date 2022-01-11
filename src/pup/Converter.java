package pup;

import java.util.Arrays;
import java.util.Random;

public class Converter implements Runnable{
    private volatile Buffer buffer;

    public Converter(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer){
                StringBuilder builder = new StringBuilder();
                Arrays.stream(buffer.getArray()).forEach(builder::append);
                int outNumber = Integer.valueOf(builder.toString(), 3);
                System.out.println("Поток 2 - " + "Число: " + outNumber);
                buffer.clear();
                buffer.notify();
                try {
                    buffer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
