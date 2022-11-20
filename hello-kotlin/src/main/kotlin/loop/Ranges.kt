fun main() {
    val start = 1
    val end = 4
    for (x in start..end) {
        println(x)
    }

    println("=== 1 to 10 by step 2 ===")
    for (x in 1..10 step 2) {
        print("${x} ")
    }

    println("\n=== 5 to 2 by step 1 ===")
    for (x in 5 downTo 1) {
        print("${x} ")
    }

    println("\n=== 7 to 1 by step 2 ===")
    for (x in 7 downTo 1 step 2) {
        print("${x} ")
    }

    println("\n=== names iterate ===")
    val names = listOf("김재준", "김근우", "김민협")
    for (name in names) {
        println("name => $name")
    }
}