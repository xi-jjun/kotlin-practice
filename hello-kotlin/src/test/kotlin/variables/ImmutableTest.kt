package variables

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.lang.Exception

class ImmutableTest {

    @DisplayName("같은 숫자가 동일한지 확인하는 테스트")
    @Test
    fun equalTest() {
        assertThat(1).isEqualTo(1)
    }

    @DisplayName("같은 요소 같은 순서의 배열이 동일한지 확인하는 테스트")
    @Test
    fun containTest() {
        val list = listOf(1, 2, 3)

        assertThat(list).isEqualTo(listOf(1, 2, 3))
    }

    @DisplayName("배열에 요소를 추가했을 때 크기가 늘어나는지 확인하는 테스트")
    @Test
    fun addTest() {
        val list = mutableListOf("test1", "test2", "test3")

        list.add("test4")
        list.add("test5")
        list.add("test6")

        assertThat(list.size).isEqualTo(6)
    }
}