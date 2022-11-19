package variables

var topLevelVar = 10

fun main() {
    var canReassign: String = "Hello Kotlin"
    println("var can be reassigned => $canReassign")
    canReassign = "Bye Kotlin"
    println("var can be reassigned => $canReassign")


    var num = 1 // Type is inferred
    num++
    println("num = $num")


    checkTypeIsInferred()


    val result = checkTypeIsRequiredWhenNoInitializer()
    println("result = $result")


    println("Increase top level variable")
    print("`$topLevelVar` increase 1 time => ")
    increaseTopLevelVar()
    println("$topLevelVar")
}

fun increaseTopLevelVar() {
    topLevelVar++
}

fun checkTypeIsInferred() {
    val num1 = 1
    val num2 = 4

    println("$num1 + $num2 = ${num1 + num2}")
}

fun checkTypeIsRequiredWhenNoInitializer(): Int {
    val num: Int // Type required when no initializer is provided
    var num2: Int

    num = 100 // deferred assignment
    num2 = 14 // deferred assignment
    num2++

    return num + num2
}