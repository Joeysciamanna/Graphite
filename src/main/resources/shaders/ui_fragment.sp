#version 330

in vec2 fragInTexCoord;
in vec4 fragInColor;
flat in int fragInTextureEnabled;

out vec4 fragColor;

uniform sampler2D texture_sampler;

void main(){

	if(fragInColor.a == 0){
		discard;
	}
    fragColor = fragInColor;
	if (fragInTextureEnabled == 1){
		fragColor += texture(texture_sampler, fragInTexCoord);
	}
}