- listsのサイズがn, listのサイズの最大値がmの時
  - 各リストの値の最小値を求めるのにループn, それをm回繰り返すから時間計算量はO(n*m)？
  - 最終的に返すリストの長さは最大n*m個のリストがつながっているからO(n*m)？
- listsがnull, もしくは各listが全てnullだった時のコーナーケースを考えないといけない
- また、listの繋ぎ忘れ、もしくは最後に余計なlistを繋げてしまうことにも注意
