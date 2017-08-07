oc delete project demo
oc new-project demo
oc policy add-role-to-user admin developer -n demo

oc new-app -f fis-jaxrs-quickstart \
-p GIT_REPO=https://github.com/sonngx/myapp.git \
-p GIT_REF=release-01 \
-p contextDir=fuse-openshift/spring-boot-cxf-jaxrs-account \
-p APP_NAME=account-service \
-p APP_VERSION=1.0 \
-p BUILDER_VERSION=2.0-9 -n sit-r01   
