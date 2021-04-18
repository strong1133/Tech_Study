# 항해99_알고리즘_2021-03-16 백준번호: 8958_OX퀴즈../by 정석진

r = int(input())
for _ in range(r):
    ox = input()
    arr = [i for i in str(ox)]
    s = 0
    c = 1
    for i in arr:
        if i == 'O':
            s += c
            c += 1
        else:
            c = 1

    print(s)
