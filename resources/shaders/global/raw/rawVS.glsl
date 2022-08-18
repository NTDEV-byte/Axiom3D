#version 400

layout (location = 0) in vec3 positions;
layout (location = 1) in vec2 textures;
layout (location = 2) in vec3 normals;

uniform mat4 modelMatrix = mat4(1.0);
uniform mat4 viewMatrix = mat4(1.0);
uniform mat4 projectionMatrix = mat4(1.0);

void main() {

        gl_Position = projectionMatrix * viewMatrix * modelMatrix * vec4(positions,1.0);

}