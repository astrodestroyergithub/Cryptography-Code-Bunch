def encrypt(pt):
    baconian = {
        'A': "aaaaa",
        'B': "aaaab",
        'C': "aaaba",
        'D': "aaabb",
        'E': "aabaa",
        'F': "aabab",
        'G': "aabba",
        'H': "aabbb",
        'I': "abaaa",
        'J': "abaab",
        'K': "ababa",
        'L': "ababb",
        'M': "abbaa",
        'N': "abbab",
        'O': "abbba",
        'P': "abbbb",
        'Q': "baaaa",
        'R': "baaab",
        'S': "baaba",
        'T': "baabb",
        'U': "babaa",
        'V': "babab",
        'W': "babba",
        'X': "babbb",
        'Y': "bbaaa",
        'Z': "bbaab"
    }
    encpt1=""
    for i in range(0,len(pt)):
        encpt1 = encpt1 + baconian[pt[i]]
    return encpt1

def decrypt(encpt):
    baconian = {
        "aaaaa":"A",
        "aaaab":"B",
        "aaaba":"C",
        "aaabb":"D",
        "aabaa":"E",
        "aabab":"F",
        "aabba":"G",
        "aabbb":"H",
        "abaaa":"I",
        "abaab":"J",
        "ababa":"K",
        "ababb":"L",
        "abbaa":"M",
        "abbab":"N",
        "abbba":"O",
        "abbbb":"P",
        "baaaa":"Q",
        "baaab":"R",
        "baaba":"S",
        "baabb":"T",
        "babaa":"U",
        "babab":"V",
        "babba":"W",
        "babbb":"X",
        "bbaaa":"Y",
        "bbaab":"Z"
    }
    decpt1 = ""
    for i in range(0,len(encpt),5):
        decpt1 = decpt1 + baconian[encpt[i:i+5]]
    return decpt1

pt=input("Enter plaintext: ")
encpt=encrypt(pt)
print("Encrypted text: ",encpt)
decpt=decrypt(encpt)
print("Decrypted text: ",decpt)

