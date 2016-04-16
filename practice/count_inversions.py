import sys

def swap(A, i, j):
    temp = A[i]
    A[i] = A[j]
    A[j] = temp

def count_swaps(n, d):
    if n == 1:
        return 0, d

    mid = n / 2
    left_swaps, left = count_swaps(mid, d[:mid])
    right_swaps, right = count_swaps(n - mid , d[mid:])

    count = left_swaps + right_swaps

    left_size = len(left)
    right_size = len(right)
    left_index = 0
    right_index = 0

    merged = []
    while left_index < left_size and right_index < right_size:
        if left[left_index] <= right[right_index]:
            merged.append(left[left_index])
            left_index += 1
        else:
            merged.append(right[right_index])
            count += right_index + left_size - (left_index + right_index)
            right_index += 1

    if left_index < left_size:
        merged += left[left_index:]
    elif right_index < right_size:
        merged += right[right_index:]

    return count, merged

n = 5000
d = [x for x in range(n, 0, -1)]
print count_swaps(n, d)[0]
