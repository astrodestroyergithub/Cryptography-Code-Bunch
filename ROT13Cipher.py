
def encrypt(pt):
    encpt1=list(pt)
    for i in range(len(pt)):
        n=ord(pt[i])
        if(n>=78):
            n+=13
            n=n-90+64
            ch=chr(n)
            encpt1[i]=ch
        else:
            n+=13
            ch=chr(n)
            encpt1[i]=ch
    return (''.join(encpt1))


def decrypt(encpt):
    decpt1=list(encpt)
    for i in range(len(encpt)):
        n=ord(encpt[i])
        if(n<=77):
            n-=13
            n=91-(65-n)
            ch=chr(n)
            decpt1[i]=ch
        else:
            n-=13
            ch=chr(n)
            decpt1[i]=ch
    return (''.join(decpt1))


pt = input("Enter plaintext: ")
encpt = encrypt(pt)
print("Encrypted text: ",encpt)
decpt = decrypt(encpt)
print("Decrypted text: ",decpt)

