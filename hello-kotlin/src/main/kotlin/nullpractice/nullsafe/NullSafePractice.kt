/**
 * NullSafePractice.java 를 Kotlin code 로 변환한 것입니다.
 */

fun main() {
    val badWord = "It is BAD word"
    val goodWord = "It is GOOD word"
    val niceWord = "It is NICE word"

    val badWordResult = isBadWord(badWord)
    println("badWordResult = ${badWordResult}")

    val goodWordResult = isGoodWord(goodWord)
    println("goodWordResult = ${goodWordResult}")

    val niceWordResult = isNiceWord(niceWord)
    println("niceWordResult = ${niceWordResult}")
}

fun isBadWord(word: String?): Boolean {
    if (word == null) {
        throw IllegalArgumentException("null 은 문자열이 아니에요")
    }

    return word.contains("BAD")
}

/**
 * 기본적으로 kotlin 의 모든 type 은 null 이 들어갈 수 없게 되어있다.
 * 그러나 ? 키워드를 붙이면 null 이 들어가는게 가능하다.
 */
fun isGoodWord(word: String?): Boolean? {
    if (word == null) {
        return null
    }

    return word.contains("GOOD")
}

fun isNiceWord(word: String?): Boolean {
    if (word == null) {
        return false;
    }

    return word.contains("NICE")
}