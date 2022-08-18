#version 400

out vec4 color;
in vec2 uvs;

uniform sampler2D image;

void main() {

    color = texture(image,uvs);
}