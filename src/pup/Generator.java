package pup;

import java.util.Random;

public class Generator implements Runnable{
    private Random r;
    private volatile Buffer buffer;
    private  int MAX_SIZE = 100;
    public Generator(Buffer buffer){
        this.r = new Random();
        this.buffer = buffer;
    }
    @Override
    public void run() {
        for (int i = 0; i < MAX_SIZE; i++) {
            int value = r.nextInt(3);
            synchronized (buffer) {
                buffer.append(value);
                System.out.println("№ числа " + (i+1) + " Поток 1 - " + buffer);
                buffer.notify();
                if (buffer.getIndex() == buffer.MAX_SIZE) {
                    buffer.clearIndex();
                    System.out.print("№ числа " + (i+1) + " ");
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
