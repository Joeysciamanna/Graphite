package ch.g_7.graphite.math.vec3;

import ch.g_7.graphite.math.vec2.Vector2f;
import ch.g_7.graphite.math.vec2.Vector2i;

public class Vector3i implements IVector3i {

    protected int x, y, z;

    public Vector3i() {}

    public Vector3i(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Vector3i add(int i) {
    	add(i, i, i, this);
    	return this;
    }
    
    @Override
    public Vector3i add(IROVector3i vec) {
        add(vec.getX(), vec.getY(), vec.getZ(), this);
        return this;
    }

    @Override
    public Vector3i add(int x, int y, int z) {
        add(x, y, z, this);
        return this;
    }

    @Override
    public IVector3i add(int i, IVector3i des) {
    	return add(i, i, i, this);
    }
    
    @Override
    public IVector3i add(IROVector3i vec, IVector3i des) {
        return add(vec.getX(), vec.getY(), vec.getZ(), des);
    }

    @Override
    public IVector3i add(int x, int y, int z, IVector3i des) {
        des.setX(this.x + x);
        des.setY(this.y + y);
        des.setZ(this.z + z);
        return des;
    }

    
    @Override
    public Vector3i sub(int i) {
    	sub(i, i, i, this);
    	return this;
    }
    
    @Override
    public Vector3i sub(IROVector3i vec) {
        sub(vec.getX(), vec.getY(), vec.getZ(), this);
        return this;
    }

    @Override
    public Vector3i sub(int x, int y, int z) {
        sub(x, y, z, this);
        return this;
    }

    @Override
    public IVector3i sub(int i, IVector3i des) {
    	return sub(i, i, i, this);
    }
    
    @Override
    public IVector3i sub(IROVector3i vec, IVector3i des) {
        return sub(vec.getX(), vec.getY(), vec.getZ(), des);
    }

    @Override
    public IVector3i sub(int x, int y, int z, IVector3i des) {
        des.setX(this.x - x);
        des.setY(this.y - y);
        des.setZ(this.z - z);
        return des;
    }

    
    @Override
    public Vector3i mul(int i) {
    	mul(i, i, i, this);
    	return this;
    }
    
    @Override
    public Vector3i mul(IROVector3i vec) {
        mul(vec.getX(), vec.getY(), vec.getZ(), this);
        return this;
    }

    @Override
    public Vector3i mul(int x, int y, int z) {
        mul(x, y, z, this);
        return this;
    }

    @Override
    public IVector3i mul(int i, IVector3i des) {
    	return mul(i, i, i, this);
    }
    
    @Override
    public IVector3i mul(IROVector3i vec, IVector3i des) {
        return mul(vec.getX(), vec.getY(), vec.getZ(), des);
    }

    @Override
    public IVector3i mul(int x, int y, int z, IVector3i des) {
        des.setX(this.x * x);
        des.setY(this.y * y);
        des.setZ(this.z * z);
        return des;
    }

    
    @Override
    public Vector3i div(int i) {
    	div(i, i, i, this);
    	return this;
    }
    
    @Override
    public Vector3i div(IROVector3i vec) {
        div(vec.getX(), vec.getY(), vec.getZ(), this);
        return this;
    }

    @Override
    public Vector3i div(int x, int y, int z) {
        div(x, y, z, this);
        return this;
    }

    @Override
    public IVector3i div(int i, IVector3i des) {
    	return div(i, i, i, this);
    }
    
    @Override
    public IVector3i div(IROVector3i vec, IVector3i des) {
        return div(vec.getX(), vec.getY(), vec.getZ(), des);
    }

    @Override
    public IVector3i div(int x, int y, int z, IVector3i des) {
        des.setX(this.x / x);
        des.setY(this.y / y);
        des.setZ(this.z / z);
        return des;
    }

    
    @Override
    public Vector3i max(int i) {
    	max(i, i, i, this);
    	return this;
    }
    
    @Override
    public Vector3i max(IROVector3i vec) {
        max(vec.getX(), vec.getY(), vec.getZ(), this);
        return this;
    }

    @Override
    public Vector3i max(int x, int y, int z) {
        max(x, y, z, this);
        return this;
    }

    @Override
    public IVector3i max(int i, IVector3i des) {
    	return max(i, i, i, this);
    }
    
    @Override
    public IVector3i max(IROVector3i vec, IVector3i des) {
        return max(vec.getX(), vec.getY(), vec.getZ(), des);
    }

    @Override
    public IVector3i max(int x, int y, int z, IVector3i des) {
        des.setX(x > this.x ? x : this.x);
        des.setY(y > this.y ? y : this.y);
        des.setZ(z > this.z ? z : this.z);
        return des;
    }

    
    @Override
    public Vector3i min(int i) {
    	min(i, i, i, this);
    	return this;
    }
    
    @Override
    public Vector3i min(IROVector3i vec) {
        min(vec.getX(), vec.getY(), vec.getZ(), this);
        return this;
    }

    @Override
    public Vector3i min(int x, int y, int z) {
        min(x, y, z, this);
        return this;
    }

    @Override
    public IVector3i min(int i, IVector3i des) {
    	return min(i, i, i, this);
    }
    
    @Override
    public IVector3i min(IROVector3i vec, IVector3i des) {
        return min(vec.getX(), vec.getY(), vec.getZ(), des);
    }

    @Override
    public IVector3i min(int x, int y, int z, IVector3i des) {
        des.setX(x < this.x ? x : this.x);
        des.setY(y < this.y ? y : this.y);
        des.setZ(z < this.z ? z : this.z);
        return des;
    }

    
	@Override
	public Vector3i cross(IROVector3i vec) {
		cross(vec.getX(), vec.getY(), vec.getZ(), this);
		return this;
	}
	
	@Override
	public Vector3i cross(int x, int y, int z) {
		cross(x, y, z, this);
		return this;
	}
	
	@Override
	public IVector3i cross(IROVector3i vec, IVector3i des) {
		return cross(vec.getX(), vec.getY(), vec.getZ(), des);
	}
	
	@Override
	public IVector3i cross(int x, int y, int z, IVector3i des) {
		des.setX(this.y*z - this.z*y);
		des.setY(this.z*x - this.x*z);
		des.setZ(this.x*y - this.y*x);
		return des;
	}
	
	
	@Override
	public Vector3i rotate(IROVector3i vec, float angle) {
		rotate(vec.getX(), vec.getY(), vec.getZ(), angle, this);
		return this;
	}
	
	@Override
	public Vector3i rotate(int x, int y, int z, float angle) {
		rotate(x, y, z, angle, this);
		return this;
	}
	
	@Override
	public IVector3i rotate(IROVector3i vec, float angle, IVector3i des) {
		return rotate(vec.getX(), vec.getY(), vec.getZ(), angle, des);
	}
	
	@Override
	public IVector3i rotate(int x, int y, int z, float angle, IVector3i des) {
		//TODO
		throw new UnsupportedOperationException("Method not implemented yet, please feel free to do so");
	}
	
	@Override
	public Vector3i rotateX(float angle) {
		rotateX(angle, this);
		return this;
	}
	
	@Override
	public IVector3i rotateX(float angle, IVector3i des) {
		float cs = (float) Math.cos(angle);
		float sn = (float) Math.sin(angle);
		des.setX(x);
		des.setY((int) (y * cs - z * sn));
		des.setZ((int) (y * sn + z * cs));
		return des;
	}
	
	@Override
	public Vector3i rotateY(float angle) {
		rotateY(angle, this);
		return this;
	}
	
	@Override
	public IVector3i rotateY(float angle, IVector3i des) {
		float cs = (float) Math.cos(angle);
		float sn = (float) Math.sin(angle);
		des.setX((int) (x * cs + z * sn));
		des.setY(y);
		des.setZ((int) (-x * sn + z * cs));
		return des;
	}
	
	@Override
	public Vector3i rotateZ(float angle) {
		rotateZ(angle, this);
		return this;
	}
	
	@Override
	public IVector3i rotateZ(float angle, IVector3i des) {
		float cs = (float) Math.cos(angle);
		float sn = (float) Math.sin(angle);
		des.setX((int) (x * cs - y * sn));
		des.setY((int) (x * sn + y * cs));
		des.setZ(z);
		return des;
	}
	
	
    @Override
    public float dot(IROVector3i vec) {
        return dot(vec.getX(), vec.getY(), vec.getZ());
    }

    @Override
    public float dot(int x, int y, int z) {
        return this.x * x + this.y + y + this.z * z;
    }

    @Override
    public float angle(IROVector3i vec) {
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
    public float distance(IROVector3i vec) {
        return distance(vec.getX(), vec.getY(), vec.getZ());
    }

    @Override
    public float distance(int x, int y, int z) {
        return (float) Math.sqrt(distanceSq(x, y, z));
    }
    
    @Override
    public float distanceSq(IROVector3i vec) {
    	return distanceSq(vec.getX(), vec.getY(), vec.getZ());
    }
    
    @Override
    public float distanceSq(int x, int y, int z) {
    	return (x-this.x)*(x-this.x) +  (y-this.y)*(y-this.y) + (z-this.z)*(z-this.z);
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
    public float lenght() {
    	return (float) Math.sqrt(lenghtSq());
    }
    
    @Override
    public float lenghtSq() {
    	return x*x + y*y + z*z;
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
    public Vector3i set(IROVector3i vec) {
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
