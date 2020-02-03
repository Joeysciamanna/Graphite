package ch.g_7.graphite.math.vec;

public class Vector3i implements IVector3i {

    protected int x, y, z;

    public Vector3i() {}

    public Vector3i(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Vector3i add(IVector3i vec) {
        return add(vec.getX(), vec.getY(), vec.getZ(), this);
    }

    @Override
    public Vector3i add(int x, int y, int z) {
        return add(x, y, z, this);
    }

    @Override
    public Vector3i add(IVector3i vec, Vector3i des) {
        return add(vec.getX(), vec.getY(), vec.getZ(), des);
    }

    @Override
    public Vector3i add(int x, int y, int z, Vector3i des) {
        des.x = this.x + x;
        des.y = this.y + y;
        des.z = this.z + z;
        return des;
    }

    @Override
    public Vector3i sub(IVector3i vec) {
        return sub(vec.getX(), vec.getY(), vec.getZ(), this);
    }

    @Override
    public Vector3i sub(int x, int y, int z) {
        return sub(x, y, z, this);
    }

    @Override
    public Vector3i sub(IVector3i vec, Vector3i des) {
        return sub(vec.getX(), vec.getY(), vec.getZ(), des);
    }

    @Override
    public Vector3i sub(int x, int y, int z, Vector3i des) {
        des.x = this.x - x;
        des.y = this.y - y;
        des.z = this.z - z;
        return des;
    }

    @Override
    public Vector3i mul(IVector3i vec) {
        return mul(vec.getX(), vec.getY(), vec.getZ(), this);
    }

    @Override
    public Vector3i mul(int x, int y, int z) {
        return mul(x, y, z, this);
    }

    @Override
    public Vector3i mul(IVector3i vec, Vector3i des) {
        return mul(vec.getX(), vec.getY(), vec.getZ(), des);
    }

    @Override
    public Vector3i mul(int x, int y, int z, Vector3i des) {
        des.x = this.x * x;
        des.y = this.y * y;
        des.z = this.z * z;
        return des;
    }

    @Override
    public Vector3i div(IVector3i vec) {
        return div(vec.getX(), vec.getY(), vec.getZ(), this);
    }

    @Override
    public Vector3i div(int x, int y, int z) {
        return div(x, y, z, this);
    }

    @Override
    public Vector3i div(IVector3i vec, Vector3i des) {
        return div(vec.getX(), vec.getY(), vec.getZ(), des);
    }

    @Override
    public Vector3i div(int x, int y, int z, Vector3i des) {
        des.x = this.x / x;
        des.y = this.y / y;
        des.z = this.z / z;
        return des;
    }

    @Override
    public Vector3i max(IVector3i vec) {
        return max(vec.getX(), vec.getY(), vec.getZ(), this);
    }

    @Override
    public Vector3i max(int x, int y, int z) {
        return max(x, y, z, this);
    }

    @Override
    public Vector3i max(IVector3i vec, Vector3i des) {
        return max(vec.getX(), vec.getY(), vec.getZ(), des);
    }

    @Override
    public Vector3i max(int x, int y, int z, Vector3i des) {
        des.x = x > this.x ? x : this.x;
        des.y = y > this.y ? y : this.y;
        des.z = z > this.z ? z : this.z;
        return des;
    }

    @Override
    public Vector3i min(IVector3i vec) {
        return min(vec.getX(), vec.getY(), vec.getZ(), this);
    }

    @Override
    public Vector3i min(int x, int y, int z) {
        return min(x, y, z, this);
    }

    @Override
    public Vector3i min(IVector3i vec, Vector3i des) {
        return min(vec.getX(), vec.getY(), vec.getZ(), des);
    }

    @Override
    public Vector3i min(int x, int y, int z, Vector3i des) {
        des.x = x < this.x ? x : this.x;
        des.y = y < this.y ? y : this.y;
        des.z = z < this.z ? z : this.z;
        return des;
    }

    @Override
    public float dot(IVector3i vec) {
        return dot(vec.getX(), vec.getY(), vec.getZ());
    }

    @Override
    public float dot(int x, int y, int z) {
        return this.x * x + this.y + y + this.z * z;
    }

    @Override
    public float angle(IVector3i vec) {
        return angle(vec.getX(), vec.getY(), vec.getZ());
    }

    @Override
    public float angle(int x, int y, int z) {
        float ab = this.x * x + this.y * y + this.z * z;
        float a = (float) Math.sqrt(this.x * this.x + (this.y * this.y) + (this.z * this.z));
        float b = (float) Math.sqrt(x * x + y * y + z * z);
        return (float) Math.acos(ab / a * b);
    }

    @Override
    public float distance(IVector3i vec) {
        return distance(vec.getX(), vec.getY(), vec.getZ());
    }

    @Override
    public float distance(int x, int y, int z) {
        return (float) Math.sqrt((x-this.x)*(x-this.x) +  (y-this.y)*(y-this.y) + (z-this.z)*(z-this.z));
    }

    @Override
    public int distanceX(int x) {
        return x - this.x;
    }

    @Override
    public int distanceY(int y) {
        return y - this.y;
    }

    @Override
    public int distanceZ(int z) {
        return z - this.z;
    }

    @Override
    public Vector3f transform3f() {
        return new Vector3f(x, y, z);
    }

    @Override
    public Vector2f transform2f() {
        return new Vector2f(x, y);
    }

    @Override
    public Vector2i transform2i() {
        return new Vector2i((int)x, (int)y);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getZ() {
        return z;
    }

    @Override
    public Vector3i set(IVector3i vec) {
        return set(vec.getX(), vec.getY(), vec.getZ());
    }

    @Override
    public Vector3i set(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    @Override
    public Vector3i setX(int x) {
        this.x = x;
        return this;
    }

    @Override
    public Vector3i setY(int y) {
        this.y = y;
        return this;
    }

    @Override
    public Vector3i setZ(int z) {
        this.z = z;
        return this;
    }

    @Override
    public Vector3i clone() {
        return new Vector3i(x, y, z);
    }
}
