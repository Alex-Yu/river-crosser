package org.alexy.river

import scala.io.StdIn._

object Main extends App {
  trait River extends Solver with RiverUniverse

  print("Enter the river template or press ENTER for default (#--#---#---#----#--#): ")
  val r = readLine()
  print("Enter initial velocity or press ENTER for default (0): ")
  val v = readLine()
  require(v.isEmpty || v.forall(_.isDigit))

  object River extends River {
    override val river: String = if (r.isEmpty) "#--#---#---#----#--#" else r
    override val startVelocity: Int = if (v.isEmpty) 0 else v.toInt
  }

  val result = River.solution
  val strResult =
    if (result.isEmpty) "No solution found."
    else "Solution:  " + result.flatMap[Char, String](m => s"(${m.velocity})" +
      s"->")(collection.breakOut)

  println(strResult)
}