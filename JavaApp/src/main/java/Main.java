
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			assert args.length == 2;
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			System.out.printf("%d + %d = %d\n", a,b,add(a, b));
		}
		catch(Exception e) {
			System.out.println("wrong input");
		}
	}

	public static int add(int a, int b) {
		return a+b;
	}
}
