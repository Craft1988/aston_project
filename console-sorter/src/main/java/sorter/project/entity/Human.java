package sorter.project.entity;


public class Human {

    private final String sex;
    private final int age;
    private final String surname;

    public Human(HumanBuilder humanBuilder) {
        this.sex = humanBuilder.sex;
        this.age = humanBuilder.age;
        this.surname = humanBuilder.surname;
    }


    public static class HumanBuilder {

        private String sex;
        private int age;
        private final String surname;

        public HumanBuilder(String surname) {
            this.surname = surname;
        }

        public HumanBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public HumanBuilder setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public Human build() {
            return new Human(this);
        }


    }

    public int getAge() {
        return age;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Human{" + "sex='" + sex + '\'' + ", age=" + age + ", surname='" + surname + '\'' + '}';
    }


}
