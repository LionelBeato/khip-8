interface Register {
    val label: String
}

// data class to produce registers
// default values for values and index
data class EightBitRegister(
    override val label: String,
    var value: UByte = 0u,
) : Register

data class SixteenBitRegister(
    override val label: String,
    var value: UShort = 0u,
) : Register

/*
16 8-bit (one byte) general-purpose variable
registers numbered 0 through F hexadecimal,
ie. 0 through 15 in decimal, called V0 through `VF
 */
object Registers {
    // 16 bit index register
    var indexRegister = SixteenBitRegister("index")

    // 8 bit regular registers
    var V0 = EightBitRegister("V0")
    var V1 = EightBitRegister("V1")
    var V2 = EightBitRegister("V2")
    var V3 = EightBitRegister("V3")
    var V4 = EightBitRegister("V4")
    var V5 = EightBitRegister("V5")
    var V6 = EightBitRegister("V6")
    var V7 = EightBitRegister("V7")
    var V8 = EightBitRegister("V8")
    var V9 = EightBitRegister("V9")
    var VA = EightBitRegister("VA")
    var VB = EightBitRegister("VB")
    var VC = EightBitRegister("VC")
    var VD = EightBitRegister("VD")
    var VE = EightBitRegister("VE")

    /*
    VF is also used as a flag register;
    many instructions will set it to
    either 1 or 0 based on some rule,
    for example using it as a carry flag
     */
    var VF = EightBitRegister("VF")

    var registers = arrayListOf(
        EightBitRegister("V0"),
        EightBitRegister("V1"),
        EightBitRegister("V2"),
        EightBitRegister("V3"),
        EightBitRegister("V4"),
        EightBitRegister("V5"),
        EightBitRegister("V6"),
        EightBitRegister("V7"),
        EightBitRegister("V8"),
        EightBitRegister("V9"),
        EightBitRegister("VA"),
        EightBitRegister("VB"),
        EightBitRegister("VC"),
        EightBitRegister("VD"),
        EightBitRegister("VE"),
        /*
        VF is also used as a flag register;
        many instructions will set it to
        either 1 or 0 based on some rule,
        for example using it as a carry flag
         */
        EightBitRegister("VF")
    )
}