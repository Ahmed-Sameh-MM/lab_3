import java.util.Scanner;

public class Clock {

    enum State{NORMAL, UPDATE, ALARM}
    enum State1{TIME, DATE}
    enum State2{MIN, HOUR, DAY, MONTH, YEAR}
    enum AlarmState{ALARM, CHIME}

    static int m = 0, h = 0, D = 1, M = 1, Y =2000;

    public void DisplayDate() {
        System.out.println(Y + "-" + M + "-" + D);
    }

    public void DisplayTIME() {
        System.out.println(h + ":" + m);
    }

    public void watch() {
        Scanner s = new Scanner(System.in);
        String input = s.next();

        State state = State.NORMAL;
        State1 state1 = State1.TIME;
        State2 state2 = State2.MIN;
        AlarmState alarmState = AlarmState.ALARM;

        for(int i = 0; i < input.length(); i++) {
            switch (state) {
                case NORMAL:
                    if(input.charAt(i) == 'c') state = State.UPDATE;
                    else if(input.charAt(i) == 'b') state = State.ALARM;
                    else if(input.charAt(i) == 'a' && state1 == State1.TIME) state1 = State1.DATE;
                    else if(input.charAt(i) == 'a' && state1 == State1.DATE) state1 = State1.TIME;
                    break;

                case UPDATE:
                    if(input.charAt(i) == 'b') {
                        if(state2 == State2.MIN) {
                            if(m < 60) m++;
                            else m = 0;
                        }
                        else if(state2 == State2.HOUR) {
                            if(h < 24) h++;
                            else h = 0;
                        }
                        else if(state2 == State2.DAY) {
                            if(D < 31) D++;
                            else D = 1;
                        }
                        else if(state2 == State2.MONTH) {
                            if(M < 12) M++;
                            else M = 1;
                        }
                        else if(state2 == State2.YEAR) {
                            if(Y < 2100) Y++;
                            else Y = 2000;
                        }
                    }
                    else if(input.charAt(i) == 'd') state = State.NORMAL;
                    else if(input.charAt(i) == 'a') {
                        if(state2 == State2.MIN) state2 = State2.HOUR;
                        else if(state2 == State2.HOUR) state2 = State2.DAY;
                        else if(state2 == State2.DAY) state2 = State2.MONTH;
                        else if(state2 == State2.MONTH) state2 = State2.YEAR;
                        else if(state2 == State2.YEAR) {
                            state = State.NORMAL;
                            state1 = State1.TIME;
                        }
                    }
                    break;

                case ALARM:
                    if(input.charAt(i) == 'd') {
                        state = State.NORMAL;
                        alarmState = AlarmState.ALARM;
                    }
                    else if(input.charAt(i) == 'a') alarmState = alarmState.CHIME;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Clock c = new Clock();
        c.watch();
    }
}
