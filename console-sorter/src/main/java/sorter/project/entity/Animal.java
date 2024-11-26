package sorter.project.entity;

import java.util.Comparator;

public class Animal {
    private String type;
    private String eyeColor;
    private boolean wool;

    private Animal(AnimalBuilder builder) {
        this.type = builder.type;
        this.eyeColor = builder.eyeColor;
        this.wool = builder.wool;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Animal{type='" + type + "', eyeColor='" + eyeColor + "', wool=" + wool + '}';
    }

    public static class AnimalBuilder {
        private String type;
        private String eyeColor;
        private boolean wool;

        public AnimalBuilder(String types, String eyeColor, boolean wool) {
        }

        public AnimalBuilder() {

        }

        public AnimalBuilder setType(String type) {
            this.type = type;
            return this;
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
//public class Animal {
//    private static Comparator<Animal> comparator = Comparator.comparing(a -> a.type);
//    private String type;
//    private String eyeColor;
//    private boolean wool;
//
//    public String getType() {
//        return type;
//    }
//
//
//    public Animal(AnimalBuilder animalBuilder) {
//        this.type = animalBuilder.type;
//        this.eyeColor = animalBuilder.eyeColor;
//        this.wool = animalBuilder.wool;
//    }


//    public static class AnimalBuilder implements Autobuilder {
//        private String type;
//        private String eyeColor;
//        private boolean wool;
//
//        public AnimalBuilder(String type, String eyeColor, boolean wool) {
//            this.type = type;
//            this.eyeColor = eyeColor;
//            this.wool = wool;
//        }
//
//        public void setType(String type) {
//            this.type = type;
//        }
//
//        public void setEyeColor(String eyeColor) {
//            this.eyeColor = eyeColor;
//        }
//
//        public void setWool(boolean wool) {
//            this.wool = wool;
//        }
//
//
//        @Override
//        public Autobuilder randomAutoset() {
//            // TODO Auto-generated method stub
//            return this;
//        }
//
//        @Override
//        public Autobuilder fromFileAutoset() {
//            // TODO Auto-generated method stub
//            return this;
//        }
//
//        public Animal build() {
//            return new Animal(this);
//        }
//
//    }
//
//    @Override
//    public String toString() {
//        return "Animal{" + "type='" + type + '\'' + ", eyeColor='" + eyeColor + '\'' + ", wool=" + wool + '}';
//    }
//
//    public static Comparator<Animal> getComparator() {
//        return comparator;
//    }

}
