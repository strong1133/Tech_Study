# 항해99_알고리즘_2021-03-16 백준번호: 2562_최댓값_/by 정석진

arr = []
for i in range(9):
    a = int(input())
    arr.append(a)

max_ = max(arr)
ind = arr.index(max_)+1
print(max_)
print(ind)
