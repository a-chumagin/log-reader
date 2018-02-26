import LogFinder.convertContentToSeq
import LogFinder.isLineContains
import org.scalatest.FunSuite

class LogFinderTest extends FunSuite {

  test("testIsLineContains") {
    assert(isLineContains("test line", "test"))
  }

  test("testConvertContentToSeq") {
    val content = Iterator[String]("A", "B", "C")
    val result: Seq[String] = convertContentToSeq(content)
    assert(result == Seq[String]("A", "B", "C"))
  }

}
