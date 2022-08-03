DESCRIPTION = "Resize rootfs to max size"

inherit dpkg-raw

SRC_URI = " \
        file://resize-rootfs.service \
        file://resize-rootfs.sh \
        file://postinst"

do_install() {
   install -d -m 0775 ${D}/lib/systemd/system
   install -m 0644 ${WORKDIR}/resize-rootfs.service ${D}/lib/systemd/system/
   install -d -m 0775 ${D}/etc/resize-rootfs
   install -m 0644 ${WORKDIR}/resize-rootfs.sh ${D}/etc/resize-rootfs/
}
