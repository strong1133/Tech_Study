# 프로그래머스_알고리즘_2021-03-31, 하샤드 수 y 정석진

def solution(x):
    arr = [int(i) for i in str(x)]
    v = sum(arr)
    if x % v == 0:
        return True
    return False


print(solution(10))
