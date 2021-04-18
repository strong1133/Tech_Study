# 프로그래머스_알고리즘_2021-03-14, level01_시저암호../by 정석진

def solution(s, n):
    s = list(s)
    for i in range(len(s)):
        if s[i].isupper():  # 대문자 찾기
            s[i] = chr((ord(s[i])-ord('A')+n) %
                       26+ord('A'))  # 아스키 코드 변환하는 함수들 %26 로 대소문자 넘나들기
        elif s[i].islower():  # 소문자 찾기
            s[i] = chr((ord(s[i])-ord('a')+n) % 26+ord('a'))
    return "".join(s)


print(solution(input(), int(input())))
