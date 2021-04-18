# 프로그래머스_알고리즘_2021-03-25, level01_정수 제곱근../by 정석진

import math


def solution(n):
    num = math.sqrt(n)
    if math.sqrt(n) == int(math.sqrt(n)):
        return pow(num+1, 2)
    return -1
