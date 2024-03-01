import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

class VentanaInicio extends JFrame implements ActionListener,KeyListener{
	
	private static final long serialVersionUID = 1L;
	private GridBagConstraints gbc = new GridBagConstraints();
	private GridBagLayout gbl = new GridBagLayout();
	private JComboBox<String> grados,grados2;
	private JTextField txt,caja,transformado;
	private logica log = new logica();
	boolean teclado = false;
	
	public void components(JComponent c, int x, int y, int w, int h) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        gbl.setConstraints(c, gbc);
        add(c);
    }
	
	public VentanaInicio() {
		getContentPane().setLayout(gbl);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 100);
        setLocationRelativeTo(null);
        setTitle("Calculadora");
        setVisible(true);
		
        txt = new JTextField("Convertir");
		components(txt, 0, 0, 1, 1); 
		txt.setEditable(false);
		txt.setBorder(null);
		
		caja = new JTextField(8);
		caja.setText("10");
		caja.addKeyListener(this);//aquí agrego el deste codigo del teclado
		components(caja, 2, 0, 1, 1);
		
		grados = new JComboBox<>();
		grados2 = new JComboBox<>();
		String temps[] = {"ºCentígrados", "ºFahrenheit", "ºKelvin", "ºRankine"};
		
		for(String i:temps) {
			grados.addItem(i);
		}
		grados.addActionListener(this);//=========================================
		components(grados, 4, 0, 1, 1);
		
		txt = new JTextField("A:");
		components(txt, 0, 2, 1, 1); 
		txt.setEditable(false);
		txt.setBorder(null);
		
		for(String j:temps) {
			grados2.addItem(j);
		}
		grados2.addActionListener(this);//=========================================
		components(grados2, 2, 2, 1,1);
		
		transformado = new JTextField(8);
		components(transformado, 4, 2, 1, 1);
		transformado.setEditable(false);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//===========================================Metiendo Logica Convercion====================================
		String option1 = (String) grados.getSelectedItem();
		String option2 = (String) grados2.getSelectedItem();
		double numGrados = Double.parseDouble(caja.getText());
		String Resultados = log.logicaConvertir(option1, option2, numGrados);
		
		transformado.setText(Resultados);
	}

	boolean impedirLetras(KeyEvent e) {
		char a = e.getKeyChar();//La tecla que puché
		return !(Character.isDigit(a) || (a == '.' && !teclado));//Si la tecla precionada no es una letra
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
		for(char l : caja.getText().toCharArray()) {//Iterando Checamos sobre cada letra de la caja
			
			if(l == '.') { teclado = true; break;}//con esto no permitimos masde un punto
			
		}
		
		if(impedirLetras(e)) e.consume();//si o no escribir el "." .
		
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {//Cuando tecleas algo
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {/*Cuando dejas de precionar*/}
	
}

public class InterfaceConvertidorGrados {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VentanaInicio();
			}
		});
	}
}