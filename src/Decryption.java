import java.io.File;


public class Decryption implements Runnable{
	private int keyLength;
	private int mode;
	private boolean tableMode;
	private File sourceFile;
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
	
	public void run() {
		keyLength = instance.getKeyLength();
		mode = instance.getMode();
		tableMode = instance.isTableMode();
		sourceFile = instance.getSourceFile();
		//解密實作程式碼
		if(!TABLEOFF){
			switch(mode){
			case 1:
				
				break;
			case CBC:
				
				break;
				
			case CTR:
				
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
