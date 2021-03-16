i> # TIL - 2021-03-15

## 💡 백트레킹
<hr/>


- 백트래킹은 모든 경우의 수를 잔부 고려하는 알고리즘..
- 일종의 탐색 알고리즘이며 DFS와 BFS 두가지로 구현이 가능

<div style ="text-align:center">
<img src="https://kyun2da.github.io/img/algorithm/backTracking.png" width = "80%" ></img>
</div>
  - `답이 될수 없는 후보는 더이상 들어가지 않고 되돌아 가는 방법을 의미한다!`
  - 부르트포스 방법보다 훨씬 더 빠르게 탐색 가능
  - 참고 영상: https://youtu.be/Enz2csssTCs
  <br/>

## 💡 백트레킹 예시
<hr/>

```python
  procedure bt(c) is
    if reject(p, c) then return
    if accept(p, c) then output(p, c)
    s <- first(p, c)
    while s != Null do
      bt(s)
      s <- next(p, s)
```
  - reject(p, c): 다음의 노드가 후보가 아니면 return 종료
  - accept(p, c): 현재 노드가 답과 일치한다면 출력

  <br/>

## 💡 백트래킹 대표문제 _ N-Queen
<hr/>
<div style ="text-align:center">
<img src ="https://kyun2da.github.io/img/algorithm/nQueen.gif" width=80%></img>
</div>
<br/><br/>

 > 풀이

 ### 퀸과 퀸이 겹치는 경우
  - 퀸이 같은 가로줄에 있을때
  - 퀸이 같은 세로줄에 있을때
  - 퀸이 같은 대각선에 있을때

    `해당 경우들을 피해서 DFS탐색`