#version 330

layout (location=0) in vec3 position;
layout (location=1) in vec2 texCoord;

out vec2 outTexCoord;
out vec4 outColor;

uniform vec4 color;

uniform mat4 model_view_matrix;


void main(){
	
    gl_Position =  model_view_matrix * vec4(position, 1.0);
    outTexCoord = texCoord;
    outColor = color;
}



