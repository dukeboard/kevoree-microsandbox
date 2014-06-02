#!/bin/bash

if [ "$#" -ne 2 ]; then
    echo "Illegal number of parameters"
    echo "Usage $0 PID DIRECTORY"
    exit 1
fi

if [ ! -d $2 ]; then
	echo "Creating directory $2"
	mkdir $2
fi

IFS=$'\n'

ready_to_dump() {
	local c
	let c=0
	for line in $(lsof -a -p $1 -i | grep ESTABLISHED) ; do
		let c=c+1
	done
	echo $c
}

close_ports() {
	local c
	let c=0
	for line in $(lsof -a -p $1 -i | grep java | grep $1 | grep CLOSE_WAIT) ; do	
		socketID=`echo $line | awk '{print $4}' | cut -d "u" -f 1`
		../../Downloads/criu-1.2/criu exec -t $1 close $socketID &> /dev/null
		echo "Socket $socketID with index $c"
		let c=c+1
	done
	echo $c
}

c=`ready_to_dump $1`
while [ $c -gt 0 ] ; do
	sleep 2
	echo "Waiting 2 seconds"
	c=`ready_to_dump $1`
done

echo "Closing ports in status CLOSE_WAIT"
c=`close_ports $1`
echo "$c sockets were closed"

echo "Dumping process with id $1"
../../Downloads/criu-1.2/criu dump -t $1 -D $2 --tcp-established -v2 -o dump.log && echo OK
