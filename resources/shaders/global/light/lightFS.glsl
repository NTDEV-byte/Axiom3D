#version 400

out vec4 color;

in vec2 uvs;
in vec3 tlsVec3;
in vec3 transformedNormals;
in vec3 toCameraVector;

uniform vec3  lightColor;
uniform float intensity;
uniform float reflectivity;
uniform sampler2D image;

void main() {

        vec3 unitTLSVec3 = normalize(tlsVec3);
        vec3 unitNormals = normalize(transformedNormals);


        float diffuseFactor = dot(unitTLSVec3,unitNormals);
        diffuseFactor = clamp(diffuseFactor,-1.0f,1.0f);

        vec3 diffuseColor = lightColor * diffuseFactor;

        //specular caluclation
        vec3 unitInvTLSVec3 = -unitTLSVec3;
        vec3 unitTCV = normalize(toCameraVector);
        vec3 unitReflectedRay = normalize(reflect(unitInvTLSVec3,unitNormals));

        float specularFactor = dot(unitReflectedRay,unitTCV);
        specularFactor = pow(specularFactor,intensity);
        specularFactor = clamp(specularFactor,0.0,1.0f);
        specularFactor = specularFactor * reflectivity;

        vec3 specularColor = lightColor * specularFactor;


        color =  texture(image,uvs) * vec4(diffuseColor,1.0) + vec4(specularColor,1.0);
}