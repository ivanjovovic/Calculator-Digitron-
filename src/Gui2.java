import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Gui2 extends JFrame {

	private JPanel contentPane;
	private JTextField brojilac1;
	private JTextField imenilac1;
	private JTextField brojilac2;
	private JTextField imenilac2;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui2 frame = new Gui2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gui2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 389, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton sabiranje = new JRadioButton("Sabiranje");
		
		sabiranje.setBounds(8, 136, 127, 25);
		contentPane.add(sabiranje);
		
		brojilac1 = new JTextField();
		brojilac1.setBounds(8, 72, 46, 22);
		contentPane.add(brojilac1);
		brojilac1.setColumns(10);
		
		imenilac1 = new JTextField();
		imenilac1.setBounds(89, 72, 46, 22);
		contentPane.add(imenilac1);
		imenilac1.setColumns(10);
		
		JLabel znak = new JLabel("");
		znak.setBounds(149, 78, 27, 16);
		contentPane.add(znak);
		
		JLabel label = new JLabel("/");
		label.setBounds(66, 75, 40, 16);
		contentPane.add(label);
		
		brojilac2 = new JTextField();
		brojilac2.setBounds(188, 72, 46, 22);
		contentPane.add(brojilac2);
		brojilac2.setColumns(10);
		
		imenilac2 = new JTextField();
		imenilac2.setColumns(10);
		imenilac2.setBounds(273, 72, 46, 22);
		contentPane.add(imenilac2);
		
		JLabel label_1 = new JLabel("/");
		label_1.setBounds(246, 75, 40, 16);
		contentPane.add(label_1);
		
		JLabel Rezultat = new JLabel(" ");
		Rezultat.setBounds(23, 13, 315, 16);
		contentPane.add(Rezultat);
		
		JRadioButton oduzimanje = new JRadioButton("Oduzimanje");
		
		oduzimanje.setBounds(8, 176, 127, 25);
		contentPane.add(oduzimanje);
		
		JRadioButton mnozenje = new JRadioButton("Mnozenje");
		
		mnozenje.setBounds(8, 220, 127, 25);
		contentPane.add(mnozenje);
		
		JRadioButton dijeljenje = new JRadioButton("Dijeljenje");
		
		dijeljenje.setBounds(8, 266, 127, 25);
		contentPane.add(dijeljenje);
		
		JButton btnIzracunaj = new JButton("Izracunaj");
		btnIzracunaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Razlomak r1,r2,rez = new Razlomak();
				r1 = new
				Razlomak(Integer.parseInt(brojilac1.getText()),Integer.parseInt(imenilac1.getText()));
				r2 = new
				Razlomak(Integer.parseInt(brojilac2.getText()),Integer.parseInt(imenilac2.getText()));
				if (znak.getText().equals("+"))
				rez = Razlomak.saberi(r1, r2);
				if (znak.getText().equals("-"))
				rez = Razlomak.oduzmi(r1, r2);
				if (znak.getText().equals("*"))
				rez = Razlomak.pomnozi(r1, r2);
				if (znak.getText().equals("/"))
				rez = Razlomak.podijeli(r1, r2);
				rez.skrati();
				Rezultat.setText("Rezultat je:" + rez.toString());
				
			}
		});
		btnIzracunaj.setBounds(188, 124, 97, 25);
		contentPane.add(btnIzracunaj);
		
		JButton btnObrisi = new JButton("Obrisi");
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				oduzimanje.setSelected(false);
				mnozenje.setSelected(false);
				dijeljenje.setSelected(false);
				sabiranje.setSelected(false);
				Rezultat.setText("");
				imenilac1.setText("");
				brojilac1.setText("");
				imenilac2.setText("");
				brojilac2.setText("");
				znak.setText("");
			}
		});
		btnObrisi.setBounds(189, 162, 97, 25);
		contentPane.add(btnObrisi);
		
		JButton btnIzadji = new JButton("Izadji");
		btnIzadji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		btnIzadji.setBounds(189, 200, 97, 25);
		contentPane.add(btnIzadji);
		
		JButton btnSacuvaj = new JButton("Sacuvaj");
		btnSacuvaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jedan =Rezultat.getText().toString();
				
				
				try {
					FileWriter pisanje=new FileWriter("rezultati.txt",true);
					pisanje.write(jedan);
					pisanje.write(System.getProperty("line.separator"));
					

					pisanje.close();

					JOptionPane.showMessageDialog(rootPane,"SACUVANO");
					
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(rootPane,"Greska");	
					
				}
			}
		});
		btnSacuvaj.setBounds(189, 238, 97, 25);
		contentPane.add(btnSacuvaj);
		
		JButton btnVidi = new JButton("Vidi");
		btnVidi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileReader fr= new FileReader("rezultati.txt");
					BufferedReader br=new BufferedReader(fr);
					
					String str;
					while((str=br.readLine()) != null) {
						System.out.println(str+"\n");
					}
					br.close();
				}
				catch(Exception e1) {
					System.out.println("Nema fajla");
					
				}
			}
		});
		btnVidi.setBounds(189, 280, 97, 25);
		contentPane.add(btnVidi);
		
		sabiranje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sabiranje.isSelected())
					oduzimanje.setSelected(false);
				mnozenje.setSelected(false);
				dijeljenje.setSelected(false);
				znak.setText("+");
					
			}
		});
		
		oduzimanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(oduzimanje.isSelected())
					sabiranje.setSelected(false);
				mnozenje.setSelected(false);
				dijeljenje.setSelected(false);
				znak.setText("-");	
			}
		});
		
		mnozenje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mnozenje.isSelected())
					sabiranje.setSelected(false);
				oduzimanje.setSelected(false);
				dijeljenje.setSelected(false);
				znak.setText("*");
			}
		});
		
		dijeljenje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dijeljenje.isSelected())
					sabiranje.setSelected(false);
				oduzimanje.setSelected(false);
				mnozenje.setSelected(false);
				znak.setText("/");
			}
		});
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
