import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.Choice;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
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
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();

		// setup file chooser
		final JFileChooser fileChooser = new JFileChooser();
		frame.setBounds(100, 100, 800, 500);
		fileChooser.setBounds(28, 5, 693, 397);
		fileChooser.setVisible(false);
		frame.getContentPane().add(fileChooser);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnScegliFile = new JButton("SCEGLI FILE");
		btnScegliFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fileChooser.setVisible(true);
				int returnVal = fileChooser.showOpenDialog(aComponent);
				if (e.getSource() == openButton) {
			        int returnVal = fileChooser.showOpenDialog(FileChooserDemo.this);

			        if (returnVal == JFileChooser.APPROVE_OPTION) {
			            File file = fileChooser.getSelectedFile();
			            //This is where a real application would open the file.
			            JOptionPane.showMessageDialog(null, "Opening: " + file.getName() + "." + newline);
			        } else {
			            log.append("Open command cancelled by user." + newline);
			        }
			   } ...
			}
		});
		btnScegliFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnScegliFile.setBounds(313, 376, 165, 48);
		frame.getContentPane().add(btnScegliFile);

	}
	JTextArea textArea = new JTextArea();
	GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
	groupLayout.setHorizontalGroup(
		groupLayout.createParallelGroup(Alignment.TRAILING)
			.addGroup(groupLayout.createSequentialGroup()
				.addContainerGap(12, Short.MAX_VALUE)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 582, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(fileChooser, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addGap(108)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
	);
	groupLayout.setVerticalGroup(
		groupLayout.createParallelGroup(Alignment.LEADING)
			.addGroup(groupLayout.createSequentialGroup()
				.addGap(156)
				.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
				.addGap(45)
				.addComponent(label, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(75)
						.addComponent(fileChooser, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(27)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))))
	);
	frame.getContentPane().setLayout(groupLayout);
}
