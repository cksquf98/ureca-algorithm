
public class StringTest {

	public static void main(String[] args) {
		String s1 = "Java";
		String s2 = "Java";
		
		System.out.println(s1 == s2); //true
		System.out.println(s1.equals(s2)); //true
		
		
		String s3 = new String("Java");
		String s4 = new String("Java");
		
		System.out.println(s3 == s1); //false
		System.out.println(s3 == s4); //false
		System.out.println(s3.equals(s4)); //true
	}

}
