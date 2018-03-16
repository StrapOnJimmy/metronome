import app.model.entity.*;

import java.util.Timer;

public class main {
    public static void main(String[] args) throws InterruptedException {

        Tact tact = new Tact();
        Beat beat = tact.createBeat();
        boolean onStart = true;

        while (onStart) {
            for (int i = 1; i <= 120 ; i++) {
                Thread.sleep(beat.getDurability( ));
            }
        }
    }
}
