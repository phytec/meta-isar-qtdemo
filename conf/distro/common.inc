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
