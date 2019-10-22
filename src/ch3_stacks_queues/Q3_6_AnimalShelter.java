package ch3_stacks_queues;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * An animal shelter, which holds only dogs and cats, operates on a
 * strictly"first in, first out" basis. People must adopt either the "oldest"
 * (based on arrival time) of all animals at the shelter, or they can select
 * whether they would prefer a dog or a cat (and will receive the oldest animal
 * of that type). They cannot select which specific animal they would like.
 * Create the data structures to maintain this system and implement operations
 * such as enqueue, dequeueAny, dequeueDog, and dequeueCat. You may use the
 * built-in Linked list data structure.
 * 
 * @author Forest
 *
 */

public class Q3_6_AnimalShelter {
	public static void main(String[] args) {
		Shelter shelter = new Shelter();
		shelter.enqueue(new Animal("Dog"));
		shelter.enqueue(new Animal("Dog"));
		shelter.enqueue(new Animal("Cat"));
		shelter.enqueue(new Animal("Dog"));
		shelter.enqueue(new Animal("Dog"));
		shelter.enqueue(new Animal("Cat"));
		shelter.enqueue(new Animal("Dog"));
		shelter.enqueue(new Animal("Dog"));
		shelter.enqueue(new Animal("Cat"));
		shelter.enqueue(new Animal("Dog"));
		System.out.println(shelter);
		shelter.dequeueAny();
		System.out.println(shelter);
		shelter.dequeueCat();
		System.out.println(shelter);
		shelter.dequeueDog();
		System.out.println(shelter);
	}

}

class Shelter {
	private LinkedList<Animal> animals;

	public Shelter() {
		// TODO Auto-generated constructor stub
		animals = new LinkedList<Animal>();
	}

	public void enqueue(Animal animal) {
		animals.add(animal);
	}

	public void dequeueAny() {
		if (animals.size() == 0) {
			return;
		}
		animals.removeFirst();
	}

	public void dequeueDog() {
		ListIterator<Animal> iterator = animals.listIterator();
		while (iterator.hasNext()) {
			if (iterator.next().getType().equals("Dog")) {
				iterator.remove();
				return;
			}
		}
	}

	public void dequeueCat() {
		ListIterator<Animal> iterator = animals.listIterator();
		while (iterator.hasNext()) {
			if (iterator.next().getType().equals("Cat")) {
				iterator.remove();
				return;
			}
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		ListIterator<Animal> iterator = animals.listIterator();
		String s = "[";
		while (iterator.hasNext()) {
			s += iterator.next().getType() + " ";
		}
		s += "]";
		return s;
	}

}

class Animal {
	private String name;
	private String type;

	public Animal(String type) {
		// TODO Auto-generated constructor stub
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}
}
