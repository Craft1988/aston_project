package sorter.project.entity;

public class Animal implements Comparable<Animal> {

    private final String type;
    private String eyeColor;
    private boolean wool;

    public Animal(AnimalBuilder animalBuilder) {
        this.type = animalBuilder.type;
    }

    public static class AnimalBuilder{

        private String type;
        private String eyeColor;
        private boolean wool;

        public AnimalBuilder(String type) {
            this.type = type;
        }
        public AnimalBuilder setEyeColor(String eyeColor) {
            this.eyeColor = eyeColor;
            return this;
        }

        public AnimalBuilder setWool(boolean wool) {
            this.wool = wool;
            return this;
        }

        public Animal build() {
            return new Animal(this);
        }


    }
    @Override
    public String toString() {
        return "Animal{" + "type='" + type + '\'' + ", eyeColor='" + eyeColor + '\'' + ", wool=" + wool + '}';
    }

    @Override
    public int compareTo(Animal o) {
        return this.type.compareTo(o.type);
    }

}
