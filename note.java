// 要知道 "邊界" 的概念, l,r代表左邊和右邊的邊界
// 要用甚麼型態?
// 初值怎麼給?
// 如何由這兩個值判斷更改的條件? 何時知道已經完成?
if x >= 1
then 1 <= x ** 0.5 <= x
elif x < 1
then x <= x ** 0.5 <= 1
-
if x >= 1 :
    l, r = 1, x
else x < 1 :
    l, r = x, 1
-
mid = (l+r)/2
while mid > l and mid < r :
    if mid*mid < x :
        l = mid
    else :
        r = mid
    mid = (l+r)/2

方法不是重點
資料表達才是