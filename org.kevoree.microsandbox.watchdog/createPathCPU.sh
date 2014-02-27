if [ ! -d /sys/fs/cgroup/cpu/inti ]; then
	sudo mkdir /sys/fs/cgroup/cpu/inti
	sudo chmod ugo+rw /sys/fs/cgroup/cpu/inti
	mkdir /sys/fs/cgroup/cpu/inti/p0
	sudo mkdir /sys/fs/cgroup/freezer/inti
	sudo chmod ugo+rw /sys/fs/cgroup/freezer/inti
	mkdir /sys/fs/cgroup/freezer/inti/p0

	echo `pwd`/cgroup_clean.sh | sudo tee /sys/fs/cgroup/freezer/release_agent
	echo `pwd`/cgroup_clean.sh | sudo tee /sys/fs/cgroup/cpu/release_agent
fi
