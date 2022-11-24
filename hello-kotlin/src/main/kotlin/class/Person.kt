package `class`

class Person(
    // Primary Constructor
    val name: String = "no named", // default value 를 설정함으로써 생성자를 여러개 만드는 것을 피할 수 있다.
    val age: Int = -1
) {

    fun eat() {
        println("EATING...")
    }

    override fun toString(): String {
        return "Person(name='$name', age=$age)"
    }

}

fun main() {
    val me = Person()
    println("me = $me")
    val you = Person(age = 26)
    println("you = ${you}")
    val friend = Person("Kim Jae Jun", 26)
    println("friend = ${friend}")
    val father = Person(name = "Park")
    println("father = ${father}")
}