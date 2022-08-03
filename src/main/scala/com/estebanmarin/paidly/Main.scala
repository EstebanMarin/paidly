package com.estebanmarin
package paidly

import zio.*
import com.estebanmarin.paidly.UserInput.*
import com.estebanmarin.paidly.Problem1.*
import com.estebanmarin.paidly.Problem2.*
import com.estebanmarin.paidly.Problem3.*

object PaidlyZIOapp extends ZIOAppDefault:
  val intervew: ZIO[AppConsole & Problem1 & Problem2 & Problem3, Throwable, Unit] =
    for
      // p1Input <- AppConsole.getInputFromUser("[P-1] Input: ")
      // p1Result <- Problem1.p1Program(p1Input)
      // _ <- AppConsole.print(s"[P-1] result => $p1Result")
      // p2InputA <- AppConsole.getInputFromUser("[P-2] Provide date1 in dd-mm-yyyy format")
      // p2InputB <- AppConsole.getInputFromUser("[P-2] Provide date2 in dd-mm-yyyy format")
      // p2Result <- Problem2.getWeekdayInterval(p2InputA, p2InputB)
      // p3InputA <- AppConsole.getInputFromUser("[P-3/4] Provide an email")
      // p4EmailObfResult <- Problem3.obfuscateEmail(p3InputA)
      // _ <- AppConsole.print(s"[P-4] email obfuscation => $p4EmailObfResult")
      p5PhoneInput <- AppConsole.getInputFromUser("[P-3/5] Provide an phone")
      p5PhoneObs <- Problem3.obfsPhone(p5PhoneInput)
      _ <- AppConsole.print(s"[P-5] phone obfuscation => $p5PhoneObs")
    yield ()

  def run = intervew.provide(
    AppConsole.live,
    Problem1.live,
    Problem2.live,
    Problem3.live,
  )
