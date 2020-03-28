package ch.g_7.graphite.math.vec;


import java.util.Objects;

public class Vector2i implements IVector2i {

	public int x, y;
	
	
	public Vector2i() {}
	
	public Vector2i(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public Vector2i add(int i) {
		add(i, i, this);
		return this;
	}
	
	@Override
	public Vector2i add(IROVector2i vec) {
		add(vec.getX(), vec.getY(), this);
		return this;
	}

	@Override
	public Vector2i add(int x, int y) {
		add(x, y, this);
		return this;
	}
	
	@Override
	public IVector2i add(int i, IVector2i des) {
		return add(i, i, des);
	}

	@Override
	public IVector2i add(IROVector2i vec, IVector2i des) {
		return add(vec.getX(), vec.getY(), des);
	}

	@Override
	public IVector2i add(int x, int y, IVector2i des) {
		des.setX(this.x + x);
		des.setY(this.y + y);
		return des;
	}

	
	@Override
	public Vector2i sub(int i) {
		sub(i, i, this);
		return this;
	}
	
	@Override
	public Vector2i sub(IROVector2i vec) {
		sub(vec.getX(), vec.getY(), this);
		return this;
	}

	@Override
	public Vector2i sub(int x, int y) {
		sub(x, y, this);
		return this;
	}

	@Override
	public IVector2i sub(int i, IVector2i des) {
		return sub(i, i, des);
	}
	
	@Override
	public IVector2i sub(IROVector2i vec, IVector2i des) {
		return sub(vec.getX(), vec.getY(), des);
	}

	@Override
	public IVector2i sub(int x, int y, IVector2i des) {
		des.setX(this.x - x);
		des.setY(this.y - y);
		return des;
	}

	
	@Override
	public Vector2i mul(int i) {
		mul(i, i, this);
		return this;
	}
	
	@Override
	public Vector2i mul(IROVector2i vec) {
		mul(vec.getX(), vec.getY(), this);
		return this;
	}

	@Override
	public Vector2i mul(int x, int y) {
		mul(x, y, this);
		return this;
	}

	@Override
	public IVector2i mul(int i, IVector2i des) {
		return mul(i, i, des);
	}
	
	@Override
	public IVector2i mul(IROVector2i vec, IVector2i des) {
		return mul(vec.getX(), vec.getY(), des);
	}

	@Override
	public IVector2i mul(int x, int y, IVector2i des) {
		des.setX(this.x * x);
		des.setY(this.y * y);
		return des;
	}
	

	@Override
	public Vector2i div(int i) {
		div(i, i, this);
		return this;
	}
	
	@Override
	public Vector2i div(IROVector2i vec) {
		div(vec.getX(), vec.getY(), this);
		return this;
	}

	@Override
	public Vector2i div(int x, int y) {
		div(x, y, this);
		return this;
	}

	@Override
	public IVector2i div(int i, IVector2i des) {
		return div(i, i, des);
	}
	
	@Override
	public IVector2i div(IROVector2i vec, IVector2i des) {
		return div(vec.getX(), vec.getY(), des);
	}

	@Override
	public IVector2i div(int x, int y, IVector2i des) {
		des.setX(this.x / x);
		des.setY(this.y / y);
		return des;
	}

	
	@Override
	public Vector2i max(int i) {
		max(i, i, this);
		return this;
	}
	
	@Override
	public Vector2i max(IROVector2i vec) {
		max(vec.getX(), vec.getY(), this);
		return this;
	}

	@Override
	public Vector2i max(int x, int y) {
		max(x, y, this);
		return this;
	}

	@Override
	public IVector2i max(int i, IVector2i des) {
		return max(i, i, des);
	}
	
	@Override
	public IVector2i max(IROVector2i vec, IVector2i des) {
		return max(vec.getX(), vec.getY(), des);
	}

	@Override
	public IVector2i max(int x, int y, IVector2i des) {
		des.setX(x > this.x ? x : this.x);
		des.setY(y > this.y ? y : this.y);
		return des;
	}


	@Override
	public Vector2i min(int i) {
		min(i, i, this);
		return this;
	}
	
	@Override
	public Vector2i min(IROVector2i vec) {
		min(vec.getX(), vec.getY(), this);
		return this;
	}

	@Override
	public Vector2i min(int x, int y) {
		min(x, y, this);
		return this;
	}

	@Override
	public IVector2i min(int i, IVector2i des) {
		return min(i, i, des);
	}
	
	@Override
	public IVector2i min(IROVector2i vec, IVector2i des) {
		return min(vec.getX(), vec.getY(), des);
	}

	@Override
	public IVector2i min(int x, int y, IVector2i des) {
		des.setX(x < this.x ? x : this.x);
		des.setY(y < this.y ? y : this.y);
		return des;
	}


	@Override
	public Vector2i rotate(IROVector2i vec, float angle) {
		rotate(vec.getX(), vec.getY(), angle, this);
		return this;
	}
	
	@Override
	public Vector2i rotate(int x, int y, float angle) {
		rotate(x, y, angle, this);
		return this;
	}
	
	@Override
	public IVector2i rotate(IROVector2i vec, float angle, IVector2i des) {
		return rotate(vec.getX(), vec.getY(), angle, des);
	}
	
	@Override
	public IVector2i rotate(int x, int y, float angle, IVector2i des) {
		float cs = (float) Math.cos(angle);
		float sn = (float) Math.sin(angle);
		
		float newX = des.getX() - x;
		float newY = des.getY() - y;
		des.setX((int) (newX * cs - newY * sn));
		des.setY((int) (newX * sn + newY * cs));
		des.add(x, y);
		return des;
	}
	
	@Override
	public Vector2i rotate(float angle) {
		rotate(angle, this);
		return this;
	}
	
	@Override
	public IVector2i rotate(float angle, IVector2i des) {
		float cs = (float) Math.cos(angle);
		float sn = (float) Math.sin(angle);
		
		des.setX((int) (x * cs - y * sn));
		des.setY((int) (x * sn + y * cs));
		return des;
	}
	
	
	@Override
	public float dot(IROVector2i vec) {
		return dot(vec.getX(), vec.getY());
	}

	@Override
	public float dot(int x, int y) {
		return this.x * x + this.y + y;
	}

	
	@Override
	public float angle(IROVector2i vec) {
		return angle(vec.getX(), vec.getY());
	}

	@Override
	public float angle(int x, int y) {
		return (int) Math.atan2(y - this.y, x - this.x);
	}

	
	@Override
	public float distance(IROVector2i vec) {
		return distance(vec.getX(), vec.getY());
	}

	@Override
	public float distance(int x, int y) {
		return (int) Math.sqrt(distanceSq(x, y));
	}

	@Override
	public float distanceSq(IROVector2i vec) {
		return distanceSq(vec.getX(), vec.getY());
	}
	
	@Override
	public float distanceSq(int x, int y) {
		return (x - this.x) * (x - this.x) + (y - this.y) * (y - this.y);
	}
	
	@Override
	public int distanceX(int x) {
		return this.x - x;
	}

	@Override
	public int distanceY(int y) {
		return this.y - y;
	}
	
	
	@Override
	public float lenght() {
		return (float) Math.sqrt(lenghtSq());
	}
	
	@Override
	public float lenghtSq() {
		return x*x + y*y;
	}
	

	@Override
	public Vector2f transform2f() {
		return new Vector2f(x, y);
	}

	@Override
	public Vector3f transform3f(float z) {
		return new Vector3f(x, y, z);
	}

	@Override
	public Vector3i transform3i(int z) {
		return new Vector3i(x, y, z);
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
	public Vector2i set(IROVector2i vec) {
		return set(vec.getX(), vec.getY());
	}

	@Override
	public Vector2i set(int x, int y) {
		this.x = x;
		this.y = y;
		return this;
	}

	@Override
	public Vector2i setX(int x) {
		this.x = x;
		return this;
	}

	@Override
	public Vector2i setY(int y) {
		this.y = y;
		return this;
	}

	@Override
	public Vector2i clone() {
		return new Vector2i(x, y);
	}
	
	@Override
	public String toString() {
		return "Vec2f["+x+", "+y+"]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Vector2i vec = (Vector2i) o;
		return x == vec.x &&
				y == vec.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}



}
