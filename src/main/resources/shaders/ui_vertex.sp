#version 330

layout (location=0) in vec3 position;
layout (location=2) in vec2 texCoord;

out vec2 fragTexCoord;

uniform mat4 modelViewMatrix;
uniform mat4 projectionMatrix;

void main(){

    gl_Position =  projectionMatrix * modelViewMatrix * vec4(position, 1.0);
    fragTexCoord = texCoord;
}



