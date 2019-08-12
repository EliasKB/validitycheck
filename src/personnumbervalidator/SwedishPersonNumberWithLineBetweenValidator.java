package personnumbervalidator;

public class SwedishPersonNumberWithLineBetweenValidator implements SwedishPersonNumberValidator {



    String personnummer;

    public SwedishPersonNumberWithLineBetweenValidator(String personnummer) {

        this.personnummer = personnummer;
    }


    public boolean isNull(){
        return  ( personnummer == null || personnummer.isEmpty() );
    }

    public boolean isCorrectPersonNumber() {

        if ( !isLengthCorrect() ) {
            return false;

        } else if ( !isYearCorrect() ) {
            return false;

        } else if ( !isMonthCorrect() ){
            return false;

        } else if ( !isDayCorrect() ){
            return false;

        } else if ( !isLastFourNumbersCorrect() ){
            return false;
        }

        else {

            int lastnumber = getLastnumber();

            int[] calculatingPartOFpersonnummer = getCalculatingPartOfThePersonNumberForApplyingAlgorithm();

            int sum = getSumOfProducts(calculatingPartOFpersonnummer);

            return doesSumMatcheLastNumber(lastnumber, sum);
        }
    }


    private String getYear(){
        return personnummer.substring(0, 4);

    }
    private String getMonth(){
        return personnummer.substring(4, 6);

    }
    private String getDay(){
        return personnummer.substring(6, 8);

    }
    private String getFourLastNumbers(){
        return personnummer.substring(9, 12);

    }

    private boolean isLengthCorrect() {
        return personnummer.length() == 13;
    }
    public boolean isInteger(String input){

        try { Integer.parseInt( input );
            return true;
        }
        catch( Exception e ) {
            return false;
        }
    }
    public boolean isYearCorrect(){
        String year = getYear();
        return (isInteger(year) && yearStartWithCorrectIntegers());
    }
    public boolean isMonthCorrect(){
        String month = getMonth();
        return isInteger(month) && monthStartWithCorrectIntegers();
    }
    public boolean isDayCorrect(){
        String day = getDay();
        return isInteger(day) && dayStartWithCorrectIntegers();
    }
    public boolean isLastFourNumbersCorrect(){
        String lastfournumbers = getFourLastNumbers();
        return isInteger(lastfournumbers);
    }

    public boolean yearStartWithCorrectIntegers() {
        return (personnummer.substring(0, 2).equals("19") || personnummer.substring(0, 2).equals("20"));
    }
    public boolean monthStartWithCorrectIntegers() {
        return (personnummer.substring(4, 5).equals("0") ||  personnummer.substring(4, 5).equals("1"));
    }
    public boolean dayStartWithCorrectIntegers() {
        return ( (personnummer.substring(6, 7).equals("0") ||  personnummer.substring(6, 7).equals("1")) ||
                (personnummer.substring(6, 7).equals("2") ||  personnummer.substring(6, 7).equals("3")) );
    }

    public int getLastnumber() {
        return Character.getNumericValue(personnummer.charAt(personnummer.length() - 1));
    }

    private int[] getCalculatingPartOfThePersonNumberForApplyingAlgorithm() {
        int[] calculatingPartOFpersonnummer = new int[9];
        int counter = 0;


        for (int i = 2; i < personnummer.length() - 1; i++) {
            if (i == 8) {
                i++;
            }
            calculatingPartOFpersonnummer[counter] = Character.getNumericValue(personnummer.charAt(i));

            counter++;
        }
        return calculatingPartOFpersonnummer;
    }

    public int getSumOfProducts(int[] calculatingPartOFpersonnummer) {
        int sum = 0;
        for (int i = 0; i < calculatingPartOFpersonnummer.length; i++) {
            if (i % 2 == 1) {
                sum += calculatingPartOFpersonnummer[i];
            } else {
                int value = calculatingPartOFpersonnummer[i] * 2;
                if (value < 10) {
                    sum += value;
                } else {
                    sum += value % 10 + value / 10;
                }
            }
        }
        return sum;
    }

    public boolean doesSumMatcheLastNumber(int lastnumber, int sum) {
        return (10 - (sum % 10)) % 10 == lastnumber;
    }


}
