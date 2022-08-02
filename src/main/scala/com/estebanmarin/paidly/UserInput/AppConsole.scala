package com.estebanmarin.paidly.UserInput

import zio.*

final case class AppConsole()
object AppConsole:
  def getInputFromUser(message: String): IO[Throwable,String] =
    for
      _ <- Console.printLine(message)
      input: String <- Console.readLine("Input : ")
    yield input

  def print(message: String): IO[Throwable, Unit]  =
    Console.printLine(message)

  val live = ZLayer.succeed(AppConsole())
