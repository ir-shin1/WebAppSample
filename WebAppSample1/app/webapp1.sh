#!/usr/bin/env sh

java -cp lib/tomcat-embed-core.jar:lib/annotations-api.jar:lib/ecj-4.6.3.jar:lib/tomcat-embed-el.jar:app/startup.jar:app/webapp1.jar com.sample.startup.TomcatApp 8080 0.0.0.0 '/WebApp/*' com.sample.webapp1.ServletApp
