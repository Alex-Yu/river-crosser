package org.alexy.river

trait TestHelper {
  class SolutionChecker(override val river: String, override val startVelocity: Int)
    extends RiverUniverse with Solver {
    def solve(ls: List[MoveRight]): State =
      ls.foldLeft(startState)(_ right _.velocity)
  }

  val surmountableRiver1 = new SolutionChecker("#--#---#---#--#-#", 3) {
    val validSolution = List(MoveRight(3), MoveRight(4), MoveRight(4), MoveRight(3), MoveRight(3))
  }

  val surmountableRiver2 = new SolutionChecker("#--#---#----#---#-#--", 3) {
    val validSolution = List(MoveRight(3), MoveRight(4), MoveRight(5), MoveRight(4), MoveRight(5))
  }

  val surmountableRiver3 = new SolutionChecker("#---#----#---#--#----", 13) {
    val validSolution = List(MoveRight(13), MoveRight(12))
  }

  val surmountableRiver4 = new SolutionChecker("#-", 1) {
    val validSolution = List(MoveRight(2))
  }

  val surmountableRiver5 = new SolutionChecker("#---#", 4) {
    val validSolution = List(MoveRight(5))
  }

  val surmountableRiver6 = new SolutionChecker("#--#-#", 4) {
    val validSolution = List(MoveRight(3), MoveRight(3))
  }

  val insurmountableRiver = new SolutionChecker("#--#---#-----#--#", 2) {
    val validSolution: List[MoveRight] = Nil
  }

  val noRiver = new SolutionChecker("", 2)

  val strangeRiver = new SolutionChecker("#--K---#-----#--#", 2)

  val negativeVelocityRiver = new SolutionChecker("#----#-----#--#", -1)

  val noFirstStoneRiver = new SolutionChecker("-----#-----#--#", 1)
}
