
public class ObjectReferenceExample {

	public static void main(String... doYourBest) {
	    String name = "";
	    name = name + "Homer";
	    changeToHomer(name);
	    System.out.println(name);
}

	static void changeToHomer(String name) {
		    name = name + "Homer";
	}
}

class Simpson {
	String name;
}