import java.util.*

class Memory {

    // memory declared as a variable
    // 4 KBs
    var memory = ByteArray(4096)

    var indexRegister = Register("index", 0)
    var V0 = Register("V0", 0)
    var V1 = Register("V1", 0)
    var V2 = Register("V2", 0)
    var V3 = Register("V3", 0)
    var V4 = Register("V4", 0)
    var V5 = Register("V5", 0)
    var V6 = Register("V6", 0)
    var V7 = Register("V7", 0)
    var V8 = Register("V8", 0)
    var V9 = Register("V9", 0)
    var VA = Register("VA", 0)
    var VB = Register("VB", 0)
    var VC = Register("VC", 0)
    var VD = Register("VD", 0)
    var VE = Register("VE", 0)
    var VF = Register("VF", 0)









    var stack:Stack<Byte> = Stack()

    // fontset for the chip-8
    // taken from here: https://austinmorlan.com/posts/chip8_emulator/#what-is-an-emulator
    val fontSet = {
            arrayOf(
                0xF0, 0x90, 0x90, 0x90, 0xF0,  // 0
                0x20, 0x60, 0x20, 0x20, 0x70,  // 1
                0xF0, 0x10, 0xF0, 0x80, 0xF0,  // 2
                0xF0, 0x10, 0xF0, 0x10, 0xF0,  // 3
                0x90, 0x90, 0xF0, 0x10, 0x10,  // 4
                0xF0, 0x80, 0xF0, 0x10, 0xF0,  // 5
                0xF0, 0x80, 0xF0, 0x90, 0xF0,  // 6
                0xF0, 0x10, 0x20, 0x40, 0x40,  // 7
                0xF0, 0x90, 0xF0, 0x90, 0xF0,  // 8
                0xF0, 0x90, 0xF0, 0x10, 0xF0,  // 9
                0xF0, 0x90, 0xF0, 0x90, 0x90,  // A
                0xE0, 0x90, 0xE0, 0x90, 0xE0,  // B
                0xF0, 0x80, 0x80, 0x80, 0xF0,  // C
                0xE0, 0x90, 0x90, 0x90, 0xE0,  // D
                0xF0, 0x80, 0xF0, 0x80, 0xF0,  // E
                0xF0, 0x80, 0xF0, 0x80, 0x80   // F
            )
    }

}