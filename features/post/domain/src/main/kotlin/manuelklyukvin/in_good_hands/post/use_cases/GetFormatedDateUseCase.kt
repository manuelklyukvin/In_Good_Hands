package manuelklyukvin.in_good_hands.post.use_cases

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

class GetFormatedDateUseCase {
    operator fun invoke(date: String): String {
        val instant = Instant.parse(date)
        val zoneId = ZoneId.systemDefault()
        val localDateTime = LocalDateTime.ofInstant(instant, zoneId)

        val locale = getLocale()
        val pattern = getPattern(locale)
        val formatter = DateTimeFormatter.ofPattern(pattern, locale)
        return localDateTime.format(formatter)
    }

    private fun getLocale() = when (Locale.getDefault().language) {
        "ru" -> Locale.forLanguageTag("ru")
        "cs" -> Locale.forLanguageTag("cs")
        else -> Locale.ENGLISH
    }

    private fun getPattern(locale: Locale) = when (locale.language) {
        "ru" -> "dd MMMM yyyy HH:mm"
        "cs" -> "d. MMMM yyyy HH:mm"
        else -> "MMMM d, yyyy HH:mm"
    }
}