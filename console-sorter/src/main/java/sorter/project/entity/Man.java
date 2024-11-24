package sorter.project.entity;

public class Man {
    private final String lastName;
    private final int age;
    private final String gender;
    private Man(ManBuilder builder) {
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.gender = builder.gender;

    }
    public static class ManBuilder {
        private final String lastName;
        private int age;
        private String gender;

        public ManBuilder(String lastName) {
            this.lastName = lastName;
        }
        public ManBuilder age(int age) {
            this.age = age;
            return this;
        }
        public ManBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }
        public Man build() {
            return new Man(this);
        }
    }
    @Override
    public String toString() {
        return "Человек{" +
                "фамилия='" + lastName + '\'' +
                ", возраст='" + age + '\'' +
                ", пол='" + gender +
                "'}";
    }
}
