
def s(left, right, sets, string):
    if left == sets and right == sets:
        print string
        return

    if left < sets:
        s(left + 1, right, sets, string + "(")
    if right < sets and right < left:
        s(left, right + 1, sets, string + ")")

s(1, 0, 4, "(")
