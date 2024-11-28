package sorter.project.entity;

public class Barrel {

    private final double volume;
    private final String storedMaterial;
    private final String material;

    public Barrel(BarrelBuilder barrelBuilder) {
        this.volume = barrelBuilder.volume;
        this.storedMaterial = barrelBuilder.storedMaterial;
        this.material = barrelBuilder.material;
    }

    public static class BarrelBuilder {

        private final double volume;
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

    public double getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "Barrel{" + "volume=" + volume + ", storedMaterial='" + storedMaterial + '\'' + ", material='" + material
                + '\'' + '}';
    }
}