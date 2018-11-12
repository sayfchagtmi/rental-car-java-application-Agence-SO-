import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class Bienvenue {
	private JFrame frmAgenceSo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bienvenue window = new Bienvenue();
					window.frmAgenceSo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Bienvenue() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgenceSo = new JFrame();
		frmAgenceSo.setResizable(false);
		frmAgenceSo.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 12));
		frmAgenceSo.setTitle("Agence SO _ Location des Voitures");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int w =950;
		int h = 650;
		int xPos = (dim.width / 2) - (w / 2);
		int yPos = (dim.height / 2) - (h / 2);		
		frmAgenceSo.setBounds(xPos,yPos, w, h);
		frmAgenceSo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgenceSo.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Bienvenue.class.getResource("/images/logo.png")));
		lblNewLabel.setBounds(0, 0, 50, 50);
		frmAgenceSo.getContentPane().add(lblNewLabel);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_1.setIcon(new ImageIcon(Bienvenue.class.getResource("/images/cancel.png")));
		button_1.setBounds(900, 0, 45, 50);
		frmAgenceSo.getContentPane().add(button_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 944, 50);
		frmAgenceSo.getContentPane().add(panel);
		
		JLabel lblAgenceSoDe = new JLabel("Agence SO de Location des Voitures");
		lblAgenceSoDe.setForeground(new Color(255, 255, 255));
		lblAgenceSoDe.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 35));
		panel.add(lblAgenceSoDe);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setToolTipText("Cr\u00E9\u00E9r Compte ");
		btnNewButton.setIcon(new ImageIcon(Bienvenue.class.getResource("/images/management.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Compte c = new Compte();
				c.NvCompte();
			}
		});
		btnNewButton.setBounds(643, 525, 100, 85);
		frmAgenceSo.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connecter con =new Connecter();
				con.toConnect();
			}
		});
		button.setIcon(new ImageIcon(Bienvenue.class.getResource("/images/login.png")));
		button.setToolTipText("Se Connecter");
		button.setBounds(811, 525, 100, 85);
		frmAgenceSo.getContentPane().add(button);
		
		JLabel lblSeConnecter = new JLabel("Se Connecter");
		lblSeConnecter.setBackground(Color.DARK_GRAY);
		lblSeConnecter.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeConnecter.setForeground(new Color(30, 144, 255));
		lblSeConnecter.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		lblSeConnecter.setBounds(811, 500, 100, 14);
		frmAgenceSo.getContentPane().add(lblSeConnecter);
		
		JLabel lblCrerCompte = new JLabel("Cr\u00E9er Compte");
		lblCrerCompte.setBackground(Color.LIGHT_GRAY);
		lblCrerCompte.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrerCompte.setForeground(new Color(30, 144, 255));
		lblCrerCompte.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		lblCrerCompte.setBounds(643, 500, 100, 14);
		frmAgenceSo.getContentPane().add(lblCrerCompte);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Bienvenue.class.getResource("/images/cadre_compte.png")));
		label.setBounds(643, 500, 100, 110);
		frmAgenceSo.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Bienvenue.class.getResource("/images/cadre_compte.png")));
		label_1.setBounds(811, 500, 100, 110);
		frmAgenceSo.getContentPane().add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(-27, 41, 1000, 580);
		frmAgenceSo.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(Bienvenue.class.getResource("/images/back.jpg")));
	}
}
