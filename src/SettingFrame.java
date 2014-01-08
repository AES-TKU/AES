import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class SettingFrame extends JPanel implements ActionListener {
	Singleton instance = Singleton.getSharedInstance();
	
	private JPanel mainPanel;
	private JPanel keyBitPanel;
	private JPanel keyBitButtonPanel;
	private JPanel modePanel;
	private JPanel modeButtonPanel;
	private JPanel tablePanel;
	private JPanel tableButtonPanel;
	private JPanel ButtonPanel;
	
	private JLabel keyBitLabel;
	private JLabel modeLabel;
	private JLabel tableLabel;
	
	private ButtonGroup keyBitButtonGroup;
	private ButtonGroup modeButtonGroup;
	private ButtonGroup tableButtonGroup;
	
	private JRadioButton oneTwoEightBitKeyRadioButton;
	private JRadioButton oneNineTwoBitKeyRadioButton;
	private JRadioButton twoFiveSixBitKeyRadioButton;
	
	private JRadioButton ECBRadioButton;
	private JRadioButton CBCRadioButton;
	private JRadioButton CTRRadioButton;
	private JRadioButton CFB1RadioButton;
	private JRadioButton CFB8RadioButton;
	private JRadioButton OFBRadioButton;
	private JRadioButton XTSRadioButton;
	
	private JRadioButton tableOnRadioButton;
	private JRadioButton tableOffRadioButton;
	private JButton saveButton;
	private JButton cancelButton;
	
	private int keyLength = 128;
	private int mode = 2;
	private boolean tableMode = false;
	private final int ECB = 1;
	private final int CBC = 2;
	private final int CTR = 3;
	private final int CFBONE = 4;
	private final int CFBEIGHT = 5;
	private final int OFB = 6;
	private final int XTS = 7;
	private final boolean TABLEOFF = false;
	private final boolean TABLEON = true;
	
	private MainFrame mainFrame;
	
	SettingFrame(MainFrame m){
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
		
		mainFrame = m;
		setLayout(new BorderLayout());
		mainPanel = new JPanel(new GridLayout(4,1));
		keyBitPanel = new JPanel(new BorderLayout());
		keyBitButtonPanel = new JPanel(new GridLayout(1,3));
		modePanel = new JPanel(new BorderLayout());
		modeButtonPanel = new JPanel(new GridLayout(2,4));
		tablePanel = new JPanel(new BorderLayout());
		tableButtonPanel = new JPanel(new GridLayout(1,2));
		ButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		keyBitLabel = new JLabel("Secret Key 長度：");
		modeLabel = new JLabel("AES 模式：");
		tableLabel = new JLabel("查表模式：");
		
		keyBitButtonGroup = new ButtonGroup();
		modeButtonGroup = new ButtonGroup();
		tableButtonGroup = new ButtonGroup();
		
		oneTwoEightBitKeyRadioButton = new JRadioButton("128 bits");
		oneNineTwoBitKeyRadioButton = new JRadioButton("192 bits");
		twoFiveSixBitKeyRadioButton = new JRadioButton("256 bits");
		oneTwoEightBitKeyRadioButton.setSelected(true);
		
		keyBitButtonGroup.add(oneTwoEightBitKeyRadioButton);
		keyBitButtonGroup.add(oneNineTwoBitKeyRadioButton);
		keyBitButtonGroup.add(twoFiveSixBitKeyRadioButton);
		
		keyBitButtonPanel.add(oneTwoEightBitKeyRadioButton);
		keyBitButtonPanel.add(oneNineTwoBitKeyRadioButton);
		keyBitButtonPanel.add(twoFiveSixBitKeyRadioButton);
		
		oneTwoEightBitKeyRadioButton.addActionListener(this);
		oneNineTwoBitKeyRadioButton.addActionListener(this);
		twoFiveSixBitKeyRadioButton.addActionListener(this);
		
		keyBitPanel.add(keyBitLabel,BorderLayout.NORTH);
		keyBitPanel.add(keyBitButtonPanel,BorderLayout.CENTER);
		
		ECBRadioButton = new JRadioButton("ECB");
		CBCRadioButton = new JRadioButton("CBC");
		CTRRadioButton = new JRadioButton("CTR");
		CFB1RadioButton = new JRadioButton("CFB-1");
		CFB8RadioButton = new JRadioButton("CFB-8");
		OFBRadioButton = new JRadioButton("OFB");
		XTSRadioButton = new JRadioButton("XTS");
		ECBRadioButton.setSelected(true);
		
		modeButtonGroup.add(ECBRadioButton);
		modeButtonGroup.add(CBCRadioButton);
		modeButtonGroup.add(CTRRadioButton);
		modeButtonGroup.add(CFB1RadioButton);
		modeButtonGroup.add(CFB8RadioButton);
		modeButtonGroup.add(OFBRadioButton);
		modeButtonGroup.add(XTSRadioButton);
		
		modeButtonPanel.add(ECBRadioButton);
		modeButtonPanel.add(CBCRadioButton);
		modeButtonPanel.add(CTRRadioButton);
		modeButtonPanel.add(CFB1RadioButton);
		modeButtonPanel.add(CFB8RadioButton);
		modeButtonPanel.add(OFBRadioButton);
		modeButtonPanel.add(XTSRadioButton);
		
		ECBRadioButton.addActionListener(this);
		CBCRadioButton.addActionListener(this);
		CTRRadioButton.addActionListener(this);
		CFB1RadioButton.addActionListener(this);
		CFB8RadioButton.addActionListener(this);
		OFBRadioButton.addActionListener(this);
		XTSRadioButton.addActionListener(this);
		
		modePanel.add(modeLabel,BorderLayout.NORTH);
		modePanel.add(modeButtonPanel,BorderLayout.CENTER);
		
		tableOnRadioButton = new JRadioButton("開");
		tableOffRadioButton = new JRadioButton("關");
		tableOffRadioButton.setSelected(true);
		
		tableButtonGroup.add(tableOnRadioButton);
		tableButtonGroup.add(tableOffRadioButton);
		
		tableButtonPanel.add(tableOnRadioButton);
		tableButtonPanel.add(tableOffRadioButton);
		
		tableOnRadioButton.addActionListener(this);;
		tableOffRadioButton.addActionListener(this);
		
		tablePanel.add(tableLabel,BorderLayout.NORTH);
		tablePanel.add(tableButtonPanel,BorderLayout.CENTER);
		
		saveButton = new JButton("確定");
		cancelButton = new JButton("恢復預設");
		
		ButtonPanel.add(cancelButton);
		ButtonPanel.add(saveButton);
		
		saveButton.addActionListener(this);
		cancelButton.addActionListener(this);
		
		mainPanel.add(keyBitPanel);
		mainPanel.add(modePanel);
		mainPanel.add(tablePanel);
		mainPanel.add(ButtonPanel);
		
		add(mainPanel);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == oneTwoEightBitKeyRadioButton)
			keyLength = 128;
		else if(e.getSource() == oneNineTwoBitKeyRadioButton)
			keyLength = 192;
		else if(e.getSource() == twoFiveSixBitKeyRadioButton)
			keyLength = 256;
		
		if(e.getSource() == ECBRadioButton)
			mode = ECB;
		else if(e.getSource() == CBCRadioButton)
			mode = CBC;
		else if(e.getSource() == CTRRadioButton)
			mode = CTR;
		else if(e.getSource() == CFB1RadioButton)
			mode = CFBONE;
		else if(e.getSource() == CFB8RadioButton)
			mode = CFBEIGHT;
		else if(e.getSource() == OFBRadioButton)
			mode = OFB;
		else if(e.getSource() == XTSRadioButton)
			mode = XTS;
		
		if(e.getSource() == tableOffRadioButton)
			tableMode = TABLEOFF;
		else if(e.getSource() == tableOnRadioButton)
			tableMode = TABLEON;
		
		if(e.getSource() == saveButton){
			instance.setKeyLength(keyLength);
			instance.setMode(mode);
			instance.setTableMode(tableMode);
			mainFrame.setTabbedPane(0);
		}
			
		if(e.getSource() == cancelButton){
			oneTwoEightBitKeyRadioButton.setSelected(true);
			oneNineTwoBitKeyRadioButton.setSelected(false);
			twoFiveSixBitKeyRadioButton.setSelected(false);
			
			ECBRadioButton.setSelected(true);
			CBCRadioButton.setSelected(false);
			CTRRadioButton.setSelected(false);
			CFB1RadioButton.setSelected(false);
			CFB8RadioButton.setSelected(false);
			OFBRadioButton.setSelected(false);
			XTSRadioButton.setSelected(false);
			
			tableOffRadioButton.setSelected(true);
			tableOnRadioButton.setSelected(false);
			keyLength = 128;
			mode = ECB;
			tableMode = TABLEOFF;
		}
	}
}
