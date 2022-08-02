package com.estebanmarin
package paidly

import zio.*
import com.estebanmarin.paidly.UserInput.*
import com.estebanmarin.paidly.Problem1.*

object PaidlyZIOapp extends ZIOAppDefault:
  val intervew: ZIO[AppConsole & Problem1, Throwable, Unit] =
    for
      p1Input <- AppConsole.getInputFromUser("[Problem 1] Provide Integer: ")
      p1Result <- Problem1.p1Program(p1Input)
      _ <- AppConsole.print(s"[Problem 1] result =>$p1Result")
      p2InputA <- AppConsole.getInputFromUser("[Problem 2] Provide date1 in dd-mm-yyyy format")
      p2InputB <- AppConsole.getInputFromUser("[Problem 2] Provide date2 in dd-mm-yyyy format")
    yield ()

  def run = intervew.provide(
    AppConsole.live,
    Problem1.live,
  )
