package org.brailsmt.generator;

/**
 * Defines the interface for all Generator function objects.
 * @param <T> The type to be generated
 */
public interface Generator<T> {
    /**
     * Create and return an object instance of type T.
     *
     * @return a fully constructed object of type T
     */
    public T gen();
}