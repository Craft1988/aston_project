package sorter.project.entity;

public class Barrel{
	private final float volume;
	private final String storedMaterial;
	private final String material;
	private Barrel(Barrel.BarrelBuilder builder) {
		this.volume = builder.volume;
		this.storedMaterial = builder.storedMaterial;
		this.material = builder.material;

	}
	public static class BarrelBuilder {
		private final float volume;
		private String storedMaterial;
		private String material;

		public BarrelBuilder(float volume) {
			this.volume = volume;
		}
		public Barrel.BarrelBuilder storedMaterial(String storedMaterial) {
			this.storedMaterial = storedMaterial;
			return this;
		}
		public Barrel.BarrelBuilder material(String material) {
			this.material = material;
			return this;
		}
		public Barrel build() {
			return new Barrel(this);
		}
	}
	@Override
	public String toString() {
		return "Бочка{" +
				"вместимость='" + volume + '\'' +
				", материал='" + material + '\'' +
				", хранимый материал='" + storedMaterial +
				"'}";
	}
}
