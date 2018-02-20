package app.model.entity;

public class Beat {
    private double bpm;
    private BeatsType beatsType;
    private double durability;

    public Beat(BeatsType beatsType, double bpm) {
        this.beatsType = beatsType;
        this.bpm = bpm;
        setDurability();
    }

    public long getDurability() {
        return (long) durability;
    }

    private void setDurability() {
        switch (beatsType){
            case WHOLE:
                durability = (DefaultValues.ONE_MINUTE /(bpm/4))*1000;
                break;
            case HALF:
                durability = (DefaultValues.ONE_MINUTE  /(bpm/2))*1000;
                break;
            case QUARTER:
                durability = (DefaultValues.ONE_MINUTE  /bpm)*1000;
                break;
            case EIGHTH:
                durability = (DefaultValues.ONE_MINUTE  /(bpm*2))*1000;
                break;
            case SIXTEENTH:
                durability = (DefaultValues.ONE_MINUTE /(bpm*4))*1000;
                break;
            case THIRTYTWO:
                durability = (DefaultValues.ONE_MINUTE /(bpm*8))*1000;
                break;
            case SIXTYFOURTH:
                durability = (DefaultValues.ONE_MINUTE /(bpm*16))*1000;
                break;
        }
    }

    public BeatsType getBeatsType() {
        return beatsType;
    }
}
