package box.discord.result;

public class Option<T> implements Result {
    
    private T value;
    private Result delegate;
    
    Option(T value, Result delegate) {
        this.value = value;
        this.delegate = delegate;
    }
    
    public T get() {
        if (value == null)
            throw new NullPointerException(this.toString() + "is null in Option.get()");
        else
            return value;
    }
    
    @Override
    public boolean isSuccess() { return delegate.isSuccess(); }
    @Override
    public void throwException() throws Exception { delegate.throwException(); }
}
