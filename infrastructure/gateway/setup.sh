# Document Backend
curl -i -X POST \
  --url http://localhost:8001/services/ \
  --data 'name=document' \
  --data 'url=http://document:8080/v1/document';

curl -i -X POST \
  --url http://localhost:8001/services/document/routes \
  --data 'paths[]=/document' \
  --data 'name=document-route';


# Allow `Connections from Frontend
curl -X POST http://localhost:8001/services/document/plugins \
    --data "name=cors"  \
    --data "config.origins=http://localhost:5173" \
    --data "config.methods=GET" \
    --data "config.methods=POST" \
    --data "config.headers=Accept" \
    --data "config.headers=Accept-Version" \
    --data "config.headers=Content-Length" \
    --data "config.headers=Content-MD5" \
    --data "config.headers=Content-Type" \
    --data "config.headers=Date" \
    --data "config.headers=X-Auth-Token" \
    --data "config.exposed_headers=X-Auth-Token" \
    --data "config.credentials=true" \
    --data "config.max_age=3600";

# SSO Backend
curl -i -X POST \
  --url http://localhost:8001/services/ \
  --data 'name=sso' \
  --data 'url=http://sso:8080/auth';

curl -i -X POST \
  --url http://localhost:8001/services/sso/routes \
  --data 'paths[]=/sso' \
  --data 'name=sso-route';

curl -k -X POST --url http://localhost:8001/routes/document-route/plugins \
  --data name=oidc \
  --data config.realm=master \
  --data config.client_id=kong \
  --data config.client_secret=PsQpZXs32XDGb9ywLZ8KAkm48Pfd2P0k \
  --data config.discovery=http://sso:8080/auth/realms/master/.well-known/openid-configuration


curl -k -X POST --url http://localhost:8001/routes/document-route/plugins \
  --data name=oidc \
  --data config.realm=master \
  --data config.client_id=kong \
  --data config.client_secret=PsQpZXs32XDGb9ywLZ8KAkm48Pfd2P0k \
  --data config.discovery=http://localhost:8000/sso/realms/master/.well-known/openid-configuration

curl -X OPTIONS http://sso:8080/auth/realms/master/.well-known/openid-configuration -H 'Origin: http://localhost:5173'



curl -X DELETE --url E9C15E99-39B0-4C9C-ABAD-0765B82610C8