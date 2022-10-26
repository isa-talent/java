import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class temperature extends JFrame {

	private JPanel contentPane;
	private JTextField celtxt;
	private JTextField fahtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					temperature frame = new temperature();
					frame.setVisible(true);
					frame.setTitle("Temperature Converter");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public temperature() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(10, 11, 414, 239);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblHeader = new JLabel("Temperature Converter");
		lblHeader.setForeground(Color.BLUE);
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblHeader.setBounds(53, 11, 291, 35);
		panel.add(lblHeader);

		celtxt = new JTextField();
		celtxt.setFont(new Font("Tahoma", Font.BOLD, 15));
		celtxt.setBounds(10, 106, 197, 35);
		panel.add(celtxt);
		celtxt.setColumns(10);

		fahtxt = new JTextField();
		fahtxt.setFont(new Font("Tahoma", Font.BOLD, 15));
		fahtxt.setColumns(10);
		fahtxt.setBounds(10, 193, 197, 35);
		panel.add(fahtxt);

		JLabel lblCelcius = new JLabel("Celsius");
		lblCelcius.setForeground(Color.RED);
		lblCelcius.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblCelcius.setBounds(53, 68, 78, 27);
		panel.add(lblCelcius);

		JLabel lblFarenheit = new JLabel("Fahrenheit");
		lblFarenheit.setForeground(Color.RED);
		lblFarenheit.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblFarenheit.setBounds(53, 155, 117, 27);
		panel.add(lblFarenheit);

		JButton btnCalculateC = new JButton("Calculate");
		btnCalculateC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String cel = celtxt.getText();
					double d = Double.parseDouble(cel);

					double celsius = ((d*1.8)+32);
					String str = String.valueOf(celsius);
					fahtxt.setText(str);
				}catch(Exception ec) {
					String num = null;
					JOptionPane.showMessageDialog(contentPane, "Enter numbers only", num, JOptionPane.ERROR_MESSAGE);
					fahtxt.setText(null);
					celtxt.setText(null);
				}
			}
		});
		btnCalculateC.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCalculateC.setForeground(Color.BLUE);
		btnCalculateC.setBounds(286, 106, 97, 35);
		panel.add(btnCalculateC);

		JButton btnCalculateF = new JButton("Calculate");
		btnCalculateF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String fah = fahtxt.getText();
					double d = Double.parseDouble(fah);

					double fahrenheit = ((d-32)*1.8);
					String str = String.valueOf(fahrenheit);
					celtxt.setText(str);
				}catch(Exception ex) {
					String num = null;
					JOptionPane.showMessageDialog(contentPane, "Enter numbers only", num, JOptionPane.ERROR_MESSAGE);
					fahtxt.setText(null);
					celtxt.setText(null);
				}
			}
		});
		btnCalculateF.setForeground(Color.BLACK);
		btnCalculateF.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCalculateF.setBounds(286, 193, 97, 35);
		panel.add(btnCalculateF);

		JButton btnclear_1 = new JButton("X");
		btnclear_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fahtxt.setText(null);
				celtxt.setText(null);			}
		});
		btnclear_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnclear_1.setForeground(Color.RED);
		btnclear_1.setBounds(224, 106, 52, 35);
		panel.add(btnclear_1);

		JButton btnclear = new JButton("X");
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fahtxt.setText(null);
				celtxt.setText(null);

			}
		});
		btnclear.setForeground(Color.RED);
		btnclear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnclear.setBounds(224, 193, 52, 35);
		panel.add(btnclear);
	}

}
