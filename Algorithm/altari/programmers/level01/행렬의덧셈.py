# 프로그래머스_알고리즘_2021-03-18, level01_행렬의 덧셈_/by 정석진
def sumMatrix(A, B):
    answer = [[c + d for c, d in zip(a, b)] for a, b in zip(A, B)]
    return answer


def sumMatrix(A, B):
    for i in range(len(A)):
        for j in range(len(A[0])):
            A[i][j] += B[i][j]
    return A
