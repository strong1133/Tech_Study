# 항해99_알고리즘_2021-03-16 백준번호: 3052_나머지../by 정석진

arr = []
for i in range(10):
    a = int(input())
    arr.append(a % 42)

arr = set(arr)
print(len(arr))
