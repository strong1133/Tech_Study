# 프로그래머스_알고리즘_2021-03-21, level01_두 정수 사이의 합../by 정석진

def solution(a, b):

    answer = 0

    for item in range(min(a, b), max(a, b)+1):

        answer += item

    return answer
