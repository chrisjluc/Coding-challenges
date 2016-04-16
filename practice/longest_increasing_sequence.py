a = [1, 7, 8, 3, 2]
b = [[1 for j in xrange(len(a))] for i in xrange(len(a))]

for i in xrange(0, len(a)):
    for j in xrange(0, len(b)):
        if a[j] > a[i]:
            if i > 0 and j > 0:
                b[i][j] = b[i - 1][j - 1] + 1
            else:
                b[i][j] = 2
        else:
            b[i][j] = max(b[i][j - 1], b[i - 1][j])
print b
print b[len(a) - 1][len(a) - 1]
