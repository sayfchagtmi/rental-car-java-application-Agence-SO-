import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import javax.swing.DropMode;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import sun.security.util.Password;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Compte {

	private JFrame frmCrerUnCompte;
	private JPasswordField passwordField;
	private JTextField Nom;
	private JTextField Prenom;
	private JTextField AdresseMail;
	
	private static final String EMAIL_PATTERN = 
		    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	
	java.sql.Connection cnx = null;
	PreparedStatement prepared =null;
	ResultSet resultat =null;
	
	/**
	 * Launch the application.
	 */
	public static void NvCompte() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Compte window = new Compte();
					window.frmCrerUnCompte.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Compte() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrerUnCompte = new JFrame();
		frmCrerUnCompte.setTitle("Cr\u00E9er un compte");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int w =950;
		int h = 650;
		int xPos = (dim.width / 2) - (w / 2);
		int yPos = (dim.height / 2) - (h / 2);
		frmCrerUnCompte.setBounds(xPos,yPos,w,h);
		frmCrerUnCompte.getContentPane().setLayout(null);
		
		cnx = ConnexionMysql.connexionDB();
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(46, 139, 87));
		btnNewButton.setIcon(new ImageIcon(Compte.class.getResource("/images/checked (2).png")));
		btnNewButton.setToolTipText("Soumettre");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					String sql ="insert into users (nom,prenom,mail,password) values (?,?,?,?)" ;
				try {
					if(Nom.getText().toString().equals("")||
							Prenom.getText().toString().equals("")||
							AdresseMail.getText().toString().equals("")||		
							passwordField.getText().toString().equals(""))
						JOptionPane.showMessageDialog(null, "Un ou plusieurs champs vide(s) !");
					else if(!AdresseMail.getText().toString().matches(EMAIL_PATTERN))
						JOptionPane.showMessageDialog(null, "Adresse mail non valide ! \n (Elle doit etre de la forme"
								+ ": exemple@exemple.exemple");
					else {
					prepared = (PreparedStatement) cnx.prepareStatement(sql);
					prepared.setString(1, Nom.getText().toString() );
					prepared.setString(2, Prenom.getText().toString());
					prepared.setString(3, AdresseMail.getText().toString() );
					prepared.setString(4, passwordField.getText().toString());
					
					prepared.execute();
					JOptionPane.showMessageDialog(null, "Inscription réussite !");
					Nom.setText(null);
					Prenom.setText(null);
					AdresseMail.setText(null);
					passwordField.setText(null);
						}}
				 catch (SQLException e1) {
					
					e1.printStackTrace();
				}
	
			}
		});
		
		JLabel lblCrerUne = new JLabel("Cr\u00E9er un compte");
		lblCrerUne.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrerUne.setForeground(SystemColor.textHighlight);
		lblCrerUne.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 25));
		lblCrerUne.setBackground(Color.GRAY);
		lblCrerUne.setBounds(360, 71, 270, 40);
		frmCrerUnCompte.getContentPane().add(lblCrerUne);
		btnNewButton.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		btnNewButton.setBounds(457, 428, 70, 70);
		frmCrerUnCompte.getContentPane().add(btnNewButton);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblNom.setForeground(SystemColor.activeCaption);
		lblNom.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		lblNom.setBackground(Color.GRAY);
		lblNom.setBounds(360, 119, 270, 18);
		frmCrerUnCompte.getContentPane().add(lblNom);
		
		Nom = new JTextField();
		Nom.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 15));
		Nom.setBounds(360, 149, 270, 30);
		frmCrerUnCompte.getContentPane().add(Nom);
		Nom.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrenom.setForeground(SystemColor.activeCaption);
		lblPrenom.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		lblPrenom.setBackground(Color.GRAY);
		lblPrenom.setBounds(360, 189, 270, 18);
		frmCrerUnCompte.getContentPane().add(lblPrenom);
		
		Prenom = new JTextField();
		Prenom.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 15));
		Prenom.setColumns(10);
		Prenom.setBounds(360, 220, 270, 30);
		frmCrerUnCompte.getContentPane().add(Prenom);
		
		JLabel lblAdresseMail = new JLabel("Adresse Mail");
		lblAdresseMail.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdresseMail.setForeground(SystemColor.activeCaption);
		lblAdresseMail.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		lblAdresseMail.setBackground(Color.GRAY);
		lblAdresseMail.setBounds(360, 266, 270, 18);
		frmCrerUnCompte.getContentPane().add(lblAdresseMail);
		
		AdresseMail = new JTextField();
		AdresseMail.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 15));
		AdresseMail.setColumns(10);
		AdresseMail.setBounds(360, 297, 270, 30);
		frmCrerUnCompte.getContentPane().add(AdresseMail);
		
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setHorizontalAlignment(SwingConstants.CENTER);
		lblMotDePasse.setBackground(new Color(128, 128, 128));
		lblMotDePasse.setForeground(SystemColor.activeCaption);
		lblMotDePasse.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		lblMotDePasse.setBounds(360, 346, 270, 18);
		frmCrerUnCompte.getContentPane().add(lblMotDePasse);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(360, 375, 270, 30);
		frmCrerUnCompte.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Compte.class.getResource("/images/cadre_compte.png")));
		lblNewLabel_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1.setBounds(315, 55, 350, 468);
		frmCrerUnCompte.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmCrerUnCompte.setVisible(false);
			}
		});
		btnNewButton_1.setBackground(new Color(255, 102, 102));
		btnNewButton_1.setIcon(new ImageIcon(Compte.class.getResource("/images/back.png")));
		btnNewButton_1.setToolTipText("Accueil");
		btnNewButton_1.setBounds(0, 0, 44, 39);
		frmCrerUnCompte.getContentPane().add(btnNewButton_1);
		
		JLabel lblRetour = new JLabel("Retour");
		lblRetour.setForeground(Color.DARK_GRAY);
		lblRetour.setFont(new Font("Dialog", Font.BOLD, 15));
		lblRetour.setBounds(53, 0, 70, 39);
		frmCrerUnCompte.getContentPane().add(lblRetour);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Compte.class.getResource("/images/compte.jpg")));
		lblNewLabel.setBounds(0, 0, 934, 611);
		frmCrerUnCompte.getContentPane().add(lblNewLabel);
		
	}
}
