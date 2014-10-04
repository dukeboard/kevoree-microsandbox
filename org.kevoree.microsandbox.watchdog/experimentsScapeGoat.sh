#!/bin/bash

if [[ -d $1 ]]; then

LEN_1=${#1}
((LEN_1+=1))

output_file=results_results.txt

if [ "$#" -eq 2 ]; then
    if [[ -f $2 ]]; then
        read -p "There is a file with that name, Do you want to overwrite it?  (y/n)" -n 1 -r
        echo    # (optional) move to a new line
        if [[ $REPLY =~ ^[Yy]$ ]]
        then
            # do dangerous stuff
            output_file=${2}
        fi
    else
        output_file=${2}
    fi
fi

# creating file for results
echo "" > ${output_file}

for d in $1/*; do
    if [[ -d $d ]]; then
        exp_group=${d:${LEN_1}}
        if [ $exp_group == "uc6" ]; then
            LEN2=${#d}
            ((LEN2+=1))
            for test in $d/*; do
                if [[ -f ${test} ]]; then
                    echo -e "\e[1m\e[35mExecuting ${test}\e[0m"
                    echo "Executing ${test}" >> ${output_file}
                    for i in {1..5}; do
                        java -Dnode.bootstrap=${test} -Dversion=5.0.1 -Duse.criu=false -Dexperiment.log= -Dnode.name=node0 -Xbootclasspath/p:/tmp/ext-rt.jar:/tmp/shared-res-1.1.jar -javaagent:/tmp/ext-agent1.1.jar=scapegoat -jar /tmp/kevoree-runtime-5.0.1.jar &
                        the_pid=$!
                        r=`nc -l 4444`
                        kill -s 9 ${the_pid}
                        echo -e "\e[31m\e[1m$i,$exp_group\e[0m,\e[33m${test:$LEN2},\e[32m${r}\e[0m"
                        echo "$i,$exp_group,${test:$LEN2},${r}" >> ${output_file}
                    done
                    echo >> ${output_file}
                fi
            done
        fi
    fi
done

fi
