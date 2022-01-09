#!/bin/bash

sudo modprobe nfs
sudo modprobe nfsd

docker run 					        \
	-v ~/nfs/data:/data 			\
	-e NFS_EXPORT_0='/data *(rw,no_subtree_check)'	\
	-p 2049:2049				      \
	-itd 					            \
	--privileged				      \
	--name nfs-server			\
	erichough/nfs-server
	
