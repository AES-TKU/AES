import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;




public class OperationFrame extends JPanel implements ActionListener{
	private JPanel mainPanel;
	private JPanel radioButtonPanel;
	private JPanel pathPanel;
	private JPanel sourcePanel;
	private JPanel destinationPanel;
	private JPanel progressPanel;
	private JPanel ButtonPanel;
	private ButtonGroup chooseGroup;
	private JRadioButton encryptionRadioButton;
	private JRadioButton decryptionRadioButton;
	private JTextField sourceField;
	private JTextField destinationField;
	private JButton sourceButton;
	private JButton destinationButton;
	private JButton startButton;
	private JButton exitButton;
	private JProgressBar progressBar;
	private JLabel sourceLabel;
	private JLabel destinationLabel;
	private JLabel progressLabel;
	private int mode = 0;
	private final int ENCRYPTION = 1;
	private final int DECRYPTION = 2;

	
	private JFileChooser fileChooser;
	private File sourceFile;
	private File destinationFile;
	private String destinationPath;
	
	public OperationFrame(){
		super();
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		setLayout(new BorderLayout());
		mainPanel = new JPanel(new GridLayout(2,1));
		radioButtonPanel = new JPanel(new GridLayout(1,2));
		
		pathPanel = new JPanel(new GridLayout(2,1));
		sourcePanel = new JPanel(new BorderLayout());
		destinationPanel = new JPanel(new BorderLayout());
		progressPanel = new JPanel(new GridLayout(3,1));
		ButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		chooseGroup = new ButtonGroup();
		encryptionRadioButton = new JRadioButton("�[�K");
		decryptionRadioButton = new JRadioButton("�ѱK");
		
		sourceField = new JTextField();
		destinationField = new JTextField();
		sourceLabel = new JLabel("�ӷ��ɮצ�m�G");
		destinationLabel = new JLabel("�s���ɮצ�m�G");
		sourceButton = new JButton("����ɮ�...");
		destinationButton = new JButton("�t�s�s��...");
		
		startButton = new JButton("�}�l");
		exitButton = new JButton("����");
		
		progressBar = new JProgressBar();
		progressLabel = new JLabel("�N��");
		
		fileChooser = new JFileChooser();
		
		encryptionRadioButton.addActionListener(this);
		decryptionRadioButton.addActionListener(this);
		
		chooseGroup.add(encryptionRadioButton);
		chooseGroup.add(decryptionRadioButton);
		radioButtonPanel.add(encryptionRadioButton);
		radioButtonPanel.add(decryptionRadioButton);
		
		sourcePanel.add(sourceLabel,BorderLayout.NORTH);
		sourcePanel.add(sourceField,BorderLayout.CENTER);
		sourcePanel.add(sourceButton,BorderLayout.EAST);
		
		destinationPanel.add(destinationLabel,BorderLayout.NORTH);
		destinationPanel.add(destinationField,BorderLayout.CENTER);
		destinationPanel.add(destinationButton,BorderLayout.EAST);
		
		pathPanel.add(sourcePanel);
		pathPanel.add(destinationPanel);
		
		ButtonPanel.add(Box.createHorizontalGlue());
		ButtonPanel.add(startButton);
		ButtonPanel.add(exitButton);
		
		startButton.addActionListener(this);
		exitButton.addActionListener(this);
		
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		
		progressPanel.add(progressLabel,BorderLayout.NORTH);
		progressPanel.add(progressBar,BorderLayout.CENTER);
		progressPanel.add(ButtonPanel,BorderLayout.SOUTH);
		
		sourceButton.addActionListener(this);
		destinationButton.addActionListener(this);
		
		mainPanel.add(pathPanel,BorderLayout.CENTER);
		mainPanel.add(progressPanel,BorderLayout.SOUTH);
		
		add(mainPanel,BorderLayout.CENTER);
		add(radioButtonPanel,BorderLayout.NORTH);
	}

	public void setProgressLabelText(String s){
		progressLabel.setText(s);
	}
	
	public void setProgressBarValue(int n){
		progressBar.setValue(n);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == encryptionRadioButton)
			mode = ENCRYPTION;
		if(e.getSource() == decryptionRadioButton)
			mode = DECRYPTION;
		if(e.getSource() == sourceButton){ 
			fileChooser.setDialogTitle("��ܨӷ��ɮ�");
			int returnVal = fileChooser.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				sourceFile = fileChooser.getSelectedFile();
				sourceField.setText(sourceFile.getAbsolutePath());
			}	
		}
		if(e.getSource() == destinationButton){
			fileChooser.setDialogTitle("��ܦs���m�ΦW��");
			int returnVal = fileChooser.showSaveDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				destinationFile = fileChooser.getSelectedFile();;
				destinationField.setText(destinationFile.getAbsolutePath());
			}
		}
		
		if(e.getSource() == startButton){
			if(mode == ENCRYPTION && sourceFile != null && destinationFile != null){
				startButton.setEnabled(false);
				exitButton.setEnabled(false);
				
				new Thread(new Encryption()).start();
				
				startButton.setEnabled(true);
				exitButton.setEnabled(true);
			}

			else if(mode == DECRYPTION && sourceFile != null && destinationFile != null){
				startButton.setEnabled(false);
				exitButton.setEnabled(false);
				
				new Thread(new Decryption()).start();
				
				startButton.setEnabled(true);
				exitButton.setEnabled(true);
			}
				
			else{
				String errorMessage = "";
				if(mode != ENCRYPTION && mode!= DECRYPTION)
					errorMessage += " - �S����ܾާ@�覡\n";
				if(sourceFile == null)
					errorMessage += " - �S���ӷ��ɮ�\n";
				if(destinationFile == null)
					errorMessage += " - �S���s����|\n";
				JOptionPane.showMessageDialog(null, "�L�k����ʧ@�C�иѨM�H�U���D��A�~��G\n" + errorMessage, "AES �[/�ѱK�{��",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(e.getSource() == exitButton){
			System.exit(0);
		}
	}

}
