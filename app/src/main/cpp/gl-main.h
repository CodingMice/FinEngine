//
// Created by iFinVer on 2016/11/12.
//

#ifndef MYOPENGLES_GL_NATIVE_LIB_H
#define MYOPENGLES_GL_NATIVE_LIB_H

#include "gl-include-header.h"
#include "gl-utils.h"

extern "C" {
JNIEXPORT jlong JNICALL Java_com_ifinver_myopengles_GLNative_createGLContext(JNIEnv *env, jclass type,jobject jSurface);
JNIEXPORT void JNICALL Java_com_ifinver_myopengles_GLNative_releaseGLContext(JNIEnv *env, jclass type, jlong nativeContext);
JNIEXPORT void JNICALL Java_com_ifinver_myopengles_GLNative_renderOnContext(JNIEnv *env, jclass type, jlong nativeGlContext, jbyteArray data_, jint frameWidth,
}

GL_Context_Holder *newGLContext(JNIEnv *env, jobject jSurface);

void releaseGLContext(GL_Context_Holder *pHolder);

void renderFrame(GL_Context_Holder *holder, jbyte *data, jint width, jint height);

#endif //MYOPENGLES_GL_NATIVE_LIB_H


