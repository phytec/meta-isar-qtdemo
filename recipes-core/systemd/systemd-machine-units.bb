DESCRIPTION = "Machine specific systemd units"
MAINTAINER = "isar-users <isar-users@googlegroups.com>"

inherit dpkg-raw

DEBIAN_DEPENDS = "systemd"

SRC_URI += " \
    file://postinst \
    file://10-watchdog.conf \
    file://10-eth0.network \
    file://10-eth1.network \
    file://90-dhcp-default.network \
    file://can0.network \
    file://can1.network \
    file://touchscreen.rules \
"

SRC_URI_append_mx6ul = " file://cpuidle-disable-state.rules"

do_install_append() {
    install -d ${D}/etc/systemd/network/
    for file in $(find ${WORKDIR} -maxdepth 1 -type f -name *.network); do
        install -m 0644 "$file" ${D}/etc/systemd/network/
    done
    install -d ${D}/usr/lib/systemd/system/
    for file in $(find ${WORKDIR} -maxdepth 1 -type f -name *.service); do
        install -m 0644 "$file" ${D}/usr/lib/systemd/system/
    done

    install -d ${D}/etc/systemd/system.conf.d/
    [ -e ${WORKDIR}/10-watchdog.conf ] && \
      install -m 0644 ${WORKDIR}/10-watchdog.conf ${D}/etc/systemd/system.conf.d/10-watchdog.conf

    install -d ${D}/etc/udev/rules.d/
    for rule in $(find ${WORKDIR} -maxdepth 1 -type f -name "*.rules"); do
        install -m 0644 $rule ${D}/etc/udev/rules.d/
    done
}
