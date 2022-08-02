package com.estebanmarin.paidly.Problem3

import zio.*
import scala.util.*

final case class Problem3()
object Problem3:
  def live = ZLayer.succeed(Problem3())

  private def isValid(email: String): IO[Throwable, Boolean] =
    Try(
      """^[-a-z0-9!#$%&'*+/=?^_`{|}~]+(\.[-a-z0-9!#$%&'*+/=?^_`{|}~]+)*@([a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?\.)*(aero|arpa|asia|biz|cat|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|net|org|pro|tel|travel|[a-z][a-z])$"""
        .r
        .findFirstIn(email)
    ) match
      case Success(v) => ZIO.succeed(true)
      case Failure(e) => ZIO.fail(throw new RuntimeException(s"[P-3] Provide valid email"))

  private def obfuscateEmailUtil(email: String) = ZIO.succeed {
    val temp: List[String] = email.split('@').toList
    val ob = temp(0).head
    val ob2 = temp(0).tail.reverse.head
    val middle = temp(0).tail.map(_ => '*').tail
    s"$ob$middle$ob2@${temp.tail}"
  }

  def obfuscateEmail(stg: String): IO[Throwable, String] =
    for
      validEmail <- isValid(stg)
      obfEmail <- obfuscateEmailUtil(stg)
    yield obfEmail
