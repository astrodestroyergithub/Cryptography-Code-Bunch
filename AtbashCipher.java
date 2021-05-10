<<<<<<< HEAD
import java.util.Scanner;

public class AtbashCipher {
	
	static String encrypt(String pt) {
		int a,i;
		char ch;
		char[] encpt1 = pt.toCharArray();
		for(i=0;i<pt.length();i++) {
			a=encpt1[i];
			a=91-(a-64);
			ch=(char) a;
			encpt1[i]=ch;
		}
		String encpt2 = new String(encpt1);
		return encpt2;
	}
	
	static String decrypt(String encpt) {
		int a,i;
		char ch;
		char[] decpt1 = encpt.toCharArray();
		for(i=0;i<encpt.length();i++) {
			a=decpt1[i];
			a=91-a+64;
			ch=(char) a;
			decpt1[i]=ch;
		}
		String decpt2 = new String(decpt1);
		return decpt2;
	}
	
	public static void main(String[] args) {
		String pt,encpt,decpt;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter plaintext :");
		pt=scanner.nextLine();
		
		encpt=encrypt(pt);
		System.out.println("Encrypted text :");
		System.out.println(encpt);
		
		decpt=decrypt(encpt);
		System.out.println("Decrypted text :");
		System.out.println(decpt);
	}

}
=======
import java.util.Scanner;

public class MyProgram {
	
	static String encrypt(String pt) {
		int a,i;
		char ch;
		char[] encpt1 = pt.toCharArray();
		for(i=0;i<pt.length();i++) {
			a=encpt1[i];
			a=91-(a-64);
			ch=(char) a;
			encpt1[i]=ch;
		}
		String encpt2 = new String(encpt1);
		return encpt2;
	}
	
	static String decrypt(String encpt) {
		int a,i;
		char ch;
		char[] decpt1 = encpt.toCharArray();
		for(i=0;i<encpt.length();i++) {
			a=decpt1[i];
			a=91-a+64;
			ch=(char) a;
			decpt1[i]=ch;
		}
		String decpt2 = new String(decpt1);
		return decpt2;
	}
	
	public static void main(String[] args) {
		String pt,encpt,decpt;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter plaintext :");
		pt=scanner.nextLine();
		
		encpt=encrypt(pt);
		System.out.println("Encrypted text :");
		System.out.println(encpt);
		
		decpt=decrypt(encpt);
		System.out.println("Decrypted text :");
		System.out.println(decpt);
	}

}

>>>>>>> 7fd36153b99a94a93b0816f110f15f883dd28abc
