import java.io.File;


public class Singleton {
	private static Singleton _sharedInstance = null;

	int keyLength = 128;
	int mode = 2;
	boolean tableMode = false;
	File sourceFile;
	
	private static int ECB = 1;
	private static int CBC = 2;
	private static int CTR = 3;
	private static int CFBONE = 4;
	private static int CFBEIGHT = 5;
	private static int OFB = 6;
	private static int XTS = 7;
	private static boolean TABLEOFF = false;
	private static boolean TABLEON = true;
	
	public int getKeyLength() {
		return keyLength;
	}

	public void setKeyLength(int keyLength) {
		this.keyLength = keyLength;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public boolean isTableMode() {
		return tableMode;
	}

	public void setTableMode(boolean tableMode) {
		this.tableMode = tableMode;
	}

	public static Singleton getSharedInstance()
    {
        if(_sharedInstance == null)
        {
            _sharedInstance = new Singleton();
        }
        
        return _sharedInstance;
    }
	
	public File getSourceFile() {
		return sourceFile;
	}

	public void setSourceFile(File sourceFile) {
		this.sourceFile = sourceFile;
	}

	private Singleton()
    {
        super();
    }
	
}
