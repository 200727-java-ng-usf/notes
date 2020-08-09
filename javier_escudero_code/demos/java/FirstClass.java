public class FirstClass {


	/**
		This is a JavaDoc comment, used for documentation purposes
	*/
	public static void main(String[] args) {

		String s = "Hello, future Java devs!";
		System.out.println(s);

		int i = 10;
		System.out.println(i++);
		System.out.println(i);
		// single-line comment

		/*
			Multi-line
			comment
		*/

	}

	static {
		System.out.println("I run! but when?");
	}

	{
		System.out.println("Do I run?");
	}

}
