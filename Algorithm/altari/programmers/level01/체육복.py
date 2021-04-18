# 프로그래머스_알고리즘_2021-03-14, level01_체육복../by 정석진

def solution(n, lost, reserve):
    set_reserve = set(reserve) - set(lost)
    set_lost = set(lost) - set(reserve)
    for i in set_reserve:
        if i-1 in set_lost:
            set_lost.remove(i-1)
        elif i+1 in set_lost:
            set_lost.remove(i+1)
    return n-len(set_lost)


print(solution(5, [2, 4], [1, 2, 5]))
