import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class LouerVoiture {

	private JFrame frmLesMarques;

	/**
	 * Launch the application.
	 */
	public static void NvLouerVoiture() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LouerVoiture window = new LouerVoiture();
					window.frmLesMarques.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LouerVoiture() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLesMarques = new JFrame();
		frmLesMarques.setTitle("Les Marques");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int w =950;
		int h = 650;
		int xPos = (dim.width / 2) - (w / 2);
		int yPos = (dim.height / 2) - (h / 2);
		frmLesMarques.setBounds(xPos, yPos, w, h);
		frmLesMarques.getContentPane().setLayout(null);
		
		JLabel Renault = new JLabel("");
		Renault.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Renault r = new Renault();
				r.NvRenault();
			}
		});
		Renault.setIcon(new ImageIcon(LouerVoiture.class.getResource("/images/renault.png")));
		Renault.setBounds(200, 100, 130, 130);
		frmLesMarques.getContentPane().add(Renault);
		
		JLabel Toyota = new JLabel("");
		Toyota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Toyota t = new Toyota();
				t.NvToyota();
			}
		});
		Toyota.setIcon(new ImageIcon(LouerVoiture.class.getResource("/images/toyota.png")));
		Toyota.setBounds(400, 100, 130, 130);
		frmLesMarques.getContentPane().add(Toyota);
		
		JLabel Citroen = new JLabel("");
		Citroen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Citroen c = new Citroen();
				c.NvCitroen();
			}
		});
		Citroen.setIcon(new ImageIcon(LouerVoiture.class.getResource("/images/citroen.png")));
		Citroen.setBounds(600, 100, 130, 130);
		frmLesMarques.getContentPane().add(Citroen);
		
		JLabel Fiat = new JLabel("");
		Fiat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Fiat f = new Fiat();
				f.NvFiat();
			}
		});
		Fiat.setIcon(new ImageIcon(LouerVoiture.class.getResource("/images/fiat.png")));
		Fiat.setBounds(200, 350, 130, 130);
		frmLesMarques.getContentPane().add(Fiat);
		
		JLabel Kia = new JLabel("");
		Kia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Kia k = new Kia();
				k.NvKia();
			}
		});
		Kia.setIcon(new ImageIcon(LouerVoiture.class.getResource("/images/kia.png")));
		Kia.setBounds(400, 350, 130, 130);
		frmLesMarques.getContentPane().add(Kia);
		
		JLabel Peugeot = new JLabel("");
		Peugeot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Peugeot p = new Peugeot();
				p.NvPeugeot();
			}
		});
		Peugeot.setIcon(new ImageIcon(LouerVoiture.class.getResource("/images/peugeot.png")));
		Peugeot.setBounds(600, 350, 130, 130);
		frmLesMarques.getContentPane().add(Peugeot);
		
		JLabel lblReneult = new JLabel("Renault");
		lblReneult.setHorizontalAlignment(SwingConstants.CENTER);
		lblReneult.setForeground(SystemColor.textHighlight);
		lblReneult.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 20));
		lblReneult.setBounds(225, 241, 83, 26);
		frmLesMarques.getContentPane().add(lblReneult);
		
		JLabel lblToyota = new JLabel("Toyota");
		lblToyota.setHorizontalAlignment(SwingConstants.CENTER);
		lblToyota.setForeground(SystemColor.textHighlight);
		lblToyota.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 20));
		lblToyota.setBounds(423, 241, 83, 26);
		frmLesMarques.getContentPane().add(lblToyota);
		
		JLabel lblCitroen = new JLabel("Citroen");
		lblCitroen.setHorizontalAlignment(SwingConstants.CENTER);
		lblCitroen.setForeground(SystemColor.textHighlight);
		lblCitroen.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 20));
		lblCitroen.setBounds(623, 241, 83, 26);
		frmLesMarques.getContentPane().add(lblCitroen);
		
		JLabel lblPeugeot = new JLabel("Peugeot");
		lblPeugeot.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeugeot.setForeground(SystemColor.textHighlight);
		lblPeugeot.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 20));
		lblPeugeot.setBounds(623, 491, 83, 29);
		frmLesMarques.getContentPane().add(lblPeugeot);
		
		JLabel lblKia = new JLabel("Kia");
		lblKia.setHorizontalAlignment(SwingConstants.CENTER);
		lblKia.setForeground(SystemColor.textHighlight);
		lblKia.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 20));
		lblKia.setBounds(423, 494, 83, 26);
		frmLesMarques.getContentPane().add(lblKia);
		
		JLabel lblFiat = new JLabel("Fiat");
		lblFiat.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiat.setForeground(SystemColor.textHighlight);
		lblFiat.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 20));
		lblFiat.setBounds(225, 494, 83, 26);
		frmLesMarques.getContentPane().add(lblFiat);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(LouerVoiture.class.getResource("/images/back.png")));
		button.setBounds(0, 0, 44, 39);
		frmLesMarques.getContentPane().add(button);
		
		JLabel lblRetour = new JLabel("Retour");
		lblRetour.setHorizontalAlignment(SwingConstants.CENTER);
		lblRetour.setForeground(SystemColor.textHighlight);
		lblRetour.setFont(new Font("Dialog", Font.BOLD, 20));
		lblRetour.setBounds(50, 0, 83, 39);
		frmLesMarques.getContentPane().add(lblRetour);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LouerVoiture.class.getResource("/images/flat-black-wallpaper.jpg")));
		label.setBounds(0, 0, 944, 611);
		frmLesMarques.getContentPane().add(label);
	}

	protected Citroen Citroen() {
		// TODO Auto-generated method stub
		return null;
	}

	protected Toyota Toyota() {
		// TODO Auto-generated method stub
		return null;
	}

	protected Renault Renault() {
		// TODO Auto-generated method stub
		return null;
	}
}
