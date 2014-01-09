import java.io.File;


public class Singleton {
	private static Singleton _sharedInstance = null;

	int keyLength = 128;
	int mode = 1;
	boolean tableMode = false;
	File sourceFile;
	File destinationFile;
	
	byte[] key= new byte[] { (byte) 0x66, (byte) 0xE9, (byte) 0x4B, (byte) 0xD4,
            (byte) 0xEF, (byte) 0x8A, (byte) 0x2C, (byte) 0x3B,
            (byte) 0x88, (byte) 0x4C, (byte) 0xFA, (byte) 0x59,
            (byte) 0xCA, (byte) 0x34, (byte) 0x2B, (byte) 0x2E,
            (byte) 0x66, (byte) 0xE9, (byte) 0x4B, (byte) 0xD4,
            (byte) 0xEF, (byte) 0x8A, (byte) 0x2C, (byte) 0x3B,
            (byte) 0x88, (byte) 0x4C, (byte) 0xFA, (byte) 0x59,
            (byte) 0xCA, (byte) 0x34, (byte) 0x2B, (byte) 0x2E,
//            (byte) 0x66, (byte) 0xE9, (byte) 0x4B, (byte) 0xD4,
//            (byte) 0xEF, (byte) 0x8A, (byte) 0x2C, (byte) 0x3B,
//            (byte) 0x88, (byte) 0x4C, (byte) 0xFA, (byte) 0x59,
//            (byte) 0xCA, (byte) 0x34, (byte) 0x2B, (byte) 0x2E,
//            (byte) 0xE7, (byte) 0x77, (byte) 0xB9, (byte) 0x8D,
//            (byte) 0xD2, (byte) 0x8A, (byte) 0x40, (byte) 0x71,
//            (byte) 0xA0, (byte) 0xC9, (byte) 0x48, (byte) 0x21,
//            (byte) 0xB7, (byte) 0xA1, (byte) 0xA4, (byte) 0xD1,

//            (byte) 0x66, (byte) 0xE9, (byte) 0x4B, (byte) 0xD4,
//            (byte) 0xEF, (byte) 0x8A, (byte) 0x2C, (byte) 0x3B,
//            (byte) 0x88, (byte) 0x4C, (byte) 0xFA, (byte) 0x59,
//            (byte) 0xCA, (byte) 0x34, (byte) 0x2B, (byte) 0x2E,
//            (byte) 0x66, (byte) 0xE9, (byte) 0x4B, (byte) 0xD4,
//            (byte) 0xEF, (byte) 0x8A, (byte) 0x2C, (byte) 0x3B,
//            (byte) 0x88, (byte) 0x4C, (byte) 0xFA, (byte) 0x59,
//            (byte) 0xCA, (byte) 0x34, (byte) 0x2B, (byte) 0x2E,
//            (byte) 0x66, (byte) 0xE9, (byte) 0x4B, (byte) 0xD4,
//            (byte) 0xEF, (byte) 0x8A, (byte) 0x2C, (byte) 0x3B,
//            (byte) 0x88, (byte) 0x4C, (byte) 0xFA, (byte) 0x59,
//            (byte) 0xCA, (byte) 0x34, (byte) 0x2B, (byte) 0x2E,
//            (byte) 0xE7, (byte) 0x77, (byte) 0xB9, (byte) 0x8D,
//            (byte) 0xD2, (byte) 0x8A, (byte) 0x40, (byte) 0x71,
//            (byte) 0xA0, (byte) 0xC9, (byte) 0x48, (byte) 0x21,
//            (byte) 0xB7, (byte) 0xA1, (byte) 0xA4, (byte) 0xD1,

//            (byte) 0xE1, (byte) 0x4D, (byte) 0x5D, (byte) 0x0E,
//            (byte) 0xE2, (byte) 0x77, (byte) 0x15, (byte) 0xDF,
//            (byte) 0x08, (byte) 0xB4, (byte) 0x15, (byte) 0x2B,
//            (byte) 0xA2, (byte) 0x3D, (byte) 0xA8, (byte) 0xE0,
//            (byte) 0xE1, (byte) 0x4D, (byte) 0x5D, (byte) 0x0E,
//            (byte) 0xE2, (byte) 0x77, (byte) 0x15, (byte) 0xDF,
//            (byte) 0x08, (byte) 0xB4, (byte) 0x15, (byte) 0x2B,
//            (byte) 0xA2, (byte) 0x3D, (byte) 0xA8, (byte) 0xE0,
//            (byte) 0xE1, (byte) 0x4D, (byte) 0x5D, (byte) 0x0E,
//            (byte) 0xE2, (byte) 0x77, (byte) 0x15, (byte) 0xDF,
//            (byte) 0x08, (byte) 0xB4, (byte) 0x15, (byte) 0x2B,
//            (byte) 0xA2, (byte) 0x3D, (byte) 0xA8, (byte) 0xE0,
//            (byte) 0x0D, (byte) 0x1D, (byte) 0x0D, (byte) 0xD8,
//            (byte) 0x85, (byte) 0xEA, (byte) 0xD1, (byte) 0x6A,
//            (byte) 0x83, (byte) 0xA1, (byte) 0x8F, (byte) 0x0A,
//            (byte) 0xA5, (byte) 0x17, (byte) 0xD4, (byte) 0x4C,

//            (byte) 0xE1, (byte) 0x4D, (byte) 0x5D, (byte) 0x0E,
//            (byte) 0xE2, (byte) 0x77, (byte) 0x15, (byte) 0xDF,
//            (byte) 0x08, (byte) 0xB4, (byte) 0x15, (byte) 0x2B,
//            (byte) 0xA2, (byte) 0x3D, (byte) 0xA8, (byte) 0xE0,
//            (byte) 0xE1, (byte) 0x4D, (byte) 0x5D, (byte) 0x0E,
//            (byte) 0xE2, (byte) 0x77, (byte) 0x15, (byte) 0xDF,
//            (byte) 0x08, (byte) 0xB4, (byte) 0x15, (byte) 0x2B,
//            (byte) 0xA2, (byte) 0x3D, (byte) 0xA8, (byte) 0xE0,
//            (byte) 0xE1, (byte) 0x4D, (byte) 0x5D, (byte) 0x0E,
//            (byte) 0xE2, (byte) 0x77, (byte) 0x15, (byte) 0xDF,
//            (byte) 0x08, (byte) 0xB4, (byte) 0x15, (byte) 0x2B,
//            (byte) 0xA2, (byte) 0x3D, (byte) 0xA8, (byte) 0xE0,
//            (byte) 0x0D, (byte) 0x1D, (byte) 0x0D, (byte) 0xD8,
//            (byte) 0x85, (byte) 0xEA, (byte) 0xD1, (byte) 0x6A,
//            (byte) 0x83, (byte) 0xA1, (byte) 0x8F, (byte) 0x0A,
//            (byte) 0xA5, (byte) 0x17, (byte) 0xD4, (byte) 0x4C,

//            (byte) 0x5E, (byte) 0xBA, (byte) 0x73, (byte) 0xF8,
//            (byte) 0x91, (byte) 0x42, (byte) 0xC5, (byte) 0x48,
//            (byte) 0x80, (byte) 0xF6, (byte) 0x85, (byte) 0x94,
//            (byte) 0x37, (byte) 0x3C, (byte) 0x5C, (byte) 0x37,
//            (byte) 0x5E, (byte) 0xBA, (byte) 0x73, (byte) 0xF8,
//            (byte) 0x91, (byte) 0x42, (byte) 0xC5, (byte) 0x48,
//            (byte) 0x80, (byte) 0xF6, (byte) 0x85, (byte) 0x94,
//            (byte) 0x37, (byte) 0x3C, (byte) 0x5C, (byte) 0x37,
//            (byte) 0x5E, (byte) 0xBA, (byte) 0x73, (byte) 0xF8,
//            (byte) 0x91, (byte) 0x42, (byte) 0xC5, (byte) 0x48,
//            (byte) 0x80, (byte) 0xF6, (byte) 0x85, (byte) 0x94,
//            (byte) 0x37, (byte) 0x3C, (byte) 0x5C, (byte) 0x37,
//            (byte) 0x07, (byte) 0x29, (byte) 0xF7, (byte) 0xAE,
//            (byte) 0x87, (byte) 0xB4, (byte) 0x3A, (byte) 0x01,
//            (byte) 0xDC, (byte) 0xAB, (byte) 0xCF, (byte) 0xBE,
//            (byte) 0x20, (byte) 0xF8, (byte) 0xD1, (byte) 0x5B
    };
	
	byte[] ivBytes = new byte[] { (byte) 0x69, (byte) 0xdd, (byte) 0xa8, (byte) 0x0c,
								  (byte) 0x45, (byte) 0x5c, (byte) 0x7d, (byte) 0xd4,
								  (byte) 0x25, (byte) 0x4b, (byte) 0xf3, (byte) 0x53,
								  (byte) 0xb7, (byte) 0x73, (byte) 0x30, (byte) 0x4e };
	
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
