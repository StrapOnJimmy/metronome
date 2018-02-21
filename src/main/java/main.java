import app.model.entity.*;

import java.util.Scanner;

public class main {
    public static void main(String[] args) throws InterruptedException {
        String inputData;
        boolean onStart = false;

        Tact tact = new Tact(130,8);
        Beat beat = tact.createBeat(BeatsTypes.EIGHTH);
        Click click = tact.createClick();
        click.createSound(InstrumentsTypes.SideStick);

        Scanner scanner = new Scanner(System.in);
        inputData = scanner.nextLine();

        if (inputData.equals("1")){
            onStart = true;
        }else {
            click.getSound().close();
        }

        while (onStart) {
                click.play(beat.getDurability(),true);
        }
    }
}
