package sorter.project.entity;

public class Animal implements SelfComparator<Animal> {
	private String type;
	private boolean wool;

	public Animal(String type, boolean wool) {
		this.type = type;
		this.wool = wool;
	}

	@Override
	public String toString() {
		return "Animal [type=" + type + ", wool=" + wool + "]";
	}
  
	@Override
	public boolean moreThen(Animal another) {
		return this.type.compareTo(another.type) > 0;
	}
}
