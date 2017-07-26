#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_ndkcmake_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_ndkcmake_MainActivity_print(JNIEnv *env, jobject instance) {

    // TODO
    std::string hello = "calling print";

    return env->NewStringUTF(hello.c_str());
}


