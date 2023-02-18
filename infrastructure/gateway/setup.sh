curl -i -X POST \
  --url http://localhost:8001/services/ \
  --data 'name=document' \
  --data 'url=http://document:8080/v1/document'

curl -i -X POST \
  --url http://localhost:8001/services/document/routes \
  --data 'paths[]=/document' \
  --data 'name=document-route'