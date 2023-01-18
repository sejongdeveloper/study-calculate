import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /**
         * 2023-01-18
         * 스프링 데이터 JPA - 264분
         * 스프링과 JPA 기반 웹 애플리케이션  1092분
         * 더 개발자, 인터뷰 가이드 - 761분
         */
        int counts[] = {264, 1092, 761};
        calculateCompleteDate(counts[0]);
        calculateCompleteDate(counts[0] + counts[1]);
        calculateCompleteDate(counts[0] + counts[1] + counts[2]);
    }

    private static void calculateCompleteDate(int count) {
        int target = count;
        LocalDate date = LocalDate.now();
        List<LocalDate> holidays = List.of(LocalDate.of(2023, 1, 23), LocalDate.of(2023, 1, 24));

        boolean isComplete = false;
        while (!isComplete) {
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY || holidays.contains(date)) {
                target = target - (60 * 3);
            } else {
                target = target - 60;
            }
            if (target <= 0) {
                isComplete = true;
            } else {
                date = date.plusDays(1);
            }
        }
        System.out.println(String.format("목표개수 %d : 완료날짜 %s", count, date));
    }
}
