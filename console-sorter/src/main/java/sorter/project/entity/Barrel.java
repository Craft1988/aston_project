package sorter.project.entity;

public class Barrel implements Comparable<Barrel> {
    private double volume;
    private String storedMaterial;
    private String material;

    public Barrel(BarrelBuilder barrelBuilder) {
        this.volume = barrelBuilder.volume;
        this.storedMaterial = barrelBuilder.storedMaterial;
        this.material = barrelBuilder.material;
    }

    public static class BarrelBuilder  {

        private double volume;
        private String storedMaterial;
        private String material;

        public BarrelBuilder(double volume) {
            this.volume = volume;
        }

        public BarrelBuilder setStoredMaterial(String storedMaterial) {
            this.storedMaterial = storedMaterial;
            return this;
        }

        public BarrelBuilder setMaterial(String material) {
            this.material = material;
            return this;
        }

        public Barrel build() {
            return new Barrel(this);
        }

    }
    @Override
    public String toString() {
        return "Barrel{" + "volume=" + volume + ", storedMaterial='" + storedMaterial + '\'' + ", material='" + material
                + '\'' + '}';
    }

    @Override
    public int compareTo(Barrel o) {
        return Double.compare(this.volume, o.volume);
    }

}