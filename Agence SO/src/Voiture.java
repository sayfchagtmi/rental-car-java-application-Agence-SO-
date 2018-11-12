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

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;

public class Voiture {

	private JFrame frmCrerUnCompte;
	
	java.sql.Connection cnx = null;
	PreparedStatement pst =null;
	ResultSet rs =null;
	private static  int r=0,t=0,c=0,f=0,k=0,p=0;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private String s;
	
	/**
	 * Launch the application.
	 */
	public static void NvVoiture() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Voiture window = new Voiture();
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
	public Voiture() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrerUnCompte = new JFrame();
		frmCrerUnCompte.setTitle("Voitures");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int w =950;
		int h = 650;
		int xPos = (dim.width / 2) - (w / 2);
		int yPos = (dim.height / 2) - (h / 2);
		frmCrerUnCompte.setBounds(xPos,yPos,w,h);
		frmCrerUnCompte.getContentPane().setLayout(null);
		
		JLabel lblModle = new JLabel("Mod\u00E8le");
		lblModle.setForeground(SystemColor.textHighlight);
		lblModle.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		lblModle.setBounds(10, 113, 62, 14);
		frmCrerUnCompte.getContentPane().add(lblModle);
		
		JLabel lblNewLabel_1 = new JLabel("Marque ");
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 51, 81, 14);
		frmCrerUnCompte.getContentPane().add(lblNewLabel_1);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Renault", "Toyota", "Citro\u00EBn", "Fiat", "Kia", "Peugeot"}));
		comboBox.setForeground(SystemColor.textHighlight);
		comboBox.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		comboBox.setBounds(130, 48, 118, 20);
		frmCrerUnCompte.getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(130, 111, 118, 20);
		frmCrerUnCompte.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre de place");
		lblNewLabel_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_2.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 182, 118, 14);
		frmCrerUnCompte.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(130, 180, 118, 20);
		frmCrerUnCompte.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Energie");
		lblNewLabel_3.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		lblNewLabel_3.setForeground(SystemColor.textHighlight);
		lblNewLabel_3.setBounds(10, 250, 101, 14);
		frmCrerUnCompte.getContentPane().add(lblNewLabel_3);
		
		JLabel lblBoiteVitesse = new JLabel("Boite Vitesse");
		lblBoiteVitesse.setForeground(SystemColor.textHighlight);
		lblBoiteVitesse.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		lblBoiteVitesse.setBounds(10, 320, 101, 14);
		frmCrerUnCompte.getContentPane().add(lblBoiteVitesse);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Automatique", "Manuelle"}));
		comboBox_1.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		comboBox_1.setForeground(SystemColor.textHighlight);
		comboBox_1.setBounds(130, 318, 118, 20);
		frmCrerUnCompte.getContentPane().add(comboBox_1);
		
		final JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Essence", "Diesel"}));
		comboBox_2.setForeground(SystemColor.textHighlight);
		comboBox_2.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		comboBox_2.setBounds(130, 248, 118, 20);
		frmCrerUnCompte.getContentPane().add(comboBox_2);
		
		JLabel lblNewLabel_4 = new JLabel("Prix");
		lblNewLabel_4.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		lblNewLabel_4.setForeground(SystemColor.textHighlight);
		lblNewLabel_4.setBounds(258, 53, 46, 14);
		frmCrerUnCompte.getContentPane().add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(307, 49, 107, 20);
		frmCrerUnCompte.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		lblId.setForeground(SystemColor.textHighlight);
		lblId.setBounds(258, 116, 46, 14);
		frmCrerUnCompte.getContentPane().add(lblId);
		
		textField_4 = new JTextField();
		textField_4.setBounds(307, 111, 107, 20);
		frmCrerUnCompte.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnAjouter = new JButton("");
		btnAjouter.setIcon(new ImageIcon(Voiture.class.getResource("/images/add (2).png")));
		btnAjouter.setToolTipText("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					if(textField.getText().toString().equals("")||textField_1.getText().toString().equals("")||
							textField_3.getText().toString().equals("")||
							textField_4.getText().toString().equals(""))
						JOptionPane.showMessageDialog(null, "Un ou plusieurs champs vide(s) !");
					else {
					String sql ="insert into cars (id,marque,modele,nb_place,energie,boite,prix,image) values (?,?,?,?,?,?,?,?)" ;
					pst = (PreparedStatement) cnx.prepareStatement(sql);
					InputStream imgg = new FileInputStream(new File(s));
					pst.setInt(1, Integer.parseInt(textField_4.getText().toString()));
					pst.setString(2, comboBox.getSelectedItem().toString());
					pst.setString(3, textField.getText().toString() );
					pst.setInt(4, Integer.parseInt( textField_1.getText().toString()));
					pst.setString(5,comboBox_2.getSelectedItem().toString());
					pst.setString(6, comboBox_1.getSelectedItem().toString());
					pst.setString(7, textField_3.getText().toString());
					pst.setBlob(8, imgg);
					
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Voiture Ajouté !");
					textField.setText(null);
					textField_1.setText(null);
					textField_3.setText(null);
					textField_4.setText(null);
					frmCrerUnCompte.setVisible(false);
					Voiture.NvVoiture();}
						}
				 catch (SQLException e1) {
					
					e1.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		final JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Voiture.class.getResource("/images/dark_background_2-wallpaper-1600x1200.jpg")));
		lblNewLabel_5.setBackground(SystemColor.desktop);
		lblNewLabel_5.setBounds(130, 365, 284, 221);
		frmCrerUnCompte.getContentPane().add(lblNewLabel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(424, 0, 510, 611);
		frmCrerUnCompte.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int ligne = table.getSelectedRow();
				String id = table.getModel().getValueAt(ligne, 0).toString();
				String sql = "select * from cars where id= '"+id+"'";
				try {
					pst = (PreparedStatement) cnx.prepareStatement(sql);
					rs = pst.executeQuery();
					if(rs.next()) {
						textField_4.setText(rs.getString("id"));
						comboBox.setSelectedItem(rs.getString("marque"));
						textField.setText(rs.getString("modele"));
						textField_1.setText(Integer.toString(rs.getInt("nb_place")));
						comboBox_2.setSelectedItem(rs.getString("energie"));
						comboBox_1.setSelectedItem(rs.getString("boite"));
						textField_3.setText(rs.getString("prix"));
						
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
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Marque", "Mod\u00E8le", "Nombre de place", "Energie", "Bo\u00EEte Vitesse", "Prix"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(39);
		scrollPane.setViewportView(table);
		btnAjouter.setBounds(307, 161, 35, 35);
		frmCrerUnCompte.getContentPane().add(btnAjouter);
		
		JButton btnModifier = new JButton("");
		btnModifier.setIcon(new ImageIcon(Voiture.class.getResource("/images/refresh (1).png")));
		btnModifier.setToolTipText("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				try {
					

					if(textField.getText().toString().equals("")||textField_1.getText().toString().equals("")||
							textField_3.getText().toString().equals("")||
							textField_4.getText().toString().equals(""))
						JOptionPane.showMessageDialog(null, "Un ou plusieurs champs vide(s) !");
					else {
					InputStream imgg = new FileInputStream(new File(s));
					String sql ="update cars set  "
							+"id = ? ,"
							+ "marque = ?,"
							+"modele = ?,"
							+"nb_place = ?,"
							+"energie = ? ,"
							+"boite = ?,"
							+"prix = ?,"
							+"image = ? "
							+"where id = ? ";
					System.out.println(sql);
					pst = (PreparedStatement) cnx.prepareStatement(sql);
					pst.setInt(1,Integer.parseInt(textField_4.getText().toString()));
					pst.setString(2, comboBox.getSelectedItem().toString());
					pst.setString(3, textField.getText().toString());
					pst.setInt(4, Integer.parseInt(textField_1.getText().toString()));
					pst.setString(5, comboBox_2.getSelectedItem().toString());
					pst.setString(6, comboBox_1.getSelectedItem().toString());
					pst.setString(7, textField_3.getText().toString());
					pst.setBlob(8, imgg);
					pst.setInt(9,Integer.parseInt(textField_4.getText().toString()));
					pst.execute();
					JOptionPane.showMessageDialog(null, "Voiture Modifié !");
					textField.setText(null);
					textField_1.setText(null);
					textField_3.setText(null);
					textField_4.setText(null);
					frmCrerUnCompte.setVisible(false);
					Voiture.NvVoiture();}
						}
				 catch (SQLException e1) {
					
					e1.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnModifier.setBounds(307, 229, 35, 35);
		frmCrerUnCompte.getContentPane().add(btnModifier);
		
		JButton btnSupprimer = new JButton("");
		btnSupprimer.setIcon(new ImageIcon(Voiture.class.getResource("/images/remove (1).png")));
		btnSupprimer.setToolTipText("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {					
					if(textField.getText().toString().equals("")||textField_1.getText().toString().equals("")||
							textField_3.getText().toString().equals("")||
							textField_4.getText().toString().equals(""))
						JOptionPane.showMessageDialog(null, "Un ou plusieurs champs vide(s) !");
					else {
						String sql ="delete from cars where id='"+textField_4.getText().toString()+"';";
						pst = (PreparedStatement) cnx.prepareStatement(sql);
						pst.execute();
						JOptionPane.showMessageDialog(null, "Voiture Supprimée !");
						textField.setText(null);
						textField_1.setText(null);
						textField_3.setText(null);
						textField_4.setText(null);
						frmCrerUnCompte.setVisible(false);
						Voiture.NvVoiture();}
						}
				 catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnSupprimer.setBounds(307, 299, 35, 35);
		frmCrerUnCompte.getContentPane().add(btnSupprimer);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Voiture.class.getResource("/images/list.png")));
		btnNewButton.setToolTipText("Parcourir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File("D:\\"));
				FileFilter filter = new FileNameExtensionFilter("IMAGE", ImageIO.getReaderFileSuffixes());
				fileChooser.addChoosableFileFilter(filter);
				int result = fileChooser.showDialog(null,null);
				
				if(result == JFileChooser.APPROVE_OPTION) {
					File selectedfile = fileChooser.getSelectedFile();
					String path = selectedfile.getAbsolutePath();
					ImageIcon myImage = new ImageIcon(path);
					java.awt.Image img = myImage.getImage();
					java.awt.Image newImage = img.getScaledInstance(lblNewLabel_5.getWidth(), lblNewLabel_5.getHeight(), java.awt.Image.SCALE_SMOOTH);
					ImageIcon finalImg = new ImageIcon(newImage);
					lblNewLabel_5.setIcon(finalImg);
					s = path;
				}
				else {
					if (result == JFileChooser.CANCEL_OPTION)
						JOptionPane.showMessageDialog(null,"T'as rien choisi");
				}
				
			}
		});
		
		
		
		
		
		btnNewButton.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setBounds(35, 386, 45, 45);
		frmCrerUnCompte.getContentPane().add(btnNewButton);
		
		JLabel label = new JLabel("Supprimer");
		label.setForeground(SystemColor.textHighlight);
		label.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		label.setBounds(352, 309, 69, 14);
		frmCrerUnCompte.getContentPane().add(label);
		
		JLabel lblModifier = new JLabel("Modifier");
		lblModifier.setForeground(SystemColor.textHighlight);
		lblModifier.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		lblModifier.setBounds(352, 239, 69, 14);
		frmCrerUnCompte.getContentPane().add(lblModifier);
		
		JLabel lblAjouter = new JLabel("Ajouter");
		lblAjouter.setForeground(SystemColor.textHighlight);
		lblAjouter.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		lblAjouter.setBounds(352, 171, 69, 14);
		frmCrerUnCompte.getContentPane().add(lblAjouter);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();
				dataset.setValue(r/2, "", "Renault");
				dataset.setValue(t/2, "", "Toyot	a");
				dataset.setValue(c/2, "", "Citroën");
				dataset.setValue(f/2, "", "Fiat");
				dataset.setValue(k/2, "", "Kia");
				dataset.setValue(p/2, "", "Peugeot");
				
				JFreeChart chart = ChartFactory.createBarChart("Nombre de voitures en stock par marque", "Les Marques", "Nombre de Voitures", dataset,PlotOrientation.VERTICAL,true,true,true);
				CategoryPlot catPlot = chart.getCategoryPlot();
				catPlot.setRangeGridlinePaint(Color.BLACK);
				
				ChartFrame chartframe = new ChartFrame("Les Statistiques",chart,true);
				chartframe.setVisible(true);
				Toolkit tk = Toolkit.getDefaultToolkit();
				Dimension dim = tk.getScreenSize();
				int w =950;
				int h = 650;
				int xPos = (dim.width / 2) - (w / 2);
				int yPos = (dim.height / 2) - (h / 2);
				chartframe.setBounds(xPos, yPos, w, h);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(Voiture.class.getResource("/images/presentation.png")));
		btnNewButton_1.setToolTipText("Les Statistiques");
		btnNewButton_1.setBounds(21, 493, 70, 70);
		frmCrerUnCompte.getContentPane().add(btnNewButton_1);
		
		JLabel lblParcourir = new JLabel("Parcourir");
		lblParcourir.setHorizontalAlignment(SwingConstants.CENTER);
		lblParcourir.setForeground(SystemColor.textHighlight);
		lblParcourir.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		lblParcourir.setBounds(24, 446, 67, 14);
		frmCrerUnCompte.getContentPane().add(lblParcourir);
		
		JLabel lblNewLabel_6 = new JLabel("Statistiques");
		lblNewLabel_6.setForeground(SystemColor.textHighlight);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		lblNewLabel_6.setBounds(0, 574, 111, 14);
		frmCrerUnCompte.getContentPane().add(lblNewLabel_6);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCrerUnCompte.setVisible(false);
			}
		});
		button.setIcon(new ImageIcon(Voiture.class.getResource("/images/back.png")));
		button.setBounds(0, 0, 44, 39);
		frmCrerUnCompte.getContentPane().add(button);
		
		JLabel lblRetour = new JLabel("Retour");
		lblRetour.setForeground(SystemColor.textHighlight);
		lblRetour.setFont(new Font("Dialog", Font.BOLD, 15));
		lblRetour.setBounds(47, 0, 62, 40);
		frmCrerUnCompte.getContentPane().add(lblRetour);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Voiture.class.getResource("/images/dark_background_2-wallpaper-1600x1200.jpg")));
		lblNewLabel.setBounds(0, 0, 425, 611);
		frmCrerUnCompte.getContentPane().add(lblNewLabel);
		
		cnx = ConnexionMysql.connexionDB();
		String sql = "SELECT * FROM cars ";
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
	            if (Marque.equals("Renault")) {r++;}
	            if (Marque.equals("Toyota")) {t++;}
	            if (Marque.equals("Citroën")) {c++;}
	            if (Marque.equals("Fiat")) {f++;}
	            if (Marque.equals("Kia")) {k++;}
	            if (Marque.equals("Peugeot")) {p++;}
	           DefaultTableModel model = (DefaultTableModel) table.getModel();
	           model.addRow(new Object[]{Id,Marque,Modele,NBS,Energie,Boite,Prix});
	        }
	        
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Contact non trouvé");
		}
		
	}
}
