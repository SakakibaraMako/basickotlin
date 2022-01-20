package edu.uw.basickotlin

class Library {
    // This is just here as a placeholder, to make sure tests run and pass
    // before you add any code
    fun someLibraryMethod(): Boolean {
        return true
    }
}

// write a "whenFn" that takes an arg of type "Any" and returns a String
fun whenFn(arg: Any): String {
    when(arg) {
        "Hello" -> return "world"
        is String -> return "Say what?"
        0 -> return "zero"
        1 -> return "one"
        in 2..10 -> return "low number"
        is Int -> return "a number"
        else -> return "I don't understand"
    }
}
// write an "add" function that takes two Ints, returns an Int, and adds the values
fun add(left: Int, right: Int): Int {
    return left + right
}
// write a "sub" function that takes two Ints, returns an Int, and subtracts the values
fun sub(left: Int, right: Int): Int {
    return left - right
}
// write a "mathOp" function that takes two Ints and a function (that takes two Ints and returns an Int), returns an Int, and applies the passed-in-function to the arguments
fun mathOp(left: Int, right: Int, func: (left: Int, right: Int) -> Int): Int{
    return func(left, right)
}
// write a class "Person" with first name, last name and age
class Person(var firstName: String, var lastName: String, var age: Int) {
//    val debugString: String
//        get() {
//            return "[Person firstName:$firstName lastName:$lastName age:$age]"
//        }
    val debugString: String = "[Person firstName:$firstName lastName:$lastName age:$age]"

}

// write a class "Money" with amount and currency, and define a convert() method and the "+" operator
class Money(var amount: Int, var currency: String) {
    private val currencyType = listOf<String>("USD", "EUR", "CAN", "GBP")
    val rate: Array<DoubleArray> = arrayOf(
                                doubleArrayOf(1.0, 1.5, 1.25, 0.5),
                                doubleArrayOf(2.0/3.0, 1.0, 5.0/6.0, 1.0/3.0),
                                doubleArrayOf(0.8, 6.0/5.0, 1.0, 0.4),
                                doubleArrayOf(2.0, 3.0, 2.5, 1.0)
    )
    private val mapping = hashMapOf<String, Int>("USD" to 0, "EUR" to 1, "CAN" to 2, "GBP" to 3)
    init {
        if ((amount < 0) or (currency !in currencyType))
            throw IllegalArgumentException()
    }
    fun convert(type: String): Money {
        return Money((amount * rate[mapping[currency]!!][mapping[type]!!]).toInt(), type)
    }
    operator fun plus(other: Money): Money {
        return Money(amount + other.convert(currency).amount, currency)
    }
}