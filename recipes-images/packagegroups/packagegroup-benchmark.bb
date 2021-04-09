inherit dpkg-raw

DESCRIPTION = "Benchmark tools used on Phytec boards"

DEBIAN_DEPENDS = " \
    bonnie++, \
    hdparm, \
    iozone3, \
    iperf3, \
    lmbench, \
    rt-tests, \
    evtest, \
    stress-ng, \
    ${@bb.utils.contains("DISTRO_FEATURES", "systemd", "systemd", "",d)}, \
"

#TODO: implement packages
#DEBIAN_DEPENDS += " \
#    pmbw, \
#    perf, \
#"
#
