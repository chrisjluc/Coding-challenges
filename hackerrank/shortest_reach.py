# https://www.hackerrank.com/challenges/bfsshortreach

def shortest_reach():
    N, M = map(int, raw_input().split())
    adjacency_dict = {}
    for i in range(N):
        a, b = map(int, raw_input().split())
        if a not in adjacency_dict:
            adjacency_dict[a] = []
        if b not in adjacency_dict:
            adjacency_dict[b] = []

        if b not in adjacency_dict[a]:
            adjacency_dict[a].append(b)
        if a not in adjacency_dict[b]:
            adjacency_dict[b].append(a)

    start = input()
    queue = [start]
    shortest_reach_dict = {i + 1: -1  for i in range(N)}
    shortest_reach_dict[start] = 0

    visited = set()
    while len(queue) != 0:
        node = queue.pop(0)
        neighbors = adjacency_dict[node]
        for n in neighbors:
            if n not in visited:
                queue.append(n)
                shortest_reach_dict[n] = shortest_reach_dict[node] + 6
    sorted_reach_list = sorted(filter(lambda x: x > 0, shortest_reach_dict.values))
    return sorted_reach_list + [-1] * (N - len(sorted_reach_list) + 1)


tests = input()
for p in range(test):
    print shortest_reach()
