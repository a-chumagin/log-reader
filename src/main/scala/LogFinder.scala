import scala.io.Source

object LogFinder extends App {

  private final val filepath = "./data/test.log"

  var results = time {
    getResult("1234567890", 3, 3)
  }
  results.foreach {
    println
  }


  def getResult(pattern: String, line_before: Int, line_after: Int): Seq[String] = {
    val fileContent = getFileContent(filepath)
    val fileSeq = convertContentToSeq(fileContent)

    val result = for {
      (line, index) <- fileSeq.zipWithIndex if isLineContains(line, pattern)
    }  yield fileSeq.slice(index - line_before, index + line_after + 1)

    result flatten

  }

  def isLineContains(line: String, pattern: String): Boolean = {
    line contains pattern
  }

  def convertContentToSeq(content: Iterator[String]): Seq[String] = {
    content.toSeq
  }

  def getFileContent(filename: String): Iterator[String] = {
    Source.fromFile(filename).getLines()
  }


  private def time[R](block: => R): R = {
    val t0 = System.currentTimeMillis()
    val result = block // call-by-name
    val t1 = System.currentTimeMillis()
    println("Elapsed time: " + (t1 - t0) + " ms")
    result
  }
}


