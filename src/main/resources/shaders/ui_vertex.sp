#version 330

layout (location=0) in vec3 position;
layout (location=1) in vec2 texCoord;

out vec2 outTexCoord;
out vec4 outColor;

uniform vec4 color;

uniform vec2 window_size;


void main(){
	
	vec2 i = window_size;
    gl_Position = vec4(position.x - 1, position.y + 1, 0, 1);
    outTexCoord = texCoord;
    outColor = color;
}



