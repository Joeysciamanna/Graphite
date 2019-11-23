package ch.g_7.graphite.entity.mesh;

import java.io.Closeable;
import java.util.List;

import org.joml.Vector3fc;

import ch.g_7.util.stuff.Initializable;


//TODO Pleas remake the Mesh System, its stupdi
public interface IMesh extends Initializable, Closeable{

	List<Vector3fc> getPoints();
	
	Vector3fc getMaxPoint();
	
	Vector3fc getMinPoint();
	
	@Override
    void close();
}
