# 프로그래머스_알고리즘_2021-03-13, level01_나누어 떨어지는 숫자 배열_/by 정석진

def solution(arr, divisor):
    answer = []
    for i in arr:
        if i % divisor == 0:
            answer.append(i)
    if len(answer) == 0:
        answer.append(-1)
    return sorted(answer)

#
# def solution(arr, divisor): return sorted([n for n in arr if n%divisor == 0]) or [-1]
# sorted가 비어있으면 거짓이므로 뒤어꺼 반환
#
