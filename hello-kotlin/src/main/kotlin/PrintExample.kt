fun main() {
    val num1 = 1
    val num2: Int = 3

    add(num1, num2)
}

fun add(num1: Int, num2: Int) {
    return println("$num1 + $num2 = ${num1 + num2}")
}