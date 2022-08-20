import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.moshi.responseObject
import com.github.kittinunf.result.Result
import model.OneCall
import java.text.SimpleDateFormat
import java.util.*

const val API_KEY = "28b2a88ec9947e44cb016172f0835f27"
val JAKARTA_COORD = Pair(-6.2146, 106.8451)


class OpenWeatherService {
    companion object {
        const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    }

    fun fetchNext8DaysWeatherForecast(): Request {
        val endpoint =
            "${BASE_URL}onecall?units=metric&exclude=minutely,hourly&lat=${JAKARTA_COORD.first}&lon=${JAKARTA_COORD.second}&appid=$API_KEY"
        return endpoint.httpGet()
    }
}

fun displayTemperatures(data: OneCall) {
    val dateFormat = SimpleDateFormat("E, dd MMM yyyy")
    data.daily.forEach { day ->
        val date = dateFormat.format(Date(day.dt * 1000))
        val temperatureMedian = (day.temp.max + day.temp.min) / 2.0
        println("${date}: ${"%.2f".format(temperatureMedian)}\u00B0C")
    }
}

fun main() {
    val openWeatherService = OpenWeatherService()
    val next8DaysForecastRequest = openWeatherService.fetchNext8DaysWeatherForecast()

    println("Weather forecast:")
    next8DaysForecastRequest.responseObject<OneCall> { _, _, res ->
        when (res) {
            is Result.Success -> {
                displayTemperatures(res.value)
            }

            is Result.Failure -> {
                println(res.error)
            }
        }
    }.join()
}