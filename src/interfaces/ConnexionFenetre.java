package interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import main.DatabaseConnection;
import models.Conseiller;

import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConnexionFenetre extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldLogin;
	private JPasswordField textFieldPassword;
	
	private void connectUser(Conseiller user) {
		DatabaseConnection app = new DatabaseConnection();
		app.connect();
	}
	
	public ConnexionFenetre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setPreferredSize(new Dimension(800, 500));
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 400, 463);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel backgroundConnexion = new JLabel("");
		backgroundConnexion.setBounds(0, 0, 534, 314);
		panel.add(backgroundConnexion);
		backgroundConnexion.setVerticalAlignment(SwingConstants.TOP);
		backgroundConnexion.setIcon(new ImageIcon(ConnexionFenetre.class.getResource("/images/connexion.jpg")));
		
		JLabel lblConnexion = new JLabel("Connexion");
		lblConnexion.setFont(new Font("Dialog", Font.BOLD, 20));
		lblConnexion.setForeground(Color.WHITE);
		lblConnexion.setBounds(125, 365, 135, 43);
		panel.add(lblConnexion);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conseiller user = new Conseiller(textFieldLogin.getText(), String.valueOf(textFieldPassword.getPassword()));
				connectUser(user);
			}
		});
		btnConnexion.setForeground(Color.WHITE);
		btnConnexion.setBackground(new Color(241, 57, 83));
		btnConnexion.setBounds(446, 316, 299, 34);
		getContentPane().add(btnConnexion);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(446, 143, 299, 34);
		getContentPane().add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(446, 221, 299, 34);
		getContentPane().add(textFieldPassword);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(446, 116, 70, 15);
		getContentPane().add(lblLogin);
		
		JLabel lblPassword = new JLabel("Mot de passe");
		lblPassword.setBounds(446, 194, 111, 15);
		getContentPane().add(lblPassword);
	}
}
