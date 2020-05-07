public interface UISubject {
    public void registerObserver(UIObserver o);
    public void removeObserver(UIObserver o);
    public void notifyObservers(String s);
}