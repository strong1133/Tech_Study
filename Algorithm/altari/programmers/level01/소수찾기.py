# 프로그래머스_알고리즘_2021-03-21, level01_소수찾기../by 정석진

def solution(n):
    num = set(range(2, n+1))

    for i in range(2, n+1):
        if i in num:
            num -= set(range(2*i, n+1, i))  # 에라토네스 체의 응용
            # set(range(2*i, n+1, i)) 이부분은 만약 i가 2인 경우 2*i= 4 부터 n+1 까지 i만큼 늘어난다.
            # 즉, n=10, i=2 일때 set(4,6,8,10)가 됨으로 차집합으로 지워주는 로직
            #
    return len(num)  # num안에 남아있는 것들은 소수 이므로 길이를 재준다.
