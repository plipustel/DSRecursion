def foo(depth):
    if depth > 3: # depth of tree
        return   
    for i in range(3): # nodes
        print(depth, i)
        foo(depth + 1)
    print()
     
foo(0)