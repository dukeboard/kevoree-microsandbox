# wsServer

##Contract
```
addComponent componentWSServer@node0 : WsServer {
    port='8092',
    cpu_wall_time = '258',
    memory_max_size = '0',
    //throughput_msg_per_second='all=0;service=0',
    uselessParameter = '' // WsServer
}
```

## Goal
This component is an implementation of a Web Socket server based on [Webbit](https://github.com/webbit/webbit)
