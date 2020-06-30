FROM gcr.io/google-appengine/openjdk
VOLUME /tmp
COPY atm.jar ./
ENTRYPOINT ["java"]
CMD ["-jar", "/atm.jar", "--server.port=8080"]
EXPOSE 8080