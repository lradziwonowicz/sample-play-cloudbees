import sbt._
import Keys._
import play.Project._
import cloudbees.Plugin._

object ApplicationBuild extends Build {

    val appName         = "sample-play-cloudbees"
    val appVersion      = "1.0"

    val appDependencies = Seq(
      javaCore,
      javaJdbc,
      javaJpa,
      "org.hibernate" % "hibernate-entitymanager" % "3.6.9.Final",
	  "com.typesafe.slick" %% "slick" % "1.0.0",
	  "mysql" % "mysql-connector-java" % "5.1.18"
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
      ebeanEnabled := false).settings(
	  cloudBeesSettings :_*).settings(
	  CloudBees.applicationId := Some("computer-db"))
}
            
