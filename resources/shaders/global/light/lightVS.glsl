#version 400

layout (location = 0) in vec3 positions;
layout (location = 1) in vec2 textures;
layout (location = 2) in vec3 normals;

uniform mat4 projectionMatrix = mat4(1.0);
uniform mat4 viewMatrix = mat4(1.0);
uniform mat4 modelMatrix = mat4(1.0);

uniform vec3 lightPosition;

out vec2 uvs;
out vec3 tlsVec3;
out vec3 transformedNormals;

void main(){

        vec4 positionRelativeToWorld = modelMatrix * vec4(positions,1.0);
        vec4 positionRelativeToCamera = viewMatrix * positionRelativeToWorld;

        gl_Position = projectionMatrix * positionRelativeToCamera;
        uvs = textures;

        // input for diffuse lighting calculations
        tlsVec3 = lightPosition - positionRelativeToWorld.xyz;
        transformedNormals = (modelMatrix * (vec4(transformedNormals,1.0))).xyz;

}