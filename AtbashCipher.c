#include<stdio.h>
#include<string.h>

char* encrypt(char encpt[])
{
	int i,a;
	char ch, encpt1[100];
	for(i=0;i<strlen(encpt);i++)
	{
		a=encpt[i];
		a=91-(a-64);
		ch=a;
		encpt1[i]=ch;
	}
	return encpt1;
}

char* decrypt(char decpt[])
{
	int i,a;
	char ch, decpt1[100];
	for(i=0;i<strlen(decpt);i++)
	{
		a=decpt[i];
		a=91-a+64;
		ch=a;
		decpt1[i]=ch;
	}
	return decpt1;
}

int main()
{
	char pt[100],encpt[100],decpt[100];
	printf("Enter plaintext: ");
	gets(pt);
	strcpy(encpt,encrypt(pt));
	printf("Encrypted text: %s\n",encpt);
	strcpy(decpt,decrypt(encpt));
	printf("Decrypted text: %s",decpt);
	
	return 0;
}

