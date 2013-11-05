// Comment to get more information during initialization
logLevel := Level.Warn

// The Typesafe repository
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

// Use the Play sbt plugin for Play projects
// Use -M2- I get problems with reading annotations if you don't.
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.2.0-M2")