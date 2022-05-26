DESCRIPTION = "Machine specific qtbase configuration"

inherit dpkg-raw

SRC_URI = "\
    file://qtLauncher \
    file://eglfs_kms.config \
    file://tslib.sh \
    file://res-touchscreen.rules \
"

DEBIAN_DEPENDS = "libts-bin, libts-dev"

# Use xwayland for wayland platforms
QT_QPA_PLATFORM ??= "${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'xcb', 'eglfs', d)}"

do_install() {
	install -d ${D}/etc
	install -m 0644 ${WORKDIR}/eglfs_kms.config ${D}/etc/eglfs_kms.config

	install -d ${D}/usr/bin
	install -m 0755 ${WORKDIR}/qtLauncher ${D}/usr/bin/qtLauncher
	sed -i 's,@QT_QPA_PLATFORM@,${QT_QPA_PLATFORM},g' ${D}/usr/bin/qtLauncher
	sed -i 's,@QT_QPA_EGLFS_KMS_CONFIG@,/etc/eglfs_kms.config,g' ${D}/usr/bin/qtLauncher

	install -Dm0755 ${WORKDIR}/tslib.sh ${D}/etc/profile.d/tslib.sh

        install -d ${D}/usr/lib/udev/rules.d
        install -m 0644 ${WORKDIR}/res-touchscreen.rules ${D}/usr/lib/udev/rules.d/
}
