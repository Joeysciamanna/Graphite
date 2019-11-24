#version 330

layout (location=0) in vec3 position;
layout (location=1) in vec2 texCoord;

out vec2 fragmentInTexCoord;
out vec4 fragmentInColor;
flat out int fragmentInTextureEnabled;

uniform vec4 color;
uniform int textureEnabled;
uniform mat4 model_view_matrix;


void main(){
	
    gl_Position =  model_view_matrix * vec4(position, 1.0);
    fragmentInTexCoord = texCoord;
    fragmentInColor = color;
    fragmentInTextureEnabled = textureEnabled;
}



