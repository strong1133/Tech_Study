# 프로그래머스_알고리즘_2021-03-14, level01_문자열내림차순배치../by 정석진
def solution(s):
    answer = sorted(s, reverse=True)
    a = ''
    for i in answer:
        a += str(i)
    return a
