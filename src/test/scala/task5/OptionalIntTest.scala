package task5

import org.junit.*
import org.junit.Assert.*
import Optionals.*
import task5.Optionals.OptionalInt.isEmpty

class OptionalIntTest:
  @Test def emptyOptionalShouldBeEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertTrue(OptionalInt.isEmpty(empty))

  @Test def nonEmptyOptionalShouldNotBeEmpty(): Unit =
    val nonEmpty = OptionalInt.Just(0)
    assertFalse(OptionalInt.isEmpty(nonEmpty))

  @Test def orElseShouldReturnDefaultWhenEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertEquals(1, OptionalInt.orElse(empty, 1))

  @Test def orElseShouldReturnValueWhenNonEmpty(): Unit =
    val nonEmpty = OptionalInt.Just(0)
    assertEquals(0, OptionalInt.orElse(nonEmpty, 1))

  /** Task 5: do test for map **/
  @Test def mapIntShouldReturnMappedValueWhenNonEmpty(): Unit =
    val value = 5
    val nonEmpty = OptionalInt.Just(value)
    val mapFunction: (Int) => Int = x => x + 1
    assertEquals(
      OptionalInt.Just(mapFunction(value)),
      OptionalInt.mapInt(nonEmpty)(mapFunction)
    )

  @Test def mapIntShouldReturnEmptyWhenEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertTrue(isEmpty(OptionalInt.mapInt(empty)(_ + 1)))

  @Test def filterShouldReturnEmptyWhenEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertTrue(isEmpty(OptionalInt.filter(empty)(_ < 4)))

  @Test def filterShouldReturnEmptyWhenFalse(): Unit =
    val nonEmpty = OptionalInt.Just(9)
    assertTrue(isEmpty(OptionalInt.filter(nonEmpty)(_ < 4)))

  @Test def filterShouldReturnParameterWhenTrue(): Unit =
    val nonEmpty = OptionalInt.Just(6)
    assertEquals(nonEmpty, OptionalInt.filter(nonEmpty)(_ > 5))