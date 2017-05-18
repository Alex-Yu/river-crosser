package org.alexy.river

trait Solver extends Universe {
  def done(s: State): Boolean = goal(s.pos)

  def stepsWithHistory(s: State, history: List[MoveRight]): Stream[(State, List[MoveRight])] =
   s.legalSteps.map[(State, List[MoveRight]), Stream[(State, List[MoveRight])]] { case (n, m) =>
      (n, m :: history)
    } (collection.breakOut)


  def from(initial: Stream[(State, List[MoveRight])]): Stream[(State, List[MoveRight])] =
    if (initial.isEmpty) Stream.empty
    else {
      val more = for {
        (s, h) <- initial
        neighbors <- stepsWithHistory(s, h)
      } yield neighbors
      initial #::: from(more)
    }

  lazy val pathsFromStart: Stream[(State, List[MoveRight])] = from(Stream((startState, List.empty)))

  lazy val pathsToGoal: Stream[(State, List[MoveRight])] = pathsFromStart.filter{ case (s, _) => done(s) }

  lazy val solution: List[MoveRight] =
    pathsToGoal.headOption
      .map(_._2.reverse)
      .getOrElse(List.empty)
}
