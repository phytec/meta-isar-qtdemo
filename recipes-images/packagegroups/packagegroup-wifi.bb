inherit dpkg-raw

DESCRIPTION = "Phytec wifi software"

DEBIAN_DEPENDS = " \
    wpasupplicant, \
    iw, \
    hostapd, \
    firmware-ti-connectivity, \
    firmware-brcm80211, \
"

#TODO: implement packages
#DEBIAN_DEPENDS += " \
#    wl12xx-calibrator, \
#"
#
