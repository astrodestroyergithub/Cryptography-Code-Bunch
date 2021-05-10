#include<iostream>
#include<string>
#include<cstring>
using namespace std;

string encrypt(string pt)
{
	string key[26]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	string value[26]={"aaaaa","aaaab","aaaba","aaabb","aabaa","aabab","aabba","aabbb","abaaa","abaab","ababa","ababb","abbaa",
	"abbab","abbba","abbbb","baaaa","baaab","baaba","baabb","babaa","babab","babba","babbb","bbaaa","bbaab"};
	
	int i,j;
	string encpt1="";
	for(i=0;i<pt.length();i++)
	{
		for(j=0;j<26;j++)
		{
			if(pt.substr(i,i+1)==key[j])
			{
				encpt1 = encpt1 + value[j];
			}	
		}
	}
	return encpt1;
}

string decrypt(string encpt)
{
	string value[26]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	string key[26]={"aaaaa","aaaab","aaaba","aaabb","aabaa","aabab","aabba","aabbb","abaaa","abaab","ababa","ababb","abbaa",
	"abbab","abbba","abbbb","baaaa","baaab","baaba","baabb","babaa","babab","babba","babbb","bbaaa","bbaab"};
	
	int i,j;
	string decpt1="";
	for(i=0;i<encpt.length();i=i+5)
	{
		for(j=0;j<26;j++)
		{
			if(key[j]==encpt.substr(i,i+5))
			{
				decpt1 = decpt1 + value[j];
			}
		}
	}
	return decpt1;
}

int main()
{
	string pt,encpt,decpt;
	cout<<"Enter plaintext: ";
	cin>>pt;
	encpt = encrypt(pt);
	cout<<"Encrypted text: "<<encpt<<"\n";
	decpt = decrypt(encpt);
	cout<<"Decrypted text: "<<decpt;
	return 0;
}

