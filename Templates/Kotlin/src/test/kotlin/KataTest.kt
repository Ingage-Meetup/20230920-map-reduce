import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class KataTest {
    private lateinit var fixture: Kata

    @BeforeEach
    fun setUp() {
        fixture = Kata()
    }

    @Test
    fun `hello should return message with specified name`() {
        val name = "Ingage"
        assertEquals("Hello $name", fixture.hello(name))
    }
}
