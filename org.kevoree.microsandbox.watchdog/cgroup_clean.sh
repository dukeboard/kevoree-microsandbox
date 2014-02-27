#!/bin/sh
if [ -d /sys/fs/cgroup/cpu/$1 ]; then
	rmdir /sys/fs/cgroup/cpu/$1
fi
if [ -d /sys/fs/cgroup/freezer/$1 ]; then
	rmdir /sys/fs/cgroup/freezer/$1
fi
