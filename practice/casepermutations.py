
def print_permutations(a):
    n = len(a)
    for i in range(2 ** n):
        current = i
        b = a[:]
        for j in range(n):
            if 2 ** (n - j - 1) <= current:
                current -= 2 ** (n - j - 1)
                b[j] = b[j].upper()
        print b


def recursive_permutation(test):

    binary = list("0"*len(test))
    print test
    def recurse(binary, test):
        index = "".join(binary).rfind('1') + 1
        for i in range(index, len(binary)):
            t = test[:]
            t[i] = t[i].upper()
            print t
            temp = binary[:]
            temp[i] = '1'
            recurse(temp, t)

    recurse(binary, test)

def f(i, s):
    return s[:i] + s[i].upper() + s[i+1:]

def s(i, string):
    if i == len(string):
        print string
        return

    result = f(i, string)
    s(i + 1, string)
    s(i + 1, result)


s(0, "asd")
