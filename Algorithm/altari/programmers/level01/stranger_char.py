# 항해99_알고리즘_2021-03-17, 백준번호: 2667_단지번호 정하기../by 정석진
def solution(s):
    ss = s.split(" ")
    for x in range(len(ss)):
        arr = list(ss[x])

        for i in range(len(arr)):
            if i % 2 == 0:
                arr[i] = arr[i].upper()
            elif i % 2 == 1:
                arr[i] = arr[i].lower()
        ss[x] = "".join(arr)

    ans = " ".join(ss)
    return ans


print(solution("try hello world"))
