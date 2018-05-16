package ValueObjects;

public class TimerValue {
    private int seconds = 0;

    public TimerValue() {
    }

    public TimerValue(String string) {
        String[] splitedString = string.split(":");
        int minutes = Integer.parseInt(splitedString[0]);
        int seconds = Integer.parseInt(splitedString[1]);
        this.seconds = minutes * 60 + seconds;
    }

    public void addOneSecond() {
        this.seconds++;
    }

    public int getSeconds() {
        return seconds;
    }

    @Override
    public String toString() {
        String result = "";
        int minutes = seconds / 60;
        int leftSeconds = seconds % 60;
        if (minutes == 0) {
            result += "00";
        } else if (minutes < 10) {
            result += "0" + minutes;
        } else {
            result += minutes;
        }
        result += ":";

        if (leftSeconds == 0) {
            result += "00";
        } else if (leftSeconds < 10) {
            result += "0" + leftSeconds;
        } else {
            result += leftSeconds;
        }
        return result;
    }
}
