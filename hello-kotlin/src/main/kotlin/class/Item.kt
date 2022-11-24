package `class`

class Item(private val id: Int) { // primary constructor

    init {
        println("Init block")
    }

    private var name: String = ""
    private var price: Int = 0

    // this() : default constructor of this class
    // secondary constructor : 필요할 때만 써라
    constructor(id: Int, name: String, price: Int) : this(id) {
        this.name = name
        this.price = price
    }

    override fun toString(): String {
        return "Item(id=$id, name='$name', price=$price)"
    }

}

fun main() {
    val phone = Item(id = 45, name = "IPhone", price = 1000)
    println("phone = ${phone}")

    val tv = Item(id = 100)
    println("tv = ${tv}")
}