# Deployment

Before deployment, an adjustment must be made in the hosts file: <br>
```
127.0.0.1	sso
```

At the moment the gateway must be manually configured, please execute the commands, from infrastructure/gateway/setup.sh file

Single Service
``` bash
docker-compose -p company-management-document -f docker-compose.document.yml buld
docker-compose -p company-management-document -f docker-compose.document.yml up
```