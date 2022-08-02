package com.estebanmarin
package paidly

import zio.*
import com.estebanmarin.paidly.UserInput.*
import com.estebanmarin.paidly.Problem1.*
import com.estebanmarin.paidly.Problem2.*

object PaidlyZIOapp extends ZIOAppDefault:
  val intervew: ZIO[AppConsole & Problem1 & Problem2, Throwable, Unit] =
    for
      p1Input <- AppConsole.getInputFromUser("[Problem 1] Provide Integer: ")
      p1Result <- Problem1.p1Program(p1Input)
      _ <- AppConsole.print(s"[P-1] result => $p1Result")
      p2InputA <- AppConsole.getInputFromUser("[P-2] Provide date1 in dd-mm-yyyy format")
      p2InputB <- AppConsole.getInputFromUser("[P-2] Provide date2 in dd-mm-yyyy format")
      p2Result <- Problem2.getWeekdayInterval(p2InputA, p2InputB)
      _  <- AppConsole.print(s"[P-2] $p2Result")
    yield ()

  def run = intervew.provide(
    AppConsole.live,
    Problem1.live,
    Problem2.live,
  )
