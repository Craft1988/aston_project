package sorter.project.entity;

import lombok.Getter;

public class Animal {

    @Getter
    private final String type;
    private final String eyeColor;
    private final boolean wool;

    public Animal(Animal.AnimalBuilder animalBuilder) {
        this.type = animalBuilder.type;
        this.eyeColor = animalBuilder.eyeColor;
        this.wool = animalBuilder.wool;
    }

    public static class AnimalBuilder {

        private final String type;
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

}
