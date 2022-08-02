package com.estebanmarin.paidly.Problem2

import com.github.nscala_time.time.Imports.*
import zio.*

final case class Problem2()
object Problem2:
    def getCurrent = DateTime.now() + 2.months
    def live = ZLayer.succeed(Problem2())

