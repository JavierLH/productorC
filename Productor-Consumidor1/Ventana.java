import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *
 * @author denilson
 */
public class Ventana extends JFrame {
    JLabel texto1, pizza,cocinero;
    Buffer miBuffer = new Buffer(10);     
    public Ventana(){
        this.setTitle("Pizzería");
        this.setSize(600,500);
	    this.setLayout(null);
	    this.setLocationRelativeTo(null);
        this.setResizable(false);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        componentes();
        
    }
    public void componentes(){

    texto1 = new JLabel("Bienvenido a la pizzería.");
	texto1.setBounds(50,50,150,25);

    pizza = new JLabel ();
    ImageIcon ip = new ImageIcon("/home/denilson/Escritorio/productorC/Productor-Consumidor1/img/pizza.png");
    pizza.setIcon(ip); 
    pizza.setBounds(50,40,250,250);

    cocinero = new JLabel();
    ImageIcon ic = new ImageIcon("/home/denilson/Escritorio/productorC/Productor-Consumidor1/img/cocinero.png");
    cocinero.setIcon(ic);
    cocinero.setBounds(460,60,250,250);
        this.add(texto1);
        this.add(pizza);
        this.add(cocinero);
    }
}
