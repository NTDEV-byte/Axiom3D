#version 400

out vec4 color;
in vec3 samplerVectors;

uniform samplerCube sampleCube;

void main() {

        color = texture(sampleCube,samplerVectors);

}