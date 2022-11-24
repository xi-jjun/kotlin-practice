package `class`

data class Course(
    val id: Int,
    var lecture: String,
    var professor: String
) {
    val lectureCode: String
        get() = "${id}_$lecture"

    var attendedCount: Int = 0
        set(value) {
            println("value = ${value}")
            if (value >= 0) {
                field = value // 'field' 라는 이름으로 접근해야 함. attendedCount 로 접근하면 would make setter recursive
                return
            }

            throw IllegalArgumentException("참석인원은 0보다 아래가 될 수 없습니다.")
        }
}

fun main() {
    val korean = Course(1, "Korean", "Kim Jae Jun")
    println("korean = ${korean}")
    korean.attendedCount = 1
    println("korean = ${korean}")
    println("korean.lectureCode = ${korean.lectureCode}")

    korean.attendedCount--
    korean.attendedCount-- // error 발생!
}