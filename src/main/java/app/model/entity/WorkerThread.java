package app.model.entity;

public class WorkerThread extends Thread {
    private Click click;
    private Beat beat;
    private boolean onStart;

    public WorkerThread(Click click, Beat beat) {
        this.click = click;
        this.beat = beat;
    }

    public void run() {
        onStart = true;
        do {
            click.play(beat.getDurability(), true);
        } while (onStart);
    }

    public void stopPlay() {
        onStart = false;
        click.stop();
    }
}
