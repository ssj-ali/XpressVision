package com.ssjali.xpressvision;

public interface Classifier {
    String name();
    Classification recognize(final float[] pixels);
}
