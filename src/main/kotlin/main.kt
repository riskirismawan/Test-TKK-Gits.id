import java.util.*

fun main() {

    while (true) {
        println()
        print("""
        1. Hello World
        2. Email Chacker
        3. Konversi waktu
        4. Reverse kalimat
        5. Palindrom cek
        
        Pilih salah satu dengan menginput nomor : 
    """.trimIndent())

        when (readLine()?.toInt()) {
            1 -> helloWorld()
            2 -> emailChecker()
            3 -> konversiWaktu()
            4 -> reverseKalimat()
            5 -> println(palindrom())
        }
    }
}


fun helloWorld() {
    print("Masukkan angka : ")
    val value = readLine()?.toInt()

    if (value != null) {
        when {
            value%3==0 && value%5==0 -> println("Hello World")
            value%3==0 -> println("Hello")
            value%5==0 -> println("World")
            else -> println("Bukan merupakan bilangan yang habis di bagi 3 dan atau 5")
        }
    }
}

fun emailChecker() {

    var isUseAt = false
    var isUseDot = false
    var isDomain = false
    val listDomain = arrayOf(".co.id", ".id")
    var name = ""
    var domain: String
    var count = 0
    var index = 0

    print("Masukkan Email : ")
    var email = readLine()
    email = email?.replace(" ", "")

    if (email != null) {
        email.forEach {
            if (it == '@') {
                isUseAt = true
                name = email.substring(0, count)
                index = count
            }
            count++
        }

        if (isUseAt) {
            if (email[index + 1] == '.') {
                isUseDot = true
            }

            domain = email.substring(index + 2)
            count = 0
            index = 0
            domain.forEach {
                if (it == '.' && index < 1) {
                    domain = domain.substring(count)
                    index++
                }
                count++
            }

            listDomain.forEach {
                if (domain == it) {
                    isDomain = true
                }
            }
        }

        when {
            name.length > 20 -> println("Panjang email maksimum 20 karakter sebelum \'@\'")
            !isUseAt -> println("Format email wajib menggunakan \'@\'")
            !isUseDot -> println("Format email wajib menggunakan tanda titik ‘\'.\' setelah \'@\'")
            !isDomain -> println("domain yang diperbolehkan hanya \".co.id\" dan \".id\"")
            else -> println("Format email benar")
        }
    }
}

fun konversiWaktu() {
    var hour = ""
    var minute = ""
    var timeFormat: String
    var count = 0
    var cek = 0

    print("Masukkan waktu : ")
    var time = readLine()
    time = time?.replace(" ", "")

    if (time != null) {
        time.forEach {
            if (it == ':' && cek < 1) {
                hour = time.substring(0, count)
                cek++
            } else if (it == ':' && cek < 2) {
                minute = time.substring(hour.length+1, count)
                cek++
            }
            count++
        }

        timeFormat = time.substring(time.length-2)
        timeFormat = timeFormat.toLowerCase()

        if (timeFormat == "pm") {
            hour = (hour.toInt() + 12).toString()
            if (hour == "24") hour ="00"
        }

        println("$hour:$minute")
    }
}

fun reverseKalimat() {
    print("Masukan kalimat : ")

    val kalimat = readLine()
    val reverse: LinkedList<Char> = LinkedList()

    kalimat?.forEach {
        reverse.addFirst(it)
    }

    reverse.forEach {
        print(it)
    }
    println()
}

fun palindrom(): Boolean {
    print("Masukan kata : ")
    val kalimat = readLine()

    if (kalimat != null) {
        var index = kalimat.length-1

        kalimat.forEach {
            if (it != kalimat[index]) {
                return false
            } else index--
        }
    }
    return true
}