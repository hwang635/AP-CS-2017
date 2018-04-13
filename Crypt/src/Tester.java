
public class Tester {
	
	public static void main(String[] args) {
		Crypt c = new Crypt();
		//c.encrypt("test1.txt", "encryptedFile.txt", "crypt");
		c.decrypt("encryptedFile.txt", "decryptedFile.txt", "crypt");
	}
}
