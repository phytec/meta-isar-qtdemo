require recipes-images/images/phytec-headless-image.bb

SUMMARY =  "This image is designed to show development of a Qt application \
            running on the eglfs single application backend."

IMAGE_FEATURES += "splash ssh-server-openssh hwcodecs qtcreator-debug"

CONFLICT_DISTRO_FEATURES_mx6 = "x11 wayland"

IMAGE_INSTALL += "\
    packagegroup-base \
    packagegroup-gstreamer \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston-init', '', d)} \
    qtbase-machine-config \
"

IMAGE_PREINSTALL += "\
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'qtwayland5 weston', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', 'xwayland', '', d)} \
"

#TODO: implement packages
#IMAGE_INSTALL += "\
#    qt5-opengles2-test \
#    phytec-qtdemo \
#"

LICENSE = "MIT"
