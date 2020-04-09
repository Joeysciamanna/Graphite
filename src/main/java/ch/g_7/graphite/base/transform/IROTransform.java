package ch.g_7.graphite.base.transform;

import org.joml.Vector3fc;

public interface IROTransform {

    Vector3fc getTranslation();

    Vector3fc getRotation();

    Vector3fc getScale();

}
