#!/bin/bash

echo "Install Hello App Upstart Script"

UPSTART=/etc/init/helloworld.conf

if [ ! -e  $UPSTART ]; then
  cat > $UPSTART << 'EOF'
start on (started networking)

exec java -jar /target/gs-spring-boot-0.1.0.jar
EOF
  initctl start $UPSTART
fi
