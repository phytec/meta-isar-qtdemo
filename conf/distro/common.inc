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
