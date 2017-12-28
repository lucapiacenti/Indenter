import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JFileChooser;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.miginfocom.swing.MigLayout;
import javax.swing.SpringLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

public class grafica {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					grafica window = new grafica();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public grafica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 624, 435);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setVisible(false);

		JLabel contenutoFile = new JLabel("contenutoFile");
		contenutoFile.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		contenutoFile.setForeground(Color.GREEN);

		JLabel pathFile = new JLabel("pathFile");
		pathFile.setForeground(Color.GREEN);

		JButton btnNewButton = new JButton("INDENTA FILE");
		btnNewButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				fileChooser.setVisible(true);
				int n = fileChooser.showOpenDialog(null);
				String parola = "";
				if (n == JFileChooser.APPROVE_OPTION) {
					File f;
					f = fileChooser.getSelectedFile();
					pathFile.setText("" + f);
					// scrittura su un file
					String path = "" + f;

					char[] in = new char[9999];
					int size = 0;
					try {
						File file = new File(path);
						FileReader fr = new FileReader(file);
						size = fr.read(in);

						System.out.print("Caratteri presenti: " + size + "\n");
						System.out.print("Il contenuto del file è il seguente:\n");

						for (int i = 0; i < size; i++) {
							parola.equals(parola += in[i]);
							// primo criterio di indentazione per spazio
							if (parola.endsWith("  ")) {					
								parola.equals("1");
								JOptionPane.showMessageDialog(null, parola);
							}
							fr.close();
						}
						contenutoFile.setText(parola);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}

		});

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap(24, Short.MAX_VALUE)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(contenutoFile, GroupLayout.PREFERRED_SIZE, 582, GroupLayout.PREFERRED_SIZE)
						.addComponent(fileChooser, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(pathFile)))));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(156)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 25,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(pathFile))
								.addGap(45)
								.addComponent(contenutoFile, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addGap(75).addComponent(fileChooser, GroupLayout.PREFERRED_SIZE, 62,
										GroupLayout.PREFERRED_SIZE)));
		frame.getContentPane().setLayout(groupLayout);

	}
}
