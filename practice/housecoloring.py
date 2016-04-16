costs = [[1, 2, 3, 1], [4, 3, 1, 8], [5, 5, 1, 7], [9, 6, 5, 4]]
total = []
for i in xrange(len(costs)):
    if i == 0:
        total.append(costs[0])
        continue;

    total.append([])
    for j in xrange(len(costs[0])):
        min_tot = 999999999
        for k in xrange(len(costs[0])):
            if j == k:
                continue
            min_tot = min(costs[i][j] + total[i - 1][k], min_tot)
        total[i].append(min_tot)

print total

