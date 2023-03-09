FROM kong:2.3
USER root
RUN apk update && apk add git unzip luarocks

RUN luarocks install kong-oidc

ENV KONG_PLUGINS=bundled,oidc,cors