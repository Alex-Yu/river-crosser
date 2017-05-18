package org.alexy.river


case class Pos(col: Int) extends AnyVal {
  def deltaCol(d: Int): Pos = copy(col = col + d)
}

case class MoveRight(velocity: Int) extends AnyVal

trait Universe {
  case class State(pos: Pos, velocity: Int) {
    require(velocity >= 0, "Velocity can't be negative")

    def right(v: Int): State = copy(pos.deltaCol(v), v)

    def isLegal: Boolean = drySpace(pos)

    def steps: List[(State, MoveRight)] =
      (velocity - 1 to velocity + 1).withFilter(_ > 0).map[(State, MoveRight), List[(State, MoveRight)]] { d =>
        (right(d), MoveRight(d))
      }(collection.breakOut)

    def legalSteps: List[(State, MoveRight)] = steps.filter(_._1.isLegal)

  }

  val startState: State

  type ValidPosition = Pos => Boolean

  val drySpace: ValidPosition

  val goal: ValidPosition
}