# 항해99_알고리즘_2021-03-16 백준번호: 2577_숫자의 개수../by 정석진

a = int(input())
b = int(input())
c = int(input())

res = [i for i in str(a*b*c)]

for i in range(10):
    print(res.count(str(i)))
