import app.model.entity.*;

import java.util.Scanner;

public class main {
    public static void main(String[] args) throws InterruptedException {
        String inputData;
        boolean onStart = false;

        Tact tact = new Tact();
        Beat beat = tact.createBeat();
        Click click = tact.createClick();
        click.createSound();

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
