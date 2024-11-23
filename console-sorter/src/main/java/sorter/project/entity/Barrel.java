package sorter.project.entity;

public class Barrel implements SelfComparator<Barrel> {
    private float volume;
    private String matherialOfPreserve;
    private String matherial;

    public Barrel(float volume, String matherialOfPreserve, String matherial) {
        super();
        this.volume = volume;
        this.matherialOfPreserve = matherialOfPreserve;
        this.matherial = matherial;
    }

    @Override
    public boolean moreThen(Barrel another) {
        // TODO Auto-generated method stub
        return (this.volume - another.volume) > 0.00001;
    }

    @Override
    public String toString() {
        return "Barrel [volume=" + volume + ", matherialOfPreserve=" + matherialOfPreserve + ", matherial=" + matherial
                + "]";
    }


}
