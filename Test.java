import java.io.*;

class Test{

	public static void main(String args[]){
		System.out.println("Test route cipher");
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("Ingrese texto: ");
			char[] plain = br.readLine().toCharArray();
			
			System.out.print("Ingrese la clave: ");
			char[] key = br.readLine().toCharArray();
			
			Cipher c = new RouteCipher();
			
			char[] ciphertext = c.encrypt(plain,key);
			System.out.println("Texto cifrado: "+new String(ciphertext));
			
			plain = c.decrypt(ciphertext,key);
			System.out.println("Texto descifrado: "+new String(plain));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
