package productorconsumidor;

import productorconsumidor.GUI.ProductorConsumidorGUI;

public class ProductorConsumidor {

    public static void main(String[] args) {
        
        //java.awt.EventQueue.invokeLater(() -> {
          //  new ProductorConsumidorGUI().setVisible(true);
        //});
        
        Buffer buffer = new Buffer(100);
        
        Productor producer = new Productor(1000, buffer);
        producer.start();
        
        Consumidor consumer = new Consumidor(1000, buffer);
        consumer.start();
        
    }
    
}
