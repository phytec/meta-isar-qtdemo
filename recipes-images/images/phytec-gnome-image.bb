require recipes-images/images/phytec-headless-image.bb

SUMMARY =  "This image is designed to show how to build gnome into an image"

LICENSE = "MIT"

IMAGE_FEATURES += "splash ssh-server-openssh hwcodecs qtcreator-debug"

CONFLICT_DISTRO_FEATURES_mx6 = "x11 wayland"

IMAGE_INSTALL += "\
    packagegroup-base \
    packagegroup-gstreamer \
    phytec-qtdemo-gnome \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston-init-gnome', '', d)} \
    qtbase-machine-config \
    swap \
"

IMAGE_PREINSTALL += "\
    systemd-timesyncd \
    gnome \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'qtwayland5 weston', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', 'xwayland', '', d)} \
"

IMAGE_INSTALL += "\
    qtperf \
    qmlbench \
"

# Additional tools for testing
IMAGE_PREINSTALL += "\
    vim \
"

#TODO: implement packages
#IMAGE_INSTALL += "\
#    qt5-opengles2-test \
#"
