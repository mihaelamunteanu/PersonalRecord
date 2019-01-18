package com.codeprehend.medical.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.listeners.AccessExamButtonActionListener;
import com.codeprehend.medical.listeners.GoHomeFromExaminationPatientButtonListener;
import com.codeprehend.medical.listeners.ModifyPatientButtonActionListener;
import com.codeprehend.medical.listeners.OpenFileButtonActionListener;
import com.codeprehend.medical.listeners.SaveAttachmentActionPerformed;
import com.codeprehend.medical.resources.Attachement;
import com.codeprehend.medical.resources.Patient;

public class FilesPatientPanel extends JPanel {
	
	/**
	 * Default serial key. 
	 */
	private static final long serialVersionUID = 1L;
	
	private MedicalRecordGUI parentPanel;

	private JTextField browseFileTextField = new JTextField();
	
//	private static final Logger LOGGER = Logger.getLogger(FilesPatientPanel.class.getName());

	public FilesPatientPanel(MedicalRecordGUI parent) {
		super();
		this.setLayout(null);

		this.parentPanel = parent;
		this.setVisible(false);
	}
	
	public void loadFilesForPatientGUIPanel(Patient patient, List<Attachement> attachements) {
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		parentPanel.add(this, BorderLayout.CENTER);
		GridBagLayout gbl_GridBagLayoutPanel = new GridBagLayout();
		gbl_GridBagLayoutPanel.columnWidths = new int[] {0};
		gbl_GridBagLayoutPanel.rowHeights = new int[] {0, 0, 0, 0, 0};
		gbl_GridBagLayoutPanel.columnWeights = new double[]{1.0};
		gbl_GridBagLayoutPanel.rowWeights = new double[]{0.05, 1.0, 0.1, 0.1, 0.1};
		this.setLayout(gbl_GridBagLayoutPanel);
		
		JPanel InformationGridBagLayoutPanel =  new JPanel();
		GridBagConstraints gbc_InformationGridBagLayoutPanel = new GridBagConstraints();
		gbc_InformationGridBagLayoutPanel.insets = new Insets(5, 45, 5, 45);
		gbc_InformationGridBagLayoutPanel.weightx = 1.0;
		gbc_InformationGridBagLayoutPanel.fill = GridBagConstraints.BOTH;
		gbc_InformationGridBagLayoutPanel.gridx = 0;
		gbc_InformationGridBagLayoutPanel.gridy = 0;
		this.add(InformationGridBagLayoutPanel, gbc_InformationGridBagLayoutPanel);
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
		
		JLabel NameLabel = new JLabel(patient.getNume());
		GridBagConstraints gbc_NameLabel = new GridBagConstraints();
		gbc_NameLabel.anchor = GridBagConstraints.WEST;
		gbc_NameLabel.weightx = 1.0;
		gbc_NameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_NameLabel.gridx = 0;
		gbc_NameLabel.gridy = 1;
		InformationGridBagLayoutPanel.add(NameLabel, gbc_NameLabel);
		
		JLabel PrenumeLabel = new JLabel(patient.getPrenume());
		GridBagConstraints gbc_PrenumeLabel = new GridBagConstraints();
		gbc_PrenumeLabel.anchor = GridBagConstraints.WEST;
		gbc_PrenumeLabel.weightx = 1.0;
		gbc_PrenumeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_PrenumeLabel.gridx = 1;
		gbc_PrenumeLabel.gridy = 1;
		InformationGridBagLayoutPanel.add(PrenumeLabel, gbc_PrenumeLabel);
		
		JLabel DataNastereLabel = new JLabel("Data nasterii: " + (patient.getDataNasterii() != null ? patient.getDataNasterii().toString() : ""));
		GridBagConstraints gbc_DataNastereLabel = new GridBagConstraints();
		gbc_DataNastereLabel.weightx = 1.0;
		gbc_DataNastereLabel.insets = new Insets(0, 0, 5, 5);
		gbc_DataNastereLabel.anchor = GridBagConstraints.WEST;
		gbc_DataNastereLabel.gridx = 2;
		gbc_DataNastereLabel.gridy = 1;
		InformationGridBagLayoutPanel.add(DataNastereLabel, gbc_DataNastereLabel);
		
		JLabel CNPLabel = new JLabel("CNP: " + patient.getCnp());
		GridBagConstraints gbc_CNPLabel = new GridBagConstraints();
		gbc_CNPLabel.anchor = GridBagConstraints.WEST;
		gbc_CNPLabel.weightx = 1.0;
		gbc_CNPLabel.insets = new Insets(0, 0, 5, 5);
		gbc_CNPLabel.gridx = 3;
		gbc_CNPLabel.gridy = 1;
		InformationGridBagLayoutPanel.add(CNPLabel, gbc_CNPLabel);
		
		JLabel TelefonLabel = new JLabel("Telefon: " + patient.getNumarTelefon());
		GridBagConstraints gbc_TelefonLabel = new GridBagConstraints();
		gbc_TelefonLabel.insets = new Insets(0, 0, 5, 0);
		gbc_TelefonLabel.anchor = GridBagConstraints.WEST;
		gbc_TelefonLabel.weightx = 1.0;
		gbc_TelefonLabel.gridx = 4;
		gbc_TelefonLabel.gridy = 1;
		InformationGridBagLayoutPanel.add(TelefonLabel, gbc_TelefonLabel);
		
		JLabel lblNasteriNaturale = new JLabel("Nasteri naturale: " + String.valueOf(patient.getNasteriNaturale()));
		GridBagConstraints gbc_lblNasteriNaturale = new GridBagConstraints();
		gbc_lblNasteriNaturale.anchor = GridBagConstraints.WEST;
		gbc_lblNasteriNaturale.insets = new Insets(0, 0, 0, 5);
		gbc_lblNasteriNaturale.gridx = 0;
		gbc_lblNasteriNaturale.gridy = 2;
		InformationGridBagLayoutPanel.add(lblNasteriNaturale, gbc_lblNasteriNaturale);
		
		JLabel lblCezariene = new JLabel("Cezariene: " + String.valueOf(patient.getCezariene()));
		GridBagConstraints gbc_lblCezariene = new GridBagConstraints();
		gbc_lblCezariene.anchor = GridBagConstraints.WEST;
		gbc_lblCezariene.insets = new Insets(0, 0, 0, 5);
		gbc_lblCezariene.gridx = 1;
		gbc_lblCezariene.gridy = 2;
		InformationGridBagLayoutPanel.add(lblCezariene, gbc_lblCezariene);
		
		JLabel lblAvorturiLaCerere = new JLabel("Avorturi la cerere: " + String.valueOf(patient.getAvorturiLaCerere()));
		GridBagConstraints gbc_lblAvorturiLaCerere = new GridBagConstraints();
		gbc_lblAvorturiLaCerere.anchor = GridBagConstraints.WEST;
		gbc_lblAvorturiLaCerere.insets = new Insets(0, 0, 0, 5);
		gbc_lblAvorturiLaCerere.gridx = 2;
		gbc_lblAvorturiLaCerere.gridy = 2;
		InformationGridBagLayoutPanel.add(lblAvorturiLaCerere, gbc_lblAvorturiLaCerere);
		
		JLabel lblAvorturiSpontane = new JLabel("Avorturi spontane: " + String.valueOf(patient.getAvorturiSpontane()));
		GridBagConstraints gbc_lblAvorturiSpontane = new GridBagConstraints();
		gbc_lblAvorturiSpontane.anchor = GridBagConstraints.WEST;
		gbc_lblAvorturiSpontane.insets = new Insets(0, 0, 0, 5);
		gbc_lblAvorturiSpontane.gridx = 3;
		gbc_lblAvorturiSpontane.gridy = 2;
		InformationGridBagLayoutPanel.add(lblAvorturiSpontane, gbc_lblAvorturiSpontane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 45, 5, 45);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		this.add(scrollPane, gbc_scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setColumnHeaderView(panel);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setRowHeaderView(panel_1);
		
		JPanel fileListPanel = new JPanel();
		scrollPane.setViewportView(fileListPanel);
		
		GridBagLayout gbl_fileListPanel = new GridBagLayout();
		gbl_fileListPanel.columnWidths = new int[]{0, 0, 0};
		gbl_fileListPanel.rowHeights = new int[]{0, 0};
		gbl_fileListPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_fileListPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		fileListPanel.setLayout(gbl_fileListPanel);
		
		JList<String> fileList = new JList<String>();
		GridBagConstraints gbc_fileList = new GridBagConstraints();
		gbc_fileList.fill = GridBagConstraints.BOTH;
		gbc_fileList.gridx = 1;
		gbc_fileList.gridy = 0;
		fileListPanel.add(fileList, gbc_fileList);
		
//		final List<Attachement> attachements = AtachementsDAO.getAttachmentsByPatientId(patient.getId());
		
		DefaultListModel<String> DLM = new DefaultListModel<String>();
		for (Attachement attachement: attachements) {
			
			String str = new String ("");
			str = str.concat(attachement.getFileName());
			str = str.concat(".");
			str = str.concat(attachement.getFileType());

			DLM.addElement(str);
		}
		
		fileList.setModel(DLM);
		fileList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		JPanel fileListButtonsPanel = new JPanel();
		GridBagConstraints gbc_fileListButtonsPanel = new GridBagConstraints();
		gbc_fileListButtonsPanel.insets = new Insets(8, 45, 5, 45);
		gbc_fileListButtonsPanel.fill = GridBagConstraints.BOTH;
		gbc_fileListButtonsPanel.gridx = 0;
		gbc_fileListButtonsPanel.gridy = 2;
		this.add(fileListButtonsPanel, gbc_fileListButtonsPanel);
		GridBagLayout gbl_fileListButtonsPanel = new GridBagLayout();
		gbl_fileListButtonsPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_fileListButtonsPanel.rowHeights = new int[]{0, 0};
		gbl_fileListButtonsPanel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0};
		gbl_fileListButtonsPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		fileListButtonsPanel.setLayout(gbl_fileListButtonsPanel);
		
		JButton homeButton = new JButton("Ecran Cautare");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		fileListButtonsPanel.add(homeButton, gbc_btnNewButton);
		
		JButton modifyPatientButton = new JButton("Modifica Pacient");
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_5.gridx = 1;
		gbc_btnNewButton_5.gridy = 0;
		fileListButtonsPanel.add(modifyPatientButton, gbc_btnNewButton_5);
		
		JButton folderAccesButton = new JButton("Acceseaza Consultatii");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 0;
		fileListButtonsPanel.add(folderAccesButton, gbc_btnNewButton_1);
		
		JButton openFileButton = new JButton("Deschide Fisier");
		
		GridBagConstraints gbc_openFile = new GridBagConstraints();
		gbc_openFile.gridx = 3;
		gbc_openFile.gridy = 0;
		fileListButtonsPanel.add(openFileButton, gbc_openFile);
		
		//scroll pane added to have fixed browsing text
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane2 = new GridBagConstraints();
		gbc_scrollPane2.insets = new Insets(0, 45, 5, 45);
		gbc_scrollPane2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane2.gridx = 0;
		gbc_scrollPane2.gridy = 3;
		this.add(scrollPane2, gbc_scrollPane2);
		
		JPanel panel2 = new JPanel();
		scrollPane.setColumnHeaderView(panel2);
		
		JPanel panel2_1 = new JPanel();
		scrollPane.setRowHeaderView(panel2_1);
		
		JPanel browseFilesPanel = new JPanel();
		scrollPane2.setViewportView(browseFilesPanel);
//		
//		GridBagConstraints gbc_browseFilesPanel = new GridBagConstraints();
//		gbc_browseFilesPanel.insets = new Insets(0, 45, 5, 45);
//		gbc_browseFilesPanel.fill = GridBagConstraints.BOTH;
//		gbc_browseFilesPanel.gridx = 0;
//		gbc_browseFilesPanel.gridy = 3;
//		this.add(browseFilesPanel, gbc_browseFilesPanel);
		GridBagLayout gbl_browseFilesPanel = new GridBagLayout();
		gbl_browseFilesPanel.columnWidths = new int[]{0};
		gbl_browseFilesPanel.rowHeights = new int[]{0};
		gbl_browseFilesPanel.columnWeights = new double[]{0.9};
		gbl_browseFilesPanel.rowWeights = new double[]{0.0};
		browseFilesPanel.setLayout(gbl_browseFilesPanel);
		
		browseFileTextField = new JTextField();
		GridBagConstraints gbc_browseField = new GridBagConstraints();
		gbc_browseField.gridx = 0;
		gbc_browseField.gridy = 0;
		browseFileTextField.setColumns(80);
		
		browseFilesPanel.add(browseFileTextField, gbc_browseField);
		
		JPanel browseButtonPanel = new JPanel();
		GridBagConstraints gbc_browseButtonPanel = new GridBagConstraints();
		gbc_browseButtonPanel.insets = new Insets(8, 25, 35, 15);
		gbc_browseButtonPanel.fill = GridBagConstraints.BOTH;
		gbc_browseButtonPanel.gridx = 0;
		gbc_browseButtonPanel.gridy = 4;
		this.add(browseButtonPanel, gbc_browseButtonPanel);
		GridBagLayout gbl_browseButtonPanel = new GridBagLayout();
		gbl_browseButtonPanel.columnWidths = new int[]{0, 0};
		gbl_browseButtonPanel.rowHeights = new int[]{0};
		gbl_browseButtonPanel.columnWeights = new double[]{1.0, 1.0};
		gbl_browseButtonPanel.rowWeights = new double[]{0.0};
		browseButtonPanel.setLayout(gbl_browseButtonPanel);
		
		JButton browseFileButton = new JButton("Cauta Fisier pt Upload");
		GridBagConstraints gbc_searchFile = new GridBagConstraints();
		gbc_searchFile.insets = new Insets(0, 0, 0, 5);
		gbc_searchFile.gridx = 0;
		gbc_searchFile.gridy = 0;
		browseButtonPanel.add(browseFileButton, gbc_searchFile);
		
		JButton saveFilesButton = new JButton("Upload fisier");
		saveFilesButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_btnSalveaza = new GridBagConstraints();
		gbc_btnSalveaza.gridx = 1;
		gbc_btnSalveaza.gridy = 0;
		browseButtonPanel.add(saveFilesButton, gbc_btnSalveaza);
		
		//Action Listeners
		
		modifyPatientButton.addActionListener(new ModifyPatientButtonActionListener(this.parentPanel, patient));
		
		folderAccesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AccessExamButtonActionListener.actionPerformed(parentPanel, patient);
			}
		});
		
		openFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new OpenFileButtonActionListener(parentPanel, attachements.get(fileList.getSelectedIndex()));
			}
		});
		
		homeButton.addActionListener(new GoHomeFromExaminationPatientButtonListener(this.parentPanel));
		
		browseFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser selectFile = new JFileChooser();
				selectFile.setFileSelectionMode(JFileChooser.FILES_ONLY);
				
				selectFile.showOpenDialog(parentPanel);
				
				//TODO add not null or empty validation for files
				browseFileTextField.setText(selectFile.getSelectedFile().toString());
			}
		});
		
		saveFilesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SaveAttachmentActionPerformed.saveAttachmentActionPressed(parentPanel, patient);
			}
		});
	}

	public JTextField getBrowseFileTextField() {
		return browseFileTextField;
	}

}
