DESCRIPTION = "udev rules for Freescale i.MX SOCs"
MAINTAINER = "isar-users <isar-users@googlegroups.com>"

inherit dpkg-raw

DEBIAN_DEPENDS = "systemd"

SRC_URI += " \
    file://10-imx.rules \
"

do_install_append() {
    install -d ${D}/etc/udev/rules.d
    install -m 0644 ${WORKDIR}/10-imx.rules ${D}/etc/udev/rules.d/
}
