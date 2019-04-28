package productorconsumidor;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import productorconsumidor.GUI.ProductorConsumidorGUI;

public class Productor extends Thread{
    
    private String id, operands;
    private int min, max;
    private long espera;
    private Buffer buffer;
    private ProductorConsumidorGUI gui;
    
    public Productor(String id, long espera, Buffer buffer, String operands, int min, int max, ProductorConsumidorGUI gui) {
        this.id = id;
        this.espera = espera;
        this.buffer = buffer;
        this.operands = operands;
        this.min = min;
        this.max = max+1;
        this.gui = gui;
    }
    
    @Override
    public void run() {
        System.out.println("Running Producer...");
        
        Random r = new Random(System.currentTimeMillis());
        
        while(true) {
            
            ArrayList product = new ArrayList<>();
            
            product.add(this.operands.charAt(r.nextInt(this.operands.length())));
            
            product.add(this.min + new Random().nextInt(Math.abs(this.min - this.max)));
            product.add(this.min + new Random().nextInt(Math.abs(this.min - this.max)));
            
            this.buffer.produce(product);
            
            String[] rowData = {this.id, product.toString()};
            
            this.gui.prodTable.addRow(rowData);
            
            try {
                Thread.sleep(espera);
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
