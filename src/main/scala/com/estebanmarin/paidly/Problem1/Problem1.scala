package com.estebanmarin.paidly.Problem1

import zio.*
import scala.util.*

final case class Problem1()
object Problem1:
  lazy val suffix = List("th", "st", "nd", "rd", "th")
  private def getInt(value: String): IO[Throwable, Int] = Try(value.toInt) match
    case Success(v) => ZIO.succeed(v)
    case Failure(e) => ZIO.fail(throw new RuntimeException(s"[P1 => error]: provide a number $e"))

  private def getOrdinal(value: Int): IO[Throwable, String] = Try(
    value.toString() + {
      if 11 <= (value % 100) || (value % 100) <= 13 then suffix(0)
      else suffix((value % 10).min(4))
    }
  ) match
    case Success(value) => ZIO.succeed(value)
    case Failure(e) => ZIO.fail(throw new RuntimeException(s"[P1 => error]: improve getOrdinal Method $e"))

  def p1Program(numberInput: String): IO[Throwable, String] =
    for
      int <- getInt(numberInput)
      ordinal <- getOrdinal(int)
    yield ordinal

  val live = ZLayer.succeed(Problem1())
