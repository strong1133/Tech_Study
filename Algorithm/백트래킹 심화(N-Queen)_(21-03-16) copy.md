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
<img src ="https://kyun2da.github.io/img/algorithm/nQueen.gif" width=60%></img>
</div>
<br/><br/>

 > 풀이

 ### 퀸과 퀸이 겹치는 경우
  - 퀸이 같은 가로줄에 있을때
  - 퀸이 같은 세로줄에 있을때
  - 퀸이 같은 대각선에 있을때

    `해당 경우들을 피해서 DFS탐색`

<div style ="text-align:center">
<img src ="https://github.com/strong1133/TIL/blob/main/img/qimg01.png?raw=true" width=89%></img>
</div>

 - n=4일때 경우의 수는 2이다.
 - 노드의 깊이가 n과 같아질뗴 성공한것으로 간주할수 있다.
 - 그렇다면 현재 놓여져 있는 퀸을 담을 변수 arr[]을 만들고 
 - 아래 줄 4칸에 해당하는 후보자들을 담아줄 candidate를 만들어준다
 - candidate에서 값을 하나씩 꺼내와 arr[i] 에 해당하는것이 있는지 비교해주고 있으면 후보에서 제외 해준다.
 - 해당 방법으로 수직, 대각선 방향에 있는 것들을 후보에서 제거해준다. -> `배제`
 - 위 과정을 거치고도 candidate안에 있다면 그것은 기존의 퀸과 겹치지 않는 다는 뜻
 - 새롭게 위치한 퀸에서부터 다음단계로 나아가야하니 현재 놓인 퀸의 값인 arr[]에 append
 - 새로운 arr[]을 사용해서 재귀해주고 
 - 퀸이 다른 위치에 놓였을 때 경의수를 찾아주기 위해 arr.pop() 수행  -> `백트래킹`
 - 퀸이 놓일수 있는 위치를 1층 부터 n층 까지 다찾았다면 깊이가 length == n 이된다.
 - 따라서 length == n 일때 `현재 함수`를 return해주면 된다.
 
