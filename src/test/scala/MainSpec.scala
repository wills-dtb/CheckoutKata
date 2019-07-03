import org.scalatest.{FlatSpec, Matchers}

class MainSpec extends FlatSpec with Matchers {
  "A discount" should "be applied to items when grouped according to rules" in {

    val scannedItems = List(A(), A(), B(), A())
    val mockMethod = new Main with MockMain
    val result = mockMethod.applyDiscountItem(scannedItems)

    result.filter(_ == "A").sum shouldBe 130L
  }
}

trait MockMain extends Main {
  override val applyDiscountItem: List[Items] => List[Long] = ???
}
