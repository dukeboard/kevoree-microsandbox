#!/bin/bash

for i in `seq 1 $1` ; do
	echo "Creating ${i}"
	name="virtualNode${i}"
	./createSingleClone.sh ${name} $i
done
