class Main extends App {
  val scanItems: List[Items] = List(A(), B(), A(), A())

  // Checkout
  applyDiscountItem(scanItems)

  val applyDiscountItem: List[Items] => List[Long] = (items: List[Items]) => {
    val discount = items.map(_.id match {
      case "A" => if (items.count(_ == "A") % 3 == 0) A(discountAmount = 20L).discountAmount else items.map(_.price).sum // if not a multiple of 3 (i.e. 5) it can still contain a discount - // TODO: Fix logic
      case "B" => if (items.count(_ == "B") % 2 == 0) B(discountAmount = 15L).discountAmount else items.map(_.price).sum // if not a multiple of 2 (i.e. 5) it can still contain a discount - // TODO: Fix logic
      case "C" => 0L
      case "D" => 0L
    })
    discount
  }
}

trait Items {
  def id: String
  def price: Long
  def discountAmount: Long
}

case class A(id: String = "A", price: Long = 50L, discountAmount: Long = 0L) extends Items
case class B(id: String = "B", price: Long = 30L, discountAmount: Long = 0L) extends Items
case class C(id: String = "C", price: Long = 20L, discountAmount: Long = 0L) extends Items
case class D(id: String = "D", price: Long = 15L, discountAmount: Long = 0L) extends Items

object A {
  def apply(id: String = "A", price: Long = 50L, discountAmount: Long = 0L): A = new A(id, price, discountAmount)
}

object B {
  def apply(id: String = "B", price: Long = 30L, discountAmount: Long = 0L): B = new B(id, price, discountAmount)
}

object C {
  def apply(id: String = "C", price: Long = 20L, discountAmount: Long = 0L): C = new C(id, price, discountAmount)
}

object D {
  def apply(id: String = "D", price: Long = 15L, discountAmount: Long = 0L): D = new D(id, price, discountAmount)
}

