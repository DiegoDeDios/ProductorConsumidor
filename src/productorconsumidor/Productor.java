package productorconsumidor;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Productor extends Thread{
    
    private String id;
    private long espera;
    private Buffer buffer;
    
    public Productor(String id, long espera, Buffer buffer) {
        this.id = id;
        this.espera = espera;
        this.buffer = buffer;
    }
    
    @Override
    public void run() {
        System.out.println("Running Producer...");
        
        String operands = "+-*/";
        
        Random r = new Random(System.currentTimeMillis());
        
        while(true) {
            
            ArrayList product = new ArrayList<>();
            
            product.add(operands.charAt(r.nextInt(4)));
            product.add(r.nextInt(10));
            product.add(r.nextInt(10));
            
            this.buffer.produce(product);
            
            System.out.println("Producer produced: " + product.toString());
            
            try {
                Thread.sleep(espera);
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
