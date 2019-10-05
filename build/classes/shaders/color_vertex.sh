#version 330

layout (location=0) in vec3 position;
layout (location=1) in vec2 texCoord;

out vec4 outColor;

uniform mat4 model_view_matrix;
uniform vec4 color;

void main(){
	
    gl_Position =  model_view_matrix * vec4(position, 1.0);
    outColor = color;
    
}



