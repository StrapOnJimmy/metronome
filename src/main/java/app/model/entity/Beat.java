package app.model.entity;

public class Beat {
    private double bpm;
    private BeatsTypes beatsTypes;
    private double durability;

    public Beat(BeatsTypes beatsTypes, double bpm) {
        this.beatsTypes = beatsTypes;
        this.bpm = bpm;
        setDurability();
    }

    public long getDurability() {
        return (long) durability;
    }

    private void setDurability() {
        switch (beatsTypes){
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

    public BeatsTypes getBeatsTypes() {
        return beatsTypes;
    }
}
