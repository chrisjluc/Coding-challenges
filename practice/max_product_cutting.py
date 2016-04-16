def max_product_cut(x):
    A = [1] * (x + 1)
    for i in range(2, x + 1):
        for j in range(1, int(i / 2 + 1)):
            A[i] = max(A[i], A[j] * A[i - j], j * (i - j))
    return A[x]

assert max_product_cut(2) == 1
assert max_product_cut(3) == 2
assert max_product_cut(4) == 4
assert max_product_cut(6) == 9
assert max_product_cut(10) == 36
