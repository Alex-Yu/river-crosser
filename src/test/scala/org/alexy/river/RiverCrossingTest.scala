package org.alexy.river

import org.specs2.mutable.Specification


class RiverCrossingTest extends Specification with TestHelper {

  "River crossing specification" >> {
    "should return list of correct moves to cross the river" >> {
      surmountableRiver1.solution mustEqual surmountableRiver1.validSolution
      surmountableRiver2.solution mustEqual surmountableRiver2.validSolution
      surmountableRiver3.solution mustEqual surmountableRiver3.validSolution
      surmountableRiver4.solution mustEqual surmountableRiver4.validSolution
    }

    "should return solution with minimal moves and velocity" >> {
      surmountableRiver5.solution mustEqual surmountableRiver5.validSolution
      surmountableRiver6.solution mustEqual surmountableRiver6.validSolution
    }

    "should return empty list when it can't cross the river" >> {
      insurmountableRiver.solution mustEqual insurmountableRiver.validSolution
    }

    "should throw an exception when river is empty" >> {
      noRiver.solution must throwAn[IllegalArgumentException]
    }

    "should throw an exception when there is unacceptable objects in river" >> {
      strangeRiver.solution must throwAn[IllegalArgumentException]
    }

    "should throw an exception when starting velocity is negative" >> {
      negativeVelocityRiver.solution must throwAn[IllegalArgumentException]
    }

    "should throw an exception when river isn't starting from stone" >> {
      noFirstStoneRiver.solution must throwAn[IllegalArgumentException]
    }
  }
}
