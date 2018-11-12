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
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import javax.swing.DropMode;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.sun.org.apache.xerces.internal.impl.RevalidationHandler;

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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;

public class Utilisateur {

	private JFrame frmCrerUnCompte;
	
	java.sql.Connection cnx = null;
	PreparedStatement pst =null;
	ResultSet rs =null;
	
	private static final String EMAIL_PATTERN = 
		    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	/**
	 * Launch the application.
	 */
	public static void NvUtilisateur() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Utilisateur window = new Utilisateur();
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
	public Utilisateur() {
		initialize();
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrerUnCompte = new JFrame();
		frmCrerUnCompte.setTitle("Utilisateurs");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int w =950;
		int h = 650;
		int xPos = (dim.width / 2) - (w / 2);
		int yPos = (dim.height / 2) - (h / 2);
		frmCrerUnCompte.setBounds(xPos,yPos,w,h);
		frmCrerUnCompte.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(810, 56, 114, 20);
		frmCrerUnCompte.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setForeground(SystemColor.textHighlight);
		lblNom.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		lblNom.setBounds(810, 31, 46, 14);
		frmCrerUnCompte.getContentPane().add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setForeground(SystemColor.textHighlight);
		lblPrenom.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		lblPrenom.setBounds(810, 107, 70, 14);
		frmCrerUnCompte.getContentPane().add(lblPrenom);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(810, 132, 114, 20);
		frmCrerUnCompte.getContentPane().add(textField_1);
		
		JLabel lblAdresseMail = new JLabel("Adresse Mail");
		lblAdresseMail.setForeground(SystemColor.textHighlight);
		lblAdresseMail.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		lblAdresseMail.setBounds(810, 181, 98, 14);
		frmCrerUnCompte.getContentPane().add(lblAdresseMail);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(810, 206, 114, 20);
		frmCrerUnCompte.getContentPane().add(textField_2);
		
		JLabel lblMotDePasse = new JLabel("Mot de Passe");
		lblMotDePasse.setForeground(SystemColor.textHighlight);
		lblMotDePasse.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		lblMotDePasse.setBounds(810, 256, 114, 14);
		frmCrerUnCompte.getContentPane().add(lblMotDePasse);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(810, 281, 114, 20);
		frmCrerUnCompte.getContentPane().add(textField_3);
		
		JButton btnAjouter = new JButton("");
		btnAjouter.setIcon(new ImageIcon(Utilisateur.class.getResource("/images/add (2).png")));
		btnAjouter.setToolTipText("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					String sql ="insert into users (nom,prenom,mail,password) values (?,?,?,?)" ;
				
				try {
					pst = (PreparedStatement) cnx.prepareStatement(sql);
					if(textField.getText().toString().equals("")||textField_1.getText().toString().equals("")||
							textField_2.getText().toString().equals("")||textField_3.getText().toString().equals(""))
						JOptionPane.showMessageDialog(null, "Un ou plusieurs champs vide(s) !");
					else if(!textField_2.getText().toString().matches(EMAIL_PATTERN))
						JOptionPane.showMessageDialog(null, "Adresse mail non valide ! \n (Elle doit etre de la forme"
								+ ": exemple@exemple.exemple");
					else {
					pst.setString(1, textField.getText().toString() );
					pst.setString(2, textField_1.getText().toString());
					pst.setString(3, textField_2.getText().toString() );
					pst.setString(4, textField_3.getText().toString());
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Utilisateur Ajouté !");
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
					frmCrerUnCompte.setVisible(false);
					Utilisateur.NvUtilisateur();}
						}
				 catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnAjouter.setBounds(810, 354, 35, 35);
		frmCrerUnCompte.getContentPane().add(btnAjouter);
		
		JButton btnSupprimer = new JButton("");
		btnSupprimer.setIcon(new ImageIcon(Utilisateur.class.getResource("/images/remove (1).png")));
		btnSupprimer.setToolTipText("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {					
					if(textField.getText().toString().equals("")||textField_1.getText().toString().equals("")||
							textField_2.getText().toString().equals("")||textField_3.getText().toString().equals(""))
						JOptionPane.showMessageDialog(null, "Un ou plusieurs champs vide(s) !");
					else {
						String sql ="delete from users where mail='"+textField_2.getText().toString()+"';";
						pst = (PreparedStatement) cnx.prepareStatement(sql);
						pst.execute();
						JOptionPane.showMessageDialog(null, "Utilisateur Supprimé !");
						textField.setText(null);
						textField_1.setText(null);
						textField_2.setText(null);
						textField_3.setText(null);
						frmCrerUnCompte.setVisible(false);
						Utilisateur.NvUtilisateur();}
						}
				 catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnSupprimer.setBounds(810, 425, 35, 35);
		frmCrerUnCompte.getContentPane().add(btnSupprimer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 800, 611);
		frmCrerUnCompte.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int ligne = table.getSelectedRow();
				String id = table.getModel().getValueAt(ligne, 2).toString();
				String sql = "select * from users where mail= '"+id+"'";
				try {
					pst = (PreparedStatement) cnx.prepareStatement(sql);
					rs = pst.executeQuery();
					if(rs.next()) {
						textField.setText(rs.getString("nom"));
						textField_1.setText(rs.getString("prenom"));
						textField_2.setText(rs.getString("mail"));
						textField_3.setText(rs.getString("password"));
						
						
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		table.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nom", "Prenom", "Adresse Mail", "Mot De Passe"
			}
		));
		
		JLabel lblAjouter = new JLabel("Ajouter");
		lblAjouter.setForeground(SystemColor.textHighlight);
		lblAjouter.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		lblAjouter.setBounds(855, 365, 69, 14);
		frmCrerUnCompte.getContentPane().add(lblAjouter);
		
		JLabel lblSupprimer = new JLabel("Supprimer");
		lblSupprimer.setForeground(SystemColor.textHighlight);
		lblSupprimer.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		lblSupprimer.setBounds(855, 436, 79, 14);
		frmCrerUnCompte.getContentPane().add(lblSupprimer);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
			}
		});
		button.setIcon(new ImageIcon(Utilisateur.class.getResource("/images/error.png")));
		button.setBounds(810, 489, 35, 35);
		frmCrerUnCompte.getContentPane().add(button);
		
		JLabel lblNewLabel_1 = new JLabel("Vider");
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_1.setBounds(855, 488, 69, 20);
		frmCrerUnCompte.getContentPane().add(lblNewLabel_1);
		
		JLabel lblChamps = new JLabel("Champs");
		lblChamps.setForeground(SystemColor.textHighlight);
		lblChamps.setFont(new Font("Dialog", Font.BOLD, 15));
		lblChamps.setBounds(855, 505, 69, 20);
		frmCrerUnCompte.getContentPane().add(lblChamps);
		
		JLabel lblRetour = new JLabel("Retour");
		lblRetour.setForeground(SystemColor.textHighlight);
		lblRetour.setFont(new Font("Dialog", Font.BOLD, 15));
		lblRetour.setBounds(865, 568, 69, 14);
		frmCrerUnCompte.getContentPane().add(lblRetour);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCrerUnCompte.setVisible(false);
			}
		});
		button_1.setIcon(new ImageIcon(Utilisateur.class.getResource("/images/back.png")));
		button_1.setBounds(810, 559, 46, 35);
		frmCrerUnCompte.getContentPane().add(button_1);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Utilisateur.class.getResource("/images/dark_background_2-wallpaper-1600x1200.jpg")));
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setBounds(799, 0, 135, 611);
		frmCrerUnCompte.getContentPane().add(lblNewLabel);
		
		cnx = ConnexionMysql.connexionDB();
		String sql = "SELECT nom,prenom,mail,password FROM users ";
        try {
			pst = (PreparedStatement) cnx.prepareStatement(sql);
			rs = pst.executeQuery(sql);
	        while(rs.next()) {
	        	String Nom = rs.getString("nom");
	        	String Prenom = rs.getString("prenom");
	        	String Mail = rs.getString("mail");
	            String Password = rs.getString("password");	
	           DefaultTableModel model = (DefaultTableModel) table.getModel();
	           model.addRow(new Object[]{Nom,Prenom,Mail,Password});
	        }
	        
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Contact non trouvé");
		}
		
	}
}
