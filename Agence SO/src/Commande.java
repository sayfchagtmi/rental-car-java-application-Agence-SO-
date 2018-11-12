import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.PieDataset;

import com.mysql.jdbc.PreparedStatement;
import javax.swing.JPanel;
import java.awt.SystemColor;

public class Commande {

	java.sql.Connection cnx = null;
	PreparedStatement pst =null;
	ResultSet rs =null;
	
	private JFrame frmPageAdministrateur;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnStatistiques;
	private static  int r=0,t=0,c=0,f=0,k=0,p=0;
	private JLabel lblRetour;

	/**
	 * Launch the application.
	 */
	public static void NvCommande() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Commande window = new Commande();
					window.frmPageAdministrateur.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Commande() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPageAdministrateur = new JFrame();
		frmPageAdministrateur.setTitle("Les Commandes ");
		frmPageAdministrateur.setResizable(false);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int w =950;
		int h = 650;
		int xPos = (dim.width / 2) - (w / 2);
		int yPos = (dim.height / 2) - (h / 2);
		frmPageAdministrateur.setBounds(xPos, yPos, w, h);
		frmPageAdministrateur.getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmPageAdministrateur.setVisible(false);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(Commande.class.getResource("/images/back.png")));
		btnNewButton_1.setForeground(new Color(255, 102, 102));
		btnNewButton_1.setToolTipText("Accueil");
		btnNewButton_1.setBounds(10, 11, 44, 39);
		frmPageAdministrateur.getContentPane().add(btnNewButton_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 100, 800, 510);
		frmPageAdministrateur.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Marque", "Mod\u00E8le", "Nombre de places", "Energie", "Boite Vitesse", "Prix", "Nom", "Prenom", "Adresse"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblLesCommandesDes = new JLabel("Les Commandes des Clients ");
		lblLesCommandesDes.setHorizontalAlignment(SwingConstants.CENTER);
		lblLesCommandesDes.setForeground(Color.DARK_GRAY);
		lblLesCommandesDes.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 45));
		lblLesCommandesDes.setBounds(98, 11, 798, 70);
		frmPageAdministrateur.getContentPane().add(lblLesCommandesDes);
		
		btnStatistiques = new JButton("");
		btnStatistiques.setIcon(new ImageIcon(Commande.class.getResource("/images/presentation.png")));
		btnStatistiques.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();
				dataset.setValue(r/2, "", "Renault");
				dataset.setValue(t/2, "", "Toyot	a");
				dataset.setValue(c/2, "", "Citroën");
				dataset.setValue(f/2, "", "Fiat");
				dataset.setValue(k/2, "", "Kia");
				dataset.setValue(p/2, "", "Peugeot");
				
				JFreeChart chart = ChartFactory.createBarChart("Nombre de voitures passées en commande par marque", "Les Marques", "Nombre de Voitures", dataset,PlotOrientation.VERTICAL,true,true,true);
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
		btnStatistiques.setBounds(13, 248, 70, 70);
		frmPageAdministrateur.getContentPane().add(btnStatistiques);
		
		JLabel lblStatistiques = new JLabel("Statistiques");
		lblStatistiques.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		lblStatistiques.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatistiques.setForeground(Color.DARK_GRAY);
		lblStatistiques.setBounds(0, 339, 102, 14);
		frmPageAdministrateur.getContentPane().add(lblStatistiques);
		
		lblRetour = new JLabel("Retour");
		lblRetour.setHorizontalAlignment(SwingConstants.LEFT);
		lblRetour.setForeground(Color.DARK_GRAY);
		lblRetour.setFont(new Font("Dialog", Font.BOLD, 15));
		lblRetour.setBounds(10, 50, 57, 14);
		frmPageAdministrateur.getContentPane().add(lblRetour);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setToolTipText("Les Commandes");
		lblNewLabel.setIcon(new ImageIcon(Commande.class.getResource("/images/admin_back.png")));
		lblNewLabel.setBounds(0, 0, 944, 621);
		frmPageAdministrateur.getContentPane().add(lblNewLabel);
		
		cnx = ConnexionMysql.connexionDB();
		String sql = "SELECT * FROM commande ";
        try {
			pst = (PreparedStatement) cnx.prepareStatement(sql);
			rs = pst.executeQuery(sql);
	        while(rs.next()) {
	        	String Marque = rs.getString("marque");
	        	String Modele = rs.getString("modele");
	        	String NB = rs.getString("nb_place");
	            String Energie = rs.getString("energie");	
	            String Boite = rs.getString("boite");	
	            String Prix = rs.getString("prix");	
	            String Nom = rs.getString("nom");	
	            String Prenom = rs.getString("prenom");	
	            String Adresse = rs.getString("adresse");	
	            if (Marque.equals("Renault")) {r++;}
	            if (Marque.equals("Toyota")) {t++;}
	            if (Marque.equals("Citroën")) {c++;}
	            if (Marque.equals("Fiat")) {f++;}
	            if (Marque.equals("Kia")) {k++;}
	            if (Marque.equals("Peugeot")) {p++;}
	           DefaultTableModel model = (DefaultTableModel) table.getModel();
	           model.addRow(new Object[]{Marque,Modele,NB,Energie,Boite,Prix,Nom,Prenom,Adresse});
	        }
	        
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "");
		}
        
		
	}
}
