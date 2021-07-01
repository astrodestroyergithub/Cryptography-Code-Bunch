#include<stdio.h>
#include<string.h>

char* encpt(char encpt_txt[])
{
	int i, n;
	char ch;
	for(i=0;i<strlen(encpt_txt);i++)
	{
		n=encpt_txt[i];
		n=n+13;
		if(n>90)
		{
			n=n-90+64;
			ch=n;
			encpt_txt[i]=ch;
		}
		else 
		{
			ch=n;
			encpt_txt[i]=ch;
		}
	}
	return encpt_txt;
}


char* decpt(char decpt_txt[])
{
	int i, n;
	char ch;
	for(i=0;i<strlen(decpt_txt);i++)
	{
		n=decpt_txt[i];
		n=n-13;
		if(n<65)
		{
			n=91-(65-n);
			ch=n;
			decpt_txt[i]=ch;
		}
		else 
		{
			ch=n;
			decpt_txt[i]=ch;
		}
	}
	return decpt_txt;
}



int main()
{
	char input[500], encpt_txt[500], decpt_txt[500];
	
	printf("Enter plaintext: \n");
	scanf("%s", &input);
	
	strcpy(encpt_txt,encpt(input));
	printf("\nEncrypted text: \n");
	printf("%s",encpt_txt);
	
	strcpy(decpt_txt,decpt(encpt_txt));
	printf("\n\nDecrypted text: \n");
	printf("%s",decpt_txt);

	return 0;	
}
