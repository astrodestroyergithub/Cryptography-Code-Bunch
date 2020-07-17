
def polybiusEncrypt(s):

    encpt=""

    for char in s:

        row = int((ord(char) - ord('a')) / 5) + 1

        col = ((ord(char) - ord('a')) % 5) + 1

        if char == 'k':
            row = row - 1
            col = 5 - col + 1

        elif ord(char) >= ord('j'):
            if col == 1 :
                col = 6
                row = row - 1

            col = col - 1

        r=str(row)
        c=str(col)
        encpt = encpt+r+c

    return encpt

def polybiusDecrypt(s):

    s1 = list(s)
    decpt = ""

    for i in range(0,len(s),2):
        r = int(s1[i])
        c = int(s1[i+1])
        ch = chr(((r-1)*5+c+96))
        if (ord(ch)-96>=10):
            ch = chr(((r-1)*5+c+96+1))
        ch1 = str(ch)
        decpt = decpt + ch1

    return decpt


pt = input("Enter plaintext: ")
encpt = polybiusEncrypt(pt)
print("Encrypted text: ",encpt)
decpt = polybiusDecrypt(encpt)
print("decrypted text: ",decpt)