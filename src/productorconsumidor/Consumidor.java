package productorconsumidor;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import productorconsumidor.GUI.ProductorConsumidorGUI;


public class Consumidor extends Thread {
    
    private String id;
    private long espera;
    private Buffer buffer;
    private ProductorConsumidorGUI gui;
    
    public Consumidor(String id, long espera, Buffer buffer, ProductorConsumidorGUI gui) {
        this.id = id;
        this.espera = espera;
        this.buffer = buffer;
        this.gui = gui;
    }
    
    @Override
    public void run() {
        
        while(true) {
            
            ArrayList product;
            
            product = this.buffer.consume();
            
            if(product.size() != 0) {
                int result;
                String[] rowData = new String[3];
                boolean updated = false;
                
                switch((char)product.get(0)) {
                    case '+':
                        result = (int)product.get(1) + (int)product.get(2);
                        rowData[0] = this.id; 
                        rowData[1] = product.toString(); 
                        rowData[2] = Integer.toString(result);
                        while(!updated) {
                            updated = this.gui.addConsRow(rowData);
                        }
                        this.gui.llenarBarrita();
                        break;
                    case '-':
                        result = (int)product.get(1) - (int)product.get(2);
                        rowData[0] = this.id; 
                        rowData[1] = product.toString(); 
                        rowData[2] = Integer.toString(result);
                        while(!updated) {
                            updated = this.gui.addConsRow(rowData);
                        }
                        this.gui.llenarBarrita();
                        break;
                    case '*':
                        result = (int)product.get(1) * (int)product.get(2);
                        rowData[0] = this.id; 
                        rowData[1] = product.toString(); 
                        rowData[2] = Integer.toString(result);
                        while(!updated) {
                            updated = this.gui.addConsRow(rowData);
                        }
                        this.gui.llenarBarrita();
                        break;
                    case '/':
                        rowData[0] = this.id; 
                        rowData[1] = product.toString();
                        if((int)product.get(2) != 0)
                            rowData[2] = Double.toString( new Double((int)product.get(1)) / new Double((int)product.get(2)) );
                        else
                            rowData[2] = "Div. by 0";
                        while(!updated) {
                            updated = this.gui.addConsRow(rowData);
                        }
                        this.gui.llenarBarrita();
                        break;
                    default:
                        break;
                }
            }
            
            try {
                Thread.sleep(espera);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
