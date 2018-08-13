package strikt.assertions

import strikt.api.Assertion
import java.time.Instant
import java.time.LocalDate
import java.time.LocalTime
import java.time.MonthDay
import java.time.OffsetTime
import java.time.Year
import java.time.YearMonth
import java.time.chrono.ChronoLocalDate
import java.time.temporal.TemporalAccessor

/**
 * Asserts that the subject is before [expected].
 *
 * @throws java.time.DateTimeException if [expected] is not a compatible
 * temporal type.
 */
fun <T : TemporalAccessor> Assertion.Builder<T>.isBefore(expected: TemporalAccessor): Assertion.Builder<T> =
  passesIf("is before %s", expected) {
    when (this) {
      is Instant -> isBefore(Instant.from(expected))
      is ChronoLocalDate -> isBefore(LocalDate.from(expected))
      is LocalTime -> isBefore(LocalTime.from(expected))
      is MonthDay -> isBefore(MonthDay.from(expected))
      is OffsetTime -> isBefore(OffsetTime.from(expected))
      is Year -> isBefore(Year.from(expected))
      is YearMonth -> isBefore(YearMonth.from(expected))
      else -> throw UnsupportedOperationException("Strikt's isBefore does not (currently) support ${javaClass.simpleName}")
    }
  }

/**
 * Asserts that the subject is after [expected].
 *
 * @throws java.time.DateTimeException if [expected] is not a compatible
 * temporal type.
 */
fun <T : TemporalAccessor> Assertion.Builder<T>.isAfter(expected: TemporalAccessor): Assertion.Builder<T> =
  passesIf("is before %s", expected) {
    when (this) {
      is Instant -> isAfter(Instant.from(expected))
      is ChronoLocalDate -> isAfter(LocalDate.from(expected))
      is LocalTime -> isAfter(LocalTime.from(expected))
      is MonthDay -> isAfter(MonthDay.from(expected))
      is OffsetTime -> isAfter(OffsetTime.from(expected))
      is Year -> isAfter(Year.from(expected))
      is YearMonth -> isAfter(YearMonth.from(expected))
      else -> throw UnsupportedOperationException("Strikt's isAfter does not (currently) support ${javaClass.simpleName}")
    }
  }