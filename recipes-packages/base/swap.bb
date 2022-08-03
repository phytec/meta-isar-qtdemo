DESCRIPTION = "Install and enable a systemd service that starts a script that makes a swap file on first boot"

inherit dpkg-raw

SRC_URI = " \
	file://swap.service \
	file://swap.sh \
	file://postinst"

do_install() {
   install -d -m 0775 ${D}/lib/systemd/system
   install -m 0644 ${WORKDIR}/swap.service ${D}/lib/systemd/system/
   install -d -m 0775 ${D}/etc/phytec-swap
   install -m 0644 ${WORKDIR}/swap.sh ${D}/etc/phytec-swap/
}
