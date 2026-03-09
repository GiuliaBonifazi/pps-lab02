package it.unibo.pps.u02

class Testing {
  def mult(x: Double, y: Double): Double = x * y
  // def mult(x: Double, y: Double): Double

  def curriedMult(x: Double)(y: Double): Double = x * y
  // def curriedMult(x: Double)(y: Double): Double

  mult(3, 4)
  //val res0: Double = 12.0

  //  curriedMult(5, 7)
  // [E007] Type Mismatch Error

  curriedMult(5)(7)
  // val res1: Double = 35.0

  val multBy5 = curriedMult(5)
  // val multBy5: Double => Double = Lambda$1857 / 0x000002011759ec58@755ed2e1

  multBy5(6)
  // val res2: Double = 30.0

  multBy5(9)
  // val res3: Double = 45.0

  def divide(x: Int, y: Int): Int = x / y
  // def divide(x: Int, y: Int): Int

  def curriedDivide(x: Int)(y: Int): Int = x / y
  // def curriedDivide(x: Int)(y: Int): Int

  val divide45 = curriedDivide(45)
  // val divide45: Int => Int = Lambda$1868 / 0x000002011762b528@2de29667

  divide45(5)
  // val res4: Int = 9

  divide45(6)
  // val res5: Int = 7

  val h: (Int, Int, (Int, Int) => Int) => Int = (a, b, f) => f(a, b)
  // val h: (Int, Int, (Int, Int) => Int) => Int = Lambda$1905 / 0x00000201176309f8@5974317b

  h(4, 5, divide)
  // val res6: Int = 0
}
