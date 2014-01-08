import java.io.File;


public class Singleton {
	private static Singleton _sharedInstance = null;

	int keyLength = 128;
	int mode = 2;
	boolean tableMode = false;
	File sourceFile;
	
	private final int ECB = 1;
	private final int CBC = 2;
	private final int CTR = 3;
	private final int CFBONE = 4;
	private final int CFBEIGHT = 5;
	private final int OFB = 6;
	private final int XTS = 7;
	private final boolean TABLEOFF = false;
	private final boolean TABLEON = true;
	
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
