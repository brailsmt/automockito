package org.brailsmt.generator.internal;

import java.util.Random;

/**
 * Internal utilities for use by Generators.
 *
 * @author Michael Brailsford (mb013619)
 */
public class Generators {
    private Generators() {}

    final static long classLoadTimestamp = System.currentTimeMillis();
    final static Random RNG = new Random(classLoadTimestamp);

    /**
     * Very thin wrapper around java.util.Random.
     *
     * @return {@link Random} with the seed set to System.currentTimeMillis() when the class was loaded.
     */
    public static Random rng() {
        return RNG;
    }

    /**
     * Very thin wrapper around java.util.Random.
     *
     * @return {@link Random} with the specified seed.
     */
    public static Random rng(long seed) {
        return new Random(seed);
    }

    /**
     * Returns an java.util.Random that will produce the same pseudo-random sequence.
     *
     * More precisely:
     *   repeatableRng().nextInt() == repeatableRng.nextInt() will always be true
     *
     * @return return a random number generator that will generate the same pseudo-random sequence
     */
    public static Random repeatableRng() {
        return new Random(classLoadTimestamp);
    }
}
