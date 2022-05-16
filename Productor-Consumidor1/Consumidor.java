

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumidor extends Thread {

    private Buffer buffer;
    private Ventana CV; 

    public Consumidor(Buffer b) {
        this.buffer = b;
    }
    


    public void run() {
        while (true) {
            try {
                buffer.consumir();

                sleep((int) (Math.random() * 6000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
