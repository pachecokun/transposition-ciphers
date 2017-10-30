class RouteCipher extends Cipher{
	public char[] encrypt(char[] message, char[] key){
		
		int cols = 5;
		int rows = (int)Math.ceil((float)message.length/cols);
		
		char[] res = new char[cols*rows];
		
		char[][] table = new char[rows][cols];
	
		int k = 0;
		for(int i = 0;i<rows;i++){
			for(int j = 0;j<cols;j++){
				table[i][j] = message[k++];
				if(k==message.length){
					break;
				}
			}
			if(k==message.length){
				break;
			}
		}
	
		int i = key[0]-'0';
		int j = key[1]-'0';
		
		for(k = 2;k<key.length;k++){
			res[k-2] = table[i][j];
			if(key[k]=='u'){
				i--;
			}else if(key[k]=='d'){
				i++;
			}else if(key[k]=='l'){
				j--;
			}else if(key[k]=='r'){
				j++;
			}
		}
		
		return res;
	}
	public char[] decrypt(char[] ciphertext, char[] key){
		char[] res = new char[ciphertext.length];
		
		int cols = 5;
		int rows = (int)Math.ceil(ciphertext.length/5.0);
		
		char[][] table = new char[rows][cols];
	
		int k;	
		int i = key[0]-'0';
		int j = key[1]-'0';
		
		for(k = 2;k<key.length;k++){
			table[i][j] = ciphertext[k-2];
			if(key[k]=='u'){
				i--;
			}else if(key[k]=='d'){
				i++;
			}else if(key[k]=='l'){
				j--;
			}else if(key[k]=='r'){
				j++;
			}
		}
		
		k = 0;
		
		for(i = 0;i<rows;i++){
			for(j = 0;j<cols;j++){
				res[k++] = table[i][j];
			}
		}
		
		return res;
	}
}

