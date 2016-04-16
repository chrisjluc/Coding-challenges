# Christopher Luc
# https://www.quora.com/challenges

def solve(N, K, A):

    next_non_increasing = [0] * N
    next_non_decreasing = [0] * N
    for i in range(1, N):
        if A[i] > A[i - 1]:
            next_non_decreasing[i] = i

        if A[i] < A[i - 1]:
            next_non_increasing[i] = i

    a = N
    b = N
    for i in range(N - 1, -1, -1):
        if next_non_increasing[i] > 0:
            a = i
        else:
            next_non_increasing[i] = a

        if next_non_decreasing[i] > 0:
            b = i
        else:
            next_non_decreasing[i] = b

    current_count = 0
    non_increasing_last = 0
    non_decreasing_last = 0
    counts = [0] * (N - K + 1)
    for i in range(1, N):

        if A[i] >= A[i - 1]:
            current_count += i - max(non_decreasing_last, i - K + 1)
        else:
            non_decreasing_last = i

        if A[i] <= A[i - 1]:
            current_count -= i - max(non_increasing_last, i - K + 1)
        else:
            non_increasing_last = i

        j = i - K + 1

        if j >= 0:
            if j > 0 and  A[j] >= A[j - 1]:
                current_count -= min(next_non_increasing[j], i) - j

            if j > 0 and A[j] <= A[j - 1]:
                current_count += min(next_non_decreasing[j], i) - j

            counts[j] = current_count

    return counts

N, K = map(int, raw_input().split())
A = map(int, raw_input().split())
for x in solve(N, K, A):
    print x

"""
def naive_solve(N, K, A):
    counts = []
    for i in range(N - K + 1):
        non_increasing_start = 0
        non_decreasing_start = 0
        count = 0
        for j in range(1, K):
            if A[i + j] >= A[i + j - 1]:
                count += j - non_decreasing_start
            else:
                non_decreasing_start = j

            if A[i + j] <= A[i + j - 1]:
                count -= j - non_increasing_start
            else:
                non_increasing_start = j

        counts.append(count)
    return counts

assert solve(5, 3, [1, 2, 3, 4, 5]) == [3, 3, 3]
assert solve(5, 3, [5, 4, 3, 2, 1]) == [-3, -3, -3]
assert solve(5, 2, [5, 4, 3, 2, 1]) == [-1, -1, -1, -1]

assert solve(5, 3, [1, 2, 3, 1, 1]) == [3, 0, -2]
assert solve(4, 4, [1, 2, 3, 4]) == [6]
assert solve(7, 3, [1, 2, 3, 1, 1, 1, 2]) == [3, 0, -2, 0, 2]

assert solve(5, 3, [1, 1, 2, 1, 1]) == naive_solve(5, 3, [1, 1, 2, 1, 1])
assert solve(10, 4, [1, 1, 2, 1, 1, 1, 0, 0, 0, 1]) == naive_solve(10, 4, [1, 1, 2, 1, 1, 1, 0, 0, 0, 1])
"""
