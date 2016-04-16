def count_twos_power_of_ten(n):
    counts = [0, 1]
    for i in range(2, n + 1):
        counts.append(counts[-1] * 10 + 10 ** (i - 1) - 1)
    return counts

def count_twos(n):
    power = 1
    while 10 ** power <= n:
        power += 1
    count_by_power_tens = count_twos_power_of_ten(power)
    count = 0
    for i in range(power):
        exp = power - 1 - i
        divisor = 10 ** exp
        m = n / divisor
        n %= divisor
        if m > 2:
            count += 10 ** exp - 1 if exp > 0 else 1
        if m == 2:
            count += n + 1
        count += count_by_power_tens[exp] * m
    return count


assert count_twos(21) == 4
assert count_twos(22) == 6
assert count_twos(32) == 13
assert count_twos(100) == 19
assert count_twos(199) == 38
assert count_twos(209) == 49
assert count_twos(1000) == 19 * 10 + 99
assert count_twos(1100) == 19 * 11 + 99
