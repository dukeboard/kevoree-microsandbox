# WebbitHTTPServer

## Contract
```
addComponent componentHTTPServer@node0 : WebbitHTTPServer {
    port='9500',
    cpu_wall_time = '3316',
    memory_max_size = '1112',
    throughput_msg_per_second='all=1;response=1',
    uselessParameter = '' // WebbitHTTPServer
}
```

## Goal
This component act as a web server based on [Webbit](https://github.com/webbit/webbit).
It allow everybody which use a browser to display the [FollowManager](https://github.com/dukeboard/kevoree-microsandbox/tree/master/microsandbox-experiment/nofaulty/followManager) page or any page that is connected to it.
