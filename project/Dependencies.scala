import sbt._

object Dependencies {
  object org {
    object timeLib {
      val nsclala =
        "com.github.nscala-time" %% "nscala-time" % "2.30.0"
    }

    object typelevel {
      val cats =
        "org.typelevel" %% "cats-core" % "2.7.0",
    }
    object zio {
      // main dependencies
      val zio =
        "dev.zio" %% "zio" % "2.0.0"
    }

    object scalatest {
      val scalatest =
        "org.scalatest" %% "scalatest" % "3.2.13"
    }

    object scalatestplus {
      val `scalacheck-1-16` =
        "org.scalatestplus" %% "scalacheck-1-16" % "3.2.13.0"
    }
  }
}
