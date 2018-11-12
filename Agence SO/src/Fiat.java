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
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import javax.swing.JLayeredPane;

public class Fiat {

	private JFrame frmCrerUnCompte;
	
	java.sql.Connection cnx = null;
	PreparedStatement pst =null;
	ResultSet rs =null;
	private JTable table_renault;
	private JTextField AD_text;
	
	/**
	 * Launch the application.
	 */
	public static void NvFiat() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fiat window = new Fiat();
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
	public Fiat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrerUnCompte = new JFrame();
		frmCrerUnCompte.setTitle("Fiat");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int w =950;
		int h = 650;
		int xPos = (dim.width / 2) - (w / 2);
		int yPos = (dim.height / 2) - (h / 2);
		frmCrerUnCompte.setBounds(xPos,yPos,w,h);
		frmCrerUnCompte.getContentPane().setLayout(null);
		
		final JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Fiat.class.getResource("/images/dark_background_2-wallpaper-1600x1200.jpg")));
		lblNewLabel_5.setBackground(SystemColor.desktop);
		lblNewLabel_5.setBounds(10, 11, 404, 286);
		frmCrerUnCompte.getContentPane().add(lblNewLabel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(424, 0, 510, 611);
		frmCrerUnCompte.getContentPane().add(scrollPane);
		
		table_renault = new JTable();
		table_renault.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int ligne = table_renault.getSelectedRow();
				String id = table_renault.getModel().getValueAt(ligne, 0).toString();
				String sql = "select * from cars where id= '"+id+"'";
				try {
					pst = (PreparedStatement) cnx.prepareStatement(sql);
					rs = pst.executeQuery();
					if(rs.next()) {
						byte[] img = rs.getBytes("image");
						ImageIcon image = new ImageIcon(img);
						java.awt.Image im = image.getImage();
						java.awt.Image myImg = im.getScaledInstance(lblNewLabel_5.getWidth(), lblNewLabel_5.getHeight(), java.awt.Image.SCALE_SMOOTH);
						ImageIcon imggg = new ImageIcon(myImg);
						lblNewLabel_5.setIcon(imggg);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		table_renault.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Marque", "Mod\u00E8le", "Nombre de place", "Energie", "Bo\u00EEte Vitesse", "Prix"
			}
		));
		table_renault.getColumnModel().getColumn(0).setPreferredWidth(39);
		scrollPane.setViewportView(table_renault);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmCrerUnCompte.setVisible(false);
			}
		});
		button.setIcon(new ImageIcon(Fiat.class.getResource("/images/back.png")));
		button.setToolTipText("Retour");
		button.setBounds(110, 425, 44, 39);
		frmCrerUnCompte.getContentPane().add(button);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ligne = table_renault.getSelectedRow();
				String marque = table_renault.getModel().getValueAt(ligne, 1).toString();
				String modele = table_renault.getModel().getValueAt(ligne, 2).toString();
				String nb_place = table_renault.getModel().getValueAt(ligne, 3).toString();
				String energie = table_renault.getModel().getValueAt(ligne, 4).toString();
				String boite = table_renault.getModel().getValueAt(ligne, 5).toString();
				String prix = table_renault.getModel().getValueAt(ligne, 6).toString();
				Connecter con = new Connecter();
				String nom = con.nom;
				String prenom = con.prenom;
				String adresse = AD_text.getText().toString();
				try {
					if (AD_text.getText().toString().equals("")) JOptionPane.showMessageDialog(null, "Saisir votre adresse ! ");
					else {
					String sql ="insert into commande (marque,modele,nb_place,energie,boite,prix,nom,prenom,adresse) values (?,?,?,?,?,?,?,?,?)" ;
					pst = (PreparedStatement) cnx.prepareStatement(sql);
					pst.setString(1, marque);
					pst.setString(2, modele);
					pst.setString(3, nb_place);
					pst.setString(4, energie);
					pst.setString(5, boite);
					pst.setString(6, prix);
					pst.setString(7, nom);
					pst.setString(8, prenom);
					pst.setString(9, adresse);
					pst.execute();
					String msg = "Mr/Mme : "+nom+"  "+prenom + "\n" +
					//"Adresse : "+adresse + "\n"+
							"Votre commande: \n"+
					"\t -Marque : "+marque+"\n"+
					"\t -Modèle : "+modele+"\n"+
					"\t -Nombre de places : "+nb_place+"\n"+
					"\t -Energie : "+energie+"\n"+
					"\t -Boite de vitesse  : "+boite+"\n"+
					"\t -Prix : "+prix+"\n"+
					"Sera livré à votre adresse : ' "+adresse +" ' ,dans 48h \n Vous pouvez nous appeler sur 71.008.009 pour plus d'infos";
					JOptionPane.showMessageDialog(null, msg);
					AD_text.setText(null);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
				
				
			}
		});
		
		btnNewButton.setIcon(new ImageIcon(Fiat.class.getResource("/images/receipt.png")));
		btnNewButton.setToolTipText("Passer Commande");
		btnNewButton.setBounds(259, 394, 70, 70);
		frmCrerUnCompte.getContentPane().add(btnNewButton);
		
		JLabel lblRetour = new JLabel("Retour");
		lblRetour.setHorizontalAlignment(SwingConstants.LEFT);
		lblRetour.setForeground(SystemColor.textHighlight);
		lblRetour.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		lblRetour.setBounds(110, 475, 70, 14);
		frmCrerUnCompte.getContentPane().add(lblRetour);
		
		JLabel lblPasserCommande = new JLabel("Passer Commande");
		lblPasserCommande.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasserCommande.setForeground(SystemColor.textHighlight);
		lblPasserCommande.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		lblPasserCommande.setBounds(231, 475, 129, 14);
		frmCrerUnCompte.getContentPane().add(lblPasserCommande);
		
		AD_text = new JTextField();
		AD_text.setBounds(10, 566, 404, 34);
		frmCrerUnCompte.getContentPane().add(AD_text);
		AD_text.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Saisir Votre Adresse pour passer la commande");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setBackground(SystemColor.textHighlight);
		lblNewLabel_1.setBounds(10, 542, 404, 14);
		frmCrerUnCompte.getContentPane().add(lblNewLabel_1);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Fiat.class.getResource("/images/dark_background_2-wallpaper-1600x1200.jpg")));
		lblNewLabel.setBounds(0, 0, 425, 611);
		frmCrerUnCompte.getContentPane().add(lblNewLabel);
		
		cnx = ConnexionMysql.connexionDB();
		String sql = "SELECT * FROM cars where marque = 'Fiat' ";
        try {
			pst = (PreparedStatement) cnx.prepareStatement(sql);
			rs = pst.executeQuery(sql);
	        while(rs.next()) {
	        	String Marque = rs.getString("marque");
	        	String Modele = rs.getString("modele");
	        	int NB = rs.getInt("nb_place");
	        	String NBS= Integer.toString(NB);
	            String Energie = rs.getString("energie");	
	            String Boite = rs.getString("boite");
	            String Prix = rs.getString("prix");
	            int id = rs.getInt("id");
	            String Id = Integer.toString(id);
	           DefaultTableModel model = (DefaultTableModel) table_renault.getModel();
	           model.addRow(new Object[]{Id,Marque,Modele,NBS,Energie,Boite,Prix});
	        }
	        
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Contact non trouvé");
		}
		
	}
}
