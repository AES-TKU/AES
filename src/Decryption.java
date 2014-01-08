import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JLabel;
import javax.swing.JProgressBar;


public class Decryption implements Runnable{
	private int keyLength;
	private int mode;
	private boolean tableMode;
	private JProgressBar progressBar;
	private JLabel progressLabel;
	private Cipher cipher;
	private SecretKeySpec secretKey;
	private IvParameterSpec ivSpec;
	private FileInputStream fis;
	private FileOutputStream fos;
	private CipherInputStream cis;
	
	private final int ECB = 1;
	private final int CBC = 2;
	private final int CTR = 3;
	private final int CFBONE = 4;
	private final int CFBEIGHT = 5;
	private final int OFB = 6;
	private final int XTS = 7;
	private final boolean TABLEOFF = false;
	private final boolean TABLEON = true;
	
	Singleton instance = Singleton.getSharedInstance();
	public Decryption(JProgressBar pb , JLabel l){
		progressBar = pb;
		progressLabel = l;
	}
	public void run() {
		keyLength = instance.getKeyLength();
		mode = instance.getMode();
		tableMode = instance.isTableMode();
		
		secretKey = new SecretKeySpec(instance.getKey(), "AES");
		//解密實作程式碼
		if(!TABLEOFF){
			switch(mode){
			case ECB:
				
				break;
			case CBC:
				
				break;
				
			case CTR:
				ivSpec = new IvParameterSpec(instance.getIvBytes());
				try {
					progressLabel.setText("正在初始化...");
					progressBar.setValue(10);
					cipher = Cipher.getInstance("AES/CTR/PKCS5PADDING");
					cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				} catch (NoSuchPaddingException e) {
					e.printStackTrace();
				} catch (InvalidKeyException e) {
					e.printStackTrace();
				} catch (InvalidAlgorithmParameterException e) {
					e.printStackTrace();
				}
				try {
					progressLabel.setText("開始加密...");
					progressBar.setValue(25);
					fis = new FileInputStream(instance.getSourceFile().getAbsolutePath());
					cis = new CipherInputStream(fis, cipher);
					fos = new FileOutputStream(instance.getDestinationFile().getAbsolutePath());
					progressBar.setValue(75);
					while (fis.available() > 0) {
			                byte[] buffer = new byte[1024];
			                int length = cis.read(buffer);

			                fos.write(buffer, 0, length);
			        }
					progressBar.setValue(95);
					fos.flush();
	                fos.close();
	                fis.close();
	                cis.close();
	                progressBar.setValue(100);
	                progressLabel.setText("完成");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case CFBONE:
				
				break;
			case CFBEIGHT:
				
				break;
			case OFB:
				
				break;
			case XTS:
				
				break;
			}
		}
	}

}
