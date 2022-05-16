

public class EjemploProductorConsumidor {

    public static void main(String[] args) {
        
        Ventana miVentana = new Ventana();
	    miVentana.setVisible(true);
        
        Buffer b = new Buffer(10);
        Productor p = new Productor(b);
        Consumidor c = new Consumidor(b);
        
        p.start();
        c.start();
    }
}