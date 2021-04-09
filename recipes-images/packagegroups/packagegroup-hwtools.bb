inherit dpkg-raw

DESCRIPTION = "Hardware development tools used on Phytec boards"

DEBIAN_DEPENDS = " \
    usbutils, \
    ethtool, \
    i2c-tools, \
    iw, \
    bc, \
    memtester, \
    dosfstools, \
    e2fsprogs, \
    parted, \
    mmc-utils, \
    flashbench, \
    util-linux, \
    mtd-utils, \
    iproute2, \
    libgpiod2, \
    ${@bb.utils.contains("MACHINE_FEATURES", "can", "can-utils", "", d)}, \
    ${@bb.utils.contains("MACHINE_FEATURES", "resistivetouch", "libts-bin, libts-dev", "", d)}, \
    ${@bb.utils.contains("MACHINE_FEATURES", "pci", "pciutils", "", d)}, \
    lm-sensors, \
    nfs-common, \
"

#TODO: implement packages
#DEBIAN_DEPENDS += " \
#    devmem2, \
#    fbtest, \
#    libdrm-tests, \
#    memedit, \
#    nandflipbits, \
#    bumprts, \
#    serial-test, \
#    serialcheck, \
#    rs485test, \
#    phytool, \
#    kmsxx, \
#"
#
# Those packages depend on a specific SoC architecture
#DEBIAN_DEPENDS_append_arm = " arm-memspeed"
#DEBIAN_DEPENDS_append_mx6 = " mmdc bbu"
#DEBIAN_DEPENDS_append_mx6ul = " mmdc bbu"
#DEBIAN_DEPENDS_append_rk3288 = " rkeeprom"
#DEBIAN_DEPENDS_append_ti33x = " phyedit bbu"
#
