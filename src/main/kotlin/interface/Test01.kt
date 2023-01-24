package `interface`

interface ISendEmail {
    fun send(email: String)
}

class SmtpEmailSender: ISendEmail {
    override fun send(email: String) {
        println("smtp Email Sender: $email")
    }
}

fun main() {
    val sender: ISendEmail = object : ISendEmail {
        override fun send(email: String) {
            println(email)
        }
    }

    val sender2: ISendEmail = SmtpEmailSender()

    // runtime error: ClassCastException
    val testDownCast: SmtpEmailSender =  sender as SmtpEmailSender

    // compile error: Type mismatch
    val testDownCast2: SmtpEmailSender = sender2 as SmtpEmailSender
}