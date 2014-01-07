import java.io.File;


public class Encryption implements Runnable {
	private int keyLength;
	private int mode;
	private boolean tableMode;
	private File sourceFile;
	
Singleton instance = Singleton.getSharedInstance();
	
	public void run() {
		keyLength = instance.getKeyLength();
		mode = instance.getMode();
		tableMode = instance.isTableMode();
		sourceFile = instance.getSourceFile();
		//加密實作程式碼
		
	}
}
