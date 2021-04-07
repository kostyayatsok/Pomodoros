import java.util.Scanner;

class CommandLineParser
{
    static PomodoroTimer timer = new PomodoroTimer(1, 1);
    static Scanner scanner = new Scanner(System. in);

    public static void main ( String [] arguments )
    {
        System.out.println("Welcome! Ready to start? (y/n)");

        String inputString = scanner.nextLine();
        if (inputString.equals("y")) {
            start();
        } else {
            finish();
        }
    }

    private static void start() {

    }

    public static void timeIsUp(String nextActivity) {
        System.out.println("Time is up! Ready for " + nextActivity + "? (y/n)");
        String response = scanner.nextLine();
        if (response.equals("y")) {
            start();
        } else if (response.equals("n")) {
            finish();
        }
    }
    private static void finish() {
        timer.stop();
        System.out.println("Good Bye!");
        System.exit(0);
    }
}