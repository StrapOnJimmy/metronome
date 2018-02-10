package app.model.entity;

public class Beat {
    public BeatsType beatsType;
    private final double ONE_MINUTE = 60.0;
    private double durability;

    public Beat(BeatsType beatsType,int bpm) {
        this.beatsType = beatsType;
        switch (beatsType){
            case WHOLE:
                durability = (ONE_MINUTE /(bpm/4))*1000;
                break;
            case HALF:
                durability = (ONE_MINUTE /(bpm/2))*1000;
                break;
            case QUARTER:
                durability = (ONE_MINUTE /bpm)*1000;
                break;
            case EIGHTH:
                durability = (ONE_MINUTE /(bpm*2))*1000;
                break;
            case SIXTEENTH:
                durability = (ONE_MINUTE/(bpm*4))*1000;
                break;
            case THIRTYTWO:
                durability = (ONE_MINUTE/(bpm*8))*1000;
                break;
            case SIXTYFOURTH:
                durability = (ONE_MINUTE/(bpm*16))*1000;
                break;

        }
    }

    public long getDurability() {
        return (long) durability;
    }

    public void setDurability(double durability) {
        this.durability = durability;
    }


}
