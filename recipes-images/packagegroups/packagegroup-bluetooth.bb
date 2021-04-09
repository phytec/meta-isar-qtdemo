inherit dpkg-raw

DESCRIPTION = "bluetooth tools used on Phytec boards"

DEBIAN_DEPENDS = " \
    bluez, \
    bluez-test-tools, \
    pulseaudio, \
    libpulsedsp, \
    pulseaudio-module-bluetooth, \
    firmware-brcm80211, \
"
