package it.unibo.pps.u02

import org.junit.Assert.assertEquals
import org.junit.Test

class ExprTest {
  import Expr.*

  @Test def testEvaluateLiteral(): Unit =
    val value: Int = 5
    val expression = Literal(value)
    assertEquals(value, evaluate(expression))

  @Test def testEvaluateLiteralAdd(): Unit =
    val left: Int = 5
    val right: Int = 7
    val expression = Add(Literal(left), Literal(right))
    assertEquals(left + right, evaluate(expression))

  @Test def testEvaluateLiteralMultiply(): Unit =
    val left: Int = 8
    val right: Int = 9
    val expression = Multiply(Literal(left), Literal(right))
    assertEquals(left * right, evaluate(expression))

  @Test def testEvaluateComplexExpr(): Unit =
    val addition = 5 + 7
    val multiplication = 10 * 3
    val left = Add(Literal(5), Literal(7))
    val right = Multiply(Literal(10), Literal(3))
    val expression = Multiply(left, right)
    assertEquals(addition * multiplication, evaluate(expression))

  @Test def testShowLiteral(): Unit =
    val value = 7
    val expression = Literal(value)
    assertEquals(s"$value", show(expression))

  @Test def testShowAdd(): Unit =
    val left = 7
    val right = 6
    val expression = Add(Literal(left), Literal(right))
    assertEquals(s"$left + $right", show(expression))

  @Test def testShowMultiply(): Unit =
    val left = 10
    val right = 1
    val expression = Multiply(Literal(left), Literal(right))
    assertEquals(s"$left * $right", show(expression))

  @Test def testShowComplexExpr(): Unit =
    val leftAdd = 4
    val rightAdd = 9
    val leftMultiply = 10
    val rightMultiply = 3
    val left = Add(Literal(leftAdd), Literal(rightAdd))
    val right = Multiply(Literal(leftMultiply), Literal(rightMultiply))
    val expression = Add(left, right)
    assertEquals(s"$leftAdd + $rightAdd + $leftMultiply * $rightMultiply", show(expression))
}
