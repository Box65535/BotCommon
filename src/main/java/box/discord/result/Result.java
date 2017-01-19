package box.discord.result;

public interface Result {
    
    boolean isSuccess();
    
    void throwException() throws Exception;
    
    class Success implements Result {
        private Success() {}
        @Override
        public boolean isSuccess() { return true; }
        @Override
        public void throwException() throws Exception {}
    }

    class Failure implements Result {
        private Exception e;
        private Failure() { e = null; }
        private Failure(Exception e) { this.e = e; }
        @Override
        public boolean isSuccess() { return false; }
        @Override
        public void throwException() throws Exception { if (e!= null) throw e; }
    }

    static Option<Boolean> Success() {
        return new Option<>(true, new Success());
    }

    static <T> Option<T> Success(T value) {
        return new Option<>(value, new Success());
    }

    static <T> Option<T> Failure() {
        return new Option<>(null, new Failure());
    }
    
    static <T> Option<T> Failure(Exception e) {
        return new Option<>(null, new Failure());
    }
}
