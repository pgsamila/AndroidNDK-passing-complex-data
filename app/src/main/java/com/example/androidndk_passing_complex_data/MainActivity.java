package com.example.androidndk_passing_complex_data;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements JNICallBackInterface {


    /**
     * Native Library Object
     */
    private NativeLibrary nativeLib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nativeLib = new NativeLibrary(this);
    }

    /**
     * On Get String From JNI Button Clicked Event
     *
     * @param view
     */
    public void onGetStringFromJNIButtonClicked(View view) {
        // Define text view to update
        TextView textView = findViewById(R.id.textViewGetStringFromJNI);

        // Get String From JNI
        String stringFromJNI = nativeLib.stringFromJNI();

        // Update Text Box
        textView.setText(stringFromJNI);
    }

    /**
     * On Pass Data To JNI Button Clicked Event
     *
     * @param view
     */
    public void onPassDataToJNIButtonClicked(View view) {
        TextView textView = findViewById(R.id.textViewPassDataToJNI);

        // Temp data which passing to JNI
        double[] tmpArray = {1, 2, 3};
        int tmpInt = 1;
        float tmpFloat = 2.3f;

        // Pass data & get error code
        int returnValue = nativeLib.passingDataToJni(tmpArray, tmpInt, tmpFloat);
        if (returnValue == 0) {
            textView.setText("Data Pass Success");
        } else {
            textView.setText("Data Pass Failed");
        }
    }

    /**
     * On Pass Object To JNI Button Clicked Event
     *
     * @param view
     */
    public void onPassObjectToJNI(View view) {
        TextView textView = findViewById(R.id.textViewPassObjectToJNI);

        //Create Sample Data Object
        SampleDataObj sampleDataObj = new SampleDataObj();
        sampleDataObj.setSampleInt(0);
        sampleDataObj.setSampleBoolean(true);
        sampleDataObj.setSampleString("Failed");

        // Pass data object to Native lib & get error code
        int ret = nativeLib.passObjectToJNI(sampleDataObj);

        if (ret == 0) {
            // if success, show updated values from JNI
            textView.setText(sampleDataObj.getSampleString());
        } else {
            //Failed
            textView.setText("FAILED");
        }
    }

    /**
     * On Get Object From JNI Button Clicked Event
     *
     * @param view
     */
    public void onGetObjectFromJNI(View view) {
        TextView textView = findViewById(R.id.textViewGetObjectFromJNI);
        SampleDataObj dataObj = nativeLib.getObjectFromJNI();
        textView.setText(dataObj.getSampleString());
    }

    /**
     * On Call Back From JNI Button Clicked Event
     *
     * @param view
     */
    public void onCallBackFromJNIClicked(View view) {
        // Call JNI callback method
        nativeLib.callTheCallBackMethod();
    }

    /**
     * Callback event publisher
     *
     * @param data callback data
     */
    @Override
    public void callBackEvent(final String data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TextView textView = findViewById(R.id.textViewCallBackFromJNI);
                textView.setText(data);
            }
        });
    }
}
