def grid_search():
    params = map(int, raw_input().split())
    text_rows = params[0]
    text_cols = params[1]
    text = [''] * text_rows
    for i in range(text_rows):
        text[i] = raw_input()

    params = map(int, raw_input().split())
    pattern_rows = params[0]
    pattern_cols = params[1]
    pattern = [''] * pattern_rows
    for i in range(pattern_rows):
        pattern[i] = raw_input()

    for i in range(1 + text_rows - pattern_rows):
        for j in range(1 + text_cols - pattern_cols):
            if text[i][j:pattern_cols + j] == pattern[0]:
                for k in range(1, pattern_rows):
                    if text[i + k][j:pattern_cols + j] == pattern[k]:
                        if k == (pattern_rows - 1):
                            print 'YES'
                            return
                        continue
                    else:
                        break
    print 'NO'

cases = input()
for z in range(cases):
    grid_search()
