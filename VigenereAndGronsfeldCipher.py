def makeKeyword(n):
    for i in range(n):
        keyword.append(key[i%13])

def makeTableau():
    for i in range(26):
        t = []
        for j in range(i,i+26):
            a = j+65
            if a>90:
                t.append(chr(a%91+65))
            else:
                t.append(chr(a))
        tableau.append(t)

def encrypt(pt,keyword,tableau):
    encpt = []
    for x in range(len(pt)):
        i = ord(keyword[x])-65
        j = ord(pt[x])-65
        encpt.append(tableau[i][j])
    return "".join(encpt)

def decrypt(encpt,keyword,tableau):
    decpt = []
    for x in range(len(encpt)):
        i = ord(keyword[x])-65
        for y in range(0,26):
            if tableau[i][y]==encpt[x]:
                j = y
                decpt.append(chr(j+65))
                break
    return "".join(decpt)

tableau = []
key = ['F','O','R','T','I','F','I','C','A','T','I','O','N']
keyword = []

makeTableau()
pt = input("Enter plaintext: ")
makeKeyword(len(list(pt)))
encpt = encrypt(list(pt),keyword,tableau)
print("Encrypted text: ",encpt)
decpt = decrypt(list(encpt),keyword,tableau)
print("Decrypted text: ",decpt)

