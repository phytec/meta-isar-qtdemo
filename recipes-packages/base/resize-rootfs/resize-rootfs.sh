#!/bin/bash
sleep 20s
parted /dev/mmcblk1 resizepart 2 100%
resize2fs /dev/mmcblk1p2
systemctl disable resize-rootfs
systemctl stop resize-rootfs
