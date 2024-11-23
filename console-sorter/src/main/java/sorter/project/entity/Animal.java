package sorter.project.entity;

public class Animal {
    private String type;
    private String eyeColor;
    private boolean wool;

    public Animal(AnimalBuilder animalBuilder) {
        this.type = animalBuilder.type;
        this.eyeColor = animalBuilder.eyeColor;
        this.wool = animalBuilder.wool;
    }

    public static class AnimalBuilder {
        private String type;
        private String eyeColor;
        private boolean wool;

        public AnimalBuilder(String type, String eyeColor, boolean wool) {
            this.type = type;
            this.eyeColor = eyeColor;
            this.wool = wool;
        }

        public Animal build() {
            return new Animal(this);
        }
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", wool=" + wool +
                '}';
    }
}
