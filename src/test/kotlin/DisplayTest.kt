import kotlin.test.Test

internal class DisplayTest {

    @Test
    fun testArray() {
        var screen = Display().screen

        for (i in screen) {
            for (j in i) {
                if (j == false)
                print(" ▇▇")
            }
            println()
        }
    }
}