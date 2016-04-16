# How many different ways to merge a n companies

def f(n):
    if n < 3:
        return n - 1
    else:
        return (n - 1) * f((n + 1) / 2)

print f(6)
