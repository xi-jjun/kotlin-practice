package inheritance

// 상속을 할 수 있게끔 하기 위해서 'open' keyword 사용
// why? => all the kotlin classes are final 따라서 기본적으로 상속이 불가능하다.
open class User(var name: String) {

    // 마찬가지로 open keyword 로 자식 클래스에 override 할 수 있게 해준다.
    open var id: Int = 1

    var code: String = "code123"

    // method 에도 open keyword 를 추가해야 자식 클래스에서 override 가 가능하다.
    // why? => 기본적으로 final method 이기 때문에
    open fun action() {
        println("Do it!")
    }

    override fun toString(): String {
        return "User(name='$name', id=$id, code='$code')"
    }
}

/*
Java 와 마찬가지로 1개의 class 만 상속받을 수 있다.
 */
class Student(name: String) : User(name) {

    override var id: Int = 2

    // 이렇게 된다면 var 에 대한 override 는 의미가 있는 것일까?
    fun setCode(): String {
        super.code = "changed123"
        return super.code
    }

    override fun action() {
        println("studying...")
    }
}

class Teacher(name: String) : User(name) {

    var age: Int = 0

    override fun action() {
        println("teaching...")
    }

    override fun toString(): String {
        return super.toString() + " Teacher(age=$age)"
    }
}

fun main() {
    val student = Student("Kim")
    student.action()
    student.id = 100
    val code = student.setCode()
    println("code = ${code}")
    println("student.name = ${student.name}")

    val teacher = Teacher("Park")
    teacher.age = 30
    teacher.action()
    println("[ teacher ]\nname : ${teacher.name}\nage : ${teacher.age}")
    println("teacher = ${teacher}")
}