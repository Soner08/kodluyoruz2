liste = [[1,'a',['cat'],2],[[[3]],'dog'],4,5]
l1 = []
def flatten(n):
    for i in n :
        if isinstance(i,list):
            flatten(i)
        else:
            l1.append(i)

flatten(liste)
print(l1)

input = [[1, 2], [3, 4], [5, 6, 7]]
input.reverse()
for i in range(len(input)):
    (input[i])=(input[i])[::-1]

print(input)