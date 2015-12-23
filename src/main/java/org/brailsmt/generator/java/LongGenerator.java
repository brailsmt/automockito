package org.brailsmt.generator.java;

import static org.brailsmt.generator.internal.Generators.rng;

import org.brailsmt.generator.Generator;

/**
 * @author Michael Brailsford (mb013619)
 */
public class LongGenerator implements Generator<Long> {
    public Long gen() {
        return rng().nextLong();
    }

    public long longVal() {
        return gen().longValue();
    }
}
