# WebSocketClientHandler

## Contract
```
addComponent componentWebSocketClientHandler@node0 : WebSocketClientHandler {
    cpu_wall_time = '130',
    memory_max_size = '72',
    //throughput_msg_per_second='all=0;service=0',
    uselessParameter = '' // WebSocketClientHandler
}
```

## Goal
This component is a specific JavaFX Handler which allow to interact with the [WebBrowser](https://github.com/dukeboard/kevoree-microsandbox/tree/master/microsandbox-experiment/nofaulty/webBrowser/).
It allows to connect the web browser to the [Web Socket server](https://github.com/dukeboard/kevoree-microsandbox/tree/master/microsandbox-experiment/nofaulty/wsServer/).
