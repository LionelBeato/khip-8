import Memory.memory
import org.jetbrains.annotations.TestOnly
import kotlin.test.Test
import kotlin.test.assertTrue
import ProgramCounter.currentInstruction as pc



internal class MemoryTest {

    @Test
    fun test() {
        println(pc)
        loadRom("ibm.ch8")
        println(memory.forEach{ it -> print(it)})
//        println(opCode and 0xFFF)
//        OP_1NNN()
//        OP_6xNN()
        OP_DXYN()
    }



}