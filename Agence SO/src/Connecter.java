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

public class Connecter {
	public static String nom;
	public static String prenom;
	private JFrame frmConnect;
	private JTextField AdMail_1;
	private JPasswordField Passwd_1;
	
	private static final String EMAIL_PATTERN = 
		    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	java.sql.Connection cnx = null;
	PreparedStatement pst =null;
	ResultSet rs =null;
	
	/**
	 * Launch the application.
	 */
	public static void toConnect() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connecter window = new Connecter();
					window.frmConnect.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Connecter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConnect = new JFrame();
		frmConnect.setTitle("Cr\u00E9er un compte");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int w =950;
		int h = 650;
		int xPos = (dim.width / 2) - (w / 2);
		int yPos = (dim.height / 2) - (h / 2);
		frmConnect.setBounds(xPos,yPos,w,h);
		frmConnect.getContentPane().setLayout(null);
		
		cnx = ConnexionMysql.connexionDB();
		
		JButton Connecter_B = new JButton("");
		Connecter_B.setBackground(new Color(60, 179, 113));
		Connecter_B.setIcon(new ImageIcon(Connecter.class.getResource("/images/checked (2).png")));
		Connecter_B.setToolTipText("Se Connecter");
		Connecter_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					 try {
						 if (AdMail_1.getText().toString().equals("") || Passwd_1.getText().toString().equals("") )
				        		JOptionPane.showMessageDialog(null, "Un ou plusieurs champs vide(s) !"); 
						 else if(!AdMail_1.getText().toString().matches(EMAIL_PATTERN))
								JOptionPane.showMessageDialog(null, "Adresse mail non valide ! \n (Elle doit etre de la forme"
										+ ": exemple@exemple.exemple");
						 else {
						String sql = "SELECT * FROM users ";
						pst = (PreparedStatement) cnx.prepareStatement(sql);
						rs = pst.executeQuery(sql);
						boolean bb = false;
				        while(rs.next()) {
				        	String Mail = rs.getString("mail");
				            String Password = rs.getString("password");		
				             if(AdMail_1.getText().toString().equals("root@root.root") && 
				            	Passwd_1.getText().toString().equals("root")) {
				            	bb=true;
				            	AdMail_1.setText(null);
				            	Passwd_1.setText(null);
				            	Admin a = new Admin();
				            	a.NvAdmin();
				            	frmConnect.setVisible(false);		
				            	break;}	
				             else if(AdMail_1.getText().toString().equals(Mail) && 
						            Passwd_1.getText().toString().equals(Password)) {	
				            	 	nom = rs.getString("nom");
				            	 	prenom = rs.getString("prenom");
				            	 	System.out.println(nom+prenom);
					            	bb =true;
					            	AdMail_1.setText(null);
					            	Passwd_1.setText(null);
					            	LouerVoiture lv = LouerVoiture();
					            	lv.NvLouerVoiture();
					            	frmConnect.setVisible(false);
					            	break;
						           }     
				        }			            			
				            	if(bb == false) {
				            	AdMail_1.setText(null);
				            	Passwd_1.setText(null);
				            	JOptionPane.showMessageDialog(null, "Utilisateur non trouvé !");
				            }
				        }
					 }catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Contact non trouvé !");
					}
			        
				 
				 
			}});
		
		JLabel lblCrerUne = new JLabel("Se Connecter");
		lblCrerUne.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrerUne.setForeground(SystemColor.textHighlight);
		lblCrerUne.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 25));
		lblCrerUne.setBackground(Color.GRAY);
		lblCrerUne.setBounds(360, 71, 270, 40);
		frmConnect.getContentPane().add(lblCrerUne);
		Connecter_B.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		Connecter_B.setBounds(464, 261, 70, 70);
		frmConnect.getContentPane().add(Connecter_B);
		
		JLabel AdMail = new JLabel("Adresse Mail");
		AdMail.setHorizontalAlignment(SwingConstants.CENTER);
		AdMail.setForeground(SystemColor.activeCaption);
		AdMail.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		AdMail.setBackground(Color.GRAY);
		AdMail.setBounds(360, 119, 270, 18);
		frmConnect.getContentPane().add(AdMail);
		
		AdMail_1 = new JTextField();
		AdMail_1.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 15));
		AdMail_1.setBounds(360, 149, 270, 30);
		frmConnect.getContentPane().add(AdMail_1);
		AdMail_1.setColumns(10);
		
		JLabel Passwd = new JLabel("Mot de passe");
		Passwd.setHorizontalAlignment(SwingConstants.CENTER);
		Passwd.setForeground(SystemColor.activeCaption);
		Passwd.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		Passwd.setBackground(Color.GRAY);
		Passwd.setBounds(360, 189, 270, 18);
		frmConnect.getContentPane().add(Passwd);
		
		Passwd_1 = new JPasswordField();
		Passwd_1.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 15));
		Passwd_1.setColumns(10);
		Passwd_1.setBounds(360, 220, 270, 30);
		frmConnect.getContentPane().add(Passwd_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Compte.class.getResource("/images/cadre_compte.png")));
		lblNewLabel_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1.setBounds(315, 55, 350, 296);
		frmConnect.getContentPane().add(lblNewLabel_1);
		
		JButton button = new JButton("");
		button.setBackground(new Color(255, 102, 102));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmConnect.setVisible(false);
			}
		});
		button.setIcon(new ImageIcon(Connecter.class.getResource("/images/back.png")));
		button.setToolTipText("Accueil");
		button.setBounds(0, 0, 44, 39);
		frmConnect.getContentPane().add(button);
		
		JLabel lblRetour = new JLabel("Retour");
		lblRetour.setForeground(Color.DARK_GRAY);
		lblRetour.setFont(new Font("Dialog", Font.BOLD, 15));
		lblRetour.setBounds(54, 0, 64, 39);
		frmConnect.getContentPane().add(lblRetour);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Compte.class.getResource("/images/compte.jpg")));
		lblNewLabel.setBounds(0, 0, 934, 611);
		frmConnect.getContentPane().add(lblNewLabel);
		
	}

	protected LouerVoiture LouerVoiture() {
		// TODO Auto-generated method stub
		return null;
	}
}
