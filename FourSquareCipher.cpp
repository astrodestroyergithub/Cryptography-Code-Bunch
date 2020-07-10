

#include<iostream>
#include<string.h>
using namespace std;

string key1, key2;
char TL[5][5], TR[5][5], BL[5][5], BR[5][5], agg[10][10];

void makeTableau(string key1,string key2)
{
	for(int i=0;i<2;i++)
		for(int j=0;j<5;j++)
		{
			char ch = (i*5+j+65);
			TL[i][j]=ch;
			BR[i][j]=ch;
		}
	TL[1][4]='K';
	BR[1][4]='K';
	for(int i=2;i<5;i++)
		for(int j=0;j<5;j++)
		{
			char ch = (i*5+j+66);
			TL[i][j]=ch;
			BR[i][j]=ch;
		}
	for(int i=0;i<5;i++)
		for(int j=0;j<5;j++)
			TR[i][j]=key1[(i*5+j)];
	for(int i=0;i<5;i++)
		for(int j=0;j<5;j++)
			BL[i][j]=key2[(i*5+j)];
	string seq = "";
	for(int i=0;i<5;i++)
		for(int j=0;j<10;j++)
		{
			if(j>4){
				int k = j-5;
				string s(1,TR[i][k]);
				seq=seq+s;
			}
			else
			{
				string s(1,TL[i][j]);
				seq=seq+s;
			}
		}
	for(int i=0;i<5;i++)
		for(int j=0;j<10;j++)
		{
			if(j>4)
			{
				int k = j-5;
				string s(1,BR[i][k]);
				seq=seq+s;
			}
			else
			{
				string s(1,BL[i][j]);
				seq=seq+s;
			}
		}
	int n = seq.length();
	char char_arr[n+1];
	strcpy(char_arr,seq.c_str());
	for(int i=0;i<10;i++)
		for(int j=0;j<10;j++)
			agg[i][j] = char_arr[(i*10+j)];
}

string encrypt(string pt)
{
	string encpt="";
	int length = pt.length();
	char pt_char[length+1];
	strcpy(pt_char,pt.c_str());
	for(int i=0;i<pt.length();i=i+2)
	{
		int row1,col1,row2,col2;
		for(int j=0;j<5;j++)
			for(int k=0;k<5;k++)
			{
				if(pt_char[i]==TL[j][k])
				{
					row1=j;
					col2=k;
				}
			}
		for(int j=0;j<5;j++)
			for(int k=0;k<5;k++)
			{
				if(pt_char[i+1]==BR[j][k])
				{
					row2=j+5;
					col1=k+5;
				}
			}
		string s1(1,agg[row1][col1]), s2(1,agg[row2][col2]);
		encpt=encpt+s1+s2;
	}
	return encpt;
}

string decrypt(string encpt)
{
	string decpt="";
	int length = encpt.length();
	char encpt_char[length+1];
	strcpy(encpt_char,encpt.c_str());
	for(int i=0;i<encpt.length();i=i+2)
	{
		int row1,col1,row2,col2;
		for(int j=0;j<5;j++)
			for(int k=0;k<5;k++)
			{
				if(encpt_char[i]==TR[j][k])
				{
					row1=j;
					col2=k+5;
				}
			}
		for(int j=0;j<5;j++)
			for(int k=0;k<5;k++)
			{
				if(encpt_char[i+1]==BL[j][k])
				{
					row2=j+5;
					col1=k;
				}
			}
		string s1(1,agg[row1][col1]), s2(1,agg[row2][col2]);
		decpt=decpt+s1+s2;
	}
	return decpt;
}

int main()
{
	string pt, encpt, decpt;
	
	cout<<"Enter plaintext: ";
	cin>>pt;
	cout<<"Enter Key 1: ";
	cin>>key1;
	cout<<"Enter Key 2: ";
	cin>>key2;
	makeTableau(key1,key2);
	encpt = encrypt(pt);
	cout<<"Encrypted text: "<<encpt<<endl;
	decpt = decrypt(encpt);
	cout<<"Decrypted text: "<<decpt;
	
	return 0;
}


