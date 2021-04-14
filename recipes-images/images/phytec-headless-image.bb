SUMMARY = "Phytec's headless image"
DESCRIPTION = "no graphics support in this image"
LICENSE = "MIT"
inherit image

IMAGE_INSTALL += " \
    packagegroup-base \
    packagegroup-core-boot \
    packagegroup-hwtools \
    packagegroup-benchmark \
    packagegroup-update \
    packagegroup-userland \
    packagegroup-rt \
    ${@bb.utils.contains("COMBINED_FEATURES", "alsa", "packagegroup-audio", "", d)} \
    ${@bb.utils.contains("COMBINED_FEATURES", "wifi", "packagegroup-wifi", "", d)} \
    ${@bb.utils.contains("COMBINED_FEATURES", "bluetooth", "packagegroup-bluetooth", "", d)} \
    ${@bb.utils.contains("COMBINED_FEATURES", "3g", "packagegroup-3g", "", d)} \
"

IMAGE_PREINSTALL += " \
    tzdata \
"

require common.inc
