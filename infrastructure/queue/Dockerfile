FROM rabbitmq:3-management

RUN rabbitmq-plugins enable rabbitmq_management

RUN apt-get update && apt-get install -y curl

COPY create_queue.sh /usr/local/bin/

RUN chmod +x /usr/local/bin/create_queue.sh

CMD ["create_queue.sh"]
