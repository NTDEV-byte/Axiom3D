#version 400 core

layout (location = 0) in vec3 positions;

uniform mat4 projectionMatrix = mat4(1.0);
uniform mat4 viewMatrix = mat4(1.0);
uniform mat4 modelMatrix = mat4(1.0);

out vec3 samplerVectors;

void main(){

        gl_Position = projectionMatrix * viewMatrix * modelMatrix * vec4(positions,1.0);
        samplerVectors =  positions;
}