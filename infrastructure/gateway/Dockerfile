FROM kong:latest
USER root
RUN apk update && apk add git unzip luarocks
RUN luarocks install kong-oidc
USER kong