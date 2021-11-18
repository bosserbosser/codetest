#!/usr/bin/env bash

stdout_start_remark=EXPECT_SSH_LOGGED_IN

expect ../lib/ssh.expect "$@" "$stdout_start_remark" \
| sed 's/\r//g' \
| awk 'BEGIN{matched=0} { if($0~/EXPECT_SSH_LOGGED_IN/){matched=1} else if(matched==1){print $0} }' \
| awk 'BEGIN{begun=0} { if($0!~/^$/){begun=1; print $0}else if(begun==1){print $0} }'
