#!/bin/bash
if [ ! -f /etc/phytec-swap/swap-created.txt ]
then
  sleep 20s
  parted /dev/mmcblk1 resizepart 2 100%
  resize2fs /dev/mmcblk1p2
  fallocate -l 1G /swapfile
  chmod 600 /swapfile
  mkswap /swapfile
  swapon /swapfile
  echo "/swapfile none swap sw 0 0" >> /etc/fstab
  echo>/etc/phytec-swap/swap-created.txt
  systemctl disable swap
  systemctl stop swap
fi
