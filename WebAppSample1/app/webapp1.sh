#!/usr/bin/env sh

java -Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager -Djava.util.logging.config.file=conf/logging.properties -cp lib/tomcat-embed-core.jar:lib/annotations-api.jar:app/startup.jar:app/webapp1.jar com.sample.startup.TomcatApp 8080 0.0.0.0 '/WebApp/*' com.sample.webapp1.ServletApp
