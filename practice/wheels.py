# https://www.hackerrank.com/contests/2014-icpc-central-europe-regional-contest-practice/challenges/wheels
from decimal import Decimal

def do_wheels_touch(a, b):
    return ((a[0] - b[0]) ** 2 + (a[1] - b[1]) ** 2) ** .5 == a[2] + b[2]

def fraction(x):
    for i in range(100000):
        if int(x * i) == x * i:
            return '{}/{}'.format(x * i, i)


def get_direction(x):
    if x == 0:
        return 'clockwise'
    return 'counterclockwise'

def solve_wheels():
    N = input()
    wheels = [tuple(map(int, raw_input(x).split()) + [0, 0]) for x in range(N)]
    wheels[0] += (1, 0)
    unvisited = set([i for i in range(1, N)])
    queue = [0]

    while not queue:
        curr_wheel = wheels[queue.pop(0)]
        for i in list(unvisited):
            wheel = wheels[i]
            if do_wheels_touch(curr_wheel, wheel):
                unvisited.remove(i)
                queue.append(i)
                wheel[3] = curr_wheel[3] * Decimal(wheel[2]) / curr_wheel[2]
                wheel[4] = (curr_wheel[4] + 1) % 2

    for wheel in wheels:
        if wheel[3] > 0:
            print '{} {}'.format(fraction(wheel[3]), get_direction(wheel[4]))
        else:
            print 'not moving'

