FROM kong:2.3

COPY setup.sh /usr/local/bin/setup.sh
RUN chmod +x /usr/local/bin/setup.sh
RUN /usr/local/bin/setup.sh

COPY --from=migration /kong-migrations /kong-migrations
RUN kong migrations bootstrap
