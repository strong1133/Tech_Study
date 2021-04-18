# 프로그래머스_알고리즘_2021-03-22, level01_자릿수 더하기../by 정석진
def solution(n):

    return n if n < 10 else (n % 10)+solution((n//10))
