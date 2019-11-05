import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test;

internal class SubArrayFinderTest {

    @Test
    fun `test empty array returns empty list`() {
        val input: List<Int> = emptyList()
        val solution = SubListFinder.from(input)
        val expected: List<Int> = emptyList()

        assertEquals(expected, solution)
    }

    @Test
    fun `test list with one solution returns the correct solution`() {
        val input = listOf(6, 2, 2, 3, 4)
        val solution = SubListFinder.from(input)

        assertEquals(listOf(2, 2), solution)
    }

    @Test
    fun `test list with multiple solutions returns the shortest solution`() {
        val input = listOf(1, 2, 2, 3, 1)
        val solution = SubListFinder.from(input)

        assertEquals(listOf(2, 2), solution)
    }

    @Test
    fun `test list with multiple equal solutions returns first solution`() {
        val input = listOf(1, 7, 2, 3, 1, 4, 4, 5, 8, 2, 9)
        val solution = SubListFinder.from(input)

        assertEquals(listOf(4, 4), solution)
    }

    @Test
    fun `test list with only increasing numbers returns first number`() {
        val input = (1..49999).toList()
        val solution = SubListFinder.from(input)

        assertEquals(listOf(1), solution)
    }
}