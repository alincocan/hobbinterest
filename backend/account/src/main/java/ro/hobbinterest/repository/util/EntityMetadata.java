package ro.hobbinterest.repository.util;

public interface EntityMetadata<T> {
    Class<T> getJavaType();
}
