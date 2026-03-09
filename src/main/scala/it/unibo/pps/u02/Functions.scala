package it.unibo.pps.u02

object Functions {

  // part 1

  def methodPositive(x: Int): String = x match
    case x if x >= 0 => "positive"
    case _ => "negative"

  val valPositive: Int => String = {
    case x if x >= 0 => "positive"
    case _ => "negative"
  }

  // part 2

  val valNeg: (String => Boolean) => String => Boolean = func => s => !func(s)

  def methodNeg(func: (String => Boolean))(s: String): Boolean = !func(s)

  // part 3

  val p1: Int => Int => Boolean => Boolean = x => y => z => (x<=y) == z
  val p2: (Int, Int, Boolean) => Boolean = (x, y, z) => (x<=y) == z
  def p3(x: Int)(y: Int)(z: Boolean): Boolean = (x<=y) == z
  def p4(x: Int, y: Int, z: Boolean): Boolean = (x<=y) == z

  // part 4
  val compose: (Int => Int) => (Int => Int) => Int => Int = f => g => x => f(g(x))
}

@main
def main() = {
  import Functions.*
  println("Part 1")
  println("Method:")
  println(methodPositive(4))
  println(methodPositive(0))
  println(methodPositive(-5))
  println("Val:")
  println(valPositive(4))
  println(valPositive(0))
  println(valPositive(-5))
  println()

  println("Part 2")
  val empty: String => Boolean = _ == ""
  val valNotEmpty = valNeg(empty)
  val methodNotEmpty = methodNeg(empty)
  println("Method:")
  println(methodNotEmpty(""))
  println(methodNotEmpty("banana"))
  println("Val:")
  println(valNotEmpty(""))
  println(valNotEmpty("banana"))
  println()

  println("Part 3")
  println("Curried val (p1):")
  val truep1 = p1(3)(4)
  println("x: 3, y:4, z: true => " + truep1(true))
  println("x: 3, y:4, z: false => " + truep1(false))
  val falsep1 = p1(5)(3)
  println("x: 5, y:3, z: true => " + falsep1(true))
  println("x: 5, y:3, z: false => " + falsep1(false))
  println("Non-curried val (p2):")
  println("x: 3, y:4, z: true => " + p2(3, 4, true))
  println("x: 3, y:4, z: false => " + p2(3, 4, false))
  println("x: 5, y:3, z: true => " + p2(5, 3, true))
  println("x: 5, y:3, z: false => " + p2(5, 3, false))
  println("Curried def (p3):")
  val truep3 = p3(3)(4)
  println("x: 3, y:4, z: true => " + truep3(true))
  println("x: 3, y:4, z: false => " + truep3(false))
  val falsep3 = p3(5)(3)
  println("x: 5, y:3, z: true => " + falsep3(true))
  println("x: 5, y:3, z: false => " + falsep3(false))
  println("Non-curried val (p4):")
  println("x: 3, y:4, z: true => " + p4(3, 4, true))
  println("x: 3, y:4, z: false => " + p4(3, 4, false))
  println("x: 5, y:3, z: true => " + p4(5, 3, true))
  println("x: 5, y:3, z: false => " + p4(5, 3, false))
  println()

  println("Part 4")
  def f(x: Int): Int = x - 1
  def g(x: Int): Int = x * 2
  println("f(x: Int): Int = x - 1")
  val composeF = compose(f)
  println("g(x: Int): Int = x * 2")
  println("f(g(5)) => " + composeF(g)(5))
  def h(x: Int): Int = x/4
  println("h(x: Int): Int = x/4")
  println("f(h(5)) => " + composeF(h)(5))
  println("g(h(5)) => " + compose(g)(h)(5))
  println("h(g(5)) => " + compose(h)(g)(5))
}
