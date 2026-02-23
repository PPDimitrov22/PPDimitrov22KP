import javax.sound.midi.*;
import java.util.Scanner;
public class Main {
    private static Playback player = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        while (true) {
            System.out.println("Commands:");
            System.out.println("play");
            System.out.println("stop");
            System.out.println("quit");
            System.out.print("- ");

            String cmd = sc.nextLine();

            if (cmd.equals("play")) {
                if (player != null && player.isActive()) {
                    System.out.println("Already playing...");
                    continue;
                }
                try {
                    SequenceData data = Music.createOpeningSequence();
                    Sequence midiSequence = Converter.convertToMidiSequence(data);

                    player = new Playback();
                   player.play(midiSequence, 66f);
                    System.out.println("Playing... (type 'stop' to stop)");
                } catch (Exception e) {
                    System.out.println("Cannot start playback: " + e.getMessage());
                }
            }
            else if (cmd.equals("stop")) {
                if (player != null) {
                    player.stop();
                    player = null;
                    System.out.println("Stopped.");
                } else {
                    System.out.println("Nothing is playing.");
                }
            }
            else if (cmd.equals("quit") || cmd.equals("quit")) {
                if (player != null) {
                    player.stop();
                }
                System.out.println("Goodbye!");
                break;
            }
            else {
                System.out.println("Unknown command.");
            }
        }
        sc.close();
    }
}