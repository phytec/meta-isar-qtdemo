# The bundle version interacts with the downgrade barrier.
# "r0" as version, disables the downgrade barrier. If a
# downgrade barrier is set with r1, you have to increase
# the version for every update. In that way old security
# vulnerabilities cannot be exploited.
RAUC_BUNDLE_VERSION ?= "r0"

#Overrides depend on Distro Features
OVERRIDES_append = "${@bb.utils.contains('DISTRO_FEATURES','secureboot',':secureboot', '',d)}"
PROTECTION_SHIELD_LEVEL ??= "shieldlow"
OVERRIDES_append = "${@bb.utils.contains('DISTRO_FEATURES','protectionshield',':${PROTECTION_SHIELD_LEVEL}', '',d)}"

VIRTUAL-RUNTIME_dev_manager = "udev"
VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_login_manager = "busybox"
VIRTUAL-RUNTIME_syslog = "rsyslog"
VIRTUAL-RUNTIME_initscripts = ""

VIRTUAL-RUNTIME_update-alternatives ?= "apt-utils"
VIRTUAL-RUNTIME_base-utils ?= "busybox"
VIRTUAL-RUNTIME_base-utils-hwclock ?= "util-linux"
VIRTUAL-RUNTIME_base-utils-syslog ?= "systemd"

POKY_DEFAULT_DISTRO_FEATURES = "largefile opengl ptest multiarch wayland vulkan"

DISTRO_FEATURES_LIBC_mx6ul ?= "ipv4 ipv6 libc-backtrace libc-big-macros libc-bsd libc-cxx-tests libc-catgets libc-charsets libc-crypt \
                               libc-crypt-ufc libc-db-aliases libc-envz libc-fcvt libc-fmtmsg libc-fstab libc-ftraverse \
                               libc-getlogin libc-idn libc-inet-anl libc-libm libc-locales libc-locale-code \
                               libc-memusage libc-nis libc-nsswitch libc-rcmd libc-rtld-debug libc-spawn libc-streams libc-sunrpc \
                               libc-utmp libc-utmpx libc-wordexp libc-posix-clang-wchar libc-posix-regexp libc-posix-regexp-glibc \
                               libc-posix-wchar-io"

DISTRO_FEATURES_DEFAULT ?= "acl alsa argp bluetooth ext2 ipv4 ipv6 irda largefile pcmcia usbgadget usbhost wifi xattr nfs zeroconf pci 3g nfc x11"

DISTRO_FEATURES ?= "${DISTRO_FEATURES_DEFAULT} ${DISTRO_FEATURES_LIBC} ${POKY_DEFAULT_DISTRO_FEATURES}"

python __anonymous() {
    val1 = set(d.getVar('DISTRO_FEATURES').split())
    val2 = set(d.getVar('MACHINE_FEATURES').split())
    d.setVar('COMBINED_FEATURES', " ".join(val1 & val2))
}
