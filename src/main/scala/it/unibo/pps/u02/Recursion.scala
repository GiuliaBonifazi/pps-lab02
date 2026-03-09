package it.unibo.pps.u02

import scala.annotation.tailrec

object Recursion {
  def power(base: Double, exponent: Int): Double = exponent match
    case 0 => 1
    case _ => base * power(base, exponent - 1)

  @tailrec
  def powerWithTail(base: Double, exponent: Int, acc: Double): Double = exponent match
    case 0 => acc
    case _ => powerWithTail(base, exponent - 1, base * acc)

  @tailrec
  def reverseNumberAcc(currNumber: Int, revNumber: Int): Int = currNumber / 10 match
    case 0 => revNumber * 10 + currNumber
    case x => reverseNumberAcc(
      x,
      revNumber * 10 + currNumber % 10,
    )

  def reverseNumber(n: Int): Int = n / 10 match
    case 0 => n
    case _ => reverseNumberAcc(n, 0)
}

@main
def mainRecursion() = {
  import Recursion.*
  println("Power:")
  println("5^4 => " + power(5, 4))
  println("5^0 => " + power(5, 0))
  println("1^6 => " + power(1, 6))

  println("Power with tail recursion:")
  println("5^4 => " + powerWithTail(5, 4, 1))
  println("5^0 => " + powerWithTail(5, 0, 1))
  println("1^6 => " + powerWithTail(1, 6, 1))

  println()
  println("Reverse number")
  println("0 => " + reverseNumber(0))
  println("7 => " + reverseNumber(7))
  println("14 => " + reverseNumber(14))
  println("12345 => " + reverseNumber(12345))
}