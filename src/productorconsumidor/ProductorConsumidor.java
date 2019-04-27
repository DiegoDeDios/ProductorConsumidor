package productorconsumidor;

import productorconsumidor.GUI.ProductorConsumidorGUI;

public class ProductorConsumidor {

    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(() -> {
            new ProductorConsumidorGUI().setVisible(true);
        });
        
    }
    
}
