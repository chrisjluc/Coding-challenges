# http://community.topcoder.com/stat?c=problem_statement&pm=1918&rd=5006

"""
height = [5, 4, 3, 2, 1]
bloom = [1, 1, 1, 1, 1]
wilt = [365, 365, 365, 365, 365]

height = [5, 4, 3, 2, 1]
bloom = [1, 5, 10, 15, 20]
wilt = [4, 9, 14, 19, 24]

height = [5, 4, 3, 2, 1]
bloom = [1, 5, 10, 15, 20]
wilt = [5, 10, 14, 20, 25]
"""
height = [6, 5, 4, 3, 2, 1]
bloom = [3, 1, 3, 1, 3, 1]
wilt = [4, 2, 4, 2, 4, 2]
"""
height = [3, 2, 5, 4]
bloom = [1, 2, 11, 10]
wilt = [4, 3, 12, 13]
"""
ordering = []

def days_overlap(x, y):
    overlap = y[1] <= x[2] and x[1] <= y[2]
    return overlap


def insert_flower(flower, i):
    if len(ordering) <= i:
        ordering.append(flower)
        return
    if (flower[0] < ordering[i][0]) ^ days_overlap(flower, ordering[i]):
        insert_flower(flower, i + 1)
    else:
        ordering.insert(i, flower)


if __name__ == '__main__':
    # sort from highest to lowest flowers to guarantee ordering
    for i in range(len(height)):
        insert_flower((height[i], bloom[i], wilt[i]), 0)
    print ordering
