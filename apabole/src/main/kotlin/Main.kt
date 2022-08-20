fun apaBole(i: Int): String {
    val outputBuffer = StringBuffer()
    val isApa = i % 3 == 0
    val isBole = i % 5 == 0
    if (isApa) {
        outputBuffer.append("Apa")
    }
    if (isBole) {
        outputBuffer.append("Bole")
    }
    if (!isApa && !isBole) {
        outputBuffer.append("$i")
    }
    return outputBuffer.toString()
}

fun apaBoleAccumulator(n: Int): String {
    val outputBuffer = StringBuffer()
    for (i in 1..n) {
        if (i != 1) outputBuffer.append(", ")
        outputBuffer.append(apaBole(i))
    }
    outputBuffer.append("\n")
    return outputBuffer.toString()
}

fun main() {
    println(apaBoleAccumulator(100))
}