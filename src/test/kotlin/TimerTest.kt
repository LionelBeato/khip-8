import java.util.*
import kotlin.concurrent.fixedRateTimer
//import java.util.Timer
import kotlin.test.Test
import kotlin.concurrent.schedule
import kotlin.concurrent.timer
import kotlin.concurrent.timerTask

import kotlin.test.assertTrue

internal class TimerTest {

    @Test
    fun doTest() {
        var timer = Timer()
        timer.delayTimer()


//       var time = timer("name", true, Date(), 1L) { println("Hello~!") }
//
//        time.run {
//        }
//
        Thread.currentThread().join()

    }


}



