package lk.uom.cse.msc.rle.model;

public class AttributeValue<T extends Comparable<T>> {

    T value;

    public AttributeValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Class<T> getType() {

        if (this.value != null) {
            return (Class<T>) value.getClass();
        } else {
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttributeValue<?> that = (AttributeValue<?>) o;

        return value != null ? value.equals(that.value) : that.value == null;

    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "AttributeValue{" + "value=" + value + '}';
    }
}
