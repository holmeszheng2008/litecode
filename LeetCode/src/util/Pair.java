package util;

import java.util.Objects;

public class Pair<T1, T2> {
    private T1 key;

    private T2 value;

    public T1 getKey() {
        return key;
    }

    public T2 getValue() {
        return value;
    }
    public Pair(T1 first, T2 second){
        this.key = first;
        this.value = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return key.equals(pair.key) && value.equals(pair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
