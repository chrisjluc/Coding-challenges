def solve(num_diners, pancakes):
    pancakes = sorted(map(int, pancakes.split()), reverse=True)
    return pancakes

if __name__ == "__main__":
    testcases = input()

    for case in xrange(1, testcases+1):
        num_diners = raw_input()
        pancakes = raw_input()
        print("Case #%i: %s" % (case, solve(num_diners, pancakes)))
