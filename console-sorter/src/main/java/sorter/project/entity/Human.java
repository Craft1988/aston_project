package sorter.project.entity;

public class Human {
    private String sex;
    private int age;
    private String surname;

    public Human(HumanBuilder humanBuilder) {
        this.sex = humanBuilder.sex;
        this.age = humanBuilder.age;
        this.surname = humanBuilder.surname;
    }

    public static class HumanBuilder {
        private String sex;
        private int age;
        private String surname;

        public HumanBuilder(String sex, int age, String surname) {
            this.sex = sex;
            this.age = age;
            this.surname = surname;
        }

        public Human build() {
            return new Human(this);
        }
    }

    @Override
    public String toString() {
        return "Human{" +
                "sex='" + sex + '\'' +
                ", age=" + age +
                ", surname='" + surname + '\'' +
                '}';
    }
}
