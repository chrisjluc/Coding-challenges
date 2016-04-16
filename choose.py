def fact(x):
    if x <= 1:
        return 1
    return reduce(lambda x, y: x*y, [i for i in range(2, x + 1)], 1)

def choose(n, k):
    return fact(n) / (fact(k) * fact(n-k))

def perm(n, k):
    return fact(n) / fact(n - k)


print perm(3, 1)
print perm(3, 2)
print perm(3, 3)
