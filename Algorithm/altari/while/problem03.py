# 항해99_알고리즘_2021-03-16 백준번호: 1110_더하기 사이클../by 정석진

num = int(input())

if num < 10:
    num * 10

cnt = 0
origin = num
newnum = 0

while 1:
    temp = (num//10) + (num % 10)
    newnum = ((num % 10)*10) + (temp % 10)
    num = newnum
    cnt += 1
    if origin == newnum:
        break
print(cnt)
