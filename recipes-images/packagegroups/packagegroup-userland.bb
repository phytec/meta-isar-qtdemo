inherit dpkg-raw

DESCRIPTION = "Userland softwareservices found in all Phytec BSPs"

DEBIAN_DEPENDS = " \
    gdbserver, \
    strace, \
    openssh-server, \
    openssh-sftp-server, \
    rsync, \
    htop, \
    crda, \
    kbd, \
    console-data, \
"
