package app.model.entity;

public class Tact {
    private final int DEFAULT_BEATS_NUMBER = 4;
    private final BeatsType DEFAULT_BEATS_TYPE = BeatsType.QUARTER;
    private final int DEFAULT_BPM = 120;
    private int beatsNumber;
    private Beat beat;

    public Tact() {
        this.beatsNumber = DEFAULT_BEATS_NUMBER;
        this.beat = new Beat(DEFAULT_BEATS_TYPE,DEFAULT_BPM);
    }

    public Tact(BeatsType beatsType, int bpm) {
        this.beatsNumber = DEFAULT_BEATS_NUMBER;
        this.beat = new Beat(beatsType, bpm);
    }

    public Tact(BeatsType beatsType, int beatsNumber, int bpm) {
        this.beatsNumber = beatsNumber;
        this.beat = new Beat(beatsType, bpm);
    }

    public int getBeatsNumber() {
        return beatsNumber;
    }

    public Beat getBeat() {
        return beat;
    }
}
