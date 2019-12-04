#version 330

in vec2 fragmentInTexCoord;
in vec4 fragmentInColor;
flat in int fragmentInTextureEnabled;

out vec4 fragColor;

uniform sampler2D texture_sampler;

void main(){

    fragColor = fragmentInColor;
    if (fragmentInTextureEnabled == 1){
		fragColor += texture(texture_sampler, fragmentInTexCoord);
	}
}