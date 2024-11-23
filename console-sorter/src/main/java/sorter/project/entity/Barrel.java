package sorter.project.entity;

public class Barrel {
    private double volume;
    private String storedMaterial;
    private String material;

    public Barrel(BarrelBuilder barrelBuilder) {
        this.volume = barrelBuilder.volume;
        this.storedMaterial = barrelBuilder.storedMaterial;
        this.material = barrelBuilder.material;
    }

    public static class BarrelBuilder {
        private double volume;
        private String storedMaterial;
        private String material;

        public BarrelBuilder(double volume, String storedMaterial, String material) {
            this.volume = volume;
            this.storedMaterial = storedMaterial;
            this.material = material;
        }

        public Barrel build() {
            return new Barrel(this);
        }
    }

    @Override
    public String toString() {
        return "Barrel{" +
                "volume=" + volume +
                ", storedMaterial='" + storedMaterial + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}