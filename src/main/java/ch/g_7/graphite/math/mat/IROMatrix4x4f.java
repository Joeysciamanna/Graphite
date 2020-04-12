package ch.g_7.graphite.math.mat;

import ch.g_7.graphite.math.vec.IROVector3f;
import ch.g_7.graphite.math.vec.IVector3f;

public interface IROMatrix4x4f {

    IMatrix4x4f add(IROMatrix4x4f mat, IMatrix4x4f des);
    IMatrix4x4f sub(IROMatrix4x4f mat, IMatrix4x4f des);

    IMatrix4x4f mul(IROMatrix4x4f mat, IMatrix4x4f des);
    IVector3f mul(IROVector3f vec, IVector3f des);

    IMatrix4x4f div(IROMatrix4x4f mat, IMatrix4x4f des);

    IMatrix4x4f invert(IMatrix4x4f des);

    IMatrix4x4f translate(IROVector3f vec, IMatrix4x4f des);
    IMatrix4x4f translateX(float x, IMatrix4x4f des);
    IMatrix4x4f translateY(float y, IMatrix4x4f des);
    IMatrix4x4f translateZ(float z, IMatrix4x4f des);

    IMatrix4x4f rotate(IROVector3f vec, IMatrix4x4f des);
    IMatrix4x4f rotateX(float x, IMatrix4x4f des);
    IMatrix4x4f rotateY(float y, IMatrix4x4f des);
    IMatrix4x4f rotateZ(float z, IMatrix4x4f des);

    IMatrix4x4f scale(IROVector3f vec, IMatrix4x4f des);
    IMatrix4x4f scaleX(float x, IMatrix4x4f des);
    IMatrix4x4f scaleY(float y, IMatrix4x4f des);
    IMatrix4x4f scaleZ(float z, IMatrix4x4f des);


    IMatrix4x4f setTranslation(IROVector3f vec, IMatrix4x4f des);
    IMatrix4x4f setTranslationX(float x, IMatrix4x4f des);
    IMatrix4x4f setTranslationY(float y, IMatrix4x4f des);
    IMatrix4x4f setTranslationZ(float z, IMatrix4x4f des);

    IMatrix4x4f setRotation(IROVector3f vec, IMatrix4x4f des);
    IMatrix4x4f setRotationX(float x, IMatrix4x4f des);
    IMatrix4x4f setRotationY(float y, IMatrix4x4f des);
    IMatrix4x4f setRotationZ(float z, IMatrix4x4f des);

    IMatrix4x4f setScale(IROVector3f vec, IMatrix4x4f des);
    IMatrix4x4f setScaleX(float x, IMatrix4x4f des);
    IMatrix4x4f setScaleY(float y, IMatrix4x4f des);
    IMatrix4x4f setScaleZ(float z, IMatrix4x4f des);


    IMatrix4x4f identity(IMatrix4x4f des);


    IVector3f getTranslation();
    IVector3f getRotation();
    IVector3f getScale();

    float get1x1();
    float get1x2();
    float get1x3();
    float get1x4();
    float get2x1();
    float get2x2();
    float get2x3();
    float get2x4();
    float get3x1();
    float get3x2();
    float get3x3();
    float get3x4();
    float get4x1();
    float get4x2();
    float get4x3();
    float get4x4();

}
