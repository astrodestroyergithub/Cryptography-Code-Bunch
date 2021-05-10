import java.util.Scanner;

public class MyProgram{
	
	//declare the tableau 2D char-array and string keyword variable
	public static char[][] tableau = new char[26][26];
	public static String keyword = new String("");
	
	static void makeTableau() {
		//creating the tableau
		for(int i=0;i<26;i++) {
			for(int j=i;j<i+26;j++) {
				int a = j+65;
				if (a>90) {
					tableau[i][j-i] = (char)(a%90+64);
				}
				else {
					tableau[i][j-i] = (char)a;
				}
			}
		}
	}
	
	static void makeKeyword(int n) {
		//creating the keyword
		char key[] = {'F','O','R','T','I','F','I','C','A','T','I','O','N'};
		for(int i=0;i<n;i++) {
			keyword = keyword + Character.toString(key[i%13]);
		}
	}
	
	//function for encryption
	static String encrypt(String pt) {
		char[] encpt1 = pt.toCharArray();
		char[] charArrayKeyword = keyword.toCharArray();
		String encpt2 = new String("");
		for(int i=0;i<pt.length();i++) {
			int j=charArrayKeyword[i];
			int a = j-65;
			int b = encpt1[i];
			b = b-65;
			encpt2 = encpt2 + Character.toString(tableau[a][b]);
			}
		return encpt2;
	}
	
	//function for decryption
	static String decrypt(String encpt) {
		char[] decpt1 = keyword.toCharArray();
		char[] decpt2 = encpt.toCharArray();
		String decpt3 = new String("");
		for(int k=0; k<keyword.length(); k++) {
			int i=decpt1[k],j,b=0;
			i = i-65;
			for(j=0;j<26;j++) {
				if (tableau[i][j]==decpt2[k]) {
					b=j;
					break;
				}
			}
			decpt3 = decpt3 + Character.toString((char)(b+65));
		}
		return decpt3;
	}
	
	//main method
	public static void main(String[] args) {
		
		makeTableau();
		System.out.print("Enter plaintext: ");
		Scanner scan = new Scanner(System.in);
		String pt = scan.nextLine();
		makeKeyword(pt.length());
		String encpt = encrypt(pt);
		System.out.println("Encrypted text: "+encpt);
		String decpt = decrypt(encpt);
		System.out.println("Decrypted text: "+decpt);
		
	}
}
