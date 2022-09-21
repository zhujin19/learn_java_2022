
import javax.sound.midi.*;

public class MiniMiniMusiApp {

    public static void main(String[] args) {
        MiniMiniMusiApp mini = new MiniMiniMusiApp();
        mini.play();
    }

    public void play(){
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            Sequence seq = new Sequence(Sequence.PPQ,4) ;

            Track track = seq.createTrack();

            ShortMessage a = new ShortMessage();
            a.setMessage(144,1,44,100);
            MidiEvent noteon = new MidiEvent(a,1);
            track.add(noteon);


            ShortMessage b = new ShortMessage();
            b.setMessage(128,1,44,100);
            MidiEvent noteoff = new MidiEvent(b,1);
            track.add(noteoff);

            player.setSequence(seq);
            player.start();  // 开始播放

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }   // 关闭播放

    } // 关闭类

}
