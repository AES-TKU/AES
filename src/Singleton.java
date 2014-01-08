import java.io.File;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class Singleton {
	private static Singleton _sharedInstance = null;

	int keyLength = 128;
	int mode = 2;
	boolean tableMode = false;
	File sourceFile;
	File destinationFile;
	
	byte[] key= new byte[] { (byte) 0x36, (byte) 0xf1, (byte) 0x83,
							 (byte) 0x57, (byte) 0xbe, (byte) 0x4d, (byte) 0xbd,
							 (byte) 0x77, (byte) 0xf0, (byte) 0x50, (byte) 0x51,
							 (byte) 0x5c, (byte) 0x73, (byte) 0xfc, (byte) 0xf9, (byte) 0xf2 };
	
	byte[] ivBytes = new byte[] { (byte) 0x69, (byte) 0xdd, (byte) 0xa8,
								  (byte) 0x45, (byte) 0x5c, (byte) 0x7d, (byte) 0xd4,
								  (byte) 0x25, (byte) 0x4b, (byte) 0xf3, (byte) 0x53,
								  (byte) 0xb7, (byte) 0x73, (byte) 0x30, (byte) 0x4e, (byte) 0xec };
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
	
	public File getSourceFile() {
		return sourceFile;
	}

	public void setSourceFile(File sourceFile) {
		this.sourceFile = sourceFile;
	}

	public File getDestinationFile() {
		return destinationFile;
	}

	public void setDestinationFile(File destinationFile) {
		this.destinationFile = destinationFile;
	}

	public byte[] getKey() {
		return key;
	}

	public void setKey(byte[] key) {
		this.key = key;
	}
	
	public byte[] getIvBytes() {
		return ivBytes;
	}

	public void setIvBytes(byte[] ivBytes) {
		this.ivBytes = ivBytes;
	}

	public static Singleton getSharedInstance()
    {
        if(_sharedInstance == null)
        {
            _sharedInstance = new Singleton();
        }
        
        return _sharedInstance;
    }

	private Singleton()
    {
        super();
    }
	
}
