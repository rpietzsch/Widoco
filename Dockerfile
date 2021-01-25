FROM openjdk:8-alpine

ARG VERSION=1.4.14
ADD https://github.com/dgarijo/Widoco/releases/download/v${VERSION}/widoco-${VERSION}-jar-with-dependencies.jar /opt/
RUN ln -s /opt/widoco-${VERSION}-jar-with-dependencies.jar /opt/widoco.jar

ENTRYPOINT java -jar /opt/widoco.jar

CMD "--help"