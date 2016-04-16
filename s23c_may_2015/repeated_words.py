words = re.split('\W+',s)
    word_set = set()
    for word in words:
        if word in word_set:
            return word
        word_set.add(word)
