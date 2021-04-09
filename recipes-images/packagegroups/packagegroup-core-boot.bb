inherit dpkg-raw

DESCRIPTION = "The minimal set of packages required to boot the system"

#
# Set by the machine configuration with packages essential for device bootup
#
MACHINE_ESSENTIAL_EXTRA_RDEPENDS ?= ""

# Distro can override the following VIRTUAL-RUNTIME providers:
VIRTUAL-RUNTIME_dev_manager ?= "udev"
VIRTUAL-RUNTIME_login_manager ?= "busybox"
VIRTUAL-RUNTIME_init_manager ?= "sysvinit"
VIRTUAL-RUNTIME_initscripts ?= "initscripts"

EFI_PROVIDER ??= "grub-efi"

SYSVINIT_SCRIPTS = "${@bb.utils.contains('MACHINE_FEATURES', 'rtc', '${VIRTUAL-RUNTIME_base-utils-hwclock},', '', d)} \
                    ifupdown, \
                    ${VIRTUAL-RUNTIME_initscripts}"

DEBIAN_DEPENDS = "\
    ${VIRTUAL-RUNTIME_base-utils}, \
    ${@bb.utils.contains("DISTRO_FEATURES", "sysvinit", "${SYSVINIT_SCRIPTS}", "", d)}, \
    ${@bb.utils.contains("MACHINE_FEATURES", "efi", "${EFI_PROVIDER}, linux-image-" + d.getVar('KERNEL_NAME'), "", d)}, \
    netbase, \
    ${VIRTUAL-RUNTIME_login_manager}, \
    ${VIRTUAL-RUNTIME_init_manager}, \
    ${VIRTUAL-RUNTIME_dev_manager}, \
    ${VIRTUAL-RUNTIME_update-alternatives}, \
    ${MACHINE_ESSENTIAL_EXTRA_RDEPENDS}, \
"
