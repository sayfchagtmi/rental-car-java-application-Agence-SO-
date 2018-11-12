

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Admin {

	private JFrame frmPageAdministrateur;

	/**
	 * Launch the application.
	 */
	public static void NvAdmin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin();
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
	public Admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPageAdministrateur = new JFrame();
		frmPageAdministrateur.setTitle("Page Administrateur");
		frmPageAdministrateur.setResizable(false);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int w =950;
		int h = 650;
		int xPos = (dim.width / 2) - (w / 2);
		int yPos = (dim.height / 2) - (h / 2);
		frmPageAdministrateur.setBounds(xPos, yPos, w, h);
		frmPageAdministrateur.getContentPane().setLayout(null);
		
		JButton btnConsulterLesUtilisateurs = new JButton("Consulter les utilisateurs");
		btnConsulterLesUtilisateurs.setToolTipText("Les Utilisateurs");
		btnConsulterLesUtilisateurs.setIcon(new ImageIcon(Admin.class.getResource("/images/users (1).png")));
		btnConsulterLesUtilisateurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Utilisateur u = new Utilisateur();
				u.NvUtilisateur();
			}
		});
		btnConsulterLesUtilisateurs.setBounds(65, 200, 250, 206);
		frmPageAdministrateur.getContentPane().add(btnConsulterLesUtilisateurs);
		
		JButton btnConsulterLesVoitures = new JButton("Consulter les voitures");
		btnConsulterLesVoitures.setToolTipText("Les voitures");
		btnConsulterLesVoitures.setIcon(new ImageIcon(Admin.class.getResource("/images/car (1).png")));
		btnConsulterLesVoitures.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Voiture v =new Voiture();
				v.NvVoiture();
			}
		});
		btnConsulterLesVoitures.setBounds(357, 200, 250, 206);
		frmPageAdministrateur.getContentPane().add(btnConsulterLesVoitures);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmPageAdministrateur.setVisible(false);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(Admin.class.getResource("/images/logout.png")));
		btnNewButton_1.setForeground(new Color(255, 102, 102));
		btnNewButton_1.setToolTipText("Accueil");
		btnNewButton_1.setBounds(54, 34, 40, 35);
		frmPageAdministrateur.getContentPane().add(btnNewButton_1);
		
		JButton button = new JButton("");
		button.setToolTipText("Les Commandes");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Commande c = new Commande();
				c.NvCommande();
			}
		});
		button.setIcon(new ImageIcon(Admin.class.getResource("/images/customer-service.png")));
		button.setBounds(649, 200, 250, 206);
		frmPageAdministrateur.getContentPane().add(button);
		
		JLabel lblPanneauDadministrateur = new JLabel("Panneau d'Administrateur");
		lblPanneauDadministrateur.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanneauDadministrateur.setForeground(Color.DARK_GRAY);
		lblPanneauDadministrateur.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 40));
		lblPanneauDadministrateur.setBounds(232, 24, 499, 70);
		frmPageAdministrateur.getContentPane().add(lblPanneauDadministrateur);
		
		JLabel lblDconnecter = new JLabel("Se D\u00E9connecter");
		lblDconnecter.setForeground(new Color(64, 64, 64));
		lblDconnecter.setHorizontalAlignment(SwingConstants.CENTER);
		lblDconnecter.setFont(new Font("Dialog", Font.BOLD, 15));
		lblDconnecter.setBounds(10, 80, 130, 14);
		frmPageAdministrateur.getContentPane().add(lblDconnecter);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setToolTipText("Les Commandes");
		lblNewLabel.setIcon(new ImageIcon(Admin.class.getResource("/images/admin_back.png")));
		lblNewLabel.setBounds(0, 0, 944, 621);
		frmPageAdministrateur.getContentPane().add(lblNewLabel);
	}
}
