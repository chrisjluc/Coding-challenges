is_prime_dict = {}
sols = []

def solve(N, J):
    A = [[1] for _ in range(9)]
    count = 0

    for i in range(1, N - 1):
        for j in range(9):
            A[j].append((j + 2) ** i)

        pos = 2 ** i - 1
        size = len(A[0]) - 1

        for k in range(size):
            nums = []

            for j in range(9):
                A[j].append(A[j][pos] + A[j][k])
                nums.append(A[j][pos] + A[j][k] + (j + 2) ** (N - 1))

            if k % 2 == 0 and all([is_prime(x) is not None for x in nums]):
                s = '{0:0' + str(N) + 'b}'
                b = s.format(nums[0])
                sols.append(b + ' ' + ' '.join([str(x) for x in nums]))
                count += 1
                if count >= J:
                    print '\n'.join(sols)
                    return



def is_prime(x):
    if x not in is_prime_dict:
        is_prime_dict[x] = is_prime_helper(x)
    return is_prime_dict[x]

def is_prime_helper(num):
    if num == 0 or num == 1:
        return None
    for x in range(2, int(num ** .5) + 1):
        if num % x == 0:
            return x
    return None

T = input()
for _ in range(T):
    print 'Case #' + str(_ + 1) + ':'
    N, J = raw_input().split()
    solve(int(N), int(J))
