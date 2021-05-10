#include<iostream>
#include<string.h>
#include<string>
#include <bits/stdc++.h>

char tableau[26][26];
char key[] = {'F','O','R','T','I','F','I','C','A','T','I','O','N'};
std::string keyword("");

void makeTableau()
{
	int i,j;
	for(i=0;i<26;i++)
		for(j=i;j<i+26;j++)
		{
			
			int a = j+65;
			if(a>90)
			{
				char c = a%91+65;
				tableau[i][j-i] = c;
			}
			else
			{
				char c = a;
				tableau[i][j-i] = c;
			}
		}
}

void makeKeyword(int n)
{
	int i;
	for(i=0;i<n;i++)
	{
		std::string s(1,key[i%n]);
		keyword = keyword + s;
	}
}

std::string encrypt(std::string pt)
{
	std::string encpt = "";
	char pt_char[pt.length()+1];
	strcpy(pt_char,pt.c_str());
	char kw_char[keyword.length()+1];
	strcpy(kw_char,keyword.c_str());
	int i,j;
	for(int a=0;a<pt.length();a++)
	{
		i = kw_char[a];
		i = i-65;
		j = pt_char[a];
		j = j-65;
		std::string s(1,tableau[i][j]);
		encpt = encpt + s;	
	}
	return encpt;
}

std::string decrypt(std::string encpt)
{
	std::string decpt = "";
	char encpt_char[encpt.length()+1];
	strcpy(encpt_char,encpt.c_str());
	char kw_char[keyword.length()+1];
	strcpy(kw_char,keyword.c_str());
	for(int a=0;a<encpt.length();a++)
	{
		int i = kw_char[a];
		i-=65;
		for(int b=0;b<26;b++)
		{
			if(tableau[i][b]==encpt_char[a])
			{
				char c = b+65;
				std::string s(1,c);
				decpt = decpt + s;
				break;
			}
		}
	}
	return decpt;
}

int main()
{
	std::string pt;
	std::cout<<"Enter plaintext: ";
	std::cin>>pt;
	makeTableau();
	makeKeyword(pt.length());
	std::string encpt = encrypt(pt);
	std::cout<<"Encrypted text: "<<encpt<<"\n";
	std::string decpt = decrypt(encpt);
	std::cout<<"Decrypted text: "<<decpt<<"\n";
	return 0;
}

