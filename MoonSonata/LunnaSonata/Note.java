public class Note {
    public final int key;
    public final double lengthInBeats;
    public final double startBeat;
    public final int volume;

    public Note(int key, double lengthInBeats, int volume, double startBeat) {
        this.key = key;
        this.lengthInBeats = lengthInBeats;
         this.startBeat = startBeat;
        this.volume = volume;
    }
}