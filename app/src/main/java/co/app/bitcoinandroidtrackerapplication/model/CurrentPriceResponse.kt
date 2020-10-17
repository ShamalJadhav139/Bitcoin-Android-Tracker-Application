package co.app.bitcoinandroidtrackerapplication.model

data class CurrentPriceResponse(
    val bpi: Bpi,
    val chartName: String,
    val disclaimer: String,
    val time: Time
) {
    data class Bpi(
        val EUR: EURRate,
        val GBP: GBPRate,
        val USD: USDRate
    ) {
        data class EURRate(
            val code: String,
            val description: String,
            val rate: String,
            val rate_float: Double,
            val symbol: String
        )

        data class GBPRate(
            val code: String,
            val description: String,
            val rate: String,
            val rate_float: Double,
            val symbol: String
        )

        data class USDRate(
            val code: String,
            val description: String,
            val rate: String,
            val rate_float: Double,
            val symbol: String
        )
    }

    data class Time(
        val updated: String,
        val updatedISO: String,
        val updateduk: String
    )
}