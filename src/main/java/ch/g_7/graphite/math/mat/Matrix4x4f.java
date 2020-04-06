package ch.g_7.graphite.math.mat;

import ch.g_7.graphite.math.vec.IROVector3f;
import ch.g_7.graphite.math.vec.IVector3f;
import ch.g_7.graphite.math.vec.Vector3f;
import org.joml.Matrix4f;

public class Matrix4x4f implements IMatrix4x4f {

    private static final int AFFINE      = 1<<0;
    private static final int IDENTITY    = 1<<1;
    private static final int ORTHONORMAL = 1<<2;
    private static final int PERSPECTIVE = 1<<3;
    private static final int TRANSLATION = 1<<4;


    private int properties;

    public float _1x1, _1x2, _1x3, _1x4,
                 _2x1, _2x2, _2x3, _2x4,
                 _3x1, _3x2, _3x3, _3x4,
                 _4x1, _4x2, _4x3, _4x4;

    private void determineProperties() {
        int properties = 0;
        if (_1x4 == 0.0f && _2x4 == 0.0f) {
            if (_3x4 == 0.0f && _4x4 == 1.0f) {
                properties |= AFFINE;
                if (_1x1 == 1.0f && _1x2 == 0.0f && _1x3 == 0.0f && _2x1 == 0.0f && _2x2 == 1.0f && _2x3 == 0.0f
                        && _3x1 == 0.0f && _3x2 == 0.0f && _3x3 == 1.0f) {
                    properties |= TRANSLATION | ORTHONORMAL;
                    if (_4x1 == 0.0f && _4x2 == 0.0f && _4x3 == 0.0f)
                        properties |= IDENTITY;
                }
            } else if (_1x2 == 0.0f && _1x3 == 0.0f && _2x1 == 0.0f && _2x3 == 0.0f && _3x1 == 0.0f && _3x2 == 0.0f
                    && _4x1 == 0.0f && _4x2 == 0.0f && _4x4 == 0.0f) {
                properties |= PERSPECTIVE;
            }
        }
        this.properties = properties;
    }


    @Override
    public Matrix4x4f add(IROMatrix4x4f mat) {
        add(mat, this);
        return this;
    }

    @Override
    public IMatrix4x4f add(IROMatrix4x4f mat, IMatrix4x4f des) {
        des.set1x1(_1x1 + mat.get1x1());
        des.set1x2(_1x2 + mat.get1x2());
        des.set1x3(_1x3 + mat.get1x3());
        des.set1x4(_1x4 + mat.get1x4());

        des.set2x1(_2x1 + mat.get2x1());
        des.set2x2(_2x2 + mat.get2x2());
        des.set2x3(_2x3 + mat.get2x3());
        des.set2x4(_2x4 + mat.get2x4());

        des.set3x1(_3x1 + mat.get3x1());
        des.set3x2(_3x2 + mat.get3x2());
        des.set3x3(_3x3 + mat.get3x3());
        des.set3x4(_3x4 + mat.get3x4());

        des.set4x1(_4x1 + mat.get4x1());
        des.set4x2(_4x2 + mat.get4x2());
        des.set4x3(_4x3 + mat.get4x3());
        des.set4x4(_4x4 + mat.get4x4());
        return des;
    }

    @Override
    public Matrix4x4f sub(IROMatrix4x4f mat) {
        sub(mat, this);
        return this;
    }

    @Override
    public IMatrix4x4f sub(IROMatrix4x4f mat, IMatrix4x4f des) {
        des.set1x1(_1x1 - mat.get1x1());
        des.set1x2(_1x2 - mat.get1x2());
        des.set1x3(_1x3 - mat.get1x3());
        des.set1x4(_1x4 - mat.get1x4());

        des.set2x1(_2x1 - mat.get2x1());
        des.set2x2(_2x2 - mat.get2x2());
        des.set2x3(_2x3 - mat.get2x3());
        des.set2x4(_2x4 - mat.get2x4());

        des.set3x1(_3x1 - mat.get3x1());
        des.set3x2(_3x2 - mat.get3x2());
        des.set3x3(_3x3 - mat.get3x3());
        des.set3x4(_3x4 - mat.get3x4());

        des.set4x1(_4x1 - mat.get4x1());
        des.set4x2(_4x2 - mat.get4x2());
        des.set4x3(_4x3 - mat.get4x3());
        des.set4x4(_4x4 - mat.get4x4());
        return des;
    }


    @Override
    public Matrix4x4f mul(IROMatrix4x4f mat) {
        mul(mat, this);
        return this;
    }

    @Override
    public IMatrix4x4f mul(IROMatrix4x4f mat, IMatrix4x4f des) {
        float m1x1 = mat.get1x1();
        float m1x2 = mat.get1x2();
        float m1x3 = mat.get1x3();
        float m1x4 = mat.get1x4();

        float m2x1 = mat.get2x1();
        float m2x2 = mat.get2x2();
        float m2x3 = mat.get2x3();
        float m2x4 = mat.get2x4();

        float m3x1 = mat.get3x1();
        float m3x2 = mat.get3x2();
        float m3x3 = mat.get3x3();
        float m3x4 = mat.get3x4();

        float m4x1 = mat.get4x1();
        float m4x2 = mat.get4x2();
        float m4x3 = mat.get4x3();
        float m4x4 = mat.get4x4();

        float new1x1 = _1x1 * m1x1 + _1x2 * m2x1 + _1x3 * m3x1 + _1x4 * m4x1;
        float new1x2 = _1x1 * m1x2 + _1x2 * m2x2 + _1x3 * m3x2 + _1x4 * m4x2;
        float new1x3 = _1x1 * m1x3 + _1x2 * m2x3 + _1x3 * m3x3 + _1x4 * m4x3;
        float new1x4 = _1x1 * m1x4 + _1x2 * m2x4 + _1x3 * m3x4 + _1x4 * m4x4;

        float new2x1 = _2x1 * m1x1 + _2x2 * m2x1 + _2x3 * m3x1 + _2x4 * m4x1;
        float new2x2 = _2x1 * m1x2 + _2x2 * m2x2 + _2x3 * m3x2 + _2x4 * m4x2;
        float new2x3 = _2x1 * m1x3 + _2x2 * m2x3 + _2x3 * m3x3 + _2x4 * m4x3;
        float new2x4 = _2x1 * m1x4 + _2x2 * m2x4 + _2x3 * m3x4 + _2x4 * m4x4;

        float new3x1 = _3x1 * m1x1 + _3x2 * m2x1 + _3x3 * m3x1 + _3x4 * m4x1;
        float new3x2 = _3x1 * m1x2 + _3x2 * m2x2 + _3x3 * m3x2 + _3x4 * m4x2;
        float new3x3 = _3x1 * m1x3 + _3x2 * m2x3 + _3x3 * m3x3 + _3x4 * m4x3;
        float new3x4 = _3x1 * m1x4 + _3x2 * m2x4 + _3x3 * m3x4 + _3x4 * m4x4;

        float new4x1 = _4x1 * m1x1 + _4x2 * m2x1 + _4x3 * m3x1 + _4x4 * m4x1;
        float new4x2 = _4x1 * m1x2 + _4x2 * m2x2 + _4x3 * m3x2 + _4x4 * m4x2;
        float new4x3 = _4x1 * m1x3 + _4x2 * m2x3 + _4x3 * m3x3 + _4x4 * m4x3;
        float new4x4 = _4x1 * m1x4 + _4x2 * m2x4 + _4x3 * m3x4 + _4x4 * m4x4;

        des.set1x1(new1x1);
        des.set1x2(new1x2);
        des.set1x3(new1x3);
        des.set1x4(new1x4);

        des.set2x1(new2x1);
        des.set2x2(new2x2);
        des.set2x3(new2x3);
        des.set2x4(new2x4);

        des.set3x1(new3x1);
        des.set3x2(new3x2);
        des.set3x3(new3x3);
        des.set3x4(new3x4);

        des.set4x1(new4x1);
        des.set4x2(new4x2);
        des.set4x3(new4x3);
        des.set4x4(new4x4);
        return des;
    }

    @Override
    public Vector3f mul(IROVector3f vec) {
        return (Vector3f) mul(vec, new Vector3f());
    }

    @Override
    public IVector3f mul(IROVector3f vec, IVector3f des) {
        float x = vec.getX();
        float y = vec.getY();
        float z = vec.getZ();
        float newX = _1x1 * x + _1x2 * y + _1x3 * z + _1x4;
        float newY = _2x1 * x + _2x2 * y + _2x3 * z + _2x4;
        float newZ = _3x1 * x + _3x2 * y + _3x3 * z + _3x4;
        des.set(newX, newY, newZ);
        return des;
    }


    @Override
    public Matrix4x4f div(IROMatrix4x4f mat) {
        div(mat, this);
        return this;
    }

    @Override
    public IMatrix4x4f div(IROMatrix4x4f mat, IMatrix4x4f des) {
        return mul(mat.invert(new Matrix4x4f()), des);
    }

    @Override
    public Matrix4x4f invert() {
        invert(this);
        return this;
    }

    @Override
    public IMatrix4x4f invert(IMatrix4x4f des) {
        //TODO
        Matrix4f f;
        throw new RuntimeException("Sorry, but this method is not yet implemented");
    }

    @Override
    public Matrix4x4f translate(IROVector3f vec) {
        translate(vec, this);
        return this;
    }

    @Override
    public IMatrix4x4f translate(IROVector3f vec, IMatrix4x4f des) {
        des.set1x4(_1x4 + vec.getX());
        des.set2x4(_2x4 + vec.getY());
        des.set3x4(_3x4 + vec.getZ());
        des.set4x4(1);
        return des;
    }

    @Override
    public Matrix4x4f translateX(float x) {
        translateX(x, this);
        return this;
    }

    @Override
    public IMatrix4x4f translateX(float x, IMatrix4x4f des) {
        des.set1x4(_1x4 + x);
        return des;
    }

    @Override
    public Matrix4x4f translateY(float y) {
        translateY(y, this);
        return this;
    }

    @Override
    public IMatrix4x4f translateY(float y, IMatrix4x4f des) {
        des.set2x4(_2x4 + y);
        return des;
    }

    @Override
    public Matrix4x4f translateZ(float z) {
        translateZ(z, this);
        return this;
    }

    @Override
    public IMatrix4x4f translateZ(float z, IMatrix4x4f des) {
        des.set3x4(_3x4 + z);
        return des;
    }


    @Override
    public Matrix4x4f rotate(IROVector3f vec) {
        rotate(vec, this);
        return this;
    }

    @Override
    public IMatrix4x4f rotate(IROVector3f vec, IMatrix4x4f des) {
        //TODO
        return des;

    }

    @Override
    public Matrix4x4f rotateX(float x) {
        rotateX(x, this);
        return this;
    }

    @Override
    public IMatrix4x4f rotateX(float x, IMatrix4x4f des) {
        //TODO
        return des;
    }

    @Override
    public Matrix4x4f rotateY(float y) {
        rotateY(y, this);
        return this;
    }

    @Override
    public IMatrix4x4f rotateY(float y, IMatrix4x4f des) {
        //TODO
        return des;
    }

    @Override
    public Matrix4x4f rotateZ(float z) {
        rotateZ(z, this);
        return this;
    }

    @Override
    public IMatrix4x4f rotateZ(float z, IMatrix4x4f des) {
        //TODO
        return des;
    }


    @Override
    public Matrix4x4f scale(IROVector3f vec) {
        scale(vec, this);
        return this;
    }

    @Override
    public IMatrix4x4f scale(IROVector3f vec, IMatrix4x4f des) {
        //TODO
        return des;
    }

    @Override
    public Matrix4x4f scaleX(float x) {
        scaleX(x, this);
        return this;
    }

    @Override
    public IMatrix4x4f scaleX(float x, IMatrix4x4f des) {
        //TODO
        return des;
    }

    @Override
    public Matrix4x4f scaleY(float y) {
        scaleY(y, this);
        return this;
    }

    @Override
    public IMatrix4x4f scaleY(float y, IMatrix4x4f des) {
        //TODO
        return des;
    }

    @Override
    public Matrix4x4f scaleZ(float z) {
        scaleZ(z, this);
        return this;
    }

    @Override
    public IMatrix4x4f scaleZ(float z, IMatrix4x4f des) {
        //TODO
        return des;
    }


    @Override
    public Matrix4x4f setTranslation(IROVector3f vec) {
        setTranslation(vec, this);
        return this;
    }

    @Override
    public IMatrix4x4f setTranslation(IROVector3f vec, IMatrix4x4f des) {
        //TODO
        return des;
    }

    @Override
    public Matrix4x4f setTranslationX(float x) {
        setTranslationX(x, this);
        return this;
    }

    @Override
    public IMatrix4x4f setTranslationX(float x, IMatrix4x4f des) {
        //TODO
        return des;
    }

    @Override
    public Matrix4x4f setTranslationY(float y) {
        setTranslationY(y, this);
        return this;
    }

    @Override
    public IMatrix4x4f setTranslationY(float y, IMatrix4x4f des) {
        //TODO
        return des;
    }

    @Override
    public Matrix4x4f setTranslationZ(float z) {
        setTranslationZ(z, this);
        return this;
    }

    @Override
    public IMatrix4x4f setTranslationZ(float z, IMatrix4x4f des) {
        //TODO
        return des;
    }


    @Override
    public Matrix4x4f setRotation(IROVector3f vec) {
        setRotation(vec, this);
        return this;
    }

    @Override
    public IMatrix4x4f setRotation(IROVector3f vec, IMatrix4x4f des) {
        //TODO
        return des;
    }

    @Override
    public Matrix4x4f setRotationX(float x) {
        setRotationX(x, this);
        return this;
    }

    @Override
    public IMatrix4x4f setRotationX(float x, IMatrix4x4f des) {
        //TODO
        return des;
    }

    @Override
    public Matrix4x4f setRotationY(float y) {
        setRotationY(y, this);
        return this;
    }

    @Override
    public IMatrix4x4f setRotationY(float y, IMatrix4x4f des) {
        //TODO
        return des;
    }

    @Override
    public Matrix4x4f setRotationZ(float z) {
        setRotationZ(z, this);
        return this;
    }

    @Override
    public IMatrix4x4f setRotationZ(float z, IMatrix4x4f des) {
        //TODO
        return des;
    }


    @Override
    public Matrix4x4f setScale(IROVector3f vec) {
        setScale(vec, this);
        return this;
    }

    @Override
    public IMatrix4x4f setScale(IROVector3f vec, IMatrix4x4f des) {
        //TODO
        return des;
    }

    @Override
    public Matrix4x4f setScaleX(float x) {
        setScaleX(x, this);
        return this;
    }

    @Override
    public IMatrix4x4f setScaleX(float x, IMatrix4x4f des) {
        //TODO
        return des;
    }

    @Override
    public Matrix4x4f setScaleY(float y) {
        setScaleY(y, this);
        return this;
    }

    @Override
    public IMatrix4x4f setScaleY(float y, IMatrix4x4f des) {
        //TODO
        return des;
    }

    @Override
    public Matrix4x4f setScaleZ(float z) {
        setScaleZ(z, this);
        return this;
    }

    @Override
    public IMatrix4x4f setScaleZ(float z, IMatrix4x4f des) {
        //TODO
        return des;
    }

    @Override
    public Matrix4x4f identity() {
        identity(this);
        return this;
    }

    @Override
    public IMatrix4x4f identity(IMatrix4x4f des) {
        //TODO
        return des;
    }

    @Override
    public IVector3f getTranslation() {
        //TODO
        return null;
    }

    @Override
    public IVector3f getRotation() {
        //TODO
        return null;
    }

    @Override
    public IVector3f getScale() {
        //TODO
        return null;
    }

    @Override
    public IMatrix4x4f set1x1(float v) {
        _1x1 = v;
        return this;
    }

    @Override
    public IMatrix4x4f set1x2(float v) {
        _1x2 = v;
        return this;
    }

    @Override
    public IMatrix4x4f set1x3(float v) {
        _1x3 = v;
        return this;
    }

    @Override
    public IMatrix4x4f set1x4(float v) {
        _1x4 = v;
        return this;
    }

    @Override
    public IMatrix4x4f set2x1(float v) {
        return this;
    }

    @Override
    public IMatrix4x4f set2x2(float v) {
        return this;
    }

    @Override
    public IMatrix4x4f set2x3(float v) {
        return this;
    }

    @Override
    public IMatrix4x4f set2x4(float v) {
        return this;
    }

    @Override
    public IMatrix4x4f set3x1(float v) {
        return this;
    }

    @Override
    public IMatrix4x4f set3x2(float v) {
        return this;
    }

    @Override
    public IMatrix4x4f set3x3(float v) {
        return this;
    }

    @Override
    public IMatrix4x4f set3x4(float v) {
        return this;
    }

    @Override
    public IMatrix4x4f set4x1(float v) {
        return this;
    }

    @Override
    public IMatrix4x4f set4x2(float v) {
        return this;
    }

    @Override
    public IMatrix4x4f set4x3(float v) {
        return this;
    }

    @Override
    public IMatrix4x4f set4x4(float v) {
        return this;
    }

    @Override
    public float get1x1() {
        return _1x1;
    }

    @Override
    public float get1x2() {
        return _1x2;
    }

    @Override
    public float get1x3() {
        return _1x3;
    }

    @Override
    public float get1x4() {
        return _1x4;
    }

    @Override
    public float get2x1() {
        return _2x1;
    }

    @Override
    public float get2x2() {
        return _2x2;
    }

    @Override
    public float get2x3() {
        return _2x3;
    }

    @Override
    public float get2x4() {
        return _2x4;
    }

    @Override
    public float get3x1() {
        return _3x1;
    }

    @Override
    public float get3x2() {
        return _3x2;
    }

    @Override
    public float get3x3() {
        return _3x3;
    }

    @Override
    public float get3x4() {
        return _3x4;
    }

    @Override
    public float get4x1() {
        return _4x1;
    }

    @Override
    public float get4x2() {
        return _4x2;
    }

    @Override
    public float get4x3() {
        return _4x3;
    }

    @Override
    public float get4x4() {
        return _4x4;
    }
}
