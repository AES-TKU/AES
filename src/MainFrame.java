import java.awt.BorderLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainFrame extends JFrame implements ActionListener {
	private Icon mainIcon;
	private MenuBar menuBar;
	private Menu actionMenu , helpMenu;
	private MenuItem encryptionMenuItem , decryptionMenuItem , exitMenuItem;
	private MenuItem aboutMenuItem;
	private JTabbedPane tabbedPane;
	private JLabel copyrightLabel;
	private OperationFrame operationFrame= new OperationFrame();
	private SettingFrame settingFrame = new SettingFrame(this);
	
	MainFrame(){
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
        
		mainIcon = new ImageIcon(this.getClass().getResource("key.png"));
		actionMenu = new Menu("處理");
		encryptionMenuItem = new MenuItem("加密");
		decryptionMenuItem = new MenuItem("解密");
		exitMenuItem = new MenuItem("結束");
		aboutMenuItem = new MenuItem("關於");
		helpMenu = new Menu("說明");
		tabbedPane = new JTabbedPane();
		copyrightLabel = new JLabel("本程式版權宣告，請參閱關於。");
		
		setIconImage(((ImageIcon) mainIcon).getImage());
		
		menuBar = new MenuBar();
		actionMenu.add(encryptionMenuItem);
		actionMenu.add(decryptionMenuItem);
		actionMenu.add(exitMenuItem);
		menuBar.add(actionMenu);
		helpMenu.add(aboutMenuItem);
		menuBar.add(helpMenu);
		setMenuBar(menuBar);
		
		encryptionMenuItem.addActionListener(this);
		decryptionMenuItem.addActionListener(this);
		exitMenuItem.addActionListener(this);
		aboutMenuItem.addActionListener(this);
		
		tabbedPane.add("加/解密",operationFrame);
		tabbedPane.add("設定",settingFrame);
		add(tabbedPane,BorderLayout.CENTER);
		add(copyrightLabel,BorderLayout.SOUTH);
	}
	
	public void setTabbedPane(int n){
		tabbedPane.setSelectedIndex(n);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exitMenuItem)
			System.exit(0);
		if(e.getSource() == aboutMenuItem)
			JOptionPane.showMessageDialog(null,"AES 加/解密程式\n" +
                    "由淡江大學資訊工程學系三年 B 班學生製作\n" +
                    "===========================\n" +
                    "組長: 段爲康\n" +
                    "組員: 盧威宇、江紹瑋\n" +
                    "指導教授: 黃心嘉\n" +
                    "===========================\n" +
                    "著作權 © 2014 段爲康、盧威宇、江紹瑋。版權所有。\n" +
                    "Copyrights © 2014 Wilson Duan, Willy Lu, Jiang. All rights reserved.",
                    "關於本程式",
               JOptionPane.INFORMATION_MESSAGE,mainIcon);;
		
	}
}
