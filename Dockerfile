FROM registry.access.redhat.com/jboss-eap-6/eap64-openshift:1.5-14

EXPOSE 8080 8888

RUN curl https://github.com/sonngx/myapp/raw/master/testapp.war -o $JBOSS_HOME/standalone/deployments/ROOT.war
