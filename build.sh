#!/usr/bin/env bash

mvn clean install -Dmaven.test.skip=true -U

docker build -t registry.cn-hangzhou.aliyuncs.com/springcloud-baron/product .

docker push registry.cn-hangzhou.aliyuncs.com/springcloud-baron/product
