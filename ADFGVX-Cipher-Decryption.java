import java.util.*;

public class ADFGVXCipherDecryption {
    
    static void decrypt(String decpt, String key){

        char[] key1=key.toCharArray();
        char[] decpt1=decpt.toCharArray();
        ArrayList<Character> pos2=new ArrayList<>();
        ArrayList<Integer> posKeyEle=new ArrayList<>();

        ArrayList<Character> pos3=new ArrayList<>();
        ArrayList<Character> intermediate_text=new ArrayList<>();

        for(char ch='A';ch<='Z';ch++){
            for(int i=0;i<key1.length;i++){
                if(key1[i]==ch){
                    pos2.add(ch);
                    key1[i]='\0';
                    int pos=key.indexOf(key.charAt(i));
                    posKeyEle.add(pos);
                    pos=pos*2;
                    break;
                }
            }
        }

        int ctr=0;
        int[][] posKeyEleMapping=new int[key.length()][2];
        for(int i=0;i<key.length();i++){
            posKeyEleMapping[i][0]=posKeyEle.get(i);
            posKeyEleMapping[i][1]=ctr++;
        }

        for(int i=0;i<key.length();i++){
            for(int j=0;j<key.length();j++){
                if(posKeyEleMapping[j][0]==i){
                    int temp=posKeyEleMapping[j][1];
                    pos3.add(decpt1[temp*2]);
                    pos3.add(decpt1[temp*2+1]);
                    break;
                }
            }
        }

        for(int i=0;i<decpt.length();i=i+2){
            intermediate_text.add(pos3.get(i));
        }

        for(int i=1;i<decpt.length();i=i+2){
            intermediate_text.add(pos3.get(i));
        }

        char [][] t = {{'A','X','0','N','P','Y'},
					   {'M','2','B','1','E','O'},
					   {'Z','Q','3','F','W','R'},
					   {'4','C','L','S','D','8'},
					   {'U','5','G','V','J','K'},
					   {'6','H','7','I','T','9'}};
		char [] index = {'A','D','F','G','V','X'};
        
        
        char[] plain_text=new char[key.length()];
        int ctr2=0;
        for(int i=0;i<decpt.length();i=i+2){
            int row=0,col=0;
            for(int r=0;r<key.length();r++){
                if(index[r]==intermediate_text.get(i)){
                    row=r;
                    break;
                }
            }
            for(int c=0;c<key.length();c++){
                if(index[c]==intermediate_text.get(i+1)){
                    col=c;
                    break;
                }
            }
            plain_text[ctr2++]=t[row][col];
        }

        System.out.print("Elements of Key in Alphabetical Order: ");
        System.out.println(pos2);
        System.out.print("Positions of the Alphabetically arranged Key elements in the Key itself: ");
        System.out.println(posKeyEle);
        System.out.print("Intermediate Text-2: ");
        System.out.println(pos3);
        System.out.print("Intermediate Text: ");
        System.out.println(intermediate_text);
        System.out.print("Plain Text: ");
        System.out.println(String.valueOf(plain_text));

        return;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Encrypted Text: ");
        String decpt=sc.next();
        //String decpt=new String("GFDFXGVXFVDD");
        System.out.println("Enter the Key: ");
        String key=sc.next();
        //String key=new String("GERMAN");
        decrypt(decpt,key);
    }
}
