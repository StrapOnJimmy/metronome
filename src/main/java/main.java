import app.model.entity.Beat;
import app.model.entity.BeatsType;
import app.model.entity.Sound;
import app.model.entity.Tact;
import org.junit.Test;

import java.util.Timer;

public class main {
    public static void main(String[] args) throws InterruptedException {
        boolean onStart = true;
        long durability;
        Tact tact = new Tact(BeatsType.HALF,4,120);
        durability = tact.getBeat().getDurability();
        Sound sound = new Sound();

        while (onStart) {
            for (int i = 1; i <= 120 ; i++) {
                sound.playSound();
                sound.stopSound();
                Thread.sleep(durability);
            }
        }
    }
}
