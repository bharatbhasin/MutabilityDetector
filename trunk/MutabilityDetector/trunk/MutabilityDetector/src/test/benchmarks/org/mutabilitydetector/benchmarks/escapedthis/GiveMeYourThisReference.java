/*
 * Mutability Detector
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.
 * 
 * Further licensing information for this project can be found in
 * license/LICENSE.txt
 */

package org.mutabilitydetector.benchmarks.escapedthis;

import java.util.HashSet;

public class GiveMeYourThisReference {

    private String obtainedStringField;

    /**
     * In a multithreaded environment, with a lack of synchronisation, if a 'this' reference is passed within a
     * constructor, the reference could point to an object in an incomplete state. Thus
     * {@link #GiveMeYourThisReference(Object)} could see the object changing, thus the object would not be immutable.
     */
    public GiveMeYourThisReference(Object yourThisReference) {
        obtainedStringField = yourThisReference.toString();
    }

    public String stringField() {
        return obtainedStringField;
    }

    public void passReference(Object thisReference) {
    }

    /**
     * Publishing your this reference to a static object is an unsafe publication.
     */
    public static Object YOUR_THIS_REFERENCE;

    public static final HashSet<Object> THIS_REFERENCE_MAP = new HashSet<Object>();

    public static void staticMethod(Object passThisReferenceToStaticMethod) {
    }

}