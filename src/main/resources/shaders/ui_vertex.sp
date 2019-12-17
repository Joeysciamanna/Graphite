#version 330

layout (location=0) in vec2 position;
layout (location=2) in vec2 texCoord;

out vec4 fragInColor;
out vec2 fragInTexCoord;
flat out int fragInTextureEnabled;

uniform vec4 color;
uniform int textureEnabled;
uniform mat4 model_view_matrix;


void main(){


    gl_Position =  model_view_matrix * vec4(position, 0, 1.0);
    fragInTexCoord = texCoord;
    fragInColor = color;
    fragInTextureEnabled = textureEnabled;
}



