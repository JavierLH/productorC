import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Buffer extends JFrame {
    JLabel texto1, pizza,cocinero;
    private char[] buffer;
    public int siguiente;
    private boolean estaVacia;
    private boolean estaLlena;
    
    public Buffer(int tamanio){
        this.setTitle("Pizzería");
        this.setSize(600,500);
	    this.setLayout(null);
	    this.setLocationRelativeTo(null);
        this.setResizable(false);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        componentes();
        this.buffer = new char[tamanio];
        this.siguiente = 0;
        this.estaVacia = true;
        this.estaLlena = false;
    }
    
    public void componentes(){

        texto1 = new JLabel("Bienvenido a la pizzería.");
        texto1.setBounds(50,50,150,25);
    
        pizza = new JLabel ();
        ImageIcon ip = new ImageIcon("/home/denilson/Escritorio/codigos/productorC/Productor-Consumidor1/img/pizza.png");
        pizza.setIcon(ip); 
        pizza.setBounds(50,40,250,250);
    
    
        cocinero = new JLabel();
        ImageIcon ic = new ImageIcon("/home/denilson/Escritorio/codigos/productorC/Productor-Consumidor1/img/cocinero.png");
        cocinero.setIcon(ic);
        cocinero.setBounds(460,60,250,250);
            this.add(texto1);
            this.add(pizza);
            this.add(cocinero);
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
