DESCRIPTION = "Machine specific systemd units"
MAINTAINER = "isar-users <isar-users@googlegroups.com>"

inherit dpkg-raw

DEBIAN_DEPENDS = "systemd"

SRC_URI = " \
    file://postinst \
    file://10-eth0.network \
    file://10-eth1.network \
    file://90-dhcp-default.network \
    ${@bb.utils.contains("MACHINE_FEATURES", "can", "file://can0.service", "", d)} \
"

do_install() {
    install -d ${D}/etc/systemd/network/
    for file in $(find ${WORKDIR} -maxdepth 1 -type f -name *.network); do
        install -m 0644 "$file" ${D}/etc/systemd/network/
    done
    install -d ${D}/usr/lib/systemd/system/
    for file in $(find ${WORKDIR} -maxdepth 1 -type f -name *.service); do
        install -m 0644 "$file" ${D}/usr/lib/systemd/system/
    done
}
