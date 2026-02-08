package jadex.runtime;

import java.util.function.Supplier;

public final class SafeAccess<T> {

    @FunctionalInterface
    public interface CheckedFunction<T, R> {
        R apply(T value) throws Exception;
    }

    @FunctionalInterface
    public interface CheckedSupplier<T> {
        T get() throws Exception;
    }

    private sealed interface State<T> permits Present, Empty, Failed {}

    private static final class Present<T> implements State<T> {
        final T value;
        Present(T value) { this.value = value; }
    }

    private static final class Empty<T> implements State<T> {}

    private static final class Failed<T> implements State<T> {
        final Exception exception;
        Failed(Exception exception) { this.exception = exception; }
    }

    private final State<T> state;

    private SafeAccess(State<T> state) {
        this.state = state;
    }

    // Static factory methods
    public static <T> SafeAccess<T> ofNullable(T value) {
        return value == null ? new SafeAccess<>(new Empty<>())
                : new SafeAccess<>(new Present<>(value));
    }

    public static <T> SafeAccess<T> ofChecked(CheckedSupplier<T> supplier) {
        try {
            T value = supplier.get();
            return ofNullable(value);
        } catch (Exception e) {
            return new SafeAccess<>(new Failed<>(e));
        }
    }

    public <U> SafeAccess<U> map(CheckedFunction<? super T, ? extends U> mapper) {
        if (state instanceof Empty) {
            return new SafeAccess<>(new Empty<>());
        }
        if (state instanceof Failed f) {
            return new SafeAccess<>(new Failed<>(f.exception));
        }
        try {
            U result = mapper.apply(((Present<T>) state).value);
            return result == null ? new SafeAccess<>(new Empty<>())
                    : new SafeAccess<>(new Present<>(result));
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            return new SafeAccess<>(new Failed<>(e));
        }
    }

    // terminal: get
    public T get() {
        return switch (state) {
            case Present<T> p -> p.value;
            case Empty<T> e -> null;
            case Failed<T> f -> sneakyThrow(f.exception);
        };
    }

    // terminal: orElse
    public T orElse(T other) {
        return switch (state) {
            case Present<T> p -> p.value;
            case Empty<T> e -> other;
            case Failed<T> f -> sneakyThrow(f.exception);
        };
    }

    public T orElseGet(Supplier<? extends T> supplier) {
        return switch (state) {
            case Present<T> p -> p.value;
            case Empty<T> e -> supplier.get();
            case Failed<T> f -> sneakyThrow(f.exception);
        };
    }

    // isPresent (optional)
    public boolean isPresent() {
        return state instanceof Present;
    }

    // sneakyThrow helper
    @SuppressWarnings("unchecked")
    private static <E extends Throwable, R> R sneakyThrow(Throwable e) throws E {
        throw (E) e;
    }
}
