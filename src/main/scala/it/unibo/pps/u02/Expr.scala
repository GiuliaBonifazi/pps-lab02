package it.unibo.pps.u02

enum Expr:
  case Literal(value: Int)
  case Add(leftSide: Expr, rightSide: Expr)
  case Multiply(leftSide: Expr, rightSide: Expr)

object Expr {
  import Expr.*

  def evaluate(expression: Expr): Int = expression match
    case Literal(v) => v
    case Add(left, right) => evaluate(left) + evaluate(right)
    case Multiply(left, right) => evaluate(left) * evaluate(right)

  def show(expression: Expr): String = expression match
    case Literal(v) => s"$v"
    case Add(left, right) => s"${show(left)} + ${show(right)}"
    case Multiply(left, right) => s"${show(left)} * ${show(right)}"
}