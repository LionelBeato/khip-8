import java.io.Console
import java.util.*
import java.util.Timer
import kotlin.concurrent.timer
import kotlin.concurrent.timerTask

class Timer {



//    - An 8-bit sound timer which functions like the delay timer,
//      but which also gives off a beeping sound as long as it’s not 0



//    - An 8-bit delay timer which is decremented
//      at a rate of 60 Hz (60 times per second) until it reaches 0

    var rate = 60

    fun delayTimer() {
        timer("name", false, Date(), 100) {
                println(rate)
                rate -= 1
        }.scheduleAtFixedRate(timerTask { }, Date(), 100)
    }

}