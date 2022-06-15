require recipes-images/images/phytec-headless-image.bb

SUMMARY =  "This image is designed to show development of a Qt application \
            running on the eglfs single application backend."
LICENSE = "MIT"

IMAGE_FEATURES += "splash ssh-server-openssh hwcodecs qtcreator-debug"

IMAGE_INSTALL += "\
    packagegroup-base \
    packagegroup-gstreamer \
    gnome \
    phytec-qtdemo \
    qtbase-machine-config \
    qtwayland5 \
"

IMAGE_PREINSTALL += "\
    gnome \
    vim \
"

