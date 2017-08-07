FROM registry.access.redhat.com/jboss-eap-6/eap64-openshift:1.5-14

EXPOSE 8080 8888

RUN curl https://github.com/sonngx/myapp/raw/master/testapp.war -L -o $JBOSS_HOME/standalone/deployments/testapp.war
