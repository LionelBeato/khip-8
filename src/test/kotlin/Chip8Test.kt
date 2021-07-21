
import kotlin.test.Test

internal class Chip8Test {

    @Test
    fun test() {
      var computer = Chip8(
          register = Registers.all,
          memory = Memory.memory,
          index = Register("index", 0),
          pc = 0,
          stack = Memory.stack,
          sp = 0,
          delayTimer = Timer(),
          keyPad = Keyboard.keys,
          display = Display(),
          opcode = 0x200,
      )

        computer.loadRom("stars.ch8")

        computer.memory.forEach { println(it) }

    }

}