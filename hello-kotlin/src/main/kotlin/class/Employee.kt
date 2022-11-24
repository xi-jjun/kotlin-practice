package `class`

/**
 * Data class : hold the data can be categorized as data classes
 *
 * 자동으로 hashCode(), equals(), toString() 을 생성해준다.
 * 적어도 1개의 primary constructor 를 가져야 한다.
 */

data class Employee(
    val id: Int,
    var name: String,
    var department: String
)

/**
 * Data class 를 사용하여 쓸 수 있는 유용한 method
 */
fun main() {
    val worker = Employee(1, "Kim Jae Jun", "Developer")
    println("worker = ${worker}")

    val worker2 = Employee(1, "Kim Jae Jun", "Developer")
    println("worker2 = ${worker2}")
    println("worker == worker2 ? => ${worker == worker2}")

    val copiedWorker = worker.copy(
        id = 2,
        department = "Project Manager"
    )
    println("copiedWorker = ${copiedWorker}")
}
