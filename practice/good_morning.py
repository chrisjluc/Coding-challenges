# https://www.hackerrank.com/contests/2014-icpc-central-europe-regional-contest-practice/challenges/good-morning
# if x < 21: return x

def is_valid(x, y):
    if x == y:
        return True

    if x == 0:
        x = 11
    if y == 0:
        y = 11

    if (y - 1) % 3 >= (x - 1) % 3 and (y - 1) / 3 >= (x - 1) / 3:
        return True
    return False


def generate_num():
    ret = set()
    for i in range(0, 10):
        for j in range(0, 10):
            for k in range(0, 10):
                num = 0
                if is_valid(i, j) or i == 0:
                    num = i * 10 + j
                if is_valid(j, k):
                    num = num * 10 + k
                if num not in ret and num <= 200:
                    ret.add(num)

    return sorted(list(ret))


def find_closest(x):
    min_diff = 1000000
    min_num = 0
    for num in possible_nums:
        diff = abs(x - num)
        if diff < min_diff:
            min_diff = diff
            min_num = num
        else:
            break
    return min_num


possible_nums = generate_num()
print possible_nums
assert find_closest(3) == 3
assert find_closest(180) == 180
assert find_closest(83) == 80
assert find_closest(132) == 133
assert find_closest(201) == 200
assert find_closest(200) == 200
assert find_closest(198) == 199
assert find_closest(104) == 100
assert find_closest(65) == 66
assert find_closest(1) == 1
assert find_closest(11) == 11

assert is_valid(1, 1) == True
assert is_valid(1, 2) == True
assert is_valid(1, 3) == True
assert is_valid(1, 4) == True
assert is_valid(1, 7) == True
assert is_valid(5, 9) == True
assert is_valid(5, 6) == True
assert is_valid(5, 8) == True

assert is_valid(2, 4) == False
assert is_valid(2, 1) == False
assert is_valid(5, 1) == False
assert is_valid(5, 3) == False
assert is_valid(0, 3) == False
assert is_valid(0, 7) == False
assert is_valid(0, 8) == False
assert is_valid(0, 9) == False

assert is_valid(0, 0) == True
