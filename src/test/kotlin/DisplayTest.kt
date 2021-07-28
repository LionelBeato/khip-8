import kotlin.test.Test

internal class DisplayTest {

    @Test
    fun testArray() {
        loadRom("ibm.ch8")
        cycle()
        for (i in Display.screen) {
            for (j in i) {
                if (j == 0)
                print(" ▇▇") else print("   ")
            }
            println()
        }
        OP_00E0()
        for (i in Display.screen) {
            for (j in i) {
                if (j == 0)
                    print(" ▇▇") else print("   ")
            }
            println()
        }
    }
}