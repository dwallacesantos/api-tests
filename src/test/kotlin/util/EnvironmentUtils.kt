package util

private const val QA_URI = "https://restcountries.com/v3.1/name/{countryName}"
private const val DEV_URI = "https://localhost:8080/v3.1/name/{countryName}"

fun getUri(): String {
    return if (getEnv() == Environment.QA) QA_URI else DEV_URI
}

private fun getEnv(): Environment {
    val env = System.getenv("ENV")

    return if (env.isNullOrEmpty()) Environment.QA else Environment.valueOf(env.uppercase())
}

enum class Environment {
    DEV, QA
}