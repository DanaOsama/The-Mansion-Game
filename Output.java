public class Output {
    // synchronized wrapping around system.out
    synchronized void print(String s)
    {
        System.out.print(s);
    }
	
	synchronized void println(String s)
	{
		System.out.println(s);
	}
}