

import javax.swing.JFrame;
import javax.swing.JTextField;
//import javax.swing.JTexField;
/**
 *
 * @author denilson
 */
public class Ventana extends JFrame {
    JTextField texto1;  
    public Ventana(){
        this.setTitle("Pizzería");
        this.setSize(600,500);
	this.setLayout(null);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        componentes();
    }
    public void componentes(){
        texto1 = new JTextField("Bienvenido a la pizzería.");
	texto1.setBounds(50,50,150,25);
        
        this.add(texto1);
    }
}
