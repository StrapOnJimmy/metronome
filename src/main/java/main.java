import app.model.entity.*;

import java.util.Timer;

public class main {
    public static void main(String[] args) throws InterruptedException {

        Tact tact = new Tact(90);
        Beat beat = tact.createBeat(BeatsType.QUARTER);
        tact.createClick();
        boolean onStart = true;

        while (onStart) {
            for (int i = 1; i <= 120 ; i++) {
                tact.play();
                Thread.sleep(beat.getDurability());
            }
        }
    }
}
