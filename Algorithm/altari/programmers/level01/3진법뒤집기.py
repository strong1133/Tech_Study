# 프로그래머스_알고리즘_2021-03-30, level01_3진법 뒤집기../by 정석진

def solution(n):
    if n <= 3:
        return n

    arr1 = []
    res = 0
    while 1:
        na = n % 3
        arr1.append(na)
        mok = n // 3
        n = mok
        if mok < 3:
            arr1.append(mok)
            break
    l = len(arr1)-1
    for i in arr1:
        res += (i*(3**l))
        l -= 1
    return res


print(solution(1))
