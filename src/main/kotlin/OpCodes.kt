import Memory.memory
import Memory.stack
import Registers.indexRegister
import Registers.registers
import javax.swing.text.html.HTML.Attribute.N
import javax.swing.text.html.HTML.Tag.I
import ProgramCounter.currentInstruction as pc



var opCode = ((memory[pc].toInt() shl 8) or memory[pc + 1].toInt())
var VX = (opCode and 0x0F00) shr 8
var VY = (opCode and 0x00F0) shr 4
var N = opCode and 0x000F

    // clear screen
    // WORKS
    fun OP_00E0() {
        for( row in Display.screen.indices) {
            for ( cell in Display.screen[row].indices) {
                Display.screen[row][cell] = 0
            }
        }
    }

    // jump to location NNN
    fun OP_1NNN() {
        pc = opCode and 0xFFF
        println("counter updated to $pc")
    }

    // set register VX to NN
    fun OP_6xNN() {
        var byte = opCode and 0x00FF

        var VX = (opCode and 0xFFF) shr 8
        println(VX)
        registers[VX].value = byte.toUByte()
        println(registers[VX])
    }

    fun OP_2NNN() {
        stack.push(pc.toUByte())
        pc = opCode and 0xFFF
    }

    fun OP_00EE() {
        pc = stack.pop().toInt()
    }

    // set index register
    fun OP_ANNN() {
//        println("index register: " + (opCode and 0xFFF).toUShort())
        indexRegister.value = opCode.toUShort() and 0xFFFu
    }

//    draw pixels
    fun OP_DXYN() {
        var VX = ((opCode and 0x0F00) shr 8)
        var VY = ((opCode and 0x00F0) shr 4)
        var xPos = registers[VX].value % 64u
        var yPos = registers[VY].value % 32u
        var height = (opCode and 0x000F)
        println("The height is $height")


        registers[0xF].value = 0u

        // for N rows
        for (row in 0 until height) {
            var spriteByte = memory[(indexRegister.value + row.toUInt()).toInt()]
            for (col in 0u..8u) {
                val spritePixel = spriteByte and ((0x80 shr col.toInt()).toUByte())
                var screenPixel = Display.screen[(yPos + row.toUInt()).toInt()][(xPos + col).toInt()]
                if(spritePixel > 0u) {
                    if (screenPixel > 0) {
                        registers[0xF].value = 1u
                    }
                    Display.screen[(yPos + row.toUInt()).toInt()][(xPos + col).toInt()] = (screenPixel xor 0xFFFFFF)
                }
            }
        }
    }




    fun OP_7xNN() {
        var byte = opCode and 0x00FF
        var VX = (opCode and 0xFFF) shr 8
        println("The value of VX: $VX")
        registers[VX].value = ((registers[VX].value + byte.toUByte()).toUByte())
//        registers[VX].value = 0x22u
        var printable = registers[VX]
        println("value at Register $VX is now $printable")
    }

