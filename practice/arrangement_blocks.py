"""
You are given N blocks of height 1...N. In how many ways can you arrange these blocks in a row such that when viewed from left you see only L blocks (rest are hidden by taller blocks) and when seen from right you see only R blocks? Example given N=3, L=2, R=1 there is only one arrangement {2, 1, 3} while for N=3, L=2, R=2 there are two ways {1, 3, 2} and {2, 3, 1}.
"""
def all_permutations(a, m, n):
    if len(n) == 0:
        a.append(m)
        return

    for i in range(len(n)):
        curr = m[:]
        curr.append(n[i])
        all_permutations(a, curr, n[:i] + n[i+1:])

def satisfy_left(l, perm):
    _max = 0
    viewed = 0
    for a in perm:
        if a > _max:
            _max = a
            viewed += 1

    return viewed == l

def satisfy_right(r, perm):
    _max = 0
    viewed = 0
    for a in perm[::-1]:
        if a > _max:
            _max = a
            viewed += 1

    return viewed == r


def count_arrangements(n, l, r):
    a = []
    all_permutations(a, [], [i for i in range(1, n + 1)])
    count = 0
    for perm in a:
        if satisfy_left(l, perm) and satisfy_right(r, perm):
            count += 1
    return count

print count_arrangements(9, 2, 1)
