# 프로그래머스_알고리즘_2021-03-23, level01_최소공배수, 최대 공약수../by 정석진

import math


def solution(n, m):
    a = math.gcd(n, m)
    b = n*m//a
    answer = [a, b]
    return answer
