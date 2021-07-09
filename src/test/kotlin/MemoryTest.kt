import kotlin.test.Test
import kotlin.test.assertTrue


internal class MemoryTest {

    @Test
    fun doThing() {
        val memory: Memory = Memory()

        println(memory.memory.size)
        println("I did thing!")
        assertTrue { true }
    }

}