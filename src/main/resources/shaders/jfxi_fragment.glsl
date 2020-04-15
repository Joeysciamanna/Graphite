#version 330


out vec4 fragColor;
in vec2 fragTexCoord;

uniform sampler2D img;

void main(){
	fragColor += texture(img, fragTexCoord);
}