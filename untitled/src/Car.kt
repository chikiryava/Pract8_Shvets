import kotlin.reflect.jvm.internal.impl.types.Variance
class Car(_number_on_the_car: String) {
    var number = _number_on_the_car
    private var model: String = "Lada"
    private var power: Int = 43
    private var price: Int = 2540304
    fun Input() {
        println("Введите марку машины")
        while (true) {
            var correct: Boolean = true
            model = readLine()!!.toString()
            for (i in 0..model.length - 1) {
                if (model[i].isDigit()) {
                    correct = false
                }
            }
            if (correct == false) {
                println("номер должен состоять только из цифр")
            } else {
                model = model[0].uppercase() + model.substring(1)
                break
            }
        }
        println("введите мощность")
        while (true) {
            try {
                power = readLine()!!.toInt()
                if (power <= 0)
                    println("Мощность не может быть меньше 0")
                else
                    break
            } catch (e: Exception) {
                println("В мощности могут быть только цифры")
            }
        }
        println("Введите стоимость в рублях")
        while(true){
            try {
                price = readLine()!!.toInt()
                if (price<0)
                    println("стоимость не может быть отрицательной")
                else
                    break
            }
            catch(e:Exception){
                println("в цене могут быть только числа")
            }
        }
    }
    fun Output(){
        println("Название марки - "+ model)
        println("Мошность = " +power+" л.с.")
        println("Цена = "+price+ " рублей")
    }
    fun Category(){
        when(power){
            in 0..140 -> println("категория А")
            in 140..254 -> println("категория В")
            in 254..467-> println("категория C")
            else -> println("категория d")
        }
        when(price){
            in 0..500000 -> println("Низкая ценовая категория")
            in 500000..2500000 -> println("Средняя ценовая категория")
            else -> println("Высокая ценовая категория")
        }
    }
}