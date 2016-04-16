# http://www.geeksforgeeks.org/find-minimum-possible-size-of-array-with-given-rules-for-removal/

def min_size(A, k):
    B = [0] * len(A)
    for i in range(len(B)):
        if i < 2:
            B[i] = i + 1
        else:
            n = B[i - 1]
            m = 0
            while B[i - m - 1] == n and i > m:
                if A[i - m] - A[i - m - 1] == k and A[i - m - 1] - A[i - m - 2] == k:
                    if i - m - 3 < 0:
                        B[i] = 0
                    else:
                        B[i] = B[i - m - 3]
                    break
                m += 3
            if i <= m:
                B[i] = B[i - 1] + 1


    print B
    return B[-1]

assert min_size([4, 1, 2, 3, 4, 5, 6, 4, 2, 3, 5, 6], 1) == 0
assert min_size([2, 3, 4, 5, 6, 4], 1) == 0
assert min_size([1, 2, 3, 4, 5, 6, 4, 2, 3], 1) == 0
