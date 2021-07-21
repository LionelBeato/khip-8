import org.w3c.dom.ranges.Range
import java.io.File
import java.util.*

data class Chip8(
    var register: List<Register>,
    var memory: ByteArray,
    var index: Register,
    var pc: Int,
    var stack: Stack<Byte>,
    var sp: Byte,
    var delayTimer: Timer,
    var keyPad: ByteArray,
    var display: Display,
    var opcode: Int
) {

    val START_ADDRESS = 0x200


    fun readFileAsTextUsingInputStream(fileName: String) =
        File(fileName).inputStream().readBytes().toList()

    // this kinda sorta works!
    fun loadRom(fileName: String) {
        val input = File(fileName).inputStream().readBytes().toList()
        val size = input.size
        for (i in 0 until size) {
            memory.set(START_ADDRESS+i, input[i])
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Chip8

        if (register != other.register) return false
        if (!memory.contentEquals(other.memory)) return false
        if (index != other.index) return false
        if (pc != other.pc) return false
//        if (!stack.contentEquals(other.stack)) return false
        if (sp != other.sp) return false
        if (delayTimer != other.delayTimer) return false
        if (!keyPad.contentEquals(other.keyPad)) return false
        if (display != other.display) return false
        if (opcode != other.opcode) return false

        return true
    }

//    override fun hashCode(): Int {
//        var result = register.hashCode()
//        result = 31 * result + memory.contentHashCode()
//        result = 31 * result + index
//        result = 31 * result + pc
//        result = 31 * result + stack.contentHashCode()
//        result = 31 * result + sp
//        result = 31 * result + delayTimer.hashCode()
//        result = 31 * result + keyPad.contentHashCode()
//        result = 31 * result + display.hashCode()
//        result = 31 * result + opcode
//        return result
//    }

}