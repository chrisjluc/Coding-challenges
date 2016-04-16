
subsets = []

def get_subsets(A, B):
    if len(B) == 1:
        subsets.append(A + B)
        return

    for i in range(len(B)):
        subsets.append(A + [B[i]])
        get_subsets(A + [B[i]], B[i + 1:])


get_subsets([], [1, 2, 3, 4])
print sorted(subsets)
