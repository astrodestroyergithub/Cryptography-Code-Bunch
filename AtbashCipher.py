def encrypt(pt):
    encpt=list(pt)
    for i in range(len(pt)):
        a=ord(encpt[i])
        a=91-(a-64)
        ch=chr(a)
        encpt[i]=ch
    return (''.join(encpt))

def decrypt(encpt):
    decpt=list(encpt)
    for i in range(len(encpt)):
        a=ord(decpt[i])
        a=91-a+64
        ch=chr(a)
        decpt[i]=ch
    return (''.join(decpt))

pt=input("Enter plaintext: ")
encpt=encrypt(pt)
print("Encrypted text: ",encpt)
decpt=decrypt(encpt)
print("Decrypted text: ",decpt)
