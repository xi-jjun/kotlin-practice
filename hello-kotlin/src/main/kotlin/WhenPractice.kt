fun describe(obj: Any): String =
    when (obj) {
        1 -> "this is 1"
        "Hello" -> " Kotlin!!"
        "xi-jjun" -> " : owner of this repo"
        else -> "Unknown"
    }

fun main() {
    val result1 = describe(1)
    println("input is 1, output is $result1")

    val result2 = describe("Hello")
    println("input is 'Hello', output is $result2")

    val result3 = describe("xi-jjun")
    println("input is 'xi-jjun', output is $result3")

    val result4 = describe("other thing")
    println("input is else..., output is $result4")
}