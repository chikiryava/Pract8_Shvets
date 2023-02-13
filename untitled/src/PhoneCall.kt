import java.time.*
import java.time.format.DateTimeFormatter
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString

class PhoneCall(_model:String) {
    val model = _model
    private var phonenumber:String = "9530069425"
    private var dateoftalk: String = "12.05.2022"
    private var durationofcall: Int = 10
    private var citycode: String = "435"
    fun Input() {
        println("введите номер телефона без +7")
            while (true) {
                var correct: Boolean = true
                phonenumber = readLine()!!.toString()
                if (phonenumber.length != 10)
                    println("номер должен состоять всего из 12 символов с учетом +7")
                else {
                    for (i in 0..phonenumber.length - 1) {
                        if (!phonenumber[i].isDigit()) {
                            correct = false
                        }
                    }
                    if (correct == false) {
                        println("номер должен состоять только из цифр")
                    } else
                        break
                }
            }
                println("введите дату разговора в формате dd.MM.yyyy")
                while (true) {
                    try{
                        dateoftalk = readLine()!!.toString()
                        val dateFormatInput1 = DateTimeFormatter.ofPattern("dd.MM.yyyy")
                        val date1: LocalDate = LocalDate.parse(dateoftalk,dateFormatInput1)
                        dateoftalk = date1.toString()
                        break
                    }
                    catch(e:Exception){
                        println("Введите дату правильно")
                    }
                }
            println("Введите продолжительность звонка в минутах")
            while (true){
                try{
                durationofcall = readLine()!!.toInt()
                if(durationofcall<0)
                    println("Продолжительность звонка не может быть меньше нуля")

                else
                    break
                }
                catch(e:Exception){
                    println("Можно вводить только числа")
                }
            }
        println("Введите код города")
        while (true){
            var correct: Boolean = true
            citycode = readLine()!!.toString()
            if(citycode.length!=3)
                print("Код города должен состоять из трех цифр")
            else {
                for (i in 0..citycode.length - 1) {
                    if (!citycode[i].isDigit()) {
                        correct = false
                    }
                }
                if (correct == false)
                    println("Код должен состоять только из цифр")
                 else
                    break
            }
            }
        }

    fun Output(){
        println("Номер Телефона +7${phonenumber}")
        println("Дата разговора: ${dateoftalk}")
        println("Продолжительность разговора: ${durationofcall}")
        println("Код региона: ${citycode}")

    }
    fun PriceOfCall(){
        println("Введите стоимость за минуту звонка в рублях")
        var price: Double
        while(true) {
            try{
            price = readLine()!!.toDouble()
            if(price<0){
                println("стоимость не может быть меньше нуля")
            }
                else
                    break
        }
            catch (e:Exception){
                println("Вы ввели не число")
            }
    }
        println("Стоимость звонка = ${price*durationofcall}")
    }
}




