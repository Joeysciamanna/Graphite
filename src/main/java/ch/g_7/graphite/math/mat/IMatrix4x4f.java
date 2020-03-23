package ch.g_7.graphite.math.mat;

import ch.g_7.graphite.math.vec.IROVector3f;
import ch.g_7.graphite.math.vec.IVector3f;

public interface IMatrix4x4f extends IROMatrix4x4f {

    IMatrix4x4f add(IROMatrix4x4f mat);
    IMatrix4x4f sub(IROMatrix4x4f mat);

    IMatrix4x4f mul(IROMatrix4x4f mat);
    IMatrix4x4f mul(IROVector3f vec);

    IMatrix4x4f div(IROMatrix4x4f mat);
    IMatrix4x4f div(IROVector3f vec);


    IMatrix4x4f translate(IROVector3f vec);
    IMatrix4x4f translateX(float x);
    IMatrix4x4f translateY(float y);
    IMatrix4x4f translateZ(float z);

    IMatrix4x4f rotate(IROVector3f vec);
    IMatrix4x4f rotateX(float x);
    IMatrix4x4f rotateY(float y);
    IMatrix4x4f rotateZ(float z);

    IMatrix4x4f scale(IROVector3f vec);
    IMatrix4x4f scaleX(float x);
    IMatrix4x4f scaleY(float y);
    IMatrix4x4f scaleZ(float z);


    IMatrix4x4f setTranslation(IROVector3f vec);
    IMatrix4x4f setTranslationX(float x);
    IMatrix4x4f setTranslationY(float y);
    IMatrix4x4f setTranslationZ(float z);

    IMatrix4x4f setRotation(IROVector3f vec);
    IMatrix4x4f setRotationX(float x);
    IMatrix4x4f setRotationY(float y);
    IMatrix4x4f setRotationZ(float z);

    IMatrix4x4f setScale(IROVector3f vec);
    IMatrix4x4f setScaleX(float x);
    IMatrix4x4f setScaleY(float y);
    IMatrix4x4f setScaleZ(float z);


    IMatrix4x4f identity();


    IMatrix4x4f set1x1(float v);
    IMatrix4x4f set1x2(float v);
    IMatrix4x4f set1x3(float v);
    IMatrix4x4f set1x4(float v);
    IMatrix4x4f set2x1(float v);
    IMatrix4x4f set2x2(float v);
    IMatrix4x4f set2x3(float v);
    IMatrix4x4f set2x4(float v);
    IMatrix4x4f set3x1(float v);
    IMatrix4x4f set3x2(float v);
    IMatrix4x4f set3x3(float v);
    IMatrix4x4f set3x4(float v);
    IMatrix4x4f set4x1(float v);
    IMatrix4x4f set4x2(float v);
    IMatrix4x4f set4x3(float v);
    IMatrix4x4f set4x4(float v);

}
