package com.estebanmarin.paidly.Problem2

import com.github.nscala_time.time.Imports.*
import zio.*
import scala.util.*
import com.github.nscala_time.time.Imports
import org.joda.time.DateTimeConstants
import scala.annotation.tailrec

final case class Problem2()
object Problem2:
  def live = ZLayer.succeed(Problem2())
  private val formater = DateTimeFormat.forPattern("dd-mm-yyyy")
  private def parseDate(str: String): IO[Throwable, DateTime] = Try(
    formater.parseDateTime(str)
  ) match
    case Success(v) =>
      v match
        case date: DateTime => ZIO.succeed(date)
        case _ => ZIO.fail(throw new RuntimeException(s"[P2] date parsing issue"))
    case Failure(e) => ZIO.fail(throw new RuntimeException(s"[P2] date parsing issue"))

  private def controlFlow(
      d1: DateTime,
      d2: DateTime,
    )(
      f: (a: DateTime, b: DateTime) => Int
    ): IO[Throwable, Int] =
    Try(if d1 < d2 then f(d1, d2) else f(d2, d1)) match
      case Success(v) => ZIO.succeed(v)
      case Failure(e) => ZIO.fail(throw new RuntimeException(s"[P2] error calculating Int"))

  private def getInterval(d1: DateTime, d2: DateTime): Int =
    val sunday = d1.withDayOfWeek(DateTimeConstants.SUNDAY)
    @tailrec def countDaysT(date: DateTime, acc: Int): Int =
      if date.isAfter(d2) then acc else countDaysT(date + 1.week, acc + 1)
    countDaysT(d1, 0)

  def getWeekdayInterval(d1: String, d2: String) =
    for
      date1: DateTime <- parseDate(d1)
      date2: DateTime <- parseDate(d2)
      numberOfSundays: Int <- controlFlow(date2, date1)(getInterval)
    yield numberOfSundays
