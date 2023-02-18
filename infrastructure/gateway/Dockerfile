FROM kong
LABEL description="Docker image containing Alpine + Kong 2.0.0 + kong-oidc plugin"
USER root
RUN apk update && apk add git unzip luarocks
RUN luarocks install kong-oidc
USER kong