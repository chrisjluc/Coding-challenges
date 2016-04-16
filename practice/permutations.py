
permutations = []
def permutate(s, p):
    if s == '':
        permutations.append(p)
        return
    for i in xrange(0,len(s)):
        permutate(s[:i] + s[i + 1:], p + s[i])

s = 'abcdef'
permutate(s, '')
print len(permutations)
