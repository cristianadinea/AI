import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;

@SuppressWarnings("serial")
public class Aplicatie extends JApplet implements ActionListener { 
	
	private JButton b;
	private JLabel l1;
	private JLabel l2;
	
	private BazaDeCunostinte bdc;
	
	public void init(){
    
        try {	
        	
        	setLayout(new FlowLayout()); 
        	
        	bdc = new BazaDeCunostinte();
			bdc.initializeaza(getCodeBase());
			
			b  = new JButton("Start");
			l1 = new JLabel("Raspundeti la cateva intrebari pentru a va indica facultatea potrivita.");
			l2 = new JLabel("");
			
			b.addActionListener(this); 
			
			add(l1);
	        add(b);
	        add(l2);
		} 
        catch (AplicatieException e) {
        	
        	l1 = new JLabel(e.getMessage());
        	add(l1);
        }
	}
	
	public void actionPerformed(ActionEvent e) { 
		
		l2.setText("");
		
		bdc.pornesteCautare(this);
	}
	
	public void afisareMesaj(String raspuns) {
		
		l2.setText(raspuns);
	}	
	
	public String intreaba(String intrebare,Object[] raspunsuri) {
	
		return (String)JOptionPane.showInputDialog(null, intrebare, "Intrebare", JOptionPane.QUESTION_MESSAGE, null, raspunsuri, raspunsuri[0]);
	}
	
}
