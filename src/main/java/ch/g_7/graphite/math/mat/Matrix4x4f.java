package ch.g_7.graphite.math.mat;

import ch.g_7.graphite.math.vec.IROVector3f;
import ch.g_7.graphite.math.vec.IVector3f;

public class Matrix4x4f implements IMatrix4x4f {

    public float _1x1, _1x2, _1x3, _1x4,
                 _2x1, _2x2, _2x3, _2x4,
                 _3x1, _3x2, _3x3, _3x4,
                 _4x1, _4x2, _4x3, _4x4;


    @Override
    public Matrix4x4f add(IROMatrix4x4f mat) {
        add(mat, this);
        return this;
    }

    @Override
    public IMatrix4x4f add(IROMatrix4x4f mat, IMatrix4x4f des) {
        //TODO
        return des;
    }

    @Override
    public Matrix4x4f sub(IROMatrix4x4f mat) {
        sub(mat, this);
        return this;
    }

    @Override
    public IMatrix4x4f sub(IROMatrix4x4f mat, IMatrix4x4f des) {
        //TODO
        return des;
    }


    @Override
    public Matrix4x4f mul(IROMatrix4x4f mat) {
        mul(mat, this);
        return this;
    }

    @Override
    public IMatrix4x4f mul(IROMatrix4x4f mat, IMatrix4x4f des) {
        //TODO
        return des;
    }

    @Override
    public Matrix4x4f mul(IROVector3f vec) {
        mul(vec, this);
        return this;
    }

    @Override
    public IMatrix4x4f mul(IROVector3f vec, IMatrix4x4f des) {
        //TODO
        return des;
    }


    @Override
    public Matrix4x4f div(IROMatrix4x4f mat) {
        div(mat, this);
        return this;
    }

    @Override
    public IMatrix4x4f div(IROMatrix4x4f mat, IMatrix4x4f des) {
        //TODO
        return des;
    }

    @Override
    public Matrix4x4f div(IROVector3f vec) {
        div(vec, this);
        return this;
    }

    @Override
    public IMatrix4x4f div(IROVector3f vec, IMatrix4x4f des) {
        //TODO
        return des;
    }


    @Override
    public Matrix4x4f translate(IROVector3f vec) {
        translate(vec, this);
        return this;
    }

    @Override
    public IMatrix4x4f translate(IROVector3f vec, IMatrix4x4f des) {
        //TODO
        return des;
    }

    @Override
    public Matrix4x4f translateX(float x) {
        translateX(x, this);
        return this;
    }

    @Override
    public IMatrix4x4f translateX(float x, IMatrix4x4f des) {
        //TODO
        return des;
    }

    @Override
    public Matrix4x4f translateY(float y) {
        translateY(y, this);
        return this;
    }

    @Override
    public IMatrix4x4f translateY(float y, IMatrix4x4f des) {
        //TODO
        return des;
    }

    @Override
    public Matrix4x4f translateZ(float z) {
        translateZ(z, this);
        return this;
    }

    @Override
    public IMatrix4x4f translateZ(float z, IMatrix4x4f des) {
        //TODO
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
