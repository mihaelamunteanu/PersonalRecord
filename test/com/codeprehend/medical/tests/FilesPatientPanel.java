package com.codeprehend.medical.tests;

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
import javax.swing.JList;

public class FilesPatientPanel {

	private JFrame frame;
	private JTextField browseField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FilesPatientPanel window = new FilesPatientPanel();
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
	public FilesPatientPanel() {
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
		gbl_GridBagLayoutPanel.rowHeights = new int[] {0, 0, 0, 0, 0};
		gbl_GridBagLayoutPanel.columnWeights = new double[]{1.0};
		gbl_GridBagLayoutPanel.rowWeights = new double[]{0.05, 1.0, 1.0, 1.0, 1.0};
		GridBagLayoutPanel.setLayout(gbl_GridBagLayoutPanel);
		
		JPanel InformationGridBagLayoutPanel =  new JPanel();
		GridBagConstraints gbc_InformationGridBagLayoutPanel = new GridBagConstraints();
		gbc_InformationGridBagLayoutPanel.insets = new Insets(5, 45, 5, 45);
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
		gbc_NameLabel.anchor = GridBagConstraints.WEST;
		gbc_NameLabel.weightx = 1.0;
		gbc_NameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_NameLabel.gridx = 0;
		gbc_NameLabel.gridy = 1;
		InformationGridBagLayoutPanel.add(NameLabel, gbc_NameLabel);
		
		JLabel PrenumeLabel = new JLabel("Mihaela");
		GridBagConstraints gbc_PrenumeLabel = new GridBagConstraints();
		gbc_PrenumeLabel.anchor = GridBagConstraints.WEST;
		gbc_PrenumeLabel.weightx = 1.0;
		gbc_PrenumeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_PrenumeLabel.gridx = 1;
		gbc_PrenumeLabel.gridy = 1;
		InformationGridBagLayoutPanel.add(PrenumeLabel, gbc_PrenumeLabel);
		
		JLabel DataNastereLabel = new JLabel("Data nasterii: 07-05-2018");
		GridBagConstraints gbc_DataNastereLabel = new GridBagConstraints();
		gbc_DataNastereLabel.weightx = 1.0;
		gbc_DataNastereLabel.insets = new Insets(0, 0, 5, 5);
		gbc_DataNastereLabel.anchor = GridBagConstraints.WEST;
		gbc_DataNastereLabel.gridx = 2;
		gbc_DataNastereLabel.gridy = 1;
		InformationGridBagLayoutPanel.add(DataNastereLabel, gbc_DataNastereLabel);
		
		JLabel CNPLabel = new JLabel("CNP: 283070784270023");
		GridBagConstraints gbc_CNPLabel = new GridBagConstraints();
		gbc_CNPLabel.anchor = GridBagConstraints.WEST;
		gbc_CNPLabel.weightx = 1.0;
		gbc_CNPLabel.insets = new Insets(0, 0, 5, 5);
		gbc_CNPLabel.gridx = 3;
		gbc_CNPLabel.gridy = 1;
		InformationGridBagLayoutPanel.add(CNPLabel, gbc_CNPLabel);
		
		JLabel TelefonLabel = new JLabel("Telefon: 0788567890");
		GridBagConstraints gbc_TelefonLabel = new GridBagConstraints();
		gbc_TelefonLabel.insets = new Insets(0, 0, 5, 0);
		gbc_TelefonLabel.anchor = GridBagConstraints.WEST;
		gbc_TelefonLabel.weightx = 1.0;
		gbc_TelefonLabel.gridx = 4;
		gbc_TelefonLabel.gridy = 1;
		InformationGridBagLayoutPanel.add(TelefonLabel, gbc_TelefonLabel);
		
		JLabel lblNasteriNaturale = new JLabel("Nasteri naturale: 1");
		GridBagConstraints gbc_lblNasteriNaturale = new GridBagConstraints();
		gbc_lblNasteriNaturale.anchor = GridBagConstraints.WEST;
		gbc_lblNasteriNaturale.insets = new Insets(0, 0, 0, 5);
		gbc_lblNasteriNaturale.gridx = 0;
		gbc_lblNasteriNaturale.gridy = 2;
		InformationGridBagLayoutPanel.add(lblNasteriNaturale, gbc_lblNasteriNaturale);
		
		JLabel lblCezariene = new JLabel("Cezariene: 1");
		GridBagConstraints gbc_lblCezariene = new GridBagConstraints();
		gbc_lblCezariene.anchor = GridBagConstraints.WEST;
		gbc_lblCezariene.insets = new Insets(0, 0, 0, 5);
		gbc_lblCezariene.gridx = 1;
		gbc_lblCezariene.gridy = 2;
		InformationGridBagLayoutPanel.add(lblCezariene, gbc_lblCezariene);
		
		JLabel lblAvorturiLaCerere = new JLabel("Avorturi la cerere: 0");
		GridBagConstraints gbc_lblAvorturiLaCerere = new GridBagConstraints();
		gbc_lblAvorturiLaCerere.anchor = GridBagConstraints.WEST;
		gbc_lblAvorturiLaCerere.insets = new Insets(0, 0, 0, 5);
		gbc_lblAvorturiLaCerere.gridx = 2;
		gbc_lblAvorturiLaCerere.gridy = 2;
		InformationGridBagLayoutPanel.add(lblAvorturiLaCerere, gbc_lblAvorturiLaCerere);
		
		JLabel lblAvorturiSpontane = new JLabel("Avorturi spontane: 0");
		GridBagConstraints gbc_lblAvorturiSpontane = new GridBagConstraints();
		gbc_lblAvorturiSpontane.anchor = GridBagConstraints.WEST;
		gbc_lblAvorturiSpontane.insets = new Insets(0, 0, 0, 5);
		gbc_lblAvorturiSpontane.gridx = 3;
		gbc_lblAvorturiSpontane.gridy = 2;
		InformationGridBagLayoutPanel.add(lblAvorturiSpontane, gbc_lblAvorturiSpontane);
		
		JPanel fileListPanel = new JPanel();
		GridBagConstraints gbc_fileListPanel = new GridBagConstraints();
		gbc_fileListPanel.insets = new Insets(0, 0, 5, 0);
		gbc_fileListPanel.fill = GridBagConstraints.BOTH;
		gbc_fileListPanel.gridx = 0;
		gbc_fileListPanel.gridy = 1;
		GridBagLayoutPanel.add(fileListPanel, gbc_fileListPanel);
		GridBagLayout gbl_fileListPanel = new GridBagLayout();
		gbl_fileListPanel.columnWidths = new int[]{0, 0, 0};
		gbl_fileListPanel.rowHeights = new int[]{0, 0};
		gbl_fileListPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_fileListPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		fileListPanel.setLayout(gbl_fileListPanel);
		
		JList fileList = new JList();
		GridBagConstraints gbc_fileList = new GridBagConstraints();
		gbc_fileList.fill = GridBagConstraints.BOTH;
		gbc_fileList.gridx = 1;
		gbc_fileList.gridy = 0;
		fileListPanel.add(fileList, gbc_fileList);
		
		JPanel fileListButtonsPanel = new JPanel();
		GridBagConstraints gbc_fileListButtonsPanel = new GridBagConstraints();
		gbc_fileListButtonsPanel.insets = new Insets(0, 0, 5, 0);
		gbc_fileListButtonsPanel.fill = GridBagConstraints.BOTH;
		gbc_fileListButtonsPanel.gridx = 0;
		gbc_fileListButtonsPanel.gridy = 2;
		GridBagLayoutPanel.add(fileListButtonsPanel, gbc_fileListButtonsPanel);
		GridBagLayout gbl_fileListButtonsPanel = new GridBagLayout();
		gbl_fileListButtonsPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_fileListButtonsPanel.rowHeights = new int[]{0, 0};
		gbl_fileListButtonsPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_fileListButtonsPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		fileListButtonsPanel.setLayout(gbl_fileListButtonsPanel);
		
		JButton btnNewButton = new JButton("Ecran Cautare");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		fileListButtonsPanel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_5 = new JButton("Modifica Pacient");
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_5.gridx = 2;
		gbc_btnNewButton_5.gridy = 0;
		fileListButtonsPanel.add(btnNewButton_5, gbc_btnNewButton_5);
		
		JButton btnNewButton_1 = new JButton("Acceseaza Consultatii");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 0;
		fileListButtonsPanel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton openFile = new JButton("Deschide Fisier");
		openFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_openFile = new GridBagConstraints();
		gbc_openFile.gridx = 4;
		gbc_openFile.gridy = 0;
		fileListButtonsPanel.add(openFile, gbc_openFile);
		
		JPanel browseFilesPanel = new JPanel();
		GridBagConstraints gbc_browseFilesPanel = new GridBagConstraints();
		gbc_browseFilesPanel.insets = new Insets(0, 0, 5, 0);
		gbc_browseFilesPanel.fill = GridBagConstraints.BOTH;
		gbc_browseFilesPanel.gridx = 0;
		gbc_browseFilesPanel.gridy = 3;
		GridBagLayoutPanel.add(browseFilesPanel, gbc_browseFilesPanel);
		GridBagLayout gbl_browseFilesPanel = new GridBagLayout();
		gbl_browseFilesPanel.columnWidths = new int[]{0, 0, 0};
		gbl_browseFilesPanel.rowHeights = new int[]{0, 0};
		gbl_browseFilesPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_browseFilesPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		browseFilesPanel.setLayout(gbl_browseFilesPanel);
		
		browseField = new JTextField();
		GridBagConstraints gbc_browseField = new GridBagConstraints();
		gbc_browseField.fill = GridBagConstraints.HORIZONTAL;
		gbc_browseField.gridx = 1;
		gbc_browseField.gridy = 0;
		browseFilesPanel.add(browseField, gbc_browseField);
		browseField.setColumns(10);
		
		JPanel browseButtonPanel = new JPanel();
		GridBagConstraints gbc_browseButtonPanel = new GridBagConstraints();
		gbc_browseButtonPanel.insets = new Insets(8, 25, 35, 15);
		gbc_browseButtonPanel.fill = GridBagConstraints.BOTH;
		gbc_browseButtonPanel.gridx = 0;
		gbc_browseButtonPanel.gridy = 4;
		GridBagLayoutPanel.add(browseButtonPanel, gbc_browseButtonPanel);
		GridBagLayout gbl_browseButtonPanel = new GridBagLayout();
		gbl_browseButtonPanel.columnWidths = new int[]{0};
		gbl_browseButtonPanel.rowHeights = new int[]{0};
		gbl_browseButtonPanel.columnWeights = new double[]{1.0};
		gbl_browseButtonPanel.rowWeights = new double[]{0.0};
		browseButtonPanel.setLayout(gbl_browseButtonPanel);
		
		JButton searchFile = new JButton("Cauta Fisier");
		GridBagConstraints gbc_searchFile = new GridBagConstraints();
		gbc_searchFile.anchor = GridBagConstraints.EAST;
		gbc_searchFile.insets = new Insets(0, 0, 0, 5);
		gbc_searchFile.gridx = 1;
		gbc_searchFile.gridy = 0;
		browseButtonPanel.add(searchFile, gbc_searchFile);
		
		JButton btnSalveaza = new JButton("SALVEAZA FISIER");
		btnSalveaza.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_btnSalveaza = new GridBagConstraints();
		gbc_btnSalveaza.gridheight = 2;
		gbc_btnSalveaza.gridx = 5;
		gbc_btnSalveaza.gridy = 0;
		browseButtonPanel.add(btnSalveaza, gbc_btnSalveaza);
	}

}
