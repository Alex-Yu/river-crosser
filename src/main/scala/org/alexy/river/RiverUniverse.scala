package org.alexy.river

trait RiverUniverse extends Universe {
  /**
    * '#' - stone
    * '-' - water
    * Must start with '#' and be nonEmpty
    */
  val river: String

  val startVelocity: Int

  def drySpaceFunction(riverVector: Vector[Char]): ValidPosition = { pos =>
    val col = pos.col
    col >= 0 && (goalFunction(riverVector)(pos) || riverVector(col) != '-')
  }

  def goalFunction(riverVector: Vector[Char]): ValidPosition = _.col >= riverVector.size

  private lazy val riverVector: Vector[Char] = {
    require(river.nonEmpty, "River must be nonEmpty")
    require(river.charAt(0) == '#', "River must start with stone '#'")
    require(river.forall(Set('#', '-').contains), "River consists from '#' and '-' only")
    river.toVector
  }

  override lazy val startState: State = State(Pos(0), startVelocity)
  override lazy val drySpace: ValidPosition = drySpaceFunction(riverVector)
  override lazy val goal: ValidPosition = goalFunction(riverVector)
}
