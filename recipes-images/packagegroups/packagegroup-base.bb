inherit dpkg-raw

#do_install() {
#    bbwarn "Fake install"
#}

DESCRIPTION = "Merge machine and distro options to create a basic machine task/package"

#
# packagegroup-base contain stuff needed for base system (machine related)
#
DEBIAN_DEPENDS = "\
    kmod, \
    \
    ${@bb.utils.contains('MACHINE_FEATURES', 'acpi', 'acpid', '', d)}, \
    ${@bb.utils.contains('MACHINE_FEATURES', 'phone', 'ofono', '', d)}, \
    \
    ${@bb.utils.contains('COMBINED_FEATURES', 'alsa', 'alsa-utils', '', d)}, \
    ${@bb.utils.contains('COMBINED_FEATURES', 'ext2', 'hdparm, e2fsprogs', '', d)}, \
    ${@bb.utils.contains('COMBINED_FEATURES', 'irda', 'irda-utils', '', d)}, \
    ${@bb.utils.contains('COMBINED_FEATURES', 'pci', 'pciutils', '', d)}, \
    ${@bb.utils.contains('COMBINED_FEATURES', 'pcmcia', 'pcmciautils', '', d)}, \
    ${@bb.utils.contains('COMBINED_FEATURES', 'usbhost', 'usbutils', '', d)}, \
    ${@bb.utils.contains('COMBINED_FEATURES', 'bluetooth', 'bluez', '', d)}, \
    ${@bb.utils.contains('COMBINED_FEATURES', 'wifi', 'iw, wpasupplicant', '', d)}, \
    ${@bb.utils.contains('COMBINED_FEATURES', '3g', 'ofono', '', d)}, \
    ${@bb.utils.contains('COMBINED_FEATURES', 'nfc', 'neard', '', d)}, \
    \
    ${@bb.utils.contains('DISTRO_FEATURES', 'nfs', 'rpcbind', '', d)}, \
    ${@bb.utils.contains('DISTRO_FEATURES', 'ppp', 'ppp', '', d)}, \
    ${@bb.utils.contains('DISTRO_FEATURES', 'zeroconf', 'avahi-daemon, libnss-mdns', '', d)}, \
    "
