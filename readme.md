Here's the problem:
 
There's a river that you need to cross without getting wet. Fortunately, this river has 
a series of stepping stones that run across it arranged non-uniformly generally. 
The distance between any 2 adjacent stones is some unit multiple, e.g., "#" is a stone 
and "-" is the river (water) and the unit distance, we can have the following:
 
    #--#---#--#----#--#
    --#---#----#---#-#--
    ---#----#---#--#----
 
Given any arrangement of stones, an initial velocity measured in unit distances, and 
being able to accelerate/decelerate +1/-1, or 0 when you've landed on a stepping stone,
write code that will find a solution, if it exists, given an initial velocity 
(some nonnegative integer value) and some arrangement of stones along the river. 
"Velocity" in this sense is the number of steps you can move, so if your velocity is 4 
you can move 4 steps. The problem starts with an initial velocity (may be 0) and at the bank 
of the river where you can choose +1, -1, or 0 acceleration.

Вопросы:
1) Стартовая позиция находится на берегу которого на рисунке нет и который можно рассматривать 
как непрерывный набор камней находящийся над верхним краем реки? Или стартовая позиция все таки 
на одном из камней верхнего края реки, который есть на рисунке?
2) Можно двигаться только горизонтально/вертикально или как-то еще(по диагонали, произвольные фигуры)?
3) термин velocity означает на какое расстояние можно "перепрыгнуть" (пролетев как '-' так и '#') 
за 1 ход с камня/берега(#) на камень/берег(#) ?  
4) целевая позиция это любая позиция противополжного берега, которого на рисунке нет и который 
можно рассматривать как непрерывный набор камней находящийся под нижним краем реки? Или целевая 
позиция все таки на любом из камней нижнего края реки, который есть на рисунке?

Ответы:
[18:13:45] Cyril Ponomaryov: привет, вот ответы на вопросы:
В задании описано 3 набора входных данных для 3 разных кейсов: одна строка описывает один кейс
#--#---#--#----#--#
--#---#----#---#-#--
---#----#---#--#----
1) 0 1 2 3 4 5 6 7 8 9 10 ...
       # - - #  -  - - # -
    Старт должен быть в точке 0
2) Можно двигаться только горизонтально и только вправо
3) да
4) 0 1 2 3 4 5 6 7 8 9 10 11 …
       # - - #  -  - - # -
    Финиш может быть в любой точке с индексом >= 10
[18:14:48] Cyril Ponomaryov: Если еще есть вопросы, задавай
[18:15:58] Alex Yukhymenko: привет
[18:16:53] Alex Yukhymenko:     Старт должен быть в точке 0
Тоесть в 0 точке всегда должен быть #?
[18:17:17] Cyril Ponomaryov: Можно считать и так
[18:18:04] Alex Yukhymenko: Финиш может быть в любой точке с индексом >= 10
имеется ввиду что начиная с 10 позиции всегда берег и длина реки всегда 10?
[18:19:24] Cyril Ponomaryov: длинна реки задается, считается, что после длины реки всегда берег
[18:20:55] Alex Yukhymenko: тоесть 10 было просто для примера - ок, пока понятно. Спасибо
[18:21:04] Cyril Ponomaryov: именно так
[18:21:46] Alex Yukhymenko: какие-то особые требования к коду есть?
[18:23:47] Cyril Ponomaryov: нет


