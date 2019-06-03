#include <jni.h>
#include <string>


extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_androidndk_1passing_1complex_1data_NativeLibrary_stringFromJNI(JNIEnv *env,
                                                                                jobject instance) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}extern "C"
JNIEXPORT jint JNICALL
Java_com_example_androidndk_1passing_1complex_1data_NativeLibrary_passingDataToJni(JNIEnv *env,
                                                                                   jobject instance,
                                                                                   jdoubleArray tmpArray_,
                                                                                   jint tmpInt,
                                                                                   jfloat tmpFloat) {
    jdouble *tmpArray = env->GetDoubleArrayElements(tmpArray_, NULL);
    int ret = 0;

    if (tmpArray[0] == 1 && tmpArray[1] == 2 && tmpArray[2] == 3 && tmpInt ==1) {
        // Correct Data got from JAVA
        ret = 0;
    } else {
        // Wrong Data got from JAVA
        ret = -1;
    }

    env->ReleaseDoubleArrayElements(tmpArray_, tmpArray, 0);
    return ret;
}extern "C"
JNIEXPORT jint JNICALL
Java_com_example_androidndk_1passing_1complex_1data_NativeLibrary_passObjectToJNI(JNIEnv *env,
                                                                                  jobject instance,
                                                                                  jobject sampleDataObj) {

    jclass sampleObjModel = env->GetObjectClass(sampleObjModel);
    jfieldID sampleIntField;
    int data =  env->GetIntField(sampleObjModel,sampleIntField);
    jclass fooModel = (*env)->GetObjectClass(env, sampleDataObj);
    jfieldID fooFloat = (*env)->GetFieldID(env, fooModel, "fooFloat", "D");
    jfieldID fooLong = (*env)->GetFieldID(env, fooModel, "fooLong", "J");
    jfieldID fooInt = (*env)->GetFieldID(env, fooModel, "fooInt", "I");
    jfieldID fooString = (*env)->GetFieldID(env, fooModel, "fooString", "Ljava/lang/String;");

    (*env)->SetFloatField(env, fooModel_ , fooFloat, 1.1f);
    (*env)->SetLongField(env, fooModel_ , fooLong, 1);
    (*env)->SetIntField(env, fooModel_ , fooInt, 1);
    (*env)->SetObjectField(env, fooModel_ , fooString, (*env)->NewStringUTF(env, "foo"));

}