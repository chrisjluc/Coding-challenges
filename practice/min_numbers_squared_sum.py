import math

def find_min_num(n):
    A = [0, 1, 2, 3]
    for i in range(4, n + 1):
        min_num = i
        for j in range(1, i + 1):
            s = j ** 2
            if s > i:
                break
            min_num = min(min_num, A[i - s] + 1)
        A.append(min_num)
    return A[n]

assert find_min_num(1) == 1
assert find_min_num(2) == 2
assert find_min_num(3) == 3
assert find_min_num(4) == 1
assert find_min_num(5) == 2
assert find_min_num(6) == 3
assert find_min_num(8) == 2
assert find_min_num(10) == 2
assert find_min_num(12) == 3
assert find_min_num(99) == 3
assert find_min_num(100) == 1
assert find_min_num(500) == 2
