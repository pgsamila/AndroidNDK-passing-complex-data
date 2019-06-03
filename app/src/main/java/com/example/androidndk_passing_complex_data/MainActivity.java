package com.example.androidndk_passing_complex_data;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    /**
     * Native Library Object
     */
    private NativeLibrary nativeLib = new NativeLibrary();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
     * @param view
     */
    public void onPassObjectToJNI(View view) {
        SampleDataObj sampleDataObj = new SampleDataObj();
        sampleDataObj.setSampleInt(1);
        sampleDataObj.setSampleBoolean(true);
        sampleDataObj.setSampleString("Failed");
        int ret = nativeLib.passObjectToJNI(sampleDataObj);
    }
}
