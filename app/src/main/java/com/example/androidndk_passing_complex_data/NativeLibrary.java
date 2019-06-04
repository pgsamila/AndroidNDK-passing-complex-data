package com.example.androidndk_passing_complex_data;

class NativeLibrary {

    JNICallBackInterface callBackInterface;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    public NativeLibrary(JNICallBackInterface callBackInterface) {
        this.callBackInterface = callBackInterface;
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public native int passingDataToJni(double[] tmpArray, int tmpInt, float tmpFloat);

    public native int passObjectToJNI(SampleDataObj sampleDataObj);

    public native SampleDataObj getObjectFromJNI();

    public native void callTheCallBackMethod();

    private void callBack(int data, String stringValue) {
        callBackInterface.callBackEvent(stringValue + String.valueOf(data));
    }
}
