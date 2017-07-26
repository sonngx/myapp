oc delete project demo
oc new-project demo
oc policy add-role-to-user admin admin -n demo
oc new-app -f fis-quickstart-template.json -p GIT_REPO=https://github.com/sonngx/myapp.git -p BUILDER_VERSION=2.0-9 -n demo
