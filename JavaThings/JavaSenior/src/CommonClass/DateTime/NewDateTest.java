package CommonClass.DateTime;

import org.junit.Test;

import java.time.*;

public class NewDateTest {
    @Test
    public void test1() {
        //实例化：now()：获取当前的日期、时间、日期时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of()：设置指定的年月、日、时、分、秒
        LocalDateTime localDateTime1 = LocalDateTime.of(2019,10, 1, 9, 40, 0);
        System.out.println(localDateTime1);

        System.out.println(localDateTime.getDayOfMonth());
    }

    @Test
    public void test2() {
        //实例化：now()：本初子午线标准时间
        Instant instant = Instant.now();
        System.out.println(instant);

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //获取时间戳
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        //通过给定的毫秒数获取Instant实例
        Instant instant1 = Instant.ofEpochMilli(159653513587L);
        System.out.println(instant1);
    }

    @Test
    public void test3() {
        
    }
}
