package com.example.androidndk_passing_complex_data;

class SampleDataObj {

    /**
     * Int field
     */
    public int sampleInt;

    /**
     * Boolean field
     */
    public boolean sampleBoolean;

    /**
     * String field
     */
    public String sampleString;

    /**
     * Set Sample Int Value
     *
     * @param sampleInt int value
     */
    public void setSampleInt(int sampleInt) {
        this.sampleInt = sampleInt;
    }

    /**
     * Set Boolean value
     *
     * @param sampleBoolean boolean value
     */
    public void setSampleBoolean(boolean sampleBoolean) {
        this.sampleBoolean = sampleBoolean;
    }

    /**
     * Set sample String value
     *
     * @param sampleString String value
     */
    public void setSampleString(String sampleString) {
        this.sampleString = sampleString;
    }

    /**
     * Get Sample int value
     *
     * @return int value
     */
    public int getSampleInt() {
        return sampleInt;
    }

    /**
     * Check boolean value
     *
     * @return boolean value
     */
    public boolean isSampleBoolean() {
        return sampleBoolean;
    }

    /**
     * Get sample String value
     *
     * @return string value
     */
    public String getSampleString() {
        return sampleString;
    }
}
