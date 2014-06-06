#!/bin/bash
if [ "$#" -ne 1 ]; then
    echo "Illegal number of parameters"
    echo "Usage: $0 DIRECTORY"
fi
echo "Restoring process"
/home/inti/Downloads/criu-1.2/criu restore -d -D $1 -n pid -v4 --tcp-established -o restore.log && echo OK
