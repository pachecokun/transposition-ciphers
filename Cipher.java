abstract class Cipher{
	public abstract char[] encrypt(char[] message, char[] key);
	public abstract char[] decrypt(char[] ciphertext, char[] key);
}
