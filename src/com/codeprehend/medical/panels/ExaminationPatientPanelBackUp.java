package com.codeprehend.medical.panels;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;

public class ExaminationPatientPanelBackUp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExaminationPatientPanelBackUp window = new ExaminationPatientPanelBackUp();
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
	public ExaminationPatientPanelBackUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 813, 516);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel GridBagLayoutPanel = new JPanel();
		GridBagLayoutPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(GridBagLayoutPanel, BorderLayout.CENTER);
		GridBagLayout gbl_GridBagLayoutPanel = new GridBagLayout();
		gbl_GridBagLayoutPanel.columnWidths = new int[] {0};
		gbl_GridBagLayoutPanel.rowHeights = new int[] {0, 0, 0};
		gbl_GridBagLayoutPanel.columnWeights = new double[]{1.0};
		gbl_GridBagLayoutPanel.rowWeights = new double[]{0.15, 0.7, 0.15};
		GridBagLayoutPanel.setLayout(gbl_GridBagLayoutPanel);
		
		JPanel InformationGridBagLayoutPanel =  new JPanel();
		GridBagConstraints gbc_InformationGridBagLayoutPanel = new GridBagConstraints();
		gbc_InformationGridBagLayoutPanel.insets = new Insets(25, 35, 15, 35);
		gbc_InformationGridBagLayoutPanel.weightx = 1.0;
		gbc_InformationGridBagLayoutPanel.fill = GridBagConstraints.BOTH;
		gbc_InformationGridBagLayoutPanel.gridx = 0;
		gbc_InformationGridBagLayoutPanel.gridy = 0;
		GridBagLayoutPanel.add(InformationGridBagLayoutPanel, gbc_InformationGridBagLayoutPanel);
		GridBagLayout gbl_InformationGridBagLayoutPanel = new GridBagLayout();
		gbl_InformationGridBagLayoutPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_InformationGridBagLayoutPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_InformationGridBagLayoutPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_InformationGridBagLayoutPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		InformationGridBagLayoutPanel.setLayout(gbl_InformationGridBagLayoutPanel);
		
		JLabel lblAntet = new JLabel("      ");
		GridBagConstraints gbc_lblAntet = new GridBagConstraints();
		gbc_lblAntet.insets = new Insets(0, 0, 5, 5);
		gbc_lblAntet.gridx = 0;
		gbc_lblAntet.gridy = 0;
		InformationGridBagLayoutPanel.add(lblAntet, gbc_lblAntet);
		
		JLabel NameLabel = new JLabel("Munteanu");
		GridBagConstraints gbc_NameLabel = new GridBagConstraints();
		gbc_NameLabel.weightx = 1.0;
		gbc_NameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_NameLabel.gridx = 0;
		gbc_NameLabel.gridy = 1;
		InformationGridBagLayoutPanel.add(NameLabel, gbc_NameLabel);
		
		JLabel PrenumeLabel = new JLabel("Mihaela");
		GridBagConstraints gbc_PrenumeLabel = new GridBagConstraints();
		gbc_PrenumeLabel.weightx = 1.0;
		gbc_PrenumeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_PrenumeLabel.gridx = 1;
		gbc_PrenumeLabel.gridy = 1;
		InformationGridBagLayoutPanel.add(PrenumeLabel, gbc_PrenumeLabel);
		
		JLabel DataNastereLabel = new JLabel("Data nasterii: 07-05-2018");
		GridBagConstraints gbc_DataNastereLabel = new GridBagConstraints();
		gbc_DataNastereLabel.weightx = 1.0;
		gbc_DataNastereLabel.insets = new Insets(0, 0, 5, 5);
		gbc_DataNastereLabel.anchor = GridBagConstraints.NORTH;
		gbc_DataNastereLabel.gridx = 2;
		gbc_DataNastereLabel.gridy = 1;
		InformationGridBagLayoutPanel.add(DataNastereLabel, gbc_DataNastereLabel);
		
		JLabel CNPLabel = new JLabel("CNP: 283070784270023");
		GridBagConstraints gbc_CNPLabel = new GridBagConstraints();
		gbc_CNPLabel.weightx = 1.0;
		gbc_CNPLabel.insets = new Insets(0, 0, 5, 5);
		gbc_CNPLabel.gridx = 3;
		gbc_CNPLabel.gridy = 1;
		InformationGridBagLayoutPanel.add(CNPLabel, gbc_CNPLabel);
		
		JLabel TelefonLabel = new JLabel("Telefon: 0788567890");
		GridBagConstraints gbc_TelefonLabel = new GridBagConstraints();
		gbc_TelefonLabel.insets = new Insets(0, 0, 5, 0);
		gbc_TelefonLabel.anchor = GridBagConstraints.EAST;
		gbc_TelefonLabel.weightx = 1.0;
		gbc_TelefonLabel.gridx = 4;
		gbc_TelefonLabel.gridy = 1;
		InformationGridBagLayoutPanel.add(TelefonLabel, gbc_TelefonLabel);
		
		JLabel lblNasteriNaturale = new JLabel("Nasteri naturale: 1");
		GridBagConstraints gbc_lblNasteriNaturale = new GridBagConstraints();
		gbc_lblNasteriNaturale.insets = new Insets(0, 0, 0, 5);
		gbc_lblNasteriNaturale.gridx = 0;
		gbc_lblNasteriNaturale.gridy = 2;
		InformationGridBagLayoutPanel.add(lblNasteriNaturale, gbc_lblNasteriNaturale);
		
		JLabel lblCezariene = new JLabel("Cezariene: 1");
		GridBagConstraints gbc_lblCezariene = new GridBagConstraints();
		gbc_lblCezariene.insets = new Insets(0, 0, 0, 5);
		gbc_lblCezariene.gridx = 1;
		gbc_lblCezariene.gridy = 2;
		InformationGridBagLayoutPanel.add(lblCezariene, gbc_lblCezariene);
		
		JLabel lblAvorturiLaCerere = new JLabel("Avorturi la cerere: 0");
		GridBagConstraints gbc_lblAvorturiLaCerere = new GridBagConstraints();
		gbc_lblAvorturiLaCerere.insets = new Insets(0, 0, 0, 5);
		gbc_lblAvorturiLaCerere.gridx = 2;
		gbc_lblAvorturiLaCerere.gridy = 2;
		InformationGridBagLayoutPanel.add(lblAvorturiLaCerere, gbc_lblAvorturiLaCerere);
		
		JLabel lblAvorturiSpontane = new JLabel("Avorturi spontane: 0");
		GridBagConstraints gbc_lblAvorturiSpontane = new GridBagConstraints();
		gbc_lblAvorturiSpontane.insets = new Insets(0, 0, 0, 5);
		gbc_lblAvorturiSpontane.gridx = 3;
		gbc_lblAvorturiSpontane.gridy = 2;
		InformationGridBagLayoutPanel.add(lblAvorturiSpontane, gbc_lblAvorturiSpontane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 25, 5, 25);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		GridBagLayoutPanel.add(scrollPane, gbc_scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setColumnHeaderView(panel);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setRowHeaderView(panel_1);
		
		JPanel medicalInfoPanel = new JPanel();
		scrollPane.setViewportView(medicalInfoPanel);
		GridBagLayout gbl_medicalInfoPanel = new GridBagLayout();
		gbl_medicalInfoPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_medicalInfoPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_medicalInfoPanel.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_medicalInfoPanel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 
				100.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		medicalInfoPanel.setLayout(gbl_medicalInfoPanel);
		
		JLabel AntecedenteLabel = new JLabel("Antecedente 12.12.2019");
		GridBagConstraints gbc_AntecedenteLabel = new GridBagConstraints();
		gbc_AntecedenteLabel.insets = new Insets(0, 0, 5, 5);
		gbc_AntecedenteLabel.anchor = GridBagConstraints.WEST;
		gbc_AntecedenteLabel.gridx = 0;
		gbc_AntecedenteLabel.gridy = 0;
		medicalInfoPanel.add(AntecedenteLabel, gbc_AntecedenteLabel);
		
		JLabel lblAntecendenteInitiale = new JLabel("Antecendente initiale");
		lblAntecendenteInitiale.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblAntecendenteInitiale = new GridBagConstraints();
		gbc_lblAntecendenteInitiale.gridwidth = 5;
		gbc_lblAntecendenteInitiale.anchor = GridBagConstraints.WEST;
		gbc_lblAntecendenteInitiale.insets = new Insets(0, 0, 5, 0);
		gbc_lblAntecendenteInitiale.gridx = 0;
		gbc_lblAntecendenteInitiale.gridy = 1;
		medicalInfoPanel.add(lblAntecendenteInitiale, gbc_lblAntecendenteInitiale);
		
		JLabel label = new JLabel("     ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 2;
		medicalInfoPanel.add(label, gbc_label);
		
		JLabel lblAntecedente = new JLabel("Antecedente 13.12.2019");
		lblAntecedente.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblAntecedente = new GridBagConstraints();
		gbc_lblAntecedente.anchor = GridBagConstraints.WEST;
		gbc_lblAntecedente.insets = new Insets(0, 0, 5, 5);
		gbc_lblAntecedente.gridx = 0;
		gbc_lblAntecedente.gridy = 3;
		medicalInfoPanel.add(lblAntecedente, gbc_lblAntecedente);
		
		JLabel lblAntcedenteNumarulDoi = new JLabel("Antcedente numarul doi pe mai multe randuri, ca label, vedem");
		GridBagConstraints gbc_lblAntcedenteNumarulDoi = new GridBagConstraints();
		gbc_lblAntcedenteNumarulDoi.gridwidth = 5;
		gbc_lblAntcedenteNumarulDoi.anchor = GridBagConstraints.WEST;
		gbc_lblAntcedenteNumarulDoi.insets = new Insets(0, 0, 5, 0);
		gbc_lblAntcedenteNumarulDoi.gridx = 0;
		gbc_lblAntcedenteNumarulDoi.gridy = 4;
		medicalInfoPanel.add(lblAntcedenteNumarulDoi, gbc_lblAntcedenteNumarulDoi);
		
		JButton btnNewButton_3 = new JButton("Atasamente");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 5;
		medicalInfoPanel.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton = new JButton("Ecran principal");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 5;
		medicalInfoPanel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Inapoi");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 5;
		medicalInfoPanel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Modifica Pacient");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 4;
		gbc_btnNewButton_2.gridy = 5;
		medicalInfoPanel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JTextArea textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 5;
		gbc_textArea.insets = new Insets(10, 0, 10, 0);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 6;
		medicalInfoPanel.add(textArea, gbc_textArea);
		
		JLabel lblConsultatie = new JLabel("Consultatie");
		GridBagConstraints gbc_lblConsultatie = new GridBagConstraints();
		gbc_lblConsultatie.anchor = GridBagConstraints.WEST;
		gbc_lblConsultatie.insets = new Insets(0, 0, 10, 5);
		gbc_lblConsultatie.gridx = 0;
		gbc_lblConsultatie.gridy = 7;
		medicalInfoPanel.add(lblConsultatie, gbc_lblConsultatie);
		
		JLabel lblConsultatie_1 = new JLabel("Consultatie 03.02.2017");
		GridBagConstraints gbc_lblConsultatie_1 = new GridBagConstraints();
		gbc_lblConsultatie_1.anchor = GridBagConstraints.WEST;
		gbc_lblConsultatie_1.insets = new Insets(0, 0, 12, 5);
		gbc_lblConsultatie_1.gridx = 0;
		gbc_lblConsultatie_1.gridy = 8;
		medicalInfoPanel.add(lblConsultatie_1, gbc_lblConsultatie_1);
		
		JLabel label_2 = new JLabel("Consultatiile trebuie ordonate descrescator dupa data");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 0);
		gbc_label_2.anchor = GridBagConstraints.WEST;
		gbc_label_2.gridwidth = 5;
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 9;
		medicalInfoPanel.add(label_2, gbc_label_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 10;
		medicalInfoPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 11;
		medicalInfoPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 12;
		medicalInfoPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel label_1 = new JLabel("New label");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 13;
		medicalInfoPanel.add(label_1, gbc_label_1);
		
		JLabel lblConsulatatie = new JLabel("Consulatatie 03.04.2017");
		GridBagConstraints gbc_lblConsulatatie = new GridBagConstraints();
		gbc_lblConsulatatie.anchor = GridBagConstraints.WEST;
		gbc_lblConsulatatie.insets = new Insets(0, 0, 0, 5);
		gbc_lblConsulatatie.gridx = 0;
		gbc_lblConsulatatie.gridy = 14;
		medicalInfoPanel.add(lblConsulatatie, gbc_lblConsulatatie);
		
		JPanel buttonPanel = new JPanel();
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.insets = new Insets(8, 25, 35, 15);
		gbc_buttonPanel.fill = GridBagConstraints.BOTH;
		gbc_buttonPanel.gridx = 0;
		gbc_buttonPanel.gridy = 2;
		GridBagLayoutPanel.add(buttonPanel, gbc_buttonPanel);
		GridBagLayout gbl_buttonPanel = new GridBagLayout();
		gbl_buttonPanel.columnWidths = new int[]{0};
		gbl_buttonPanel.rowHeights = new int[]{0, 0};
		gbl_buttonPanel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		gbl_buttonPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		buttonPanel.setLayout(gbl_buttonPanel);
		
		JButton btnNewButton_7 = new JButton("Inapoi");
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_7.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_7.gridx = 1;
		gbc_btnNewButton_7.gridy = 0;
		buttonPanel.add(btnNewButton_7, gbc_btnNewButton_7);
		
		JButton btnNewButton_6 = new JButton("Ecran principal");
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_6.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_6.gridx = 2;
		gbc_btnNewButton_6.gridy = 0;
		buttonPanel.add(btnNewButton_6, gbc_btnNewButton_6);
		
		JButton btnNewButton_5 = new JButton("Modifica Pacient");
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_5.gridx = 3;
		gbc_btnNewButton_5.gridy = 0;
		buttonPanel.add(btnNewButton_5, gbc_btnNewButton_5);
		
		JButton btnNewButton_4 = new JButton("Atasamente");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_4.gridx = 4;
		gbc_btnNewButton_4.gridy = 0;
		buttonPanel.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnSalveaza = new JButton("SALVEAZA CONSULTATIE");
		btnSalveaza.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btnSalveaza = new GridBagConstraints();
		gbc_btnSalveaza.gridheight = 2;
		gbc_btnSalveaza.gridx = 5;
		gbc_btnSalveaza.gridy = 0;
		buttonPanel.add(btnSalveaza, gbc_btnSalveaza);
	}

}
