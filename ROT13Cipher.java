import java.util.Scanner;
public class ROT13Cipher{

	static String encrypt(String pt){
		int i,n;
		char ch;
		char[] encpt1=pt.toCharArray();
		for(i=0;i<pt.length();i++){
			n=encpt1[i];
			if(n>=78){
				n+=13;
				n=n-90+64;
				ch=(char)n;
				encpt1[i]=ch;
			}
			else{
				n+=13;
				ch=(char)n;
				encpt1[i]=ch;
			}
		}
		String encpt2=new String(encpt1);
		return encpt2;
	}

	static String decrypt(String encpt){
		int i,n;
		char ch;
		char[] decpt1=encpt.toCharArray();
		for(i=0;i<encpt.length();i++){
			n=decpt1[i];
			if(n<=77){
				n-=13;
				n=91-(65-n);
				ch=(char)n;
				decpt1[i]=ch;
			}
			else{
				n-=13;
				ch=(char)n;
				decpt1[i]=ch;
			}
		}
		String decpt2=new String(decpt1);
		return decpt2;
	}

	public static void main(String[] args){
		String pt,encpt,decpt;
		System.out.println("Enter plaintext: ");
		Scanner scanner=new Scanner(System.in);
		pt=scanner.nextLine();
		encpt=encrypt(pt);
		System.out.println("Encrypted text: ");
		System.out.println(encpt);
		decpt=decrypt(encpt);
		System.out.println("Decrypted text: ");
		System.out.println(decpt);
	}
}