import java.util.logging.Level;
import java.util.logging.Logger;

public class Buffer {

    private char[] buffer;
    private int siguiente;
    private boolean estaVacia;
    private boolean estaLlena;
    
    public Buffer(int tamanio){
        this.buffer = new char[tamanio];
        this.siguiente = 0;
        this.estaVacia = true;
        this.estaLlena = false;
    }
     
    public synchronized char consumir(){
        while(this.estaVacia){
            try {
                System.out.println("Un cliente esta esperando");
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        siguiente--;

        System.out.println("Consumo 1 pizza y quedan "+siguiente+" en la estanteria");
        this.estaLlena = false;
        if(siguiente == 0){
            this.estaVacia = true;
        }
        
        notifyAll();
        
        return this.buffer[this.siguiente];
    }
    
    public synchronized void producir(){
        while(this.estaLlena){
            try {
                System.out.println("Estanteria llena, puedes consumir ");
                wait();

            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        siguiente++;
        System.out.println("Paco ingresa a la estenteria una pizza");
        System.out.println("La estantería tiene:" +siguiente);
        
        this.estaVacia = false;

        if(siguiente == this.buffer.length){
            this.estaLlena = true;
        }
        
        notifyAll();
    }
    
}
