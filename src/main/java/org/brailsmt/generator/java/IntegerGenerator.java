package org.brailsmt.generator.java;

import static org.brailsmt.generator.internal.Generators.rng;

import org.brailsmt.generator.Generator;

/**
 * Generator Integer values.
 *
 * @author Michael Brailsford (mb013619)
 */
public class IntegerGenerator implements Generator<Integer> {
    public IntegerGenerator() {}

    public Integer gen() {
        return rng().nextInt();
    }

    /**
     * Convenience wrapper for the truly lazy.
     *
     * @param intGen some generator of {@link Integer}
     *
     * @return an int primitive
     */
    public int intVal(IntegerGenerator intGen) {
        return intGen.gen().intValue();
    }
}
