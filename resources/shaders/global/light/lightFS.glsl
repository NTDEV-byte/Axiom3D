#version 400

out vec4 color;

in vec2 uvs;
in vec3 tlsVec3;
in vec3 transformedNormals;

uniform vec3 lightColor;
uniform sampler2D image;

void main() {

        vec3 unitTLSVec3 = normalize(tlsVec3);
        vec3 unitTN = normalize(transformedNormals);

        float diffuseFactor = dot(unitTLSVec3,unitTN);
        diffuseFactor = clamp(diffuseFactor,-1.0f , 1.0f);

        vec3 diffuseColor = lightColor * diffuseFactor;

        color = texture(image,uvs) * vec4(diffuseColor,1.0);
}