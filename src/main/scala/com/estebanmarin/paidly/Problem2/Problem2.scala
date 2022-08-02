package com.estebanmarin.paidly.Problem2

import com.github.nscala_time.time.Imports.*
import zio.*
import scala.util.*
import com.github.nscala_time.time.Imports

final case class Problem2()
object Problem2:
  def live = ZLayer.succeed(Problem2())
  private val formater = DateTimeFormat.forPattern("dd-mm-yyyy")
  private def parseDate(str: String): IO[Throwable, DateTime] = Try(formater.parseDateTime(str)) match
    case Success(v) =>
      v match
        case date: DateTime => ZIO.succeed(date)
        case _ => ZIO.fail(throw new RuntimeException(s"[P2] date parsing issue"))
    case Failure(e) => ZIO.fail(throw new RuntimeException(s"[P2] date parsing issue"))

  def getWeekdayInterval(d1: String, d2: String) = 
    for 
        date1: DateTime <- parseDate(d1)
        date2: DateTime <- parseDate(d2)
        _ <- Console.printLine(s"${date1} ${date2}")
    yield ()
