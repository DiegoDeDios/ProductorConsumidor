package productorconsumidor;

import productorconsumidor.GUI.ProductorConsumidorGUI;

public class ProductorConsumidor {

    public static void main(String[] args) {
        
<<<<<<< HEAD
        //java.awt.EventQueue.invokeLater(() -> {
          //  new ProductorConsumidorGUI().setVisible(true);
        //});
        
        Buffer buffer = new Buffer();
        
        Productor producer = new Productor(1000, buffer);
        producer.start();
        
        Consumidor consumer = new Consumidor(1000, buffer);
        consumer.start();
=======
        java.awt.EventQueue.invokeLater(() -> {
            new ProductorConsumidorGUI().setVisible(true);
        });
>>>>>>> 919e0926a2923af8414a6ead0c0b19f5663d9652
        
    }
    
}
