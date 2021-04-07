import java.util.Timer;
import java.util.TimerTask;

public class PomodoroTimer {
    private Timer timer = new Timer();
    private int workDuration = 25;
    private int restDuration =  5;
    private Status status = Status.STOP;
    private TimerTask task = null;

    PomodoroTimer(int workDuration, int restDuration) {
        setTime(workDuration, restDuration);
    }

    void setTime(int workDuration, int restDuration) {
        this.workDuration = workDuration;
        this.restDuration = restDuration;
    }

    void start() {
//        System.out.println(status);
        if (status.equals(Status.REST)) {
            task = new TimerTask() {
                @Override
                public void run() {
                    status = Status.WORK;
//                    System.out.println("Ended rest");
                    CommandLineParser.timeIsUp("work");
                }
            };
            timer.schedule(task, restDuration * 60 * 1000);
        } else {
            task = new TimerTask() {
                @Override
                public void run() {
                    status = Status.REST;
                    //System.out.println("Ended work");
                    CommandLineParser.timeIsUp("rest");
                }
            };
            timer.schedule(task, workDuration * 60 * 1000);
        }
    }

    void stop() {
        if (status != Status.STOP) {
            task.cancel();
            timer.cancel();
        }
    }
}

enum Status {
    WORK,
    REST,
    PAUSE,
    STOP,
}