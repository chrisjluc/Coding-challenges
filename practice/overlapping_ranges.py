def count_overlaps(a, b):
    if len(a) != len(b):
        raise Error
    max_num = 0
    cur_count = 0
    max_count = 0

    for i in xrange(0, len(a)):
        if a[i] > max_num:
            cur_count = 1
            max_num = b[i]
        else:
            cur_count += 1

        if cur_count > max_count:
            max_count = cur_count
    return max_count

a = [900, 940, 950, 1100, 1500, 1800]
b = [910, 1200, 1120, 1130, 1900, 2000]
print count_overlaps(a, b)
