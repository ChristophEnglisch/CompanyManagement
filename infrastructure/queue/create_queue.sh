#!/bin/bash

curl -i -u guest:guest -H "content-type:application/json" \
    -XPUT -d'{"auto_delete":false,"durable":true}' \
    http://localhost:15672/api/queues/%2f/appointment