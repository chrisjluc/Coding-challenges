def equal_subtrees(n):
    if n.left is None and n.right is None:
        return True
    elif n.left is not None and n.right is not None:
        if equal_subtrees(n.left) and equal_subtrees(n.right) and n.left == n.right:
                return True

    return False
