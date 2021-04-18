# 항해99_알고리즘_2021-03-16 백준번호: 1546_평균../by 정석진

n = int(input())
score = list(map(int, input().split()))
m = max(score)
new_score = []
for i in score:
    new = (i/m)*100
    new_score.append(new)

print(sum(new_score)/n)
