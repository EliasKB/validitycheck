package personnumbervalidator;

public interface SwedishPersonNumberValidator {

    boolean isNull();
    boolean isYearCorrect();
    boolean isMonthCorrect();
    boolean isDayCorrect();
    boolean isLastFourNumbersCorrect();
}
