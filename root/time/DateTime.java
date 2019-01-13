package root.time;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class DateTime{

    public static void init(){

		// Date and Time classes are immutable
        //		methods throw DateTimeException if value of any field is out of range
        //
        // UTC - Coordinated Universal Time, same time zone as GMT
        //      get UTC by subtracting time zone from time
        //      07:50 GMT-04:00 -> UTC 11:50
        //      +02:00 | GMT+2 | UTC+2
        LocalDate date = LocalDate.of(2019, Month.JANUARY, 01);
        LocalTime time = LocalTime.of(00, 00, 00, 00);
        LocalDateTime datetime = LocalDateTime.of(date, time);

        ZoneId id = ZoneId.of("Europe/Vienna");
        ZonedDateTime zonedDt = ZonedDateTime.of(datetime, id);

        // Manipulating Date/Time: (static methods cannot be chained -> last one returned, compiler warning)
        //      plusXXX/minusXXX(int) - XXX = Years | Months | Weeks | Days | Hours | Minutes | Seconds | Nanos
        //      plus/minus(Period/Duration)
        //      plus/minus(long, TemporalUnit)
        //      Using invalid class with method -> UnsupportedTemporalException
        //
        // Period: Used for Dates, outputs P1Y2M3D
        //      ofXXX(int) | of(int y, int m, int d)
        // Duration: Used for Times, outputs PT1H2M0.3S
        //      ofXXX(int) | of(long, TemporalUnit unit)
        //      ChronoUnit.DAYS | HOURS | MINUTES | SECONDS | MILLIS | NANOS
        //      ChronoUnit.MINUTES.between(Temporal, Temporal)                  Cannot mix up date and time
        Period p = Period.of(1, 1, 1);
        Duration d = Duration.of(5, ChronoUnit.MINUTES);
        date.plus(p);
        time.plus(d);

        // Specific Moment in GMT time without time zone string
        //      Instant.now() | zonedDateTime.toInstant() | Instant.ofEpochSecond(long)
        //      instant.plus(int, ChronoUnit)   -   cannot be used with YEARS, MONTHS, WEEKS
        Instant i = Instant.now();
        i.plus(2, ChronoUnit.DAYS);

        // Daylight Saving Time:
        //      Officially changes at 2 am | 1:59 -> 3:00 | 1:59 -> 1:00 | GMT time changes too
        //      Creating time that does not exist will roll time forward

        // Formatting Date/Time: java.time.format.DateTimeFormatter
        //      DateTimeFormatter.ofLocalizedDateTime(FormatStyle)      FormatStyle.SHORT | MEDIUM
        //                       .ofLocalizedDate(FormatStyle)
        //                       .ofLocalizedTime(FormatStyle)
        //      DateTimeFormatter.ofPattern(String) throws IllegalArgumentException
        //      MMMM, dd, yyyy, hh, mm
        //
        // Format:
        //      date.format(formatter) throws DateTimeException     / error during formatting
        //      formatter.format(date) throws DateTimeException     /
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyy");
        System.out.println(formatter.format(zonedDt));

        // Parse: LocalDateTime.parse(String, DateTimeFormatter) throws DateTimeParseException
        LocalDate ld = LocalDate.parse("12 14 2019", formatter);
        System.out.println(ld);
    }

}