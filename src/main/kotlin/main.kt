/*

https://tobiasvl.github.io/blog/write-a-chip-8-emulator/

CHIP-8 has the following components:

- Memory: CHIP-8 has direct access to up to 4 kilobytes of RAM
- Display: 64 x 32 pixels (or 128 x 64 for SUPER-CHIP) monochrome, ie. black or white
- A program counter, often called just “PC”, which points at the current instruction in memory
- One 16-bit index register called “I” which is used to point at locations in memory
- A stack for 16-bit addresses, which is used to call subroutines/functions and return from them
- An 8-bit delay timer which is decremented at a rate of 60 Hz (60 times per second) until it reaches 0
- An 8-bit sound timer which functions like the delay timer, but which also gives off a beeping sound as long as it’s not 0
- 16 8-bit (one byte) general-purpose variable registers numbered 0 through F hexadecimal, ie. 0 through 15 in decimal, called V0 through `VF
    - VF is also used as a flag register; many instructions will set it to either 1 or 0 based on some rule, for example using it as a carry flag


 */

import Memory.memory
import androidx.compose.desktop.Window
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import java.io.File
import ProgramCounter.currentInstruction as pc


fun fetch() {
    opCode = (memory[pc].toInt() shl 8) or (memory[pc + 1].toInt())
    pc =(pc + 2)
}

fun decode() {

    //    println("This is the decoded opcode: $decoded")
    when ((opCode and 0xF000) shr 12) {
        0x0 -> {
            OP_00E0()
        }
        0x1 -> {
            OP_1NNN()
        }
        0x6 -> {
            OP_6xNN()
        }
        0x7 -> {
            OP_7xNN()
        }
        0xA -> {
            OP_ANNN()
        }
        0xD -> {
            OP_DXYN()
        }
    }
}

fun execute(OP_CODE: UByte) {


}

@Composable
fun screen(display: Display) {
    Column (Modifier.verticalScroll(enabled = true, state = ScrollState(0))) {
        display.screen.forEach { row -> Row {
            row.forEach {
                if (it > 0)
                    Box(Modifier.size(10.dp).background(color = Color.White))
                else
                    Box(Modifier.size(10.dp).background(color = Color.Black))
                }
            }
      }
//        display.screen.forEach {
//            if (it > 0)
//                Box(Modifier.size(10.dp).background(color = Color.White))
//            else
//                Box(Modifier.size(10.dp).background(color = Color.Black))
//            }
        }
    }


fun loadRom(fileName: String) {
    val file = File(fileName).inputStream().readBytes().asUByteArray()
    println(file)
    for (i in file.indices) {
//        println("at index $i")
        memory[0x200 + i] = file[i]
    }
}

fun cycle() {
    for(i in 0..100) {
        fetch()
        decode()
    }
}

fun main() = Window(
    title = "Compose for Desktop",
    size = IntSize(640, 320),
    resizable = false ) {

    MaterialTheme {
        loadRom("ibm.ch8")

        cycle()
        screen(Display)
    }
}


