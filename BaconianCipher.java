import java.util.*;
import java.io.*;

public class BaconianCipher {
	
	static String encrypt(String pt) {
		Dictionary baconian = new Hashtable();
		baconian.put('A', "aaaaa");
		baconian.put('B', "aaaab");
		baconian.put('C', "aaaba");
		baconian.put('D', "aaabb");
		baconian.put('E', "aabaa");
		baconian.put('F', "aabab");
		baconian.put('G', "aabba");
		baconian.put('H', "aabbb");
		baconian.put('I', "abaaa");
		baconian.put('J', "abaab");
		baconian.put('K', "ababa");
		baconian.put('L', "ababb");
		baconian.put('M', "abbaa");
		baconian.put('N', "abbab");
		baconian.put('O', "abbba");
		baconian.put('P', "abbbb");
		baconian.put('Q', "baaaa");
		baconian.put('R', "baaab");
		baconian.put('S', "baaba");
		baconian.put('T', "baabb");
		baconian.put('U', "babaa");
		baconian.put('V', "babab");
		baconian.put('W', "babba");
		baconian.put('X', "babbb");
		baconian.put('Y', "bbaaa");
		baconian.put('Z', "bbaab");
		
		char[] encpt1 = pt.toCharArray();
		int i;
		String encpt2 = new String("");
		for(i=0;i<pt.length();i++) {
			encpt2 = encpt2 + baconian.get(encpt1[i]);
		}
		
		return encpt2;
	}
	
	static String decrypt(String encpt) {
		Dictionary baconian = new Hashtable();
		baconian.put("aaaaa","A");
		baconian.put("aaaab","B");
		baconian.put("aaaba","C");
		baconian.put("aaabb","D");
		baconian.put("aabaa","E");
		baconian.put("aabab","F");
		baconian.put("aabba","G");
		baconian.put("aabbb","H");
		baconian.put("abaaa","I");
		baconian.put("abaab","J");
		baconian.put("ababa","K");
		baconian.put("ababb","L");
		baconian.put("abbaa","M");
		baconian.put("abbab","N");
		baconian.put("abbba","O");
		baconian.put("abbbb","P");
		baconian.put("baaaa","Q");
		baconian.put("baaab","R");
		baconian.put("baaba","S");
		baconian.put("baabb","T");
		baconian.put("babaa","U");
		baconian.put("babab","V");
		baconian.put("babba","W");
		baconian.put("babbb","X");
		baconian.put("bbaaa","Y");
		baconian.put("bbaab","Z");
		
		int i;
		String decpt1 = new String("");
		for(i=0;i<encpt.length();i=i+5) {
			decpt1 = decpt1 + baconian.get(encpt.substring(i,i+5));
		}
		
		return decpt1;
	}
	
	public static void main(String[] args) {
		String pt,encpt,decpt;
		System.out.println("Enter plaintext: ");
		Scanner scanner = new Scanner(System.in);
		pt = scanner.nextLine();
		encpt = encrypt(pt);
		System.out.println("Encrypted text: " + encpt);
		decpt = decrypt(encpt);
		System.out.println("Decrypted text: " + decpt);
	}
}

