oc delete project demo
oc new-project demo
oc policy add-role-to-user admin developer -n demo
oc new-app -f s2i-spring-boot-camel-xml.json -p GIT_REPO=https://github.com/sonngx/myapp.git -p BUILDER_VERSION=2.0-9 -n demo
