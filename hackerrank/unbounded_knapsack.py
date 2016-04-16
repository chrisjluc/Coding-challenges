def knapsack():
    k = map(int, raw_input().split())[1]
    numbers = list(set(map(int, raw_input().split())))
    sums = []
    for i in range(2000):
        for num in numbers:
            for sum_ in sums:
                if (sum_ + num) <= k and (sum_ + num) not in sums:
                    sums.append(sum_ + num)

            if num not in sums:
                sums.append(num)

    print max(sums)

cases = input()
for z in range(cases):
    knapsack()
