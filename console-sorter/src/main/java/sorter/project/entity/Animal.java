package sorter.project.entity;

public class Animal{
	private final String types;
	private final boolean wool;
	private final String eyeColor;
	private Animal(Animal.AnimalBuilder builder) {
		this.types = builder.type;
		this.wool = builder.wool;
		this.eyeColor = builder.eyeColor;

	}
	public static class AnimalBuilder {
		private final String type;
		private boolean wool;
		private String eyeColor;

		public AnimalBuilder(String type) {
			this.type = type;
		}
		public Animal.AnimalBuilder wool(boolean wool) {
			this.wool = wool;
			return this;
		}
		public Animal.AnimalBuilder eyeColor(String eyeColor) {
			this.eyeColor = eyeColor;
			return this;
		}
		public Animal build() {
			return new Animal(this);
		}
	}

	@Override
	public String toString() {
		return "Животное{" +
				"вид='" + types + '\'' +
				", наличие шерсти='" + wool + '\'' +
				", цвет глаз='" + eyeColor +
				"'}";
	}
}
