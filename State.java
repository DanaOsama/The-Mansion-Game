public interface State {
	public void prev(Mood m) throws Exception;
	public void next(Mood m);
	public void printStatus();
}
